package BlackjackApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CardPanel extends JPanel {
    private Card card;

    public CardPanel(Card card) {
        this.card = card;
        setPreferredSize(new Dimension(40, 125));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        String rank = card.getRank().getDisplayName();
        String suit = card.getSuit().getDisplayName();

        // Set color based on the suit
        if (card.getSuit() == Card.Suit.DIAMONDS || card.getSuit() == Card.Suit.HEARTS) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }

        Font font = new Font("Arial", Font.BOLD, 30);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);

        int rankWidth = metrics.stringWidth(rank);
        int suitWidth = metrics.stringWidth(suit);
        int rankHeight = metrics.getAscent();
        int suitHeight = metrics.getAscent();

        g.drawString(rank, (getWidth() - rankWidth) / 2, getHeight() / 2 - rankHeight / 2);
        g.drawString(suit, (getWidth() - suitWidth) / 2, getHeight() / 2 + suitHeight / 2);
    }

}
