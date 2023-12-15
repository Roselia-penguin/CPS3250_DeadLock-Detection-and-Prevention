package ui;

import deadLock.DeadlockDetector;
import deadLock.DeadlockGeneration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author HuangYawen
 * @date 2023/12/5 20:48
 */
public class DeadLockDetectPage extends JFrame{

    //set Flag
    private Boolean DeadLockFlag = false;

    //Frame
    private JFrame frame;

    private JLabel deadLock;
    public static JTextArea resultArea;

    public void initDeadLockDetectPage() {

        // Create JFrame instance
        frame = new JFrame("DeadLock Detection");

        // Set the size and layout of JFrame
        frame.setSize(650, 650);
        frame.setLayout(null);//new FlowLayout()
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        //Text
        deadLock = new JLabel();
        deadLock = new JLabel("DeadLock Detection");
        deadLock.setBounds(200,50,300,30);
        deadLock.setFont(new Font("Tahoma", 1, 24));
        frame.add(deadLock);

        //TextArea
        resultArea = new JTextArea();
        resultArea.setColumns(20);
        resultArea.setRows(5);
        resultArea.setBounds(75,250,500,200);
        resultArea.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        //resultArea.setText(DeadlockDetector.resultString);
        frame.add(resultArea);

        //ScrollPane
        JScrollPane scrollPane = new JScrollPane();
        // Set the JTextArea as the viewport view of the JScrollPane
        scrollPane.setViewportView(resultArea);
        scrollPane.setBounds(75,250,500,200);

        // Add the JScrollPane to the frame
        frame.add(scrollPane);

        //add the deadlockGenerationButton | click --> Generate a DeadLock situation
        JButton deadlockGenerationButton = new JButton("Generate DeadLock Situation");
        deadlockGenerationButton.setBounds(175,110,300,30);
        deadlockGenerationButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockGenerationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockGeneration.Generate();
                DeadLockFlag = true;
                JOptionPane.showMessageDialog(frame, "Successfully generated deadlock situation!");
            }
        });
        frame.add(deadlockGenerationButton);

        //add the deadlockInfoButton | click --> Detect the deadlock situation
        JButton deadlockInfoButton = new JButton("Display Deadlock Information");
        deadlockInfoButton.setBounds(175,190,300,30);
        deadlockInfoButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockDetector.displayDeadlockInformation();
            }
        });
        frame.add(deadlockInfoButton);

        //add the jconsoleButton | click --> Jump to the jconsole page to obtain deadlock information
        JButton jconsoleButton = new JButton("Launch JConsole");
        jconsoleButton.setBounds(175,480,300,30);
        jconsoleButton.setFont(new Font("Calibri", Font.BOLD, 20));
        jconsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchJConsole();
            }
        });
        frame.add(jconsoleButton);
    }


    private void launchJConsole() {
        try {
            // Get the path to the Java home directory and construct the path to JConsole
            String javaHome = System.getProperty("java.home");
            String jConsolePath = javaHome + "/bin/jconsole";

            // Start the JConsole Process
            ProcessBuilder processBuilder = new ProcessBuilder(jConsolePath);
            processBuilder.start();

        } catch (IOException ex) {
            ex.printStackTrace();
            // Display an error message using JOptionPane if launching JConsole fails
            JOptionPane.showMessageDialog(this, "Error launching JConsole");
        }
    }

}
