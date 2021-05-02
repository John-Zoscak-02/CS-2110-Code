import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Player is a specialized class for playing recordings
 * 
 * @author Your friendly CS Professors 
 * @date 4/30/2021
 */
public class Player implements Runnable {
    /**
     * This player will only use one audio format: 16-bit stereo
     */
    private AudioFormat audioFormat = new AudioFormat(16000.0F, 16, 2, true, true);
    /**
     * Fields used to play the audio
     */
    private AudioInputStream audioInputStream;
    /**
     * Fields used to play the audio
     */
    private SourceDataLine sourceDataLine;
    /**
     * Audio data to be played
     */
    private byte audioData[];

    /**
     * Constructor that accepts audio data to be played, in the form of a byte[] array
     * 
     * @param audioData Audio data to be played
     */
    public Player(byte[] audioData) {
        this.audioData = audioData;

        System.out.println("Audio player initialized with " + audioData.length + " bytes of data.");
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
            audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
                    audioData.length / audioFormat.getFrameSize());

            /**
             * AudioSystem is a class that allows you to access the computer's audio system 
             * AudioSystem.getLine() can throw a LineUnavailableException, so we must catch
             */
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        } catch (LineUnavailableException e) {
            System.out.println("Error acquiring info for audio playback");
        }
    }

    /**
     * Run method, the code to execute during the thread.  Sends the audio data to the 
     * computer's sound system and also writes a sampled version of the audio waveform to a graphical
     * display.
     */
    public void run() {
        try {
            // Display the waveform of the audio data as a graph
            System.out.println("Displaying recording waveform");
            displayAudioWave();
            
            // Play the recording to the sound system
            System.out.println("Playing recordings to sound system");
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            int soundByte = 0;
            /**
             * when the audioInputStream is empty, it returns a sentinel value of -1 
             * Note we are using this byte array to access raw binary data
             */
            while ((soundByte = audioInputStream.read(audioData, 0, audioData.length)) != -1) {
                if (soundByte > 0) {
                    sourceDataLine.write(audioData, 0, soundByte);
                }
            }
            // needed to clear out and release audio resources
            sourceDataLine.drain();
            sourceDataLine.stop();
            sourceDataLine.close();
        } catch (LineUnavailableException e) {
            System.out.println("Error loading the data line");
        } catch (IOException e) {
            System.out.println("Unknown IO Exception");
        }
    }

    /**
     * Displays a sampled audio waveform of the recording being played.
     */
    public void displayAudioWave() {
        // Using the JFreeChart plotting library to display the graph
        XYSeries series1 = new XYSeries("Audio");
        
        // Down sample from visualization
        int length = audioData.length;
        int downsampleRate = 300;
        for (int i = 0; i < length; i += downsampleRate) {
            // Convert bytes (which are shorts) to integers so they can be visualized
            int x = Byte.toUnsignedInt(audioData[i]);
            if (x > 0)
                series1.add(i, x);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);

        // Create an XY Line Chart of the sampled audio waveform
        JFreeChart chart = ChartFactory.createXYLineChart("Amplitude vs Time", "Time", "Amplitude", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        try {
            // Open a new window to display the waveform
            new GraphicalDisplay(chart.createBufferedImage(1100, 300));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Failed to display the waveform graphically");
        }

    }

    /**
     * Graphical window (JFrame) to display the waveform.  This is a private class used by the Player.
     */
    private class GraphicalDisplay extends JFrame {

        /**
         * Serialization string required by extending JFrame
         */
        private static final long serialVersionUID = 1L;

        /**
         * Constructor that invokes the initialize method in a new thread
         * @param plt The graph data to display, as a BufferedImage
         */
        public GraphicalDisplay(BufferedImage plt) {

            // Invoke and start the Graphical User Interface
            javax.swing.SwingUtilities.invokeLater(() -> initialize(plt));
        }

        /**
         * Initialize all the GUI components into the JFrame, passing in the waveform data to be displayed.
         * 
         * @param plt The graph data to display, as a BufferedImage
         */
        private void initialize(BufferedImage plt) {

            // Tell Java to exit the program when the window is closed
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tell Java to title the window
            this.setTitle("Visualization");

            // Create a label to display the full image.
            JLabel imageDisplayLabel = new JLabel();
            imageDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
            imageDisplayLabel.setPreferredSize(new Dimension(1100, 300));
            imageDisplayLabel.setIcon(new ImageIcon(plt));

            // Add the panelPane to the contentPane of the Frame (Window)
            this.getContentPane().add(imageDisplayLabel);

            // Set the preferred size and show the main application window
            this.setPreferredSize(new Dimension(1100, 400));
            this.pack();
            this.setVisible(true);
        }
    }
}
