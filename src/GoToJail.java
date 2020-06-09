import javax.swing.JOptionPane;

/*This is a subclass of BoardBlock,sends player to jail
 
*/

public class GoToJail extends BoardBlock{
        
        //Constructor
	public GoToJail(String picturePath) {
		super(picturePath);
		// TODO Auto-generated constructor stub
	}
	//Sends player to jail when he lands to this specific block
	public void blockAction(Player player) {
		JOptionPane.showMessageDialog(null, "Go to Jail");
		player.goToJail();
	}

	public String getType() {
		return "GoToJail";
	}
}
