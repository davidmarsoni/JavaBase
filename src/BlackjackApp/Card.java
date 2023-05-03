package BlackjackApp;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank.getDisplayName() + suit.getDisplayName();
    }

    public enum Suit {
        CLUBS("♣️"), DIAMONDS("♦️"), HEARTS("♥"), SPADES("♠️");

        private final String displayName;

        Suit(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum Rank {
        ACE("A", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
        NINE("9", 9), TEN("10", 10), JACK("J", 10), QUEEN("Q", 10), KING("K", 10);

        private final String displayName;
        private final int value;

        Rank(String displayName, int value) {
            this.displayName = displayName;
            this.value = value;
        }

        public String getDisplayName() {
            return displayName;
        }

        public int getValue() {
            return value;
        }
    }
}
