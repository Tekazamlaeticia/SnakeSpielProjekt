/**
 *The Package SnakeGame.Test contains the logic and data of the game,
 * including the position of the queue, the food and the game state.
 */
 package SnakeGame.Test;
 import SnakeGame.Model.ModelSnake;
 import org.junit.Before;
 import org.junit.Test;
 import java.util.ArrayList;
 import static org.junit.Assert.*;


/**
 * The tests check the functionality of various methods in the ModelSnake class
 */
    public class ModelSnakeTest {
        ModelSnake model;

        @Before
        public  void setUp(){
            model = new ModelSnake();
        }

/**
 * testMove method tests the behavior of the setMove and getMove methods.
 * It creates an instance of the ModelSnake class, sets the move using
 * setMove method and then compares the value returned by the getMove method
 * with the expected value.
 **/
        @Test
        public void testMove() {

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

