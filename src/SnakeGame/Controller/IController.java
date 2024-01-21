/**
 *  The interface IController contains  methodes of ViewSnake
 */
package SnakeGame.Controller;


public interface IController {
    /**
     * nextframe decides what the view should draw next
     */
     void nextFrame();
   /**Implemented method of IController interface.
        * Updates the game state and processes user input
     */
     void userInput(Direction direction);

    //Starts the game by setting the game state to GAME.
    void startGame();


    //Use View drawFood and controller to draws the food on the board.
     void viewDrawFood();
    /**
     * Resets the game if the current game state is GAME_OVER
     * the user clicks on Continue to restart
     * @param mouseClicked der Status des Mausklicks
     */
    void userMouseClicked(int mouseClicked);


}



