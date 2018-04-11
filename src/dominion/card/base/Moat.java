package dominion.card.base;
import java.util.Scanner;

import dominion.Player;
import dominion.card.ReactionCard;

/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {

	public Moat(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.drawCard_AndAddInHand();
		p.drawCard_AndAddInHand();
	}
	
	public boolean devoileCarte(Player p){
		int answer;
		Scanner sc = new Scanner(System.in);
		System.out.println(p.getName() + ", veut tu jouer ta carte Moat ? (1 = Oui, 0 = Non");
		answer = sc.nextInt();
		if(answer == 1) return true;
		else return false;
	}
}