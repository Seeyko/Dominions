package dominion.card.base;
import java.util.*;
import java.util.concurrent.TimeUnit;

import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {

	public Adventurer() {
		super("Adventurer", 6);
	}
	public Adventurer(String name, int cost) {
		super(name, cost);
	}

	
	@Override
	public void play(Player p) {
		CardList carteTresor = new CardList();
		CardList carteADefaussez = new CardList();
		Card cartePiocher;
		
		
		//Tant que le joueur n'as pas piocher 2 cartes au tresor ou qu'il lui reste des cartes a piocher
		 
		while(carteTresor.size() < 2 && (cartePiocher = p.drawCard()) != null){
			
			p.getGame().pause(1000, "Show a draw card : " + cartePiocher.getName());
			
			//Test si la carte piocher et de type tresor
			if(cartePiocher.getTypes().contains(CardType.Treasure)) {
				
				//On l'ajoute au tas des cartes tresor
				carteTresor.add(cartePiocher);
				p.getGame().pause(500, (carteTresor.size() + " Treasure card found"));
				
			}else {
				//Sinon on l'ajoute aux tas de cartes a defaussez
				carteADefaussez.add(cartePiocher);
			}
			
		}
		
		//Quand la boucle est fini on ajoute a notre main les cartes tresor
		p.getGame().pause(1000, "Adding the treasure found to the hand.", ".", ".");
		p.getHand().addAll(carteTresor);
		//Et on défausse les autres cartes.
		p.getGame().pause(1000, "Discarding the other cards.", ".", ".");
		p.getDiscard().addAll(carteADefaussez);
	}
	
	
}