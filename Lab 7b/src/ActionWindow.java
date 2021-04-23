import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionWindow extends JFrame{
    JLabel instructionLabel;
    JTextField textInput;
    JLabel resultLabel;
    JButton actionButton;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater( new WindowRunnable() );
    }

    public static void createAndShowGui() {
        ActionWindow actionWindow = new ActionWindow();

        actionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actionWindow.addComponentsToPane(actionWindow.getContentPane());

        actionWindow.pack();
        actionWindow.setVisible(true);
    }

    public void addComponentsToPane( Container pane ) {
        JPanel panel = new JPanel();


        instructionLabel = new JLabel("Enter a numeric value into the text field and click the button to convert the entered value from kilometers to miles:");
        textInput = new JTextField(20);
        resultLabel = new JLabel("Results prints here!");
        actionButton = new JButton("Convert");

        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("changelabel")) {
                    resultLabel.setText(String.valueOf(Double.valueOf(textInput.getText()) * 1.609344));
                }
            }
        });
        actionButton.setActionCommand("changelabel");

        panel.add(instructionLabel);
        panel.add(textInput);
        panel.add(resultLabel);
        panel.add(actionButton);
        pane.add(panel);
    }

    static class WindowRunnable implements Runnable {
        @Override
        public void run() {
            ActionWindow.createAndShowGui();
        }
    }
}
