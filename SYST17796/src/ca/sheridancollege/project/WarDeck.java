/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author deepr
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WarDeck {
    private final List<WarCard> cards = new ArrayList<>();

    public WarDeck() {
        startDeck();
        shuffle();
    }

    private void startDeck() {
        String[] gameSuits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String gameSuit : gameSuits) {
            for (int gameRank = 2; gameRank <= 14; gameRank++) {
                cards.add(new WarCard(gameRank, gameSuit));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public WarCard drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            throw new IllegalStateException("Deck is empty");
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}