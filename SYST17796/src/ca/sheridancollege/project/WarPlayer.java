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
import java.util.List;

public class WarPlayer {
    private final String name;
    private final List<WarCard> hand = new ArrayList<>();

    public WarPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addToHand(WarCard card) {
        hand.add(card);
    }

    public WarCard playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        } else {
            throw new IllegalStateException("Player's hand is empty");
        }
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public int getHandSize() {
        return hand.size();
    }
}