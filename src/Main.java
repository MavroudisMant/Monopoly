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
		players.add(p2);
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
	}

}
