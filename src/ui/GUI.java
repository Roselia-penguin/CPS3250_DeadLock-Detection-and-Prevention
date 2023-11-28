package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import deadLock.DeadlockDetector;

public class GUI extends JFrame {

    public GUI() {

        JButton deadlockInfoButton = new JButton("Display Deadlock Information");
        deadlockInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockDetector.displayDeadlockInformation();
            }
        });

        //add the jconsoleButton | click --> Jump to the jconsole page to obtain deadlock information
        JButton jconsoleButton = new JButton("Launch JConsole");
        jconsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchJConsole();
            }
        });

        setLayout(new FlowLayout());
        add(deadlockInfoButton);
        add(jconsoleButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void launchJConsole() {
        try {
            String javaHome = System.getProperty("java.home");
            String jConsolePath = javaHome + "/bin/jconsole";

            ProcessBuilder processBuilder = new ProcessBuilder(jConsolePath);
            processBuilder.start();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error launching JConsole");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
