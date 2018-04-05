package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 PiÃ¨ces.
 * Vous pouvez immÃ©diatement dÃ©fausser votre deck.
 */
public class Chancellor extends ActionCard {

	public Chancellor(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		System.out.println("Voules vous défaussez tout votre deck et finir votre tour ? (1 = Oui, 0 = Non)");
		int veutDefaussez = -1;
		while(veutDefaussez != 1 && veutDefaussez != 0) {
			try {
				Scanner sc = new Scanner(System.in);
				veutDefaussez = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Voules vous défaussez tout votre deck et finir votre tour ? (1 = Oui, 0 = Non)");
			}
		}
		if(veutDefaussez == 1) {
			while(p.getHand().size() > 0) {
				p.getGame().getTrash().add(p.getHand().remove(0));
			}
		}else return;
	}
}