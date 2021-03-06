/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmant
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/*
 * This Class handles the interaction of the user with the app.
 * 
 * Differences between the code and the SDD
 * + ChooseWinner chw
 * + loadGame()
 * + saveGame()
 * + newGame()
 * + getManul()
 * - rollDiceAction() <It was moved to Player>
 * - forfeitAction() <It was moved to Player>
 * - endRoundAction() <It was moved to Player>
 * - executeBlockAction()
 */

public class ControlPanel extends javax.swing.JFrame {

    /**
     * Creates new form ControlPanel
     */
    private int currentPlayerIndex;
    private boolean playAgain = false;
    private ArrayList<Player> players;
    private Board board;
    private ControlPanel frame;   
    private ChooseWinner chw;
    //private DefaultListModel<String> listModel;
    
    
    
    public ControlPanel(ArrayList<Player> players) {
        initComponents();
        chw = new ChooseWinner();
        this.setTitle("Control Panel");
        this.players = players;
        currentPlayerIndex = 0;
    	frame = this;
    	board = new Board();
    	initializeBoard();
        currCardOptions.setEnabled(false); //You can not manage the current card before playing
        endRound.setEnabled(false); //You have to play before finishing your round
        //Set the Panel for the first Player
        updateControlPanel();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        
    }
    
    public void updateControlPanel() {
        DefaultListModel<String> listModel = new DefaultListModel<>();    
    	currentPlayer.setText(players.get(currentPlayerIndex).getName());
    	playerMoney.setText(Integer.toString(players.get(currentPlayerIndex).getMoney())+ "E");   	
    	listModel.clear();
    	for(PropertyCard card: players.get(currentPlayerIndex).getCards())
    	{
    		listModel.addElement(card.getName()+", "+card.getTeam());
    	}
    	playerCards.setModel(listModel);
    	//If the next player is NonHuman he will play his turn without displaying any new Windows
        if(players.get(currentPlayerIndex).getType().equals("NonHumanPlayer")){
            ((NonHumanPlayer)players.get(currentPlayerIndex)).playTurn(this);
        }
        else{
        	/*
        	 * If the next player is Player(human)
        	 * if he is in jail getOutOfJailGui will show and the actions from the control panel
        	 * are disabled so he can not do anything else while in jail
        	 */
            if(players.get(currentPlayerIndex).isInJail())
            {
                currCardOptions.setEnabled(false);
                rollDice.setEnabled(false);
                endRound.setEnabled(false);
                endGame.setEnabled(false);
                GetOutOfJailGUI jailWindow = new GetOutOfJailGUI(frame, false, players.get(currentPlayerIndex));
                jailWindow.setVisible(true);
                
            }
            else{
                rollDice.setEnabled(true);
                currCardOptions.setEnabled(false);
                endGame.setEnabled(true);
            }
        }

    }
    
    
    public void initializeBoard() {
    	board.initializeBoard(players);
    }
    
    public boolean isPlayAgain() {
		return playAgain;
	}

    public void setPlayAgain(boolean playAgain) {
	this.playAgain = playAgain;
    } 
    
    @SuppressWarnings("unchecked")
	public void loadGame(File f){
        try {
            FileInputStream fins = new FileInputStream(f);
            ObjectInputStream dins = new ObjectInputStream(fins);
            this.players = (ArrayList<Player>) dins.readObject();
            this.board.dispose();
            this.board = new Board((BoardBlock[]) dins.readObject());
            dins.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void setCurrentPlayerIndex(int newIndex){
        this.currentPlayerIndex = newIndex;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        currentPlayer = new javax.swing.JLabel();
        playerMoney = new javax.swing.JLabel();
        rollDice = new javax.swing.JButton();
        die1 = new javax.swing.JLabel();
        die2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerCards = new javax.swing.JList<>();
        currCardOptions = new javax.swing.JButton();
        manageCards = new javax.swing.JButton();
        forfeit = new javax.swing.JButton();
        endRound = new javax.swing.JButton();
        endGame = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveGame = new javax.swing.JMenuItem();
        newGame = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        getManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 165, 173));

        currentPlayer.setText("Player Name");

        playerMoney.setText("Money");

        rollDice.setText("Roll Dice");
        rollDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollDiceActionPerformed(evt);
            }
        });

        die1.setText("Die1");

        die2.setText("Die2");

        jScrollPane1.setViewportView(playerCards);

        currCardOptions.setText("Current Card Options");
        currCardOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currCardOptionsActionPerformed(evt);
            }
        });

        manageCards.setText("Manage Cards");
        manageCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCardsActionPerformed(evt);
            }
        });

        forfeit.setText("Forfeit");
        forfeit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forfeitActionPerformed(evt);
            }
        });

        endRound.setText("End Round");
        endRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endRoundActionPerformed(evt);
            }
        });

        endGame.setText("End Game");
        endGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(forfeit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endRound, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(endGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(playerMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rollDice)
                                .addGap(41, 41, 41)
                                .addComponent(die1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(die2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currCardOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(manageCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollDice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(currCardOptions)
                        .addGap(18, 18, 18)
                        .addComponent(manageCards)))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forfeit)
                    .addComponent(endRound)
                    .addComponent(endGame))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        fileMenu.setText("File");

        saveGame.setText("Save Game");
        saveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameActionPerformed(evt);
            }
        });
        fileMenu.add(saveGame);

        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        fileMenu.add(newGame);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Help");

        getManual.setText("Manual");
        getManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getManualActionPerformed(evt);
            }
        });
        helpMenu.add(getManual);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollDiceActionPerformed
        // TODO add your handling code here:
        int dice[] = players.get(currentPlayerIndex).rollDiceAction();
        die1.setText(Integer.toString(dice[0]));
        die2.setText(Integer.toString(dice[1]));
        BoardBlock currBlock = players.get(currentPlayerIndex).movePlayer(dice[0]+dice[1], true);//walks normal. So he has to get paid if he passes the start
        if(currBlock.getType().equals("PropertyCard")){
            currCardOptions.setEnabled(true);
        }
        playAgain = dice[0] == dice[1];
	if(!playAgain) {
	rollDice.setEnabled(false); //if playAgain==true you can roll again
	endRound.setEnabled(true); //if playAgain==false you can finish your round
	}
    }//GEN-LAST:event_rollDiceActionPerformed

    private void currCardOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currCardOptionsActionPerformed
        // TODO add your handling code here:
        CurrentCardOptions currWindow = new CurrentCardOptions((PropertyCard)board.getPlayerPositionOnBoard(), players.get(currentPlayerIndex));
    }//GEN-LAST:event_currCardOptionsActionPerformed

    private void manageCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCardsActionPerformed
        // TODO add your handling code here:
        //Calls the ManageCards class
        players.get(currentPlayerIndex).goToJail();
        ManageCards manageCards = new ManageCards(players.get(currentPlayerIndex).getCards(),players.get(currentPlayerIndex));
    }//GEN-LAST:event_manageCardsActionPerformed

    private void forfeitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forfeitActionPerformed
        // TODO add your handling code here:
        BoardBlock block = board.getPlayerPositionOnBoard();
	block.removePawn(players.get(currentPlayerIndex).getPawn());
        currentPlayerIndex = players.get(currentPlayerIndex).forfeitAction();
        endRound.setEnabled(false); 
    	rollDice.setEnabled(true);
        chw.checkRemainingPlayers(players); //Checks if there is only 1 player left in the game
    }//GEN-LAST:event_forfeitActionPerformed

    private void endRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endRoundActionPerformed
        // TODO add your handling code here:
        //Check if the next player is human/AI and if he is in Jail????? 
        currentPlayerIndex = players.get(currentPlayerIndex).endRoundAction();
	updateControlPanel();
        endRound.setEnabled(false); 
//    	rollDice.setEnabled(true); //when the round finishes re enable the rollDice for the next Player 
    }//GEN-LAST:event_endRoundActionPerformed

    
    private void endGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endGameActionPerformed
        chw.gameFinishedByThePlayers(players);
    }//GEN-LAST:event_endGameActionPerformed

    private void saveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameActionPerformed
        try {
            // TODO add your handling code here:
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("./saved games"));
            int returnVal = fc.showSaveDialog(frame);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                FileOutputStream outFile = new FileOutputStream(fc.getSelectedFile()+".ser");
                ObjectOutputStream douts = new ObjectOutputStream(outFile);
                douts.writeObject(players);
                douts.writeObject(board.getAllTheBlocks());
                douts.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveGameActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        // TODO add your handling code here:
        this.board.dispose();
        this.board = new Board();
        ArrayList<Player> newPlayers = new ArrayList<>();
        for(Player p: players){
           newPlayers.add(new Player(p.getName(), players,p.getPawn()));
        }
        for(Player p: newPlayers){
            p.setBoard(this.board);
        }
        this.players = newPlayers;
        this.initializeBoard();
    }//GEN-LAST:event_newGameActionPerformed

    private void getManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getManualActionPerformed
        File pdf = new File("./Manual/Manual.pdf");
        try {
            Desktop.getDesktop().open(pdf);
        } catch (IOException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_getManualActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton currCardOptions;
    private javax.swing.JLabel currentPlayer;
    private javax.swing.JLabel die1;
    private javax.swing.JLabel die2;
    private javax.swing.JButton endGame;
    private javax.swing.JButton endRound;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton forfeit;
    private javax.swing.JMenuItem getManual;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageCards;
    private javax.swing.JMenuItem newGame;
    private javax.swing.JList<String> playerCards;
    private javax.swing.JLabel playerMoney;
    private javax.swing.JButton rollDice;
    private javax.swing.JMenuItem saveGame;
    // End of variables declaration//GEN-END:variables
}
