/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;

/**
 *
 * @author imgur
 */
public class NewProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        WarGame warGame = new WarGame("War Game", players);
        warGame.play();
    }
}
