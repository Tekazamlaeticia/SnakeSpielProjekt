/**
 *The ControllerSnake Package implements the IController interface.
 *  It controls the flow of the game by processing user input,
 * updating the model and updating the view
 */
package SnakeGame.Controller;

import SnakeGame.Model.ModelSnake;

/**
 * The ControlSnake class implements the IController interface and controls the flow of the Snake game.
 *
 * It processes user input, updates the model, and updates the view.
 */
public class ControllerSnake implements IController {
  //An instance of Iview
    private IView view;
    //An instance for my Enum GameState
    private GameState state;
    //  An objekt of ModelSnake
    private final ModelSnake model;

    // ein instance of Enum Direction
    Direction direction;

    /**
     * Constructor for ControlSnake class
     * @param view at the view of the Snake game
     *
     */
    public ControllerSnake(IView view) {
        direction = Direction.RIGHT;
        this.view = view;
        this.state = GameState.TITLE_SCREEN;
        this.model = new ModelSnake();
    }



    /**
     * Sets the direction of the Snake based on user input
     */
    private void setSnakeDirection() {
        switch (this.direction) {
            case LEFT -> model.setMove (3);
            case RIGHT -> model.setMove(2);
            case UP -> model.setMove(1);
            case DOWN -> model.setMove(0);
        }
    }

    /**
     * Implemented method of IController interface.
     *
     * Updates the game state and processes user input.
     */
    @Override
    public void nextFrame() {
        switch (state) {
            case TITLE_SCREEN -> {
                view.drawTitleScreen();
            }
            case GAME -> {
                this.setSnakeDirection();
                //call the Game methode to manipulate my Game
                model.game();
                // call badfood
                model.badFood();
                view.drawGame();
                // draw my snake with the initial position using the Model
                view.drawSnake(model.getX(), model.getY());
                //draw food
                viewDrawFood();
                view.drawBadFood(model.getBadFoodX(), model.getBadFoodY());
                view.drawBadFood(model.getBadFood2X(), model.getBadFood2Y());
                if (model.is_game_over() || (!model.gameStart)) {
                    state = GameState.GAME_OVER;
                    System.out.println("your score ist:" + model.score);
                }
            }

            case GAME_OVER -> {
                view.drawGameOver();



            }


        }
    }

    /**
     * Implemented method of IController interface.
     * Draws the food on the board.
     */
    @Override
    public void viewDrawFood() {
        view.drawFood(model.getFoodX(), model.getFoodY(), model.getFood2X(), model.getFood2Y());
    }



    /**
     * Sets the view
     * @param  view to show on screen
     *
     */
    public void setView(IView view){
        this.view = view;
    }

    /**
     * Processes user input based on the current game state.
     * @param direction the direction entered by the user.
     */
    @Override
    public void userInput(Direction direction) {
        switch (state) {
            case TITLE_SCREEN -> {
                view.setupGame();
                state = GameState.GAME;

            }
            case GAME -> {
                this.direction = direction;
               

            }
            case GAME_OVER -> {
                view.drawGameOver();
            }
        }
    }

    /**
     * Starts the game by setting the game state to GAME.
     */
    public void startGame() {
        this.state = GameState.GAME;
    }

    /**
     * Resets the game if the current game state is GAME_OVER
     * the user clicks on Continue to restart
     * @param mouseClicked der Status des Mausklicks
     */
    public void userMouseClicked(int mouseClicked) {
        if(this.state == GameState.GAME_OVER){
            model.reset();
            state= GameState.GAME;
        }
    }
}
