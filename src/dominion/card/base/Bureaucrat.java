package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.common.Silver;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {

	public Bureaucrat() {
		super("Bureaucrat", 4);
	}
	
	public Bureaucrat(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		String carteARetirez = "";
		Player adversaire;
		
		p.getDraw().add(p.getGame().removeFromSupply("Silver"));
		
		
		//On parcours la liste de tous les adversaires du player passé en arguments
		for(int i = 0; i < p.otherPlayers().size(); i++) {
			adversaire = p.otherPlayers().get(i);
			
			//On vérifie si l'adversaire possédé la carte Moat
			if(!PlayerHasMoatInHand(adversaire)){
				
				//Animation
				p.getGame().pause(1000, ("Search for treasure card in " + adversaire.getName()) + " hand" ,"." , "." , ".");

				
				carteARetirez = adversaire.chooseCard("Choose a victory card to show ", adversaire.getVictoryCards(), false);
								
				//Si l'adversaire a choisi une carte (il n'a pas appuyé sur ENTRER)
				if(!carteARetirez.equalsIgnoreCase("")){
					//On retire la carte de sa main et on la rajoute a sa pioche
					adversaire.getDraw().add(adversaire.getHand().remove(carteARetirez));
					 p.getGame().pause(1000, "Treasure card found : " + carteARetirez + " putting it on his deck...");

				}else p.getGame().pause(1000, adversaire.getName() + " don't have any treasure card in hand.", "His hand : " + adversaire.getHand());
				
			}
		}
	}
	
}