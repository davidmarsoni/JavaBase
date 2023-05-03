package BlackjackApp;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private boolean playerTurn;

    public BlackjackGame() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        playerTurn = true;

        initialDeal();
    }

    private void initialDeal() {
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public void playerHit() {
        playerHand.addCard(deck.drawCard());
    }

    public void dealerHit() {
        dealerHand.addCard(deck.drawCard());
    }

    public boolean isPlayerBust() {
        return playerHand.getHandValue() > 21;
    }

    public boolean isDealerBust() {
        return dealerHand.getHandValue() > 21;
    }

    public boolean isPlayerWin() {
        return !isPlayerBust() && (isDealerBust() || playerHand.getHandValue() > dealerHand.getHandValue());
    }

    public boolean isDraw() {
        return !isPlayerBust() && !isDealerBust() && playerHand.getHandValue() == dealerHand.getHandValue();
    }

    public void endPlayerTurn() {
        playerTurn = false;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }
}
