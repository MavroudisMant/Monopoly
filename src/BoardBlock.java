import java.awt.BorderLayout;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BoardBlock implements Serializable {
	 private static int TOTALBLOCKS = 0;
	 private int position;
	 private JLabel picture;
	 private ImageIcon icon;

	 public BoardBlock(String picturePath) {
		 position = TOTALBLOCKS;
		 TOTALBLOCKS++;
		 icon = new ImageIcon(picturePath);
		 picture = new JLabel(icon);
	 }

	public static int getTotalBlocks() {
		return TOTALBLOCKS;
	}

	public int getPosition() {
		return position;
	}

	public JLabel getPicture() {
		return picture;
	}
	
	public void addPawn(JLabel pawn) {
		picture.setLayout(new BorderLayout());
		picture.setIcon(null);//If a picture is same as the current the board does not update
		picture.revalidate();//so it is set to null and then added again
		picture.setIcon(icon);
		picture.add(pawn);
	}
	
	public void removePawn(JLabel pawn) {
		picture.setIcon(null);//to reset the icon
		picture.remove(pawn);// to remove the pawn 
		picture.revalidate();
		picture.setIcon(icon);
	}
	
	public void blockAction(Player player) {
		
	}
	

	@Override
	public String toString() {
		return "BoardBlock [position=" + position + "]";
	}
	
 
}
