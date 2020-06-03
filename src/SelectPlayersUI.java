/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;


public class SelectPlayersUI extends javax.swing.JFrame {

    private int numPlayers;
    private  int i = 1;
    private int playersAdded = 0;
    private ArrayList<Player> players = new ArrayList<>();
    
    
    
    
    

    /**
     * Creates new form SelectPlayerUI
     */
    public SelectPlayersUI() {
        
        
        initComponents();
       compVisibility(false);
       this.setVisible(true);
      
       
       existingGamePanel.setVisible(false);
       newGamePanel.setVisible(false);
       
       
       
       
       
        
        
        
    }
    //Initialize visibility of objects
    private void compVisibility(boolean state){
        
        playersName.setVisible(state);
       
        typeName.setVisible(state);
        pawn1.setVisible(state);
        pawn2.setVisible(state);
        pawn3.setVisible(state);
        pawn4.setVisible(state);
        pawn5.setVisible(state);
        pawn6.setVisible(state);
        selectPawn.setVisible(state);
        currentPlayer.setVisible(state);
        humanButton.setVisible(state);
        addPlayer.setVisible(state);
        errorLabel.setVisible(false);
        jButton1.setVisible(false);
        readyLabel.setVisible(false);
        icon1.setVisible(state);
        icon2.setVisible(state);
        icon3.setVisible(state);
        icon4.setVisible(state);
        icon5.setVisible(state);
        icon6.setVisible(state);
        
        
    }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        firstPanel = new javax.swing.JPanel();
        existingGameButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        newGamePanel = new javax.swing.JPanel();
        typeNumber = new javax.swing.JLabel();
        numberOfPlayers = new javax.swing.JTextField();
        typeName = new javax.swing.JLabel();
        playersName = new javax.swing.JTextField();
        currentPlayer = new javax.swing.JLabel();
        selectPawn = new javax.swing.JLabel();
        pawn1 = new javax.swing.JRadioButton();
        pawn2 = new javax.swing.JRadioButton();
        pawn3 = new javax.swing.JRadioButton();
        pawn4 = new javax.swing.JRadioButton();
        pawn5 = new javax.swing.JRadioButton();
        pawn6 = new javax.swing.JRadioButton();
        humanButton = new javax.swing.JToggleButton();
        addPlayer = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        readyLabel = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        icon5 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        existingGamePanel = new javax.swing.JPanel();
        chooseFile = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        firstPanel.setBackground(new java.awt.Color(43, 31, 105));
        firstPanel.setInheritsPopupMenu(true);
        firstPanel.setName(""); // NOI18N
        firstPanel.setPreferredSize(new java.awt.Dimension(703, 367));

        existingGameButton.setText("Continue Existing Game");
        existingGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existingGameButtonActionPerformed(evt);
            }
        });

        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        photo.setText("jLabel1");

        javax.swing.GroupLayout firstPanelLayout = new javax.swing.GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(existingGameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(firstPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        firstPanelLayout.setVerticalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPanelLayout.createSequentialGroup()
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(existingGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(400, 400, 400))
        );

        newGamePanel.setBackground(new java.awt.Color(51, 204, 255));

        typeNumber.setText("Type the number of players(2-6):");

        numberOfPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPlayersActionPerformed(evt);
            }
        });

        typeName.setText("Type player's name:");

        playersName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersNameActionPerformed(evt);
            }
        });

        currentPlayer.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        currentPlayer.setText("Player 1");

        selectPawn.setText("Select pawn for the player:");

        buttonGroup.add(pawn1);
        pawn1.setToolTipText("");
        pawn1.setActionCommand("icon1");
        pawn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pawn1ActionPerformed(evt);
            }
        });

        buttonGroup.add(pawn2);
        pawn2.setActionCommand("icon2");
        pawn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pawn2ActionPerformed(evt);
            }
        });

        buttonGroup.add(pawn3);
        pawn3.setActionCommand("icon3");

        buttonGroup.add(pawn4);
        pawn4.setActionCommand("icon4");

        buttonGroup.add(pawn5);
        pawn5.setActionCommand("icon5");

        buttonGroup.add(pawn6);
        pawn6.setActionCommand("icon6");

        humanButton.setText("Human Player");
        humanButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                humanButtonStateChanged(evt);
            }
        });

        addPlayer.setText("Add player");
        addPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        errorLabel.setText("Error:Enter a number between 2 and 6");

        jButton1.setText("Start Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        readyLabel.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        readyLabel.setText("You are ready to play!");

        icon3.setIcon(new ImageIcon("Icons/pawn3.png"));

        icon4.setIcon(new ImageIcon("Icons/pawn4.png"));

        icon5.setIcon(new ImageIcon("Icons/pawn5.png"));

        icon6.setIcon(new ImageIcon("Icons/pawn6.png"));

        icon2.setIcon(new ImageIcon("Icons/pawn2.png"));

        icon1.setIcon(new ImageIcon("Icons/pawn1.png"));

        javax.swing.GroupLayout newGamePanelLayout = new javax.swing.GroupLayout(newGamePanel);
        newGamePanel.setLayout(newGamePanelLayout);
        newGamePanelLayout.setHorizontalGroup(
            newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newGamePanelLayout.createSequentialGroup()
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newGamePanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(newGamePanelLayout.createSequentialGroup()
                                .addComponent(typeName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playersName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)
                                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectPawn)
                                    .addGroup(newGamePanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newGamePanelLayout.createSequentialGroup()
                                                .addComponent(pawn5)
                                                .addGap(0, 0, 0))
                                            .addComponent(pawn1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(pawn3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(icon1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(icon3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(icon5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(newGamePanelLayout.createSequentialGroup()
                                .addComponent(typeNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(errorLabel))
                            .addGroup(newGamePanelLayout.createSequentialGroup()
                                .addComponent(humanButton)
                                .addGap(85, 85, 85)
                                .addComponent(addPlayer))))
                    .addGroup(newGamePanelLayout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pawn4)
                    .addComponent(pawn6)
                    .addComponent(pawn2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icon2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(icon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newGamePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(readyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        newGamePanelLayout.setVerticalGroup(
            newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newGamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(readyLabel)
                .addGap(1, 1, 1)
                .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playersName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPawn))
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newGamePanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(humanButton)
                            .addComponent(addPlayer)))
                    .addGroup(newGamePanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(icon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(icon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pawn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pawn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pawn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pawn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icon4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(icon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(newGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(icon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pawn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pawn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        existingGamePanel.setBackground(new java.awt.Color(51, 204, 255));
        existingGamePanel.setPreferredSize(new java.awt.Dimension(703, 367));

        chooseFile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chooseFile.setText("Choose your file to continue the game:");

        javax.swing.GroupLayout existingGamePanelLayout = new javax.swing.GroupLayout(existingGamePanel);
        existingGamePanel.setLayout(existingGamePanelLayout);
        existingGamePanelLayout.setHorizontalGroup(
            existingGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(existingGamePanelLayout.createSequentialGroup()
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        existingGamePanelLayout.setVerticalGroup(
            existingGamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, existingGamePanelLayout.createSequentialGroup()
                .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(newGamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(existingGamePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(newGamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(existingGamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numberOfPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfPlayersActionPerformed
        // TODO add your handling code here:
        
        String s;
        int k;
        s = numberOfPlayers.getText();
        System.out.println(s);
       k = Integer.parseInt(s);
       if(k>6 || k<2){
           System.out.println("error");
           errorLabel.setVisible(true);
           
       }
       else{
           
           numberOfPlayers.setVisible(false);
           typeNumber.setVisible(false);
           compVisibility(true);
           numPlayers = k;
           
       }
       
    }//GEN-LAST:event_numberOfPlayersActionPerformed

    private void playersNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersNameActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_playersNameActionPerformed

    private void humanButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_humanButtonStateChanged
        // TODO add your handling code here:
        if (humanButton.isSelected()){
                humanButton.setText("Non Human player");
            } else {
                humanButton.setText("Human Player");
            }
        
    }//GEN-LAST:event_humanButtonStateChanged

    private void addPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerActionPerformed
        // TODO add your handling code here:
        if(i<=numPlayers){
            
            
        
        String name;
        JLabel pawn = new JLabel();
        boolean nonHuman;
        name = playersName.getText();
        nonHuman = humanButton.isSelected();
        
       
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                 
                 button.setEnabled(false);
                 if(button.getActionCommand().equals("icon1")){
                     pawn = icon1;
                     
                     
                 }
                 else if(button.getActionCommand().equals("icon2")){
                     pawn = icon2;
                     
                 }
                 else if(button.getActionCommand().equals("icon3")){
                     pawn = icon3;
                     
                 }
                 else if(button.getActionCommand().equals("icon4")){
                     pawn = icon4;
                 }
                 else if(button.getActionCommand().equals("icon5")){
                     pawn = icon5;
                 }
                 else if(button.getActionCommand().equals("icon6")){
                     pawn = icon6;
                 }

                 buttonGroup.clearSelection();
                 
                 if(nonHuman){
                    Player player = new NonHumanPlayer(name, players,pawn);
                    players.add(player);
                 }
                 else{
                    Player player = new Player(name, players,pawn);
                    players.add(player);
                 }
            }
        }

        
    
        
        
            
        
        i++;
        currentPlayer.setText("Player " +i);
        
        if(i>numPlayers){    
            compVisibility(false);
            jButton1.setVisible(true);
            readyLabel.setVisible(true);
           }
        
   
        
        }
           
        
    }//GEN-LAST:event_addPlayerActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        // TODO add your handling code here:
        
        newGamePanel.setVisible(true);
        firstPanel.setVisible(false);

    }//GEN-LAST:event_newGameButtonActionPerformed

    private void existingGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existingGameButtonActionPerformed
        // TODO add your handling code here:

        //existingGamePanel.setVisible(true);
        
        firstPanel.setVisible(false);
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        ControlPanel panel = new ControlPanel(players);
        panel.loadGame(f);
        
    }//GEN-LAST:event_existingGameButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ControlPanel panel = new ControlPanel(players);
        this.dispose();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pawn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pawn1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pawn1ActionPerformed

    private void pawn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pawn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pawn2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectPlayersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectPlayersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectPlayersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectPlayersUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayer;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel chooseFile;
    private javax.swing.JLabel currentPlayer;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton existingGameButton;
    private javax.swing.JPanel existingGamePanel;
    private javax.swing.JPanel firstPanel;
    private javax.swing.JToggleButton humanButton;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton newGameButton;
    private javax.swing.JPanel newGamePanel;
    private javax.swing.JTextField numberOfPlayers;
    private javax.swing.JRadioButton pawn1;
    private javax.swing.JRadioButton pawn2;
    private javax.swing.JRadioButton pawn3;
    private javax.swing.JRadioButton pawn4;
    private javax.swing.JRadioButton pawn5;
    private javax.swing.JRadioButton pawn6;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField playersName;
    private javax.swing.JLabel readyLabel;
    private javax.swing.JLabel selectPawn;
    private javax.swing.JLabel typeName;
    private javax.swing.JLabel typeNumber;
    // End of variables declaration//GEN-END:variables
}
