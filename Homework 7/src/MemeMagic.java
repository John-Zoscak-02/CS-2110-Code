import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * MemeMagic Graphical User Interface 
 * 
 * This class contains the graphical user interface for the Meme Magic Software
 * 
 * You will need to implement certain portions of this class, marked with comments starting with "TODO" to connect 
 * it with your existing code. 
 * 
 * This class provides an example layout for the GUI. You are encouraged to be creative in your design. 
 * More information about Swing is online at: 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html.
 * 
 * 
 */
public class MemeMagic extends JFrame {

    /**
     * Serialization string required by extending JFrame
     */
    private static final long serialVersionUID = 1L;
    
    private User user;
    private GraphicalMeme currentMeme;
    
    private String backgroundImageFilename;

    private BorderLayout panelLayout;
    private JLabel backgroundImageFileNameLabel;
    private JLabel imageDisplayLabel;
    private JPanel controlPanel;
    private JPanel memeViewPanel;
    private JPanel panelPane;
    
    public MemeMagic() {
        this.user = new User();
    }
    
    public MemeMagic(User user) {
        this.user = user;
    }


    /**
     * Main method.  This method initializes a PhotoViewer, loads images into a PhotographContainer, then
     * initializes the Graphical User Interface.
     * 
     * @param args  Optional command-line arguments
     */
    public static void main(String[] args) {
        
        // Create a User object for this instance of Meme Magic
        User user = new User();

        // Instantiate the PhotoViewer Class
        MemeMagic myViewer = new MemeMagic(user);
        
        // Invoke and start the Graphical User Interface
        SwingUtilities.invokeLater(() -> myViewer.initialize());
    }

    /**
     * Initialize all the GUI components.  This method will be called by
     * SwingUtilities when the application is started.
     */
    private void initialize() {

        // Tell Java to exit the program when the window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tell Java to title the window to Meme Magic
        this.setTitle("Meme Magic");

        // We will use border layout on the main panel, since it is much easier for organizing panels.
        panelLayout = new BorderLayout();
        panelPane = new JPanel(panelLayout);

        // Create a label to display the full image.
        imageDisplayLabel = new JLabel();
        imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
        imageDisplayLabel.setPreferredSize(new Dimension(550, 550));

        // Create a panel on which to display the full image
        memeViewPanel = new JPanel(new BorderLayout());
        memeViewPanel.setPreferredSize(new Dimension(550, 550));
        memeViewPanel.add(imageDisplayLabel, BorderLayout.CENTER);


        // Create a panel on which to display the controls for building a Meme
        controlPanel = new JPanel(new BorderLayout());
        
        // Create a panel that holds BackgroundImage information and give it a title
        JPanel backgroundImagePanel = new JPanel(new GridLayout(3,1));
        backgroundImagePanel.setBorder(BorderFactory.createTitledBorder("Background Image"));

        // Create a panel that provides input for the BackgroundImage fileName
        JPanel backgroundImageFilePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Label
        JLabel backgroundImageFileLabel = new JLabel("   Filename: ");
        backgroundImageFileLabel.setPreferredSize(new Dimension(100, 20));
        backgroundImageFilePanel.add(backgroundImageFileLabel);
        
        // Button
        JButton backgroundImageButton = new JButton("Browse");
        backgroundImageFilePanel.add(backgroundImageButton);
        backgroundImageButton.setPreferredSize(new Dimension(85, 20));
        backgroundImageButton.setActionCommand("browse");
        backgroundImageButton.addActionListener(new OpenButtonListener());
        
        // Label that will contain the filename of the image
        backgroundImageFileNameLabel = new JLabel("<choose>");
        backgroundImageFilePanel.add(backgroundImageFileNameLabel);
        backgroundImageFileNameLabel.setPreferredSize(new Dimension(265, 20));

        // Create Title Panel
        JPanel backgroundImageTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("   Title: ");
        titleLabel.setPreferredSize(new Dimension(110, 20));
        backgroundImageTitlePanel.add(titleLabel);
        JTextField titleInputField = new JTextField(35);
        titleInputField.setPreferredSize(new Dimension(300, 20));
        backgroundImageTitlePanel.add(titleInputField);

        // Create Description Panel
        JPanel backgroundImageDescriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel descriptionLabel = new JLabel("   Description: ");
        descriptionLabel.setPreferredSize(new Dimension(110, 20));
        backgroundImageDescriptionPanel.add(descriptionLabel);
        JTextField descriptionInputField = new JTextField(35);
        descriptionInputField.setPreferredSize(new Dimension(300, 20));
        backgroundImageDescriptionPanel.add(descriptionInputField);
        
        // Add the panels to the BackgroundImage information panel
        backgroundImagePanel.add(backgroundImageFilePanel);
        backgroundImagePanel.add(backgroundImageTitlePanel);
        backgroundImagePanel.add(backgroundImageDescriptionPanel);

        // Create new Titled Meme Panel
        JPanel memePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        memePanel.setBorder(BorderFactory.createTitledBorder("Meme"));

        // Create new Caption Panel to go in Meme Panel
       JPanel memeCaptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JLabel captionLabel = new JLabel("   Caption: ");
       captionLabel.setPreferredSize(new Dimension(110, 20));
       memeCaptionPanel.add(captionLabel);
       JTextField memeCaptionInputField = new JTextField(35);
       memeCaptionInputField.setPreferredSize(new Dimension(300, 20));
       memeCaptionPanel.add(memeCaptionInputField);

        // Create new Vertical Align Panel to go in Meme Panel
        JPanel memeVerticalAlignPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel memeVerticalAlignLabel = new JLabel("   Vertical Align: ");
        memeVerticalAlignLabel.setPreferredSize(new Dimension(110, 20));
        memeVerticalAlignPanel.add(memeVerticalAlignLabel);
        JComboBox memeVerticalAlignInputField = new JComboBox(new String[]{"top", "middle", "bottom"});
        memeVerticalAlignInputField.setPreferredSize(new Dimension(350, 20));
        memeVerticalAlignPanel.add(memeVerticalAlignInputField);

        // Add username panel
        JPanel memeUsernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel memeUsernameLabel = new JLabel("   Username: ");
        memeUsernameLabel.setPreferredSize(new Dimension(110, 20));
        memeUsernamePanel.add(memeUsernameLabel);
        JTextField memeUsernameInputField = new JTextField(35);
        memeUsernameInputField.setPreferredSize(new Dimension(300, 20));
        memeUsernamePanel.add(memeUsernameInputField);

        // Add Caption and Vertica Align Panels to Meme Panel
        memePanel.add(memeCaptionPanel);
        memePanel.add(memeVerticalAlignPanel);
        memePanel.add(memeUsernamePanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel buttonPanelInner = new JPanel();

        JButton generateButton = new JButton("Generate");
        generateButton.setActionCommand("generate");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("generate")) {
                    String caption = memeCaptionInputField.getText();
                    String imagePath = backgroundImageFileNameLabel.getText();
                    String title = titleLabel.getText();
                    String description = descriptionLabel.getText();
                    String verticalAlign = memeVerticalAlignInputField.getSelectedItem().toString();
                    String username = memeUsernameInputField.getText();

                    BackgroundImage backgroundImage = new BackgroundImage(imagePath, title, description);
                    currentMeme = new GraphicalMeme(backgroundImage, caption, new User(username));
                    currentMeme.setCaptionVerticalAlign(verticalAlign);
                    try {
                        BufferedImage myPicture = currentMeme.compileMeme();
                        imageDisplayLabel.setIcon(new ImageIcon(myPicture));
                    } catch (IOException exception) {
                        System.err.println("Error generating a meme! (Could not locate the file)"  + " \n" + exception.getStackTrace());
                    } catch (Exception exception) {
                        System.err.println("Error generating a meme! (File is invalid)"  + " \n" + exception.getStackTrace());
                    }
                }
            }
        });
        buttonPanelInner.add(generateButton);
        JButton saveButton = new JButton("Save");
        saveButton.setActionCommand("save");
        saveButton.addActionListener(new SaveButtonListener());

        buttonPanelInner.add(generateButton);
        buttonPanelInner.add(saveButton);
        buttonPanel.add(buttonPanelInner);
        
        // Add the BackgroundImage information panel to the control panel
        controlPanel.add(backgroundImagePanel, BorderLayout.NORTH);
        controlPanel.add(memePanel, BorderLayout.CENTER);
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add all the panels to the main display based on BorderLayout
        controlPanel.setPreferredSize(new Dimension(500,570));
        panelPane.add(controlPanel, BorderLayout.WEST);
        panelPane.add(memeViewPanel, BorderLayout.CENTER);

        // Add the panelPane to the contentPane of the Frame (Window)
        this.getContentPane().add(panelPane);

        // Set the preferred size and show the main application window
        this.setPreferredSize(new Dimension(1150, 570));
        this.pack();
        this.setVisible(true);
    }
    
    
    /**
     * ActionListener for the open button.  When the button is pressed, this ActionListener
     * opens a FileChooser, asks the user to choose a JPG image file, then
     * sets the field backgroundImageFilename in the main class.
     */
    private class OpenButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose a JPG image file, then
         * sets the field backgroundImageFilename in the main class.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("browse")) {
                JFileChooser chooser2 = new JFileChooser();
                chooser2.setDialogTitle("Choose a Background Image");
                chooser2.setFileFilter(new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg"));
                int returnVal = chooser2.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    backgroundImageFilename = chooser2.getSelectedFile().getAbsolutePath();
                    backgroundImageFileNameLabel.setText(backgroundImageFilename);
                }
            }
        }
    }
    
    /**
     * ActionListener for the save button.  When the button is pressed, this ActionListener
     * opens a save FileChooser, asks the user to choose a location and filename, then
     * writes the graphical meme data to a PNG image file.
     */
    private class SaveButtonListener implements ActionListener {
        /**
         * Action performed operation.  Opens a save FileChooser, asks the user to choose
         * a location and filename, then writes the graphical meme data to a PNG file.
         * 
         * @param evt The event that was performed
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("save")) {
                JFileChooser chooser2 = new JFileChooser();
                chooser2.setDialogTitle("Save Meme");
                chooser2.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
                int returnVal = chooser2.showSaveDialog(null);

                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    String destinationFile = chooser2.getSelectedFile().getAbsolutePath() + ".png";
                    try {
                        ImageIO.write(currentMeme.compileMeme(), "png", new File(destinationFile));
                    } catch (IOException e) {
                        System.err.println("Error writing meme to file!" + destinationFile + " \n" + e.getStackTrace());
                    }

                }
            }
        }
    }
}
