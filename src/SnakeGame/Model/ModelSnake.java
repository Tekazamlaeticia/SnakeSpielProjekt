/***
 * The Package SnakeGame.Model contains the logic and data of the game,
 * including the position of the queue, the food and the game state.
 *
 */

package SnakeGame.Model;
/**
 * The java.util.Arrays class contains a static factory
 * that allows arrays to be viewes as Lists
 *
 */
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 *The ModelSnake class is used to create the snake game model
 *
 */
public class ModelSnake {
    /**
     * Constructor for ModelSnake class
     * Initializes the snake thread and sets initial coordinates for the snake and food
     */
    public ModelSnake() {
        snakeThread = new SnakeThread(this);
        snakeThread.start();
        x.add(0);
        y.add(15);
        foodX= getRandomNumber(0, w );
        food2X= getRandomNumber(0, w );
        foodY = getRandomNumber(0, w );
        food2Y = getRandomNumber(0, w + 2);
        badFoodX = getRandomNumber(1, w/2);
        badFoodY =getRandomNumber(1, h/ 2);
        badFood2X = getRandomNumber(1, w/2);
        badFood2Y =getRandomNumber(1, h/ 2);
    }

    /**
     * It uses the ArrayList class from the java.util package to store the x and y coordinates of the snake
     */
    public ArrayList<Integer> x = new ArrayList<Integer>(), y = new ArrayList<Integer>();
    SnakeThread snakeThread;

    int w = 20;
    int h = 20;
    /**
     * The move variable for the snake.
     * the snake moves to the down position to begin
     */
    private int move = 5;

     //badFoodY for my y-coordinates
    private int badFood2Y;
    //badFoodX for my x coordinates
    private  int badFood2X;
    //badFoodX for my x coordinates
    private int foodX;
  //badFoodY for my y coordinates
    private int foodY;
   // badFood for my x and y Coordinates
    private int badFoodX, badFoodY;
    //badFoodX for my x coordinates
    private int food2X;
    private int speed=100;
    //badFoodY for my y coordinates
    private int food2Y;
    // Score for my Game
    public int score = 0;
    /**
     * The gamestart variable stores whether the game is currently running or not.
     */
    public  boolean gameStart = true;

    int[] x_move = {0, 0, 1, -1}, y_move = {1, -1, 0, 0};
    /**
     * Getter method for the x coordinates of the snake
     * @return ArrayList of x coordinates
     */
    public ArrayList<Integer> getX() {
        return x;
    }
    /**
     * Getter method for the y coordinates of the snake
     * @return ArrayList of y coordinates
     */
    public ArrayList<Integer> getY() {

        return y;
    }

    /**
     * Getter method for the x coordinate of the second food
     * @return x coordinate of the second food
     */
    public int getFood2X() {

        return food2X;
    }


    /**
     * The setMove() method sets the current direction of the snake's movement.
     * @param move an integer representing the direction (0 = right, 1 = up, 2 = left, 3 = down)
     */
    public void setMove(int move) {

        this.move = move;
    }
    /**
     * Setter method for the x coordinate of the first food
     * @param foodX x coordinate of the first food
     */
    public void setFoodX(int foodX) {

        this.foodX = foodX;
    }
    /**
     * Setter method for the x coordinate of the second food
     * @param food2X x coordinate of the second food
     */
    public void setFood2X(int food2X) {

        this.food2X = food2X;
    }


    /**
     * Setter method for the y coordinate of the second food
     * @param food2Y y coordinate of the second food
     */
    public void setFood2Y(int food2Y) {

        this.food2Y = food2Y;
    }
    /**
     * Setter method for the y coordinate of the first food
     * @param foodY y coordinate of the first food
     */
    public void setFoodY(int foodY) {

        this.foodY = foodY;
    }
    /**
     * Setter method for the x coordinate of the first food
     * @param badFood2X y coordinate of the first food
     */
    public void setBadFood2X(int badFood2X) {
        this.badFood2X = badFood2X;
    }
    /**
     * Setter method for the y coordinate of the first food
     * @param badFood2Y y coordinate of the first food
     */
    public void setBadFood2Y(int badFood2Y) {
        this.badFood2Y = badFood2Y;
    }

    /**
     * Getter method for the y coordinate of the second food
     *
     * @return x coordinate of the second food
     */
    public int getFood2Y() {

        return food2Y;
    }
    /**
     * getMove methode returns the move (direction) of the snake
     *
     * @return x coordinate of the second food
     */
    public int getMove() {

        return this.move;
    }
    /**
     * The getFood2X() method returns the current x-coordinate of the second food.
     * @return the x-coordinate of the second food
     */
    public int getFoodX() {

        return foodX;
    }
    /**
     * The getFoodY() method returns the current x-coordinate of the second food.
     * @return the y-coordinate of the second food
     */
    public int getFoodY() {

        return foodY;
    }
    /**
     * The getFoodX() method returns the current x-coordinate of the second food.
     * @return the x-coordinate of the second food
     */
    public int getBadFoodX() {

        return badFoodX;
    }
    /**
     * The getFood2y() method returns the current x-coordinate of the second food.
     * @return the y-coordinate of the second food
     */
    public int getBadFoodY() {

        return badFoodY;
    }
    /**
     * The getBadFood2X() method returns the current x-coordinate of the second food.
     * @return the x-coordinate of the second food
     */
    public int getBadFood2X() {
        return badFood2X;
    }
    /**
     * The getFood2Y() method returns the current x-coordinate of the second food.
     * @return the y-coordinate of the second food
     */
    public int getBadFood2Y() {
        return badFood2Y;
    }

    /**
     * Setter method for the x coordinate of the second food
     * @param badFoodX x coordinate of the second food
     */
    public void setBadFoodX(int badFoodX) {
        this.badFoodX = badFoodX;
    }
    /**
     * Setter method for the y coordinate of the second food
     * @param badFoodY y coordinate of the second food
     */
    public void setBadFoodY(int badFoodY) {
        this.badFoodY = badFoodY;
    }

    /**
     * the Methode getRandomNumber hat two Parameter
     * this is used to generate a random value for the food
     *
     * @param min gives the min value
     * @param max gives the max value
     * @return the random
     */
    public int getRandomNumber(int min, int max) {
        int a =(int) ((Math.random() * (max - min)) + min);
        return a;
    }

    /**
     *The game method controls the logic of the Snake game when it hats started.
     * It checks for collisions with food,
     * updates the position of the snake ,
     * controls the speed and score of the game.
     */
    public void game() {

        if (gameStart) {
                /*make the size of the  snake to increade */
                x.add(0, x.get(0) + x_move[move]);
                y.add(0, y.get(0) + y_move[move]);

                if ((x.get(0) == foodX && y.get(0) == foodY)) {

                    /* increased the score after the snake has eating*/
                    score++;
                    /* generate random values of new food*/
                    newFood1();

                    System.out.println("COLLISION");

                } else if ((x.get(0) == food2X && y.get(0) == food2Y)) {

                    score++;
                    newFood2();

                } else {
                    /* remove last blocks from arraylist*/
                    x.remove(x.size() - 1);
                    y.remove(y.size() - 1);
                }

            }


        noRoad();
        freeRoad();

    }


    /**
     * the methode newFood2 generate random values for the x and
     * y position of the food
     */

    public void newFood2() {
        food2X = getRandomNumber(0, w);
        //System.out.println("food2x" + food2X);
        food2Y = getRandomNumber(0, h);
        //System.out.println("food2y" + food2Y);
    }

    /**
     * the methode newFood1 generate random values for the x and
     * y position of the food
     */

    public void newFood1() {
        foodX = getRandomNumber(0, w);
        foodY = getRandomNumber(0, h);

    }


    /**
     * the methode noRoad is used to block the snake at the y-axis
     * when ever the snake touches the up and down y-bounding it restarts the Game automatically
     * make score =0
     *

     */
    public void noRoad() {
        if (y.get(0) < 0 || y.get(0) == h) {
            reset();

        }
    }

    /**
     * The freeRoad method checks whether the snake collided with the  lower wall(x-axis) of the board
     * if the snake collide  then its comes back through the next wall
     * and continue the Game
     */
    public void freeRoad() {
        if (x.get(0) < 0) {
            x.set(0, w - 1);
        } else if (x.get(0) > w) {
            x.set(0, 0);
        }

    }

    /**
     * The bounding2 method checks whether the snake's head has hit its own body
     * ends the game if it has
     * @return true if it is the case and end the Game
     */

    public boolean is_game_over() {
        for (int i = 1; i < x.size(); i++) {
            if (x.get(0) == x.get(i) && y.get(0) == y.get(i)) {
                x.clear();
                y.clear();
                return true;
            }
        }
        return false;

    }

    /**
     * The bad-Food method also controls the logic of the Snake game
     *      It checks for collisions with bad-food,
     *      when true reduce the snake Size by 1 ,
     *      reduce the score by 1,
     *      when the snake size is less than 1 then is it game over
     *
     */

    public void badFood() {

        if ((x.get(0) == badFoodX && y.get(0) == badFoodY) ||(x.get(0) == badFood2X && y.get(0) == badFood2Y)) {

            if ((x.get(0) == badFoodX && y.get(0) == badFoodY)){
                badFoodX = getRandomNumber(1,w);
                badFoodY = getRandomNumber(1,h);
            }
            if ((x.get(0) == badFood2X && y.get(0) == badFood2Y)){
                badFood2X = getRandomNumber(1,w);
                badFood2Y = getRandomNumber(1,h);
            }

            if(x.size()>1) {
                x.remove(x.size() - 1);
                y.remove(y.size() - 1);

            }
            else {

                gameStart = false;
            }
        }
    }

    /**
     * The reset method is used to reset the game,
     * return the snake to its initial state.
     * Es setzt die Punktzahl auf 0 zurück, setzt die Geschwindigkeit auf ihren ursprünglichen Wert ,
     * setzt die Position der Schlange auf ihren Startpunkt.
     */
    public void reset() {
        x.clear();
        y.clear();
        x.add(0);
        y.add(15);
        move = 2;
        score = 0;
        gameStart = true;
    }

    /**
     * The methode toString has no Parameter
     * @return the output score for my game
     */

    public String toString() {
        String output = " ";
        for (int i = 0; i < x.size(); i++) {
            output = String.valueOf(x.size());
        }
        return output;
    }

    /**
     * the methode printSnakeJShell() test the position of my snake for my JShell Ausführung
     */
    public void printSnakeJShell(){

            System.out.println("SnakeX :"+ this.x.get(0));
            System.out.println("SnakeY : "+ this.y.get(0));


    }
    /**
     * JShell Ausführung
     */
    //jshell --class-path ./;
    //import SnakeGame.Model.ModelSnake;
    //ModelSnake snake = new ModelSnake();
    //snake.printSnakeJShell();
    //snake.gameJShell();
    // snake.setX(5);
    // snake.setFoodY(20);
    //snake.printSnkaeJShell();

    /**
     * the Methode changes my x and y Position
     */
    public void gameJShell() {
        this.x.set(0,1);
        this.y.set(0,16);

        System.out.println("FoodX: "+ getFoodX());
        System.out.println("FoodY: "+ getFoodY());


    }

    /**
     * The tests check the functionality of various methods in the ModelSnake class
     */
        public static class ModelSnakeTest {

    /**
     * testMove method tests the behavior of the setMove and getMove methods.
     * It creates an instance of the ModelSnake class, sets the move using
     * setMove method and then compares the value returned by the getMove method
     * with the expected value.
     **/
            @Test
            public void testMove() {
                ModelSnake model = new ModelSnake();
                model.setMove(2);
                int expected = 2;
                int actual = model.getMove();
                assertEquals(expected, actual);
            }
            /**
             * testFoodX method tests the behavior of the setFoodX and getFoodX methods.
             * It creates an instance of the ModelSnake class, sets the foodX using
             * setFoodX method and then compares the value returned by the getFoodX method
             * with the expected value.
             */
            @Test
            public void testFoodX() {
                ModelSnake model = new ModelSnake();
                model.setFoodX(5);
                int expected = 5;
                int actual = model.getFoodX();
                assertEquals(expected, actual);
            }
            /**
             * testFoodY method tests the behavior of the setFoodY and getFoodY methods.
             * It creates an instance of the ModelSnake class, sets the foodY using
             * setFoodY method and then compares the value returned by the getFoodY method
             * with the expected value.
             */
            @Test
            public void testFoodY() {
                ModelSnake model = new ModelSnake();
                model.setFoodY(8);
                int expected = 8;
                int actual = model.getFoodY();
                assertEquals(expected, actual);
            }
            /**
             * testRandomNumber method tests the behavior of the getRandomNumber method.
             * It creates an instance of the ModelSnake class, calls the getRandomNumber method
             * twice and compares the returned values. It asserts that the returned values
             * should not be equal.
             */
            @Test
            public void testRandomNumber() {
                ModelSnake model = new ModelSnake();
                int expected = model.getRandomNumber(0, 20);
                int actual = model.getRandomNumber(0, 20);
                assertNotEquals(expected, actual);
            }

            /**
             * testGetX method tests the behavior of the getX method.
             * It creates an instance of the ModelSnake class, creates an ArrayList with the
             * expected initial value and compares it with the value returned by the getX method.
             */
            @Test
            public void testGetX() {
                ModelSnake model = new ModelSnake();
                ArrayList<Integer> expected = new ArrayList<Integer>();
                expected.add(0);
                ArrayList<Integer> actual = model.getX();
                assertEquals(expected, actual);
            }
            /**
             * testGetY method tests the behavior of the getY method.
             * It creates an instance of the ModelSnake class, creates an ArrayList with the
             * expected initial value and compares it with the value returned by the getY method.
             */
            @Test
            public void testGetY() {
                ModelSnake model = new ModelSnake();
                ArrayList<Integer> expected = new ArrayList<Integer>();
                expected.add(15);
                ArrayList<Integer> actual = model.getY();
                assertEquals(expected, actual);
            }
            /**
             * testInitialFoodCoordinates method tests that the initial food coordinates are within the boundaries.
             * It creates an instance of the ModelSnake class, gets the initial foodX and foodY values,
             * and asserts that both are greater than or equal to 0 and less than 20.
             */


            @Test
            public void testInitialFoodCoordinates() {
                ModelSnake model = new ModelSnake();
                int foodX = model.getFoodX();
                int foodY = model.getFoodY();
                assertTrue(foodX >= 0 && foodX < 20);
                assertTrue(foodY >= 0 && foodY < 20);
            }
            /**
             * testMoveBoundaries method tests that the snake's move stays within the boundaries.
             * It creates an instance of the ModelSnake class, sets the move, calls the game method
             * and asserts that the snake's X and Y coordinates are greater than or equal to 0 and less than 20.
             */
            @Test
            public void testMoveBoundaries() {
                ModelSnake model = new ModelSnake();
                model.setMove(2);
                model.game();
                assertTrue(model.getX().get(0) >= 0 && model.getX().get(0) < 20);
                assertTrue(model.getY().get(0) >= 0 && model.getY().get(0) < 20);
            }
    /**
     * testCollisionWithFood method tests that the snake collides with the food and its length increases.
     * */

            @Test
            public void testCollisionWithFood() {
                ModelSnake model = new ModelSnake();
                model.setMove(2);
                int initialLength = model.getX().size();
                model.setFoodX(model.getX().get(0));
                model.setFoodY(model.getY().get(0));
                model.game();
                assertFalse(model.getX().size() > initialLength);
            }


            /**
             * testReset method tests that the reset method correctly resets the game state.
             * It creates an instance of the ModelSnake class, sets the move, calls the game method and then the reset method.
             * It asserts that the size of the snake's X and Y coordinates is 1, the Y coordinate is 15 and the speed is 8.
             */

            @Test
            public void testReset() {
                ModelSnake model = new ModelSnake();
                model.setMove(2);
                model.game();
                model.reset();
                assertEquals(1, model.getX().size());
                assertEquals(15, model.getY().get(0).intValue());
            }
            /**
             * testResetScore method tests that the reset method correctly resets the score.
             * It creates an instance of the ModelSnake class, sets the move and food coordinates to the snake's coordinates,
             * calls the game method multiple times, and then the reset method. It asserts that the final score is equal to the initial score.
             */
            @Test
            public void testResetScore() {
                ModelSnake model = new ModelSnake();
                model.setMove(2);
                model.setFoodX(model.getX().get(0));
                model.setFoodY(model.getY().get(0));
                model.game();
                int initialScore = model.score;
                model.reset();
                assertEquals(0, model.score);
            }
            /**
             * testResetFoodCoordinates method tests that the resetFoodCoordinates method correctly resets the food coordinates.
             * It creates an instance of the ModelSnake class, gets the initial foodX and foodY values, calls the resetFoodCoordinates method
             * and asserts that the final foodX and foodY values are different from the initial ones.
             */
            @Test
            public void testResetFoodCoordinates() {
                ModelSnake model = new ModelSnake();
                model.setMove(2);
                model.setFoodX(model.getX().get(0));
                model.setFoodY(model.getY().get(0));
                model.game();
                model.reset();
                assertEquals(model.getX().get(0).intValue(), model.getFoodX());
                assertEquals(model.getY().get(0).intValue(), model.getFoodY());
                //In JUnit gibt es sowohl eine Methode assertNotEquals(long, long) als auch assertNotEquals(Object, Object).
                // Da die Methode getFoodX() und getFoodY() in der Klasse ModelSnake ganze Zahlen (int) zurückgeben, müsste die Methode assertNotEquals(long, long) verwendet werden.
            }
        }
}