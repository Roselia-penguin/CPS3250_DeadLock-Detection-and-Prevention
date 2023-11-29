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
        jconsoleButton.setBounds(200,100,300,30);
        jconsoleButton.setFont(new Font("Calibri", Font.BOLD, 20));
        jconsoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchJConsole();
            }
        });
        add(jconsoleButton);

        //add the deadlockInfoButton | click --> Detect the deadlock situation
        JButton deadlockInfoButton = new JButton("Display Deadlock Information");
        deadlockInfoButton.setBounds(200,160,300,30);
        deadlockInfoButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockDetector.displayDeadlockInformation();
            }
        });
        add(deadlockInfoButton);

        //add the deadlockGenerationButton | click --> Generate a DeadLock situation
        JButton deadlockGenerationButton = new JButton("Generate DeadLock Situation");
        deadlockGenerationButton.setBounds(200,220,300,30);
        deadlockGenerationButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockGeneration.Generate();
                threadNumber+=2;
                hasDeadLock = DeadlockDetector.isDeadlocked();
            }
        });
        add(deadlockGenerationButton);

        //add the openPageButton | click --> Jump to the banker's Algorithm Page
        JButton openButton = new JButton("Banker's Algorithm");
        openButton.setBounds(200,280,300,30);
        openButton.setFont(new Font("Calibri", Font.BOLD, 20));
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankerAlgorithmPage banker = new BankerAlgorithmPage();
                banker.initBankerPage();
            }
        });
        add(openButton);

        //add the exitButton | click --> Exit the Program
        JButton exitButton = new JButton("Exit Program");
        exitButton.setBounds(200,340,300,30);
        exitButton.setFont(new Font("Calibri", Font.BOLD, 20));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

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
