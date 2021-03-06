/*
    This class give player the option to interact with his propertycards and other players.
    Methods listed in SDD moved to player and propertycard for nonHuman player.
 */


import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;


public class ManageCards extends javax.swing.JFrame {
    
    //Data of currentPlayer and his cards
    private ArrayList<PropertyCard> collection = new ArrayList<>();
    private Player currentPlayer ;
    
    
    public ManageCards(ArrayList<PropertyCard> playerCollection,Player player) {
        
        this.collection = playerCollection;
        this.currentPlayer = player;
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        DefaultListModel<String> listModel = new DefaultListModel();
        for (int i = 0; i < collection.size(); i++)
        {
            listModel.addElement(collection.get(i).toString());
        }
        playerCollectionList.setModel(listModel);
        moneyLabel.setText( currentPlayer.getMoney() + "E");
        
    
        
        
        
        
        
        
        
        
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        playerCollectionList = new javax.swing.JList<>();
        cardName = new javax.swing.JLabel();
        mortgageButton = new javax.swing.JButton();
        buildButton = new javax.swing.JButton();
        sellButton = new javax.swing.JButton();
        housesLabel = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playerCollectionList.setToolTipText("");
        playerCollectionList.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                playerCollectionListAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        playerCollectionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playerCollectionListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(playerCollectionList);

        mortgageButton.setText("Mortgage");
        mortgageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mortgageButtonActionPerformed(evt);
            }
        });

        buildButton.setText("Build");
        buildButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildButtonActionPerformed(evt);
            }
        });

        sellButton.setText("Sell");
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        housesLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        removeButton.setText("Sell house");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cardName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(housesLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sellButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buildButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeButton)))
                        .addGap(10, 10, 10)
                        .addComponent(mortgageButton)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(housesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mortgageButton)
                    .addComponent(buildButton)
                    .addComponent(sellButton)
                    .addComponent(removeButton))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void playerCollectionListAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_playerCollectionListAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_playerCollectionListAncestorAdded
    //Shows player cards in a label
    private void playerCollectionListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playerCollectionListValueChanged
        // TODO add your handling code here:
        
        int index = playerCollectionList.getSelectedIndex();
        PropertyCard card = collection.get(index);
        
        cardName.setText(playerCollectionList.getSelectedValue());
        if(card.isInMortgage()){
            mortgageButton.setText("Get off mortgage");
         
        }
        else{
            mortgageButton.setText("Put in mortgage");
            
        }
        
        if(card.getTeam().equals("Transport") || card.getTeam().equals("Star")){
            buildButton.setEnabled(false);
            removeButton.setEnabled(false);
            
        }
        else{
            buildButton.setEnabled(true);
            removeButton.setEnabled(true);
            housesLabel.setText("Houses built:"+ card.getHouses());
        }
        housesLabel.setText("Houses built:"+ card.getHouses());
        moneyLabel.setText( currentPlayer.getMoney() + "E");
    }//GEN-LAST:event_playerCollectionListValueChanged
    //Sell button
    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        // TODO add your handling code here:
        Player buyer = null;
        PropertyCard card;
        int index;
        boolean flag = true;
        String name ;
        int price = 0;
       
         name = JOptionPane.showInputDialog(null,"Sell card to player:");
        
        for (Player player : currentPlayer.getPlayers()) {
            
            if(player.getName().equals(name)){
                flag = false;
                buyer = player;
                price= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the price you want to sell the card:"));
                
            }
            
        }
        if(flag){
            JOptionPane.showMessageDialog(null, "Incorrect name");
            
        }
        
        
        index = playerCollectionList.getSelectedIndex();
        card = collection.get(index);
        currentPlayer.sellCard(card,buyer,price);
        moneyLabel.setText( currentPlayer.getMoney() + "E");
        
        
        
    }//GEN-LAST:event_sellButtonActionPerformed
    //Build 1 house button
    private void buildButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildButtonActionPerformed
        // TODO add your handling code here:
        
        int index = playerCollectionList.getSelectedIndex();
        PropertyCard card = collection.get(index);
        
        
        
        if(card.hasSpaceForHouse() && currentPlayer.isCollectionFull(card)){
            card.getOwner().buildHouse(card);
        }
        else if(!card.hasSpaceForHouse()){
            JOptionPane.showMessageDialog(null,"You can't build more houses");
        }
        else{
            JOptionPane.showMessageDialog(null,"Your collection is not full");
        }
        
        housesLabel.setText("Houses built:"+ card.getHouses());
        moneyLabel.setText( currentPlayer.getMoney() + "E");
        
        
        
       
        
        
        
        
        
        
    }//GEN-LAST:event_buildButtonActionPerformed
    //Put card in mortgage
    private void mortgageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mortgageButtonActionPerformed
        // TODO add your handling code here:
        
        int index = playerCollectionList.getSelectedIndex();
        PropertyCard card = collection.get(index);
        
        if(card.isInMortgage()){
            card.outOfMortgage();
            JOptionPane.showMessageDialog(null, "Card is not in mortgage now");
        }
        else{
            card.mortgageCard();
            JOptionPane.showMessageDialog(null, "Card is in mortgage now");
            
            
        }
        moneyLabel.setText( currentPlayer.getMoney() + "E");
        
        
    }//GEN-LAST:event_mortgageButtonActionPerformed
    //Sell house
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        
        int index = playerCollectionList.getSelectedIndex();
        PropertyCard card = collection.get(index);
        
        if(card.getHouses()>0){
            card.getOwner().sellHouse(card);
        }
        else{
            
            JOptionPane.showMessageDialog(null,"No houses to remove");
            
        }
        
        housesLabel.setText("Houses built:"+ card.getHouses());
        moneyLabel.setText( currentPlayer.getMoney() + "E");
    }//GEN-LAST:event_removeButtonActionPerformed
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buildButton;
    private javax.swing.JLabel cardName;
    private javax.swing.JLabel housesLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JButton mortgageButton;
    private javax.swing.JList<String> playerCollectionList;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton sellButton;
    // End of variables declaration//GEN-END:variables
}
