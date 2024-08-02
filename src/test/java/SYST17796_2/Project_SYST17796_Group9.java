/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SYST17796_2;

import java.util.ArrayList;

/**
 *
 * @author deepr
 */
public class Project_SYST17796_Group9 {

    /**
     * The main method that starts the game.
     * 
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        // Create two players for the War game
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");

        // Add players to a list
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Create and start a new War game with the players
        WarGame warGame = new WarGame("War Game", players);
        warGame.play();
    }
}
