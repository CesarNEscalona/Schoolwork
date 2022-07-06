/**
 *  Author: Cesar Escalona
 *  SDEV301 Systems Programming
 *  This class represents a deck represents two groups of cards,
 *  a dealer pile and a discard pile. Cards are dealt to a player
 *  from the dealer pile and then placed in the discard pile afterwards.
 */

package deck;

import cards.Card;
import java.util.*;

public class Deck {
    private ArrayList<Card> dealerPile;
    private ArrayList<Card> discardPile;

    public Deck() {
        // Creates a new Deck obj
        this.dealerPile = new ArrayList<>();
        this.discardPile = new ArrayList<>();

    }

    public void addCard(Card card){
        // adds a card to the dealer pile
        this.dealerPile.add(card);
    }

    public void shuffle() {
        // moves all cards from the discard pile to the dealer pile
        // created a variable to save the original .size() of the array
        int j = discardPile.size();
        for (int i = 0; i < j; i++) {
            // remove this card from the discard pile and keep iterating
            Card a = discardPile.remove(0);
            dealerPile.add(a);
        }
        // then randomizes the position of all cards in the dealer pile.
        Collections.shuffle(dealerPile);
    }

    public Card dealTopCard(){
        // removes the top card from the dealer pile and places it in the discard pile,
        Card card1 = dealerPile.remove(0);
        discardPile.add(card1);
        // then returns the removed card.
        return card1;
    }

    public int cardCount() {
        // returns the number of cards in the dealer pile
        // should tell you when you no longer have cards to deal to player.
            return dealerPile.size();
    }

    public String toString() {
         String output = cardCount() + " cards in deck" + "\n" +
                 "*****************" + "\n";
        for (int i = 0; i < dealerPile.size(); i++) {
            output += dealerPile.get(i) + "\n";
        }
        return output;
    }
}
