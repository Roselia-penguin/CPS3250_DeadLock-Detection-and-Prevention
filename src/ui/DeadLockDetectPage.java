package ui;

import deadLock.DeadlockDetector;
import deadLock.DeadlockGeneration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author HuangYawen
 * @date 2023/12/5 20:48
 */
public class DeadLockDetectPage extends JFrame{

    //Frame
    private JFrame frame;

    public void initDeadLockDetectPage() {

        // Create JFrame instance
        frame = new JFrame("DeadLock Detection");

        // Set the size and layout of JFrame
        frame.setSize(650, 500);
        frame.setLayout(null);//new FlowLayout()
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        //add the deadlockGenerationButton | click --> Generate a DeadLock situation
        JButton deadlockGenerationButton = new JButton("Generate DeadLock Situation");
        deadlockGenerationButton.setBounds(100,120,300,30);
        deadlockGenerationButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockGenerationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockGeneration.Generate();
            }
        });
        frame.add(deadlockGenerationButton);

        //add the deadlockInfoButton | click --> Detect the deadlock situation
        JButton deadlockInfoButton = new JButton("Display Deadlock Information");
        deadlockInfoButton.setBounds(100,160,300,30);
        deadlockInfoButton.setFont(new Font("Calibri", Font.BOLD, 20));
        deadlockInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeadlockDetector.displayDeadlockInformation();
            }
        });
        frame.add(deadlockInfoButton);





    }
}
