/**
 * The Package SnakeGame.View is responsible for the display of the game, including the title screen, the queue, the food
 * After launching in 1997 on the Nokia 6110, Snake quickly became a phenomenon.
 *  the  SnakeGame  by @Taneli Armanto
 *    New BSD License: https://en.wikipedia.org/wiki/Snake_(video_game_genre)
 *
 */
package SnakeGame.View;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import SnakeGame.Controller.ControllerSnake;
import SnakeGame.Controller.Direction;
import SnakeGame.Controller.IController;
import SnakeGame.Controller.IView;
import controlP5.*;
import java.util.List;
import static controlP5.ControlP5Constants.ACTION_RELEASE;

/**
 * The View contains codes on how to display My GameSnake
 * It extends PApplet and implements the IView interface.
 */
public class ViewSnake extends PApplet implements IView {
    /**
     * The main method that runs the PApplet.Main method to start the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        PApplet.main(ViewSnake.class);
    }
    /**
     * The number of blocks for the snake and food.
     */
    private final int blocks = 30;

    /**
     * The controller for the game.
     */
    private IController controller;
    /**
     * The image of the start Screen .
     */
    PImage startGame;
    /**
     * The background image of the game.
     */
    PImage background1;
    /**
     * The game over image.
     */
    PImage gameOver;
    /**
     * The image of the apple food.
     */
    PImage apple;
    /**
     * The image of the mushroom food.
     */
    PImage mushroom;
    //colors for my snake
    int R, G, B;
    //ControlP5 for my button
    ControlP5 cp5;
   //loadButton to call my button
    Button loadButton;
    //gameStart is false when the Game has not started
    public boolean gameStarted = false;
    /**
     * The settings method that sets the size of the window and loads the images.
     */
    public void settings() {
        size(600, 600);
        startGame = loadImage("startGame.png");
        background1 = loadImage("Gamespiel.png");
        gameOver = loadImage("GameOver.jpg");
        apple = loadImage("Apple.png");
        mushroom = loadImage("mushroom.png");
    }
    /**
     *
     * The setup method that sets the frame rate, initializes the controller, and creates the ControlP5 object.
     * The loadButton is to restart the Game after GameOver
     */
    public void setup() {
        frameRate(6);
        R = (int) random(0, 250);
        G = (int) random(0, 155);
        B = (int) random(0, 255);
        controller = new ControllerSnake( this);
        cp5 = new ControlP5(this);
        loadButton = cp5.addButton("continue?");
        loadButton.setPosition(width / 4 + 200, height/2+210);
        loadButton.setSize(80, 50);
        loadButton.addListenerFor(ACTION_RELEASE, callbackEvent -> {
                try {

                    controller.userMouseClicked(PConstants.ENTER);
                    loadButton.hide();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });


        loadButton.hide();



    }
    /**
     * The draw method that calls the nextFrame method of the controller.
     */

    public void draw() {
        if (controller != null) controller.nextFrame();
    }
    /**
     * The method that draws the title screen of the game.
     */
    public void drawTitleScreen() {
        image(startGame, 0, 0);
        super.textAlign(CENTER, CENTER);
        super.noStroke();
        super.textSize(40);
        super.text("**Welcome to Snake Game** ", width / 2 - 50, height / 4 - 10);
        super.textSize(30);
        super.fill(0);
        super.text("Press any key to start", width / 2 - 70, height / 2 - 80);

    }
    /**
     * The method that sets up the game.
     */
    public void setupGame() {
        super.textAlign(CENTER);
        super.textSize(27);
        super.noStroke();
        super.background(color(0, 0, 0));


    }
    /**
     * The method that draws the snake on the screen.
     *
     * @param x the x coordinates of the snake
     * @param y the y coordinates of the snake
     */
    @Override
    public void drawSnake(List<Integer> x, List<Integer> y) {
        fill(R, G, B);
        for (int i = 0; i < x.size(); i++) {
            super.rect(x.get(i) * blocks, y.get(i) * blocks, blocks, blocks);

        }
        textAlign(RIGHT);
        textSize(30);
        fill(255);
        text("Score: " + (x.size() - 1), 10, 10, width - 20, 50);
    }
    /**
     * The method that draws the food on the screen.
     *
     * @param foodX the x coordinate of the apple food
     * @param foodY the y coordinate of the apple food
     * @param food2X the 2x coordinate of the mushroom food
     * @param food2Y the 2y coordinate of the mushroom food
     */
    @Override
    public void drawFood(int foodX, int foodY, int food2X, int food2Y) {


        image(apple, foodX * blocks, foodY * blocks);

        image(mushroom, food2X * blocks, food2Y * blocks);
    }

    /**
     *  The method that draws the black badfood on the screen.
     * @param foodX the x coordinate of bad food
     * @param foodY the x coordinate of bad food
     */

    public void drawBadFood(int foodX, int foodY) {
        fill(0);
        super.rect(foodX * blocks, foodY * blocks, blocks, blocks);
    }
    /**
     * The method that sets the controller for the game.
     *
     * @param controller the controller for the game
     */
    public void setController(IController controller) {
        this.controller = controller;
    }
    /**
     * The method that draws the game on the screen.
     */

    public void drawGame() {
        image(background1, 0, 0);

    }

    /**
     * The keyPressed method that handles user input.
     * If the game has not started, it calls the startgame method of the controller when you press any Key.
     * If the key is CODED, it checks the keyCode and calls the userInput method of the controller with the corresponding direction.
     */
    public void keyPressed() {
        if (!gameStarted) {
            controller.startGame();
            gameStarted = true;
        }
        if (key == CODED) {
            switch (keyCode) {
                case LEFT:
                    controller.userInput(Direction.LEFT);
                    break;
                case RIGHT:
                    controller.userInput(Direction.RIGHT);
                    break;
                case UP:
                    controller.userInput(Direction.UP);
                    break;
                case DOWN:
                    controller.userInput(Direction.DOWN);

            }
        }

    }



    /**
     * The method that draws the game over screen.
     */
    @Override
    public void drawGameOver() {
        image(gameOver, 0, 0);
        super.textAlign(CENTER, CENTER);
        super.noStroke();
        super.textSize(30);
        super.fill(0);
        super.text("^^Thank you for playing^^", width / 4 + 20, height / 4);
        super.text("Click on continue to restart", width / 4 + 20, height - 100);
        loadButton.show();

    }


}
