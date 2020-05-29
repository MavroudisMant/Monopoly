import javax.swing.JOptionPane;

public class GoToJail extends BoardBlock{

	public GoToJail(String picturePath) {
		super(picturePath);
		// TODO Auto-generated constructor stub
	}
	
	public void GoToJailAction(Player player) {
		JOptionPane.showMessageDialog(null, "Go to Jail");
		player.goToJail();
	}

}
