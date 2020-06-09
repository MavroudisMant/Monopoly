
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*This class decides the winner of the game and terminates the application.
  This class is same as presented in SDD
*/



public class ChooseWinner {
    
    
    //Checks when a player forfeits if the remaining player is the winner
    public boolean checkRemainingPlayers(ArrayList<Player> players){
        if(players.size()==1){
            this.showTheWinner(players.get(0));
            return true;
        }
        else{
            return false;
        }
            
    }
    
    //This method is called when players decide to end the game by themselves and the winner is the wealthiest player
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
    
    //Checks total wealth of the players
    public int checkTotalValue(Player player){
        int sum=0;
        for (PropertyCard card : player.getCards()) {
            sum += card.getPrice() + (card.getHouses()*card.getHousePrice());
        }
        return player.getMoney()+sum;
    }
    
    //Dialoge with the winner and the application is terminated
    public void showTheWinner(Player player){
        JOptionPane.showMessageDialog(null, "The winner is " + player.getName());
        System.exit(0);
        
    }
         
    
    
}
