import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleWindow extends JFrame{
    JLabel instructionLabel;
    JTextField textInput;
    JLabel resultLabel;
    JButton actionButton;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater( new WindowRunnable() );
    }

    public static void createAndShowGui() {
        SimpleWindow simpleWindow = new SimpleWindow();

        simpleWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simpleWindow.addComponentsToPane(simpleWindow.getContentPane());

        simpleWindow.pack();
        simpleWindow.setVisible(true);
    }

    public void addComponentsToPane( Container pane ) {
        JPanel panel = new JPanel();
        
        instructionLabel = new JLabel("instructions");
        textInput = new JTextField(20);
        resultLabel = new JLabel("Results Label");
        actionButton = new JButton("Action Button");

        panel.add(instructionLabel);
        panel.add(textInput);
        panel.add(resultLabel);
        panel.add(actionButton);
        pane.add(panel);
    }

    static class WindowRunnable implements Runnable {
        @Override
        public void run() {
            SimpleWindow.createAndShowGui();
        }
    }
}
