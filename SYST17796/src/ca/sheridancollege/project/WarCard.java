/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author deepr4
 */


/**
 *
 * @author deepr4
 */

public class WarCard extends Card implements Comparable<WarCard> {
    private final String gameRank;
    private final String gameSuit;

    // Constructor to convert integer rank to corresponding string representation
    public WarCard(int gameRank, String gameSuit) {
        this.gameRank = convertRankToString(gameRank);
        this.gameSuit = gameSuit;
    }

    @Override
    public String toString() {
        return gameRank + " of " + gameSuit;
    }
    
    public int getGameRank() {
        return switch (gameRank) {
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            case "Jack" -> 11;
            case "Queen" -> 12;
            case "King" -> 13;
            case "Ace" -> 14;
            default -> 0;
        };
    }

    // Convert integer rank to corresponding string representation
    private String convertRankToString(int rank) {
        return switch (rank) {
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            case 14 -> "Ace";
            default -> "Unknown";
        };
    }

    @Override
    public int compareTo(WarCard other) {
        return Integer.compare(this.getGameRank(), other.getGameRank());
    }
}
