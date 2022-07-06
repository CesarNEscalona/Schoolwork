/**
 *  Author: Cesar Escalona
 *  SDEV301 Systems Programming
 *  This class represents a standard 52 card
 *  deck of playing cards
 */

package deck;

import cards.Card;
import cards.StandardCard;

public class StandardDeck extends Deck {

    public StandardDeck() {
        // create variables to hold suit and rank
        String rank = "";
        String suit = "";

        // create a loop that starts at 1 and stops at 13 cards
        for (int i = 1; i < 14; i++) {
            if (i == 1) {
                rank = "Ace";
            }
            if (i == 2) {
                rank = "2";
            }
            if (i == 3) {
                rank = "3";
            }
            if (i == 4) {
                rank = "4";
            }
            if (i == 5) {
                rank = "5";
            }
            if (i == 6) {
                rank = "6";
            }
            if (i == 7) {
                rank = "7";
            }
            if (i == 8) {
                rank = "8";
            }
            if (i == 9) {
                rank = "9";
            }
            if (i == 10) {
                rank = "10";
            }
            if (i == 11) {
                rank = "Jack";
            }
            if (i == 12) {
                rank = "Queen";
            }
            if (i == 13) {
                rank = "King";
            }

            // once all cards have a rank create a loop for each card to get a suit
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    suit = "Clubs";
                }
                if (j == 1) {
                    suit = "Diamonds";
                }
                if (j == 2) {
                    suit = "Hearts";
                }
                if (j == 3) {
                    suit = "Spades";
                }

                // Construct the card and add the card to the dealerPile
                Card card = new StandardCard(rank, suit);
                addCard(card);
            }
        }
    }

    // Retrieve the card from the parent class and cast the obj to (StandardCard)
    public StandardCard dealTopCard() {
        return (StandardCard) super.dealTopCard();
    }
}