
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ChooseWinner {
    
    public ChooseWinner(){
    
}
    public boolean checkRemainingPlayers(ArrayList<Player> players){
        if(players.size()==1){
            this.showTheWinner(players.get(0));
            return true;
        }
        else{
            return false;
        }
            
    }
    
    public void gameFinishedByThePlayers(ArrayList<Player> players){
        int max = checkTotalValue(players.get(0));
        Player winner = new Player(players.get(0).getName(),players,players.get(0).getPawn());
        
        for (Player player : players) {
            
            if(checkTotalValue(player)>max){
                max = checkTotalValue(player);
                winner = player;
                
            }
        }
        this.showTheWinner(winner);
        
        

    }
    
    public int checkTotalValue(Player player){
        int sum=0;
        for (PropertyCard card : player.getCards()) {
            sum += card.calculateCharge();
        }
        return player.getMoney()+sum;
    }
    
    public void showTheWinner(Player player){
        JOptionPane.showMessageDialog(null, player.getName());
        
    }
         
    
    
}
