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
    int Max[][]=new int[0][];
    int Allocation[][]=new int[0][];
    int needM[][]=new int[0][];
    int Available[][]=new int[0][];
    int countA = 0;//count the row in Allocation Table
    int countM = 0;//count the row in Max Table

    Object[] row1;
    Object[] row2;
    Object[] row3;
    Object[] row4;

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
    private JLabel jLabel19;

    //Button
    private JButton addRow;
    private JButton addRow1;
    private JButton clear;
    private JButton calculate;

    //TextArea
    private JTextArea ansArea;
    private JTextArea safeSequence;

    //TextField
    private JTextField avaA;
    private JTextField avaB;
    private JTextField avaC;
    private JTextField processID;
    private JTextField resourceA;
    private JTextField resourceB;
    private JTextField resourceC;
    private JTextField resourceA1;
    private JTextField resourceB1;
    private JTextField resourceC1;

    public void initBankerPage() {

        // Create JFrame instance
        frame = new JFrame("Banker's Alogrithm");

        // Set the size and layout of JFrame
        frame.setSize(1060, 650);
        frame.setLayout(null);//new FlowLayout()
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);

        // Label
        jLabel1 = new JLabel("Allocation");
        jLabel1.setBounds(130,22,100,20);
        jLabel1.setFont(new Font("Tahoma", 1, 20));
        frame.add(jLabel1);

        jLabel2 = new JLabel("Max");
        jLabel2.setBounds(500,22,120,20);
        jLabel2.setFont(new Font("Tahoma", 1, 20));
        frame.add(jLabel2);

        jLabel7 = new JLabel("Available");
        jLabel7.setBounds(838,22,100,20);
        jLabel7.setFont(new Font("Tahoma", 1, 20));
        frame.add(jLabel7);

        jLabel3 = new JLabel("Process");
        jLabel3.setBounds(26,47,100,20);
        jLabel3.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel3);

        jLabel4 = new JLabel("Resource 1");
        jLabel4.setBounds(92,47,100,20);
        jLabel4.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel4);

        jLabel5 = new JLabel("Resource 2");
        jLabel5.setBounds(176,47,100,20);
        jLabel5.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel5);

        jLabel6 = new JLabel("Resource 3");
        jLabel6.setBounds(262,47,100,20);
        jLabel6.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel6);


        jLabel8 = new JLabel("Resource 1");
        jLabel8.setBounds(390,47,100,20);
        jLabel8.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel8);

        jLabel9 = new JLabel("Resource 2");
        jLabel9.setBounds(487,47,100,20);
        jLabel9.setFont(new Font("Tahoma", 1, 14));
        frame.add(jLabel9);

        jLabel10 = new JLabel("Resource 3");
        jLabel10.setBounds(580,47,100,20);
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

        jLabel19 = new JLabel("Result");
        jLabel19.setBounds(855,380,100,20);
        jLabel19.setFont(new Font("Tahoma", 1, 12));
        frame.add(jLabel19);

        //Button
        //add the addRow Button | click --> Add the row
        addRow = new JButton("Add Process");
        addRow.setBounds(110,97,140,35);
        addRow.setFont(new Font("Calibri", Font.BOLD, 17));
        addRow.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addRowMouseClicked(evt);
            }
        });
        frame.add(addRow);

        addRow1 = new JButton("Add Process");
        addRow1.setBounds(460,97,140,35);
        addRow1.setFont(new Font("Calibri", Font.BOLD, 17));
        addRow1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addRow1MouseClicked(evt);
            }
        });
        frame.add(addRow1);

        calculate = new JButton("Calculate");
        calculate.setBounds(826,97,120,35);
        calculate.setFont(new Font("Calibri", Font.BOLD, 17));
        calculate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                createNeedM(evt);
            }
        });
        frame.add(calculate);

        //add the clear Button | click --> Clear all the input
        clear = new JButton("Clear");
        clear.setBounds(800,555,140,35);
        clear.setFont(new Font("Calibri", Font.BOLD, 17));
        clear.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clear();
            }
        });
        frame.add(clear);

        // TextField
        processID = new JTextField();
        processID.setBounds(20,68,67,20);
        processID.setFont(new Font("Tahoma", 1, 12));
        frame.add(processID);

        resourceA = new JTextField();
        resourceA.setBounds(95,68,75,20);
        resourceA.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceA);

        resourceB = new JTextField();
        resourceB.setBounds(178,68,75,20);
        resourceB.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceB);

        resourceC = new JTextField();
        resourceC.setBounds(262,68,75,20);
        resourceC.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceC);

        resourceA1 = new JTextField();
        resourceA1.setBounds(390,68,80,20);
        resourceA1.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceA1);

        resourceB1 = new JTextField();
        resourceB1.setBounds(485,68,80,20);
        resourceB1.setFont(new Font("Tahoma", 1, 12));
        frame.add(resourceB1);

        resourceC1 = new JTextField();
        resourceC1.setBounds(580,68,75,20);
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
        safeSequence = new JTextArea();
        safeSequence.setColumns(20);
        safeSequence.setRows(5);
        safeSequence.setBounds(742,180,271,175);
        safeSequence.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        frame.add(safeSequence);

        ansArea = new JTextArea();
        ansArea.setColumns(20);
        ansArea.setRows(5);
        ansArea.setBounds(742,400,271,135);
        ansArea.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        frame.add(ansArea);

        //Table
        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Process", "Resource1", "Resource2", "Resource3"
                }
        ));

        jTable2 = new JTable();
        jTable2.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Resource1", "Resource2", "Resource3"
                }
        ));

        jTable3 = new JTable();
        jTable3.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Resource1", "Resource2", "Resource3"
                }
        ));

        jTable4 = new JTable();
        jTable4.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Resource1", "Resource2", "Resource3"
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

    }

    //clear all the data (no need to restart the program to start a new Banker's Page)
    private void clear(){
        avaA.setText("");
        avaB.setText("");
        avaC.setText("");
        avaB.setText("");
        processID.setText("");
        resourceA.setText("");
        resourceB.setText("");
        resourceC.setText("");
        resourceA1.setText("");
        resourceB1.setText("");
        resourceC1.setText("");
        ansArea.setText("");
        safeSequence.setText("");


        for (int i = 0; i < Allocation.length; i++) {
            for (int j = 0; j < Allocation[i].length; j++) {
                Allocation[i][j] = 0;
            }
        }
        for (int i = 0; i < Available.length; i++) {
            for (int j = 0; j < Available[i].length; j++) {
                Available[i][j] = 0;
            }
        }
        for (int i = 0; i < Max.length; i++) {
            for (int j = 0; j < Max[i].length; j++) {
                Max[i][j] = 0;
            }
        }
        for (int i = 0; i < needM.length; i++) {
            for (int j = 0; j < needM[i].length; j++) {
                needM[i][j] = 0;
            }
        }

        countA = 0;//count the row in Allocation Table
        countM = 0;//

        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        model1.setRowCount(0); // Set the row count to 0 to remove all rows
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.setRowCount(0);
        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
        model3.setRowCount(0);
        DefaultTableModel model4 = (DefaultTableModel) jTable4.getModel();
        model4.setRowCount(0);
    }

    //Add row for the Allocation Table
    private void addRowMouseClicked(MouseEvent evt) {
        // Extracting data from text fields
        String data1 = processID.getText();
        String data2 = resourceA.getText();
        String data3 = resourceB.getText();
        String data4 = resourceC.getText();

        if (data1.isEmpty() || data2.isEmpty() || data3.isEmpty() || data4.isEmpty()) {
            //ansArea.append("\n Invalid Input!\n"+"\n The input value for Allocation is incomplete.\n");
            JOptionPane.showMessageDialog(frame, "Invalid Input!\nThe input value for Allocation is incomplete!");
        }
        else{
            row1 = new Object[]{data1, data2, data3, data4};
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(row1);
            countA++;//count the row in Allocation Table
        }

    }

    //Add row for the Max Matrix Table
    private void addRow1MouseClicked(MouseEvent evt) {
        // Extracting data from text fields
        String data2 = resourceA1.getText();
        String data3 = resourceB1.getText();
        String data4 = resourceC1.getText();

        if (data2.isEmpty() || data3.isEmpty() || data4.isEmpty()) {
            //ansArea.append("\n Invalid Input!\n"+"\n The input value for Max Matrix is incomplete.\n");
            JOptionPane.showMessageDialog(frame, "Invalid Input!\nThe input value for Max Matrix is incomplete!");
        }
        else{
            row2 = new Object[]{data2, data3, data4};
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.addRow(row2);
            countM++; //count the row in max Table
        }

    }

    //create the need table
    private void createNeedM(MouseEvent evt) {

        Allocation=new int[countA][3];
        int i = 0;
        while(i<countA){
            for(int j=0; j<3; j++){
                Allocation[i][j]=Integer.parseInt(jTable1.getModel().getValueAt(i, j+1).toString());
            }
            i++;
        }
        //For Max Matrix
        Max=new int[countM][3];
        int k = 0;
        while(k<countM){
            for(int j=0; j<3; j++){
                Max[k][j]=Integer.parseInt(jTable2.getModel().getValueAt(k, j).toString());
                //System.out.println(jTable1.getModel().getValueAt(i, j+1));
            }
            k++;
        }

        // Extracting data from text fields
        String data1 = processID.getText();
        String data2 = resourceA.getText();
        String data3 = resourceB.getText();
        String data4 = resourceC.getText();

        //if any input is empty --> showMessageDialog
        if (data1.isEmpty() || data2.isEmpty() || data3.isEmpty() || data4.isEmpty()) {
            //ansArea.append("\n Invalid Input!\n"+"\n The input value for Allocation is incomplete.\n");
            JOptionPane.showMessageDialog(frame, "Invalid Input!\nThe input value for Allocation is incomplete!");
        }

        // Extracting data from text fields
        String data5 = resourceA1.getText();
        String data6 = resourceB1.getText();
        String data7 = resourceC1.getText();

        //if any input is empty --> showMessageDialog
        if (data5.isEmpty() || data6.isEmpty() || data7.isEmpty()) {
            //ansArea.append("\n Invalid Input!\n"+"\n The input value for Max Matrix is incomplete.\n");
            JOptionPane.showMessageDialog(frame, "Invalid Input!\nThe input value for Max Matrix is incomplete!");
        }

        String data8 = avaA.getText();
        String data9 = avaB.getText();
        String data10 = avaC.getText();

        //if any input is empty --> showMessageDialog
        if (data8.isEmpty() || data9.isEmpty() || data10.isEmpty()) {
            //ansArea.append("\n Invalid Input!\n"+"\n The input value for Available is incomplete.\n");
            JOptionPane.showMessageDialog(frame, "Invalid Input!\nThe input value for Available is incomplete.");
        }

        else{
            Available=new int[1][3];
            Available[0][0] = Integer.parseInt(avaA.getText());
            Available[0][1] = Integer.parseInt(avaB.getText());
            Available[0][2] = Integer.parseInt(avaC.getText());
            needM=new int[countA][3];
            if(countA==countM && countA!=0&&countM!=0){
                for(int i1=0;i1<countA;i1++){
                    if(checkMax(i1)==false){
                        JOptionPane.showMessageDialog(frame, "Invalid Input!\nMAX is smaller than ALLOCATION");
                        clear();
                        return;
                    }
                }
                cal_need();
                algorithm();
            }
            else{
                //ansArea.append("\n Invalid Input!\n"+"\n ALLOCATION and MAX should have\n"+" the same number of rows.\n");
                JOptionPane.showMessageDialog(frame, "Invalid Input!\nALLOCATION and MAX should have\nthe same number of rows.");
            }
        }
    }

    //calculate the need
    public void cal_need(){
        if(countA==countM && countA!=0 && countM!=0){
            // Calculate the Need Matrix for each resource of each process
            for(int i=0;i<countA;i++){
                for(int j=0;j<3;j++){
                    needM[i][j]=Max[i][j]-Allocation[i][j];
                }
            }
        }
        int i=0;
        while(i<countA){
            row3 = new Object[]{needM[i][0], needM[i][1], needM[i][2]};
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.addRow(row3);
            i++;
        }
    }

    public boolean check(int p){
        // Check if the available resources are sufficient for the needs of the process
        if(Available[0][0]<needM[p][0] || Available[0][1]<needM[p][1] || Available[0][2]<needM[p][2]){
            return false;// Insufficient resources, cannot allocate
        }
        return true;// Resources are sufficient, allocation is possible
    }

    public boolean checkMax(int p){
        // Check if the max resources are bigger than allocation
        if(Max[0][0]<Allocation[p][0] || Max[0][1]<Allocation[p][1] || Max[0][2]<Allocation[p][2]){
            return false;// Insufficient resources, cannot allocate
        }
        return true;// Resources are sufficient, allocation is possible
    }

    public void algorithm(){
        int c=0; //Count Variable
        boolean status[]=new boolean[countA];
        while(c<countA){
            boolean allocated=false;
            for(int i=0;i<countA;i++){
                if( !status[i] && check(i)){
                    status[i]=true;
                    allocated=true;
                    safeSequence.append("P"+Integer.toString(i)+" Allocated\n");

                    // Update the available resources after allocation
                    for(int j=0;j<3;j++){
                        Available[0][j]=Available[0][j]+Allocation[i][j];
                    }
                    c++;// Increment the count of allocated processes
                    row4 = new Object[]{Available[0][0], Available[0][1], Available[0][2]};
                    DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                    model.addRow(row4);
                }
            }
            //if no allocation
            if(!allocated){
                break;
            }
        }

        // Check if all processes are allocated, and there is no deadlock
        if(c==countA && c!=0 && countA!= 0){ //if all processes are allocated. i.e No Deadlock
            ansArea.append("\n Safely Allocated!\n");
        }
        else{ //Deadlock is Detected and can not be avoided
            ansArea.append("\n UnSafe\n");
        }

    }



}