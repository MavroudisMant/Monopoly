import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NonHumanPlayer extends Player {
	
	public NonHumanPlayer(String name, ArrayList<Player> players) {
		super(name, players);
	}

	public void playTurn(ControlPanel panel) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!isInJail()) {
			int[] dice = rollDiceAction();
			movePlayer(dice[0]+dice[1], true);
			panel.setCurrentPlayerIndex(endRoundAction(getPlayers().indexOf(this)));
			panel.updateControlPanel();
		}
		else {
			checkGetOutOfJail(panel);
		}
	}
	
	private void checkGetOutOfJail(ControlPanel panel) {
		GetOutOfJail jailOptions = new GetOutOfJail(panel, true, this);
		if(getGetOutOfJailCards().size()>0) {
			jailOptions.useCardAction();
			playTurn(panel);
		}
		else if((getMoney()-50)>150) {
			jailOptions.payAction();
			playTurn(panel);
		}
		else if((getMoney()-50)<150 && getTimeInJail()<3) {
			boolean gotOut = jailOptions.rollAction();
			if(gotOut) {
				playTurn(panel);
			}
			else {
				panel.setCurrentPlayerIndex(endRoundAction(getPlayers().indexOf(this)));
			}
		}
		else if((getMoney()-50)<150 && getTimeInJail()>=3) {
			jailOptions.payAction();
			playTurn(panel);
		}
	}
	
	public String getType() {
		return "NonHumanPlayer";
	}
}
