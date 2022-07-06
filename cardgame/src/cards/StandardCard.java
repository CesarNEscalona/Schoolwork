/**
 *  Author: Cesar Escalona
 *  SDEV301 Systems Programming
 *  This class represents a standard playing card, with a suit and rank,
 *  that might be played in a Poker or Blackjack game
 */

package cards;

public class StandardCard extends Card{
    private String rank;
    private String suit;

    public StandardCard(String rank, String suit) {
        super(rank + " of " + suit);
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return super.toString();
    }
}
