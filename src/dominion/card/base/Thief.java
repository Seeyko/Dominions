package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. 
 * S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. 
 * Parmi ces cartes Trésor écartées, recevez celles de votre choix. Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {

	public Thief(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		String carteARecevoir = "poupipoupipoupidou";
		Player adversaire;
		Card carte1, carte2;
		int carte_a_ecarter;
		int autre_carte;
		CardList carteEcartes = new CardList();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < p.otherPlayers().size(); i++) {
			
			adversaire = p.otherPlayers().get(i);
			
			if(!PlayerHasMoatInHand(adversaire)){
				carte1 = adversaire.getHand().get(0);
				carte2 = adversaire.getHand().get(1);
				System.out.println("Joueur : " + adversaire.getName() + " a les cartes : " + carte1 + " et " + carte2);
				
				if(carte1.getTypes().contains(CardType.Treasure) && carte2.getTypes().contains(CardType.Treasure)) {
					System.out.println("Les deux cartes sont de type Tresor, ecarte en une : 1 ou 2");
					
					carte_a_ecarter = sc.nextInt();
					autre_carte = 1 - carte_a_ecarter;
					
					carteEcartes.add(adversaire.getHand().remove(carte_a_ecarter));
					adversaire.getDiscard().add(adversaire.getHand().remove(autre_carte));
				}
			}
		}
		carteARecevoir = p.chooseCard("Selectionnez une carte a recevoir parmis celle-ci : ", carteEcartes, false);
		p.getHand().add(carteEcartes.remove(carteARecevoir));
		p.gain(carteEcartes.get(0));
		
		
	}
}