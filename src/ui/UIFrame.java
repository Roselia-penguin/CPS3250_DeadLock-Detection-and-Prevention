/**
 * @author HuangYawen
 * @date 2023/11/28 23:38
 */
package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class UIFrame extends JFrame {

    public void init() {
        setTitle("DeadLock Detection and Prevention");
        setSize(750,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
        setLayout(null/**new FlowLayout()*/);

        //Label
        JLabel jLabel = new JLabel("DeadLock Detection and Prevention");
        jLabel.setBounds(80,22,600,60);
        jLabel.setFont(new Font("Tahoma", 1, 32));
        add(jLabel);

        //Image
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/lock.png"));
        icon.setImage(icon.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(100,100,icon.getIconWidth(),icon.getIconWidth());
        add(imageLabel);

        //Button
        //add the DeadLock Detection Button | click --> Jump to the DeadLock Information Page
        JButton DeadLockDetectButton = new JButton("DeadLock Detection");
        DeadLockDetectButton.setBounds(380,120,200,30);
        DeadLockDetectButton.setFont(new Font("Calibri", Font.BOLD, 20));
        //DeadLockDetectButton.setBackground(Color.decode("#5E95FF"));

        DeadLockDetectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                DeadLockDetectPage deadlock = new DeadLockDetectPage();
                deadlock.initDeadLockDetectPage();
            }
        });
        add(DeadLockDetectButton);

        //add the open Page Button | click --> Jump to the banker's Algorithm Page
        JButton openBankerButton = new JButton("Banker's Algorithm");
        openBankerButton.setBounds(380,180,200,30);
        openBankerButton.setFont(new Font("Calibri", Font.BOLD, 20));
        openBankerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                BankerAlgorithmPage banker = new BankerAlgorithmPage();
                banker.initBankerPage();
            }
        });
        add(openBankerButton);

        //add the open Page Button | click --> Jump to the About Us Page
        JButton aboutUsButton = new JButton("About Us");
        aboutUsButton.setBounds(380,240,200,30);
        aboutUsButton.setFont(new Font("Calibri", Font.BOLD, 20));
        aboutUsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt)  {
                AboutUs aboutus = new AboutUs();
                aboutus.init() ;
            }
        });
        add(aboutUsButton);

        //add the exitButton | click --> Exit the Program
        JButton exitButton = new JButton("Exit Program");
        exitButton.setBounds(380,300,200,30);
        exitButton.setFont(new Font("Calibri", Font.BOLD, 20));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt)  {
                System.exit(0);
            }
        });
        add(exitButton);

    }





}
