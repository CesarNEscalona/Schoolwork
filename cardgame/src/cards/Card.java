/**
 *  Author: Cesar Escalona
 *  SDEV301 Systems Programming
 *  This class represents a playing card in any type of card game,
 *  either SetCard or StandardCard
 */

package cards;

public class Card {
    private String cardText;

    public Card(String cardText){
        this.cardText = cardText;
    }

    public String getCardText() {
        return cardText;
    }

    public String toString(){
        return cardText;
    }
}
