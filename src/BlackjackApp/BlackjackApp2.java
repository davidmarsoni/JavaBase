package BlackjackApp;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

import base_jpanel.ApplicationPanel;
import functions.Functions;

public class BlackjackApp2 extends ApplicationPanel {
    private BlackjackGame game;
    private JPanel playerCardsPanel;
    private JPanel dealerCardsPanel;
    private JLabel playerTotalLabel;
    private JLabel dealerTotalLabel;
    private JButton hitButton;
    private JButton stayButton;
    private JButton restartButton;
    private boolean isPlayerRoundOver;

    public BlackjackApp2() {
        super("Livescore App", Functions.getImageIcon("icons\\apps\\blackjack.png"));
        game = new BlackjackGame();
        isPlayerRoundOver = false;
        generateContent();
    }

    @Override
    public void generateContent() {
        super.generateContent();

        JPanel panel = new JPanel(new BorderLayout());

        playerTotalLabel = new JLabel();
        dealerTotalLabel = new JLabel();
        playerCardsPanel = createCardsPanel(game.getPlayerHand(), playerTotalLabel, false);
        dealerCardsPanel = createCardsPanel(game.getDealerHand(), dealerTotalLabel, true);
        panel.add(playerCardsPanel, BorderLayout.NORTH);
        panel.add(dealerCardsPanel, BorderLayout.SOUTH);

        // Add JLabels for player and dealer
    JLabel playerLabel = new JLabel("Player's Cards");
    JLabel dealerLabel = new JLabel("Dealer's Cards");

    // Add a container for each card panel and its label
    JPanel playerContainer = new JPanel(new BorderLayout());
    JPanel dealerContainer = new JPanel(new BorderLayout());

    // Add the labels and card panels to their respective containers
    playerContainer.add(playerLabel, BorderLayout.NORTH);
    playerContainer.add(playerCardsPanel, BorderLayout.CENTER);
    dealerContainer.add(dealerLabel, BorderLayout.NORTH);
    dealerContainer.add(dealerCardsPanel, BorderLayout.CENTER);

    // Add containers to the main panel
    panel.add(playerContainer, BorderLayout.NORTH);
    panel.add(dealerContainer, BorderLayout.SOUTH);

        hitButton = new JButton("Hit");
        hitButton.addActionListener(e -> {
            game.playerHit();
            updateGameUI(isPlayerRoundOver);
        });

        stayButton = new JButton("Stay");
        stayButton.addActionListener(e -> {
            game.endPlayerTurn();
            while (game.getDealerHand().getHandValue() < 17) {
                game.dealerHit();
            }
            isPlayerRoundOver = true;
            updateGameUI(isPlayerRoundOver);
        });

        restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> {
            game = new BlackjackGame();
            isPlayerRoundOver = false;
            updateGameUI(isPlayerRoundOver);
            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);
        buttonPanel.add(restartButton);
        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
        updateGameUI(isPlayerRoundOver);
    }

    private JPanel createCardsPanel(Hand hand, JLabel totalLabel, boolean isDealer) {
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(0, 4, 10, 10)); // 0 means any number of rows, 3 columns, 10px horizontal and vertical gaps
        ArrayList<Card> cards = new ArrayList<>(hand.getCards());
        for (int i = 0; i < cards.size(); i++) {
            if (isDealer && i == 1 && !isPlayerRoundOver) {
                cardsPanel.add(new CardPanel(null)); // Add an empty card panel for the dealer's second card
            } else {
                cardsPanel.add(new CardPanel(cards.get(i)));
            }
        }
        cardsPanel.add(totalLabel);
        return cardsPanel;
    }
    


    private JPanel createHiddenCardPanel() {
        JPanel hiddenCardPanel = new JPanel();
        hiddenCardPanel.setPreferredSize(new Dimension(40, 125));
        hiddenCardPanel.setBackground(Color.GRAY);
        return hiddenCardPanel;
    }
    
    

    private void updateGameUI(boolean isPlayerRoundOver) {
        updateCardsPanel(playerCardsPanel, game.getPlayerHand(), playerTotalLabel, false, isPlayerRoundOver);
        updateCardsPanel(dealerCardsPanel, game.getDealerHand(), dealerTotalLabel, true, isPlayerRoundOver);

        if (game.isPlayerBust()) {
            JOptionPane.showMessageDialog(this, "Player busts! Dealer wins.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
        } else if (game.isDealerBust()) {
            JOptionPane.showMessageDialog(this, "Dealer busts! Player wins.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
        } else if (!game.isPlayerTurn()) {
            if (game.isPlayerWin()) {
                JOptionPane.showMessageDialog(this, "Player wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else if (game.isDraw()) {
                JOptionPane.showMessageDialog(this, "It's a draw!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Dealer wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
        }
    }

    private void updateCardsPanel(JPanel cardsPanel, Hand hand, JLabel totalLabel, boolean isDealer, boolean isPlayerRoundOver) {
        cardsPanel.removeAll();
        int cardIndex = 0;
            for (Card card : hand.getCards()) {
                if (isDealer && cardIndex == 1 && !isPlayerRoundOver) {
                    cardsPanel.add(createHiddenCardPanel());
                } else {
                    cardsPanel.add(new CardPanel(card));
                }
                cardIndex++;
            }
        totalLabel.setText("Total: " + hand.getHandValue());
        cardsPanel.revalidate();
        cardsPanel.repaint();
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Blackjack");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BlackjackApp2());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }
    }