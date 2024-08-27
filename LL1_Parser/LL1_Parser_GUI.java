
package LL1_Parser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ajdar
 */
public class LL1_Parser_GUI extends javax.swing.JFrame {

    /**
     * Creates new form LL1_Parser_GUI
     */
    
    private PrepareGrammar Prepared_Grammer = null;
    private LL1_Parser LL1 = null;
    private ArrayList<String> ge = null;
    private ArrayList<String> string_to_analyze = null;
    
    public LL1_Parser_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LL1JTable = new javax.swing.JTable();
        recogLabel = new javax.swing.JLabel();
        Jtext_string_analyz = new javax.swing.JTextField();
        Jbutton_AnalyzeString = new javax.swing.JButton();
        TabbedPane = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ogJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        svJTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        primeroJTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        sgtJTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaMJTable = new javax.swing.JTable();
        ResultLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ResultLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CS445 – Compilers – Project  Part (2)  LL(1) parser");

        loadBT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadBT.setForeground(new java.awt.Color(0, 102, 0));
        loadBT.setText("Compute LL(1) parse table ");
        loadBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBTActionPerformed(evt);
            }
        });

        LL1JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "stack", "input", "production"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(LL1JTable);

        recogLabel.setText("String to Analyze:");

        Jtext_string_analyz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jtext_string_analyz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jtext_string_analyzActionPerformed(evt);
            }
        });

        Jbutton_AnalyzeString.setText("Check if  string  belongs to grammar");
        Jbutton_AnalyzeString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbutton_AnalyzeStringActionPerformed(evt);
            }
        });

        ogJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No terminal", "Produccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ogJTable);

        TabbedPane.addTab("Original Rules", jScrollPane2);

        svJTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        svJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Terminal", "Produccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(svJTable);

        TabbedPane.addTab("Left recursion & left factoring", jScrollPane3);

        primeroJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Non Terminal", "First"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(primeroJTable);

        TabbedPane.addTab("First ( )", jScrollPane4);

        sgtJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Non Terminal", "Follow()"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(sgtJTable);

        TabbedPane.addTab("Follow( )", jScrollPane5);

        tablaMJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tablaMJTable);

        TabbedPane.addTab("LL(1) Parse Table", jScrollPane6);

        ResultLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ResultLabel.setForeground(new java.awt.Color(0, 153, 102));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("E->E+T\nE->T\nT->T*F\nT->F\nF->i\nF->(E)");
        jScrollPane7.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText(" Enter Grammar");

        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("Epsiloon (Ɛ) is represented by & symbol");

        jLabel5.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        ResultLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ResultLabel1.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TabbedPane)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loadBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recogLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jtext_string_analyz, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jbutton_AnalyzeString)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ResultLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loadBT)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(recogLabel)
                        .addComponent(Jtext_string_analyz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jbutton_AnalyzeString))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ResultLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readFile(){
            ge = new ArrayList<>();
            try { 
                BufferedReader br = new BufferedReader(new FileReader("src/main/java/LL1_Parser/input.txt"));
                String line;
                while((line = br.readLine()) != null){
                    ge.add(line);
                }
                br.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error opening the file!");
            }
    }
    
    private void setTablesValues(){
        DefaultTableModel tableModel = (DefaultTableModel)ogJTable.getModel();
        for(String equation : ge){
            String splittedEq[] = equation.split("->");
            String nonTerminal = splittedEq[0];
            String production = splittedEq[1];
            tableModel.addRow(new Object[]{nonTerminal, production});
        }
        tableModel = (DefaultTableModel)svJTable.getModel();
        for(Map.Entry<String, Set<String>> entry : Prepared_Grammer.getNormalizedGE().entrySet()){
            String nonTerminal = entry.getKey();
            Set<String> productions = entry.getValue();
            for(String production : productions){
                tableModel.addRow(new Object[]{nonTerminal, production});
            }
        }
        tableModel = (DefaultTableModel)primeroJTable.getModel();
        for(Map.Entry<String, Set<String>> entry : Prepared_Grammer.getFirst().entrySet()){
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().toString()});
        }
        tableModel = (DefaultTableModel)sgtJTable.getModel();
        for(Map.Entry<String, Set<String>> entry : Prepared_Grammer.getFollow().entrySet()){
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().toString()});
        }
        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        tableModel.addColumn("NonT/Terminal");
        for(String terminal : Prepared_Grammer.getTerminals()){
            tableModel.addColumn(terminal);
        }
        tableModel.addColumn("$");
        for(Map.Entry<String, HashMap<String, String>> entry : LL1.getmTable().entrySet()){
            String nonTerminal = entry.getKey();
            ArrayList<Object> row = new ArrayList<>();
            row.add(nonTerminal);
            for(String terminal : Prepared_Grammer.getTerminals()){
                String production = entry.getValue().get(terminal);
                if(production != null) production = nonTerminal + "->" + production;
                row.add(production);
            }
            row.add(entry.getValue().get("$"));
            tableModel.addRow(row.toArray());
        }
        tablaMJTable.setModel(tableModel);
    }
    
    private void resetValues(){
        Jtext_string_analyz.setText("");
        Prepared_Grammer = null;
        LL1 = null;
        jLabel1.setText("LL1 run complete");
        DefaultTableModel tableModel = (DefaultTableModel)primeroJTable.getModel();
        tableModel.setRowCount(0);
        tableModel = (DefaultTableModel)sgtJTable.getModel();
        tableModel.setRowCount(0);
        tableModel = (DefaultTableModel)ogJTable.getModel();
        tableModel.setRowCount(0);
        tableModel = (DefaultTableModel)svJTable.getModel();
        tableModel.setRowCount(0);
        tableModel = (DefaultTableModel)tablaMJTable.getModel();
        tableModel.setRowCount(0);
        tableModel = (DefaultTableModel)LL1JTable.getModel();
        tableModel.setRowCount(0);
    }
    
    private void loadBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBTActionPerformed
        //Write text area code in file
          try {
            String str =  jTextArea1.getText();
            File newTextFile = new File("src/main/java/LL1_Parser/input.txt");
              try (FileWriter fw = new FileWriter(newTextFile)) {
                  fw.write(str);
              }      
            resetValues();
            //*********** read file
            readFile();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
          
        
        try {
            if(!jTextArea1.getText().isEmpty()){
                Prepared_Grammer = new PrepareGrammar(ge);
                Prepared_Grammer.computeSets();
                
                LL1 = new LL1_Parser(Prepared_Grammer);
                LL1.compute_LL1_Table();
                setTablesValues();
            }
        } catch (Exception e) {
            jLabel1.setText("Error loading grammar.");
        }
    }//GEN-LAST:event_loadBTActionPerformed

    private void Jbutton_AnalyzeStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbutton_AnalyzeStringActionPerformed
        if(!Jtext_string_analyz.getText().isEmpty()){
            DefaultTableModel tableModel = (DefaultTableModel)LL1JTable.getModel();
            tableModel.setRowCount(0);
            if(LL1.acceptedWord(Jtext_string_analyz.getText())){
                JOptionPane.showMessageDialog(null, "String Acceptence By grammar!");
                ResultLabel.setText("Accepted");
                ResultLabel1.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "String is not recognized.");
                ResultLabel1.setText("Rejected");
                ResultLabel.setText("");

            }
            for(Object[] log : LL1.getLogs()){
                tableModel.addRow(log);
            }
        }
    }//GEN-LAST:event_Jbutton_AnalyzeStringActionPerformed

    private void Jtext_string_analyzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jtext_string_analyzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Jtext_string_analyzActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbutton_AnalyzeString;
    private javax.swing.JTextField Jtext_string_analyz;
    private javax.swing.JTable LL1JTable;
    private javax.swing.JLabel ResultLabel;
    private javax.swing.JLabel ResultLabel1;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loadBT;
    private javax.swing.JTable ogJTable;
    private javax.swing.JTable primeroJTable;
    private javax.swing.JLabel recogLabel;
    private javax.swing.JTable sgtJTable;
    private javax.swing.JTable svJTable;
    private javax.swing.JTable tablaMJTable;
    // End of variables declaration//GEN-END:variables
}
