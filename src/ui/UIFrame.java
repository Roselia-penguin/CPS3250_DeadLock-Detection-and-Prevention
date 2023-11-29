/**
 * @author HuangYawen
 * @date 2023/11/28 23:38
 */
package ui;

import deadLock.DeadlockDetector;
import deadLock.DeadlockGeneration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import deadLock.DeadlockGeneration;

public class UIFrame extends JFrame {
    private Boolean hasDeadLock = false;
    private int threadNumber = 0;

    public Boolean getHasDeadLock() {
        return hasDeadLock;
    }

    public void setHasDeadLock(Boolean hasDeadLock) {
        this.hasDeadLock = hasDeadLock;
    }

    public int getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void init() {
        setTitle("DeadLock Detection and Prevention");
        setSize(750,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
        setLayout(null/**new FlowLayout()*/);

        //Button
        //add the jconsoleButton | click --> Jump to the jconsole page to obtain deadlock information
        JButton jconsoleButton = new JButton("Launch JConsole");
        jconsoleButton.setBounds(310,100,200,30);
        jconsoleButton.setFont(new Font("Calibri", Font.BOLD, 20));
        jconsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchJConsole();
            }
        });

        //add the deadlockInfoButton | click --> Detect the deadlock situation
        JButton deadlockInfoButton = new JButton("Display Deadlock Information");
        deadlockInfoButton.setBounds(310,160,300,30);
        deadlockInfoButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockDetector.displayDeadlockInformation();
            }
        });

        //add the deadlockInfoButton | click --> Detect the deadlock situation
        JButton deadlockGenerationButton = new JButton("Generate DeadLock Situation");
        deadlockGenerationButton.setBounds(310,220,300,30);
        deadlockGenerationButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockGeneration.Generate();
                threadNumber+=2;
                hasDeadLock = DeadlockDetector.isDeadlocked();
            }
        });


        add(jconsoleButton);
        add(deadlockInfoButton);
        add(deadlockGenerationButton);
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




}
