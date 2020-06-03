import java.util.ArrayList;

public class PaidByPlayersOrder extends OrderCard {
	private int money;
	
	public PaidByPlayersOrder(String text, int money) {
		super(text);
		this.money = money;
	}

	@Override
	public void cardOrders(Player player) {
		for(Player p: player.getPlayers()) {
			if(!p.equals(player)) {
				p.payPlayer(player, money);
			}
		}
	}
	
	public String getType() {
		return "PaidByPlayersOrder";
	}
}
