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
        //add the DeadLock Detection Button | click --> Jump to the DeadLock Information Page
        JButton DeadLockDetectButton = new JButton("DeadLock Detection");
        DeadLockDetectButton.setBounds(200,100,300,30);
        DeadLockDetectButton.setFont(new Font("Calibri", Font.BOLD, 20));
        DeadLockDetectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadLockDetectPage deadlock = new DeadLockDetectPage();
                deadlock.initDeadLockDetectPage();
            }
        });
        add(DeadLockDetectButton);

        //add the open Page Button | click --> Jump to the banker's Algorithm Page
        JButton openBankerButton = new JButton("Banker's Algorithm");
        openBankerButton.setBounds(200,190,300,30);
        openBankerButton.setFont(new Font("Calibri", Font.BOLD, 20));
        openBankerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankerAlgorithmPage banker = new BankerAlgorithmPage();
                banker.initBankerPage();
            }
        });
        add(openBankerButton);

        //add the exitButton | click --> Exit the Program
        JButton exitButton = new JButton("Exit Program");
        exitButton.setBounds(200,280,300,30);
        exitButton.setFont(new Font("Calibri", Font.BOLD, 20));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

    }





}
