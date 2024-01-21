/**
 * Die GameState-Enumeration definiert die möglichen Zustände des Snake-Spiels.
 */
package SnakeGame.Controller;

public enum GameState {
   //Der Status des Spiels, wenn es auf dem Titelbildschirm angezeigt wird
    TITLE_SCREEN,
    //Der Zustand des Spiels, wenn es sich im eigentlichen Gameplay befindet.
    GAME,
    //Der Zustand des Spiels, wenn der Spieler verliert.
    GAME_OVER

}
