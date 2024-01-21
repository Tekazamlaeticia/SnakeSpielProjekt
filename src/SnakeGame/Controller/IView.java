/**
 *
 *  * The interface Iview contains  methodes of ViewSnake
 *
 */
package SnakeGame.Controller;

import java.util.List;
/**
 * Draws the current game state with the given state.
 */
public interface IView {
     /**
      * Draws the gameTitle befor starting the Game
      */
     void drawTitleScreen();

     /**
      * Give the position
      */
     void setupGame();

     /**
      * Draw the snake with x and y Position
      * @param x give the x-position
      * @param y give the y-positin
      */
     void drawSnake(List<Integer> x, List<Integer> y);

     /**
      * draw the Foods with x and y Position
      * @param foodX give the x-position for the first food
      * @param foodY give the y-position for the first food
      * @param food2X give the x-position for the second food
      * @param food2Y give the y-position for the second food
      */
     void drawFood(int foodX, int foodY, int food2X, int food2Y);

     /**
      * give the new Screen für the GameOver
      */
     void drawGameOver();

     /**
      * The draw method that calls the nextFrame method of the controller.
      */
     void drawGame();
     /**
      *  The method that draws the black badfood on the screen.
      * @param foodX the x coordinate of bad food
      * @param foodY the x coordinate of bad food
      */
     void drawBadFood(int foodX, int foodY);




}
