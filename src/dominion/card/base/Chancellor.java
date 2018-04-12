package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {

	public Chancellor(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		int veutDefaussez = -1;
		while(veutDefaussez != 1 && veutDefaussez != 0) {
			System.out.println("Voules vous defaussez tout votre deck et finir votre tour ? (1 = Oui, 0 = Non)");
			try {
				Scanner sc = new Scanner(System.in);
				veutDefaussez = sc.nextInt();
			} catch (Exception e) {
				continue;
			}
		}
		if(veutDefaussez == 1) {
			while(p.getDraw().size() > 0) {
				p.gain(p.getDraw().remove(0));
			}
		}else return;
	}
}