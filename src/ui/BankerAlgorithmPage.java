package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author HuangYawen, QiShengyi
 * @date 2023/11/29 22:00
 */
public class BankerAlgorithmPage extends JFrame {
    int countA = 0;
    int countM = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    //Frame
    private JFrame frame;
    //Panel
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;

    //Table
    public JTable jTable1;
    public JTable jTable2;
    public JTable jTable3;
    public JTable jTable4;

    //Label
    private JLabel ans;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;

    //Button
    private JButton addRow;
    private JButton addRow1;
    private JToggleButton jToggleButton1;

    //TextArea
    private JTextArea ansArea;
    private JTextArea safeSequence;

    //TextField
    private JTextField avaA;
    private JTextField avaB;
    private JTextField avaC;
    private JTextField processID;
    private JTextField resourceA;
    private JTextField resourceA1;
    private JTextField resourceB;
    private JTextField resourceB1;
    private JTextField resourceC;
    private JTextField resourceC1;

    public void initBankerPage() {
        // Create JFrame instance
        frame = new JFrame("Banker's Alogrithm");

        // Label
        jLabel1 = new JLabel("Allocation");
        jLabel1.setBounds(176,22,100,20);
        jLabel1.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel1);

        jLabel2 = new JLabel("Max matrix");
        jLabel2.setBounds(528,22,100,20);
        jLabel2.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel2);

        jLabel3 = new JLabel("Process");
        jLabel3.setBounds(47,47,100,20);
        jLabel3.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel3);

        jLabel4 = new JLabel("Resource 1");
        jLabel4.setBounds(125,47,100,20);
        jLabel4.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel4);

        jLabel5 = new JLabel("Resource 2");
        jLabel5.setBounds(222,47,100,20);
        jLabel5.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel5);

        jLabel6 = new JLabel("Resource 3");
        jLabel6.setBounds(321,47,100,20);
        jLabel6.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel6);

        jLabel7 = new JLabel("Available");
        jLabel7.setBounds(841,22,100,20);
        jLabel7.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel7);

        jLabel8 = new JLabel("Resource 1");
        jLabel8.setBounds(437,47,100,20);
        jLabel8.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel8);

        jLabel9 = new JLabel("Resource 2");
        jLabel9.setBounds(534,47,100,20);
        jLabel9.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel9);

        jLabel10 = new JLabel("Resource 3");
        jLabel10.setBounds(632,47,100,20);
        jLabel10.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel10);

        jLabel11 = new JLabel("Resource 1");
        jLabel11.setBounds(745,47,100,20);
        jLabel11.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel11);

        jLabel12 = new JLabel("Resource 2");
        jLabel12.setBounds(842,47,100,20);
        jLabel12.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel12);

        jLabel13 = new JLabel("Resource 3");
        jLabel13.setBounds(941,47,100,20);
        jLabel13.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel13);

        jLabel14 = new JLabel("ALLOCATION");
        jLabel14.setBounds(142,146,100,20);
        jLabel14.setFont(new Font("Tahoma", 1, 12));
        frame.add(jLabel14);

        jLabel15 = new JLabel("MAX");
        jLabel15.setBounds(517,146,100,20);
        jLabel15.setFont(new Font("Tahoma", 1, 12));
        frame.add(jLabel15);

        jLabel16 = new JLabel("NEED");
        jLabel16.setBounds(156,382,100,20);
        jLabel16.setFont(new Font("Tahoma", 1, 12));
        frame.add(jLabel16);

        jLabel17 = new JLabel("AVAILABLE");
        jLabel17.setBounds(491,382,100,20);
        jLabel17.setFont(new Font("Tahoma", 1, 12));
        frame.add(jLabel17);

        jLabel18 = new JLabel("Safe Sequence");
        jLabel18.setBounds(840,155,100,20);
        jLabel18.setFont(new Font("Tahoma", 1, 12));
        frame.add(jLabel18);

        //Button
        //add the addRow Button | click --> Add the row
        addRow = new JButton("Add Process");
        addRow.setBounds(142,97,140,35);
        addRow.setFont(new Font("Calibri", Font.BOLD, 17));
        addRow.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addRowMouseClicked(evt);
            }
        });
        frame.add(addRow);

        addRow1 = new JButton("Add Process");
        addRow1.setBounds(500,97,140,35);
        addRow1.setFont(new Font("Calibri", Font.BOLD, 17));
        addRow1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addRow1MouseClicked(evt);
            }
        });
        frame.add(addRow1);

        jToggleButton1 = new JToggleButton("Calculate");
        jToggleButton1.setBounds(826,97,120,35);
        jToggleButton1.setFont(new Font("Calibri", Font.BOLD, 17));
        /** jToggleButton1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                createNeedM(evt);
            }
        }); */
        frame.add(jToggleButton1);

        // TextField
        processID = new JTextField();
        processID.setBounds(40,68,67,20);
        processID.setFont(new Font("Tahoma", 1, 12));
        frame.add(processID);

        resourceA = new JTextField();
        resourceA.setBounds(118,68,90,20);
        resourceA.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceA);

        resourceB = new JTextField();
        resourceB.setBounds(216,68,90,20);
        resourceB.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceB);

        resourceC = new JTextField();
        resourceC.setBounds(315,68,90,20);
        resourceC.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceC);

        resourceA1 = new JTextField();
        resourceA1.setBounds(430,68,90,20);
        resourceA1.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceA1);

        resourceB1 = new JTextField();
        resourceB1.setBounds(528,68,90,20);
        resourceB1.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceB1);

        resourceC1 = new JTextField();
        resourceC1.setBounds(627,68,90,20);
        resourceC1.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceC1);

        avaA = new JTextField();
        avaA.setBounds(739,68,90,20);
        avaA.setFont(new Font("Tahoma", 1, 12));
        frame.add(avaA);

        avaB = new JTextField();
        avaB.setBounds(837,68,90,20);
        avaB.setFont(new Font("Tahoma", 1, 12));
        frame.add(avaB);

        avaC = new JTextField();
        avaC.setBounds(935,68,90,20);
        avaC.setFont(new Font("Tahoma", 1, 12));
        frame.add(avaC);

        //TextArea
        ansArea = new JTextArea();
        ansArea.setColumns(20);
        ansArea.setRows(5);
        ansArea.setBounds(742,189,271,195);
        ansArea.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        frame.add(ansArea);
        
        safeSequence = new JTextArea();
        safeSequence.setColumns(20);
        safeSequence.setRows(5);
        safeSequence.setBounds(742,424,271,165);
        safeSequence.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        frame.add(safeSequence);

        //Table
        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Process", "A", "B", "C"
                }
        ));

        jTable2 = new JTable();
        jTable2.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "A", "B", "C"
                }
        ));

        jTable3 = new JTable();
        jTable3.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "A", "B", "C"
                }
        ));

        jTable4 = new JTable();
        jTable4.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "A", "B", "C"
                }
        ));

        //Panel
        jPanel1= new JPanel();
        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBounds(0,0,1064,621);
        jPanel1.setLayout(null);
        frame.add(jPanel1);

        jScrollPane2 = new JScrollPane();
        jScrollPane2.setBounds(41,163,272,193);
        jScrollPane2.add(jTable1);
        jScrollPane2.setViewportView(jTable1);
        jPanel1.add(jScrollPane2);

        jScrollPane3 = new JScrollPane();
        jScrollPane3.setBounds(387,163,272,193);
        jScrollPane3.add(jTable2);
        jScrollPane3.setViewportView(jTable2);
        jPanel1.add(jScrollPane3);

        jScrollPane4 = new JScrollPane();
        jScrollPane4.setBounds(41,399,272,193);
        jScrollPane4.add(jTable3);
        jScrollPane4.setViewportView(jTable3);
        jPanel1.add(jScrollPane4);

        jScrollPane5 = new JScrollPane();
        jScrollPane5.setBounds(387,399,272,193);
        jScrollPane5.add(jTable4);
        jScrollPane5.setViewportView(jTable4);
        jPanel1.add(jScrollPane5);


        // 设置 JFrame 的大小和布局
        frame.setSize(1060, 650);
        frame.setLayout(null);//new FlowLayout()
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);

    }

    private void addRowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRowMouseClicked
        // Extracting data from text fields
        String data1 = processID.getText();
        String data2 = resourceA.getText();
        String data3 = resourceB.getText();
        String data4 = resourceC.getText();

        Object[] row = { data1, data2, data3, data4 };

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        System.out.println(countA);
        model.addRow(row);
        countA++;//count the row in Allocation Table
        System.out.println(countA);

    }

    private void addRow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRow1MouseClicked
        // Extracting data from text fields
        String data2 = resourceA1.getText();
        String data3 = resourceB1.getText();
        String data4 = resourceC1.getText();
        Object[] row = { data2, data3, data4 };

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.addRow(row);
        countM++; //count the row in max Table

    }

}