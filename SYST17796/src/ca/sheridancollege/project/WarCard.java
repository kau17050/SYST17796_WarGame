/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author deepr4
 */
public class WarCard {
    private final int gameRank;
    private final String gameSuit;

    public WarCard(int gameRank, String gameSuit) {
        this.gameRank = gameRank;
        this.gameSuit = gameSuit;
    }

    @Override
    public String toString() {
        return gameRank + " of " + gameSuit;
    }

    public int getGameRank() {
        return gameRank;
    }

    public String getGameSuit() {
        return gameSuit;
    }
}
