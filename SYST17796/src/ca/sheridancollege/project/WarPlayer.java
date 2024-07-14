/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author imgur
 */

import java.util.ArrayList;

public class WarPlayer extends Player {
    private ArrayList<PlayingCard> hand;

    public WarPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    public void addCardToHand(PlayingCard card) {
        hand.add(card);
    }

    public PlayingCard playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }

    public ArrayList<PlayingCard> playCards(int number) {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            if (!hand.isEmpty()) {
                cards.add(hand.remove(0));
            }
        }
        return cards;
    }

    @Override
    public void play() {
        // Implementation depends on the game flow, handled in WarGame class
    }
}
