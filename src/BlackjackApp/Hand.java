package BlackjackApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getHandValue() {
        int value = 0;
        int aces = 0;
    
        for (Card card : cards) {
            value += card.getRank().getValue();
            if (card.getRank() == Card.Rank.ACE) {
                aces++;
            }
        }
    
        // Check for Aces and adjust the value accordingly
        while (value + 10 <= 21 && aces > 0) {
            value += 10;
            aces--;
        }
    
        return value;
    }
    

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString();
    }
}
