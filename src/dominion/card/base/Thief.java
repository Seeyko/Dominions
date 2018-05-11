package dominion.card.base;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.Card;
import dominion.card.CardList;
import dominion.card.CardType;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. 
 * S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. 
 * Parmi ces cartes Trésor écartées, recevez celles de votre choix. Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {

	public Thief() {
		super("Thief", 4);
	}
	
	public Thief(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
	
		Player adv;
		
		Card firstCard;
		Card secondCard;
		
		String card_to_trash = "";
		String carteChoisi = "poupipoupipoupidou";

		CardList revealCard = new CardList();
		CardList trashedCard = new CardList();
		CardList treasureCard = new CardList();

		for(int i = 0; i < p.otherPlayers().size(); i++) {
			adv = p.otherPlayers().get(i);
			
			//On devoile les 2 premieres cartes du deck
			firstCard = adv.drawCard();
			secondCard = adv.drawCard();
			
			//adv a 0 cartes
			if(firstCard == null && secondCard == null) {
				p.getGame().pause(1000, adv.getName() + " didn't have any cards in his deck");
			} 
			
			//adv a une carte
			else if(firstCard != null && secondCard == null) {
				p.getGame().pause(1000, adv.getName() + " have one card in his deck : " + firstCard.getName());
			
				//La carte devoile est ajouter au tas de cartes revélé.
				revealCard.add(firstCard);

				//Si c'est une carte tresor on l'écarte
				if(firstCard.getTypes().contains(CardType.Treasure)) {
					revealCard.remove(firstCard);
					trashedCard.add(firstCard);
				}
				
			//adv a 2 cartes ou plus
			}else {
				p.getGame().pause(1000, adv.getName() + " have those two card in his deck : " + firstCard.getName() + ", " + secondCard.getName());
				
				revealCard.add(firstCard);
				revealCard.add(secondCard);
				
				//Si la carte est de type tresor l'ajoute a la pile des cartes tresor
				if(firstCard.getTypes().contains(CardType.Treasure)) {
					treasureCard.add(firstCard);
				}
				//Si la carte est de type tresor on l'ajoute a la pile des cartes tresor
				if(secondCard.getTypes().contains(CardType.Treasure)) {
					treasureCard.add(secondCard);
				}
				
				//Si au moins une des deux cartes et de types tresor
				if(!treasureCard.isEmpty()) {
					//On en choisi une a ecarte
					card_to_trash = p.chooseCard("Choose a card to trash ", treasureCard, false);
					//On l'enleve du tas de carte tresor && du tas de carte revelé et on l'ajoute au tas de cartes écarté.
					trashedCard.add(treasureCard.remove(card_to_trash));
					revealCard.remove(card_to_trash);			
				}
			}
			
			adv.getDiscard().addAll(revealCard);			
			revealCard.clear();
			treasureCard.clear();
		}
		
		while(!carteChoisi.equals("")) {
			carteChoisi = p.chooseCard("Choose a card you want to gain : (ENTER TO FINISH)", trashedCard, true);
			p.gain(trashedCard.remove(carteChoisi));
		}
	}
}