/**
 * The  Package SnakeThread.Model is an extension of the Thread class
 * is responsible for updating the food location on the board in the snake game.
 */
package SnakeGame.Model;
import java.util.Random;
/**
 * SnakeThread is a class that extends the Thread class and is responsible for updating the food location on the board.
 *
 * @author Laeticia
 * @version 1.0
 */
public class SnakeThread extends Thread {
    /**
     * The model of the Snake game.
     */
    ModelSnake modelSnake;
    /**
     * The constructor that initializes the ModelSnake object.
     *
     * @param modelSnake the model of the Snake game
     */
    public SnakeThread(ModelSnake modelSnake) {
        this.modelSnake = modelSnake;
    }

    /**
     * The Random object for generating random numbers.
     */
    Random rand = new Random();
    /**
     * The range for the random numbers.
     */
    int range = 20;
    /**
     * The run method that updates the location of the food on the board.
     */
    @Override
    public void run() {
        while (true) {
            try {
                modelSnake.setFoodX(rand.nextInt(range));
                modelSnake.setFoodY(rand.nextInt(range));
                Thread.sleep(7000);
              /* modelSnake.setFoodX(rand.nextInt(range));
                modelSnake.setFoodY(rand.nextInt(range));*/
               modelSnake.setBadFood2X(rand.nextInt(range));
                modelSnake.setBadFood2Y(rand.nextInt(range));
                modelSnake.setBadFoodX(rand.nextInt(range));
                modelSnake.setBadFoodY(rand.nextInt(range));
               modelSnake.setFood2X(rand.nextInt(range));
               modelSnake.setFood2Y(rand.nextInt(range));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
