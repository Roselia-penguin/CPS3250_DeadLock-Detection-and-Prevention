package ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author HuangYawen
 * @date 2023/12/16 0:48
 */
public class AboutUs extends JFrame {
    public void init() {
        setTitle("About Us");
        setSize(750,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
        setLayout(null/**new FlowLayout()*/);

        //Label
        JLabel jLabel = new JLabel("About Us");
        jLabel.setBounds(300,22,600,60);
        jLabel.setFont(new Font("Tahoma", 1, 32));
        add(jLabel);

        JLabel huang = new JLabel("Huang Yawen    1194921");
        huang.setBounds(400,100,600,60);
        huang.setFont(new Font("Tahoma", 1, 20));
        add(huang);

        JLabel niu = new JLabel("Niu Beining        1194133");
        niu.setBounds(400,160,600,60);
        niu.setFont(new Font("Tahoma", 1, 20));
        add(niu);

        JLabel qi = new JLabel("Qi Shengyi          1194132");
        qi.setBounds(400,220,600,60);
        qi.setFont(new Font("Tahoma", 1, 20));
        add(qi);

        JLabel li = new JLabel("Li Jiayin              1195011");
        li.setBounds(400,280,600,60);
        li.setFont(new Font("Tahoma", 1, 20));
        add(li);

        //Image
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/cat.jpg"));
        icon.setImage(icon.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(100,100,icon.getIconWidth(),icon.getIconWidth());
        add(imageLabel);
    }
}
