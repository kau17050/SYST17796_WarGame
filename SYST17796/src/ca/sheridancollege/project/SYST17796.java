package ca.sheridancollege.project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author deepr
 */
public class SYST17796 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WarGame warGame = new WarGame();
        warGame.addPlayer(new WarPlayer("Player 1"));
        warGame.addPlayer(new WarPlayer("Player 2"));
        warGame.play();
    }
    
}
