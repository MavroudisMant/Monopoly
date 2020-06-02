import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		//Player[] players = new Player[2];
		Player p1 = new Player("Mavroudis");
		Player p2 = new Player("Giorgos");
		Player p3 = new Player("Tralalala");
		Player p4 = new Player("Trololololo");
		ArrayList<Player> players = new ArrayList<>();
		players.add(p1);
		//players.add(p2);
		//players.add(p3);
		//players.add(p4);
		//players[0] = p1;
		//players[1] = p2;
		//new ControlPanel(players);
		//new Board();
		//ControlPanel panel = new ControlPanel();
		//panel.main(players);
		//ControlPanel.main(players);
        ControlPanel panel = new ControlPanel(players);
//        panel.loadGame();
//        ArrayList<OrderCard> cards = new ArrayList<>();
//        cards.add(new PayBankOrder("gia sas", 100, 0));
//		try {
//		FileOutputStream fouts = new FileOutputStream("./CardFiles/OrderCards.ser");
//		ObjectOutputStream douts = new ObjectOutputStream(fouts);
//		douts.writeObject(cards);
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	}

}
