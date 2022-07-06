package match;

import board.GameBoard;
import java.util.*;

/**
 * This class contains all logic for the match played for the user or the Ai
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class Match {
    private boolean aiMatch;

    /**
     * This constructor takes in a boolean that lets it know if the match is user or Ai
     * @param aiMatch Boolean that determines if the match is a user match or an Ai match
     */
    public Match(boolean aiMatch){
        this.aiMatch = aiMatch;
    }

    /**
     * This method plays a game based on if the match is an Ai match or a user match
     */
    public void playGame(){
        // play a match depending on the selection of the user
        if(aiMatch){
            playAI();
        }
        else{
            playUser();
        }
    }

    /**
     * This method consists of all the logic behind the cpu match
     */
    private void playAI(){
        // variables
        char bot = 'X';
        char cpu = 'O';
        // validate board dimensions
        int dimensions = validateDimension();
        GameBoard aiBoard = new GameBoard(dimensions, dimensions);
        aiBoard.fillBoard(dimensions, dimensions);
        // create rng
        Random rand = new Random();
        // Run while the board is NOT full
        aiBoardNotFull(bot, cpu, dimensions, aiBoard, rand);
    }

    /**
     * This method takes in both Ai selections and verifies if they are valid, places them on the board
     *
     * @param bot takes in a char for the player
     * @param cpu takes in a char for the player
     * @param dimensions takes dimensions for the selections
     * @param aiBoard takes in the current aiBoard
     * @param rand takes un a random number generator
     */
    private void aiBoardNotFull(char bot, char cpu, int dimensions, GameBoard aiBoard, Random rand) {
        int cpuRow;
        int cpuCol;
        int botCol;
        int botRow;
        // while the board is not full...
        while (!aiBoard.isBoardFull()){
            // take in first Ai choice, if choice is invalid, keep asking for a valid selection
            botRow = rand.nextInt(dimensions);
            botCol = rand.nextInt(dimensions);
            // if selection is not available, go in
            while (!aiBoard.isAvailable(botRow, botCol)){
                botRow = rand.nextInt(dimensions);
                botCol = rand.nextInt(dimensions);
                // break out of the loop once they make a valid selection
                if(aiBoard.isAvailable(botRow, botCol)){
                    break;
                }
            }
            // change symbol on board for that Ai
            aiBoard.changePlay(botRow, botCol, bot);
            // check if board is full
            if (aiGameOver(aiBoard)) {
                break;
            }

            // take in second Ai choices and validate spots
            cpuRow = rand.nextInt(dimensions);
            cpuCol = rand.nextInt(dimensions);
            // if selection is not available, go in
            while(!aiBoard.isAvailable(cpuRow, cpuCol)){
                cpuRow = rand.nextInt(dimensions);
                cpuCol = rand.nextInt(dimensions);
                // if selection is valid, break
                if(aiBoard.isAvailable(cpuRow, cpuCol)){
                    break;
                }
            }
            // change symbol on board
            aiBoard.changePlay(cpuRow, cpuCol, cpu);
            // check if board is full
            if (aiGameOver(aiBoard)) {
                break;
            }
        }
    }

    /**
     * This method checks if the Ai board is full after every move
     * @param aiBoard Takes in the game board for the Ai match
     */
    private boolean aiGameOver(GameBoard aiBoard) {
        if (aiBoard.isBoardFull()) {
            finalAiBoard(aiBoard);

            // get X
            int xPointsRight = aiBoard.rightPoints('X');
            int xPointsDown = aiBoard.downPoints('X');
            int xPointsDiagR = aiBoard.diagonalRPoints('X');
            int xPointsDiagL = aiBoard.diagonalLPoints('X');
            // Calculate total points
            int xPoints = xPointsDiagR + xPointsDiagL + xPointsRight + xPointsDown;
            System.out.println("Player X points: " + xPoints);

            // get O
            int oPointsRight = aiBoard.rightPoints('O');
            int oPointsDown = aiBoard.downPoints('O');
            int oPointsDiagR = aiBoard.diagonalRPoints('O');
            int oPointsDiagL = aiBoard.diagonalLPoints('O');
            // Calculate total points
            int oPoints = oPointsDiagR + oPointsDiagL + oPointsRight + oPointsDown;
            System.out.println("Player O points: " + oPoints);

            // check who won
            if (xPoints > oPoints) {
                System.out.println("Player X wins!");
            } else if (xPoints == oPoints) {
                System.out.println("Game is a tie!");
            } else {
                System.out.println("Player O wins!");
            }
            return true;
        }
        return false;
    }

    /**
     * This method prints the final Ai board if the game is over
     * @param aiBoard Takes in the game board for the Ai match
     */
    private void finalAiBoard(GameBoard aiBoard) {
        System.out.println();
        System.out.println("Final Board");
        System.out.println("********************");
        aiBoard.printBoard();
        System.out.println("********************");
        System.out.println();
    }

    /**
     * This method consists of all the logic behind the user that plays a match
     */
    private void playUser(){
        //flag variable to know which player is up
        boolean p1Turn = true;
        // Validate board dimensions
        int dimensions = validateDimension();
        // Create user board
        GameBoard userBoard = createUserBoard(dimensions);

        // Game loop Starting....
        while(true){
            // set up a system to check which player is up
            char playPiece = checkForPlayer(p1Turn);
            // Get the players choice
            int userRow = getUserRow(playPiece,
                    dimensions);
            int userCol = getUserCol(playPiece,
                    dimensions);

            // check if position is not available, if so go in
            while(!userBoard.isAvailable(userRow, userCol)){
                System.out.println("Please try another position, this position is filled.");
                userRow = getUserRow(playPiece, dimensions);
                userCol = getUserCol(playPiece, dimensions);
                if(userBoard.isAvailable(userRow, userCol)){
                    break;
                }
            }
            // take that and change the value for Player 1
            p1Turn = updateP1Symbol(playPiece, userRow, userCol, userBoard, false);

            //check if board is full and game is over
            if (userBoardFull(userBoard)) {
                break;
            }

            // Check which player is up
            playPiece = checkForPlayer(p1Turn);
            // get the second players input
            userRow = getUserRow(playPiece, dimensions);
            userCol = getUserCol(playPiece, dimensions);

            // check if position selected is taken, if so do not pass
            while(!userBoard.isAvailable(userRow, userCol)){
                System.out.println("Please try another position, this position is filled.");
                userRow = getUserRow(playPiece, dimensions);
                userCol = getUserCol(playPiece, dimensions);
                if(userBoard.isAvailable(userRow, userCol)){
                    break;
                }
            }
            // update the board
            p1Turn = updateP2Symbol(playPiece, userRow, userCol, userBoard, true);

            //check if board is full and game is over
            if (userBoardFull(userBoard)) {
                break;
            }
        }
    }

    /**
     * This method will update the players choice onto the board
     *
     * @param playPiece Takes in the game board for the Ai match
     * @param userRow takes in a user selected int for row
     * @param userCol takes in a user selected int for col
     * @param userBoard takes in the current user board and changes the symbol
     * @param changePlayer boolean that updates to swap to other player
     */
    private boolean updateP2Symbol(char playPiece, int userRow, int userCol,
                                   GameBoard userBoard, boolean changePlayer) {
        boolean p1Turn;
        userBoard.changePlay(userRow, userCol, playPiece);
        p1Turn = changePlayer; // switch back to first player
        userBoard.printBoard();
        return p1Turn;
    }

    /**
     * This method will update the second players choice onto the board
     *
     * @param playPiece Takes in the game board for the Ai match
     * @param userRow takes in a user selected int for row
     * @param userCol takes in a user selected int for col
     * @param userBoard takes in the current user board and changes the symbol
     * @param switchPlayer boolean that updates to swap to other player
     */
    private boolean updateP1Symbol(char playPiece, int userRow, int userCol,
                                   GameBoard userBoard, boolean switchPlayer) {
        boolean p1Turn;
        userBoard.changePlay(userRow, userCol, playPiece);
        p1Turn = switchPlayer; // switch to second player
        userBoard.printBoard();
        return p1Turn;
    }

    /**
     * This method checks if the board is full, then adds up the total points for each player
     * and prints out the winner
     *
     * @param userBoard Takes in the game board for the user match
     */
    private boolean userBoardFull(GameBoard userBoard) {
        if(userBoard.isBoardFull()){
            finalUserBoard(userBoard);

            // get all X points
            int xPointsRight = userBoard.rightPoints('X');
            int xPointsDown = userBoard.downPoints('X');
            int xPointsDiagR = userBoard.diagonalRPoints('X');
            int xPointsDiagL = userBoard.diagonalLPoints('X');
            // Calculate total points
            int xPoints = xPointsDiagR + xPointsDiagL+ xPointsRight + xPointsDown;
            System.out.println("Player X points: " + xPoints);

            // get all O points
            int oPointsRight = userBoard.rightPoints('O');
            int oPointsDown = userBoard.downPoints('O');
            int oPointsDiagR = userBoard.diagonalRPoints('O');
            int oPointsDiagL = userBoard.diagonalLPoints('O');
            // Calculate total points
            int oPoints = oPointsDiagR + oPointsDiagL + oPointsRight + oPointsDown;
            System.out.println("Player O points: " + oPoints);

            // check who won
            if(xPoints > oPoints) {
                System.out.println("Player X wins!");
            } else if(xPoints == oPoints){
                System.out.println("Game is a tie!");
            } else{
                System.out.println("Player O wins!");
            }
            return true;
        }
        return false;
    }

    /**
     * This method prints out the user board at the final stage
     *
     * @param userBoard takes in the user board and prints it
     */
    private void finalUserBoard(GameBoard userBoard) {
        System.out.println();
        System.out.println("Final Board");
        System.out.println("********************");
        userBoard.printBoard();
        System.out.println("********************");
        System.out.println();
    }

    /**
     * This method creates a user board with the dimensions passed
     *
     * @param dimensions takes an int from the user and creates a board with those dimensions
     */
    private GameBoard createUserBoard(int dimensions) {
        // create userBoard
        GameBoard userBoard = new GameBoard(dimensions, dimensions);
        // fill initial userBoard with _
        userBoard.fillBoard(dimensions, dimensions);
        // Print initial board
        userBoard.printBoard();
        System.out.println();
        return userBoard;
    }

    /**
     * This method gets the dimensions of the board from the user and validates it's greater than 3
     */
    private int validateDimension() {
        // want all user options here
        int dimensions = console.Console.getInt("Enter the dimensions of the board (3+): ");
        // check for valid dimension
        while (dimensions < 3) {
            System.out.println("Please choose a valid dimension (3+)");
            dimensions = console.Console.getInt("Enter the dimensions of the board (3+): ");
        }
        return dimensions;
    }

    /**
     * This method checks to see if it's player 1's turn or player 2's turn based on a bool
     *
     * @param p1Turn takes in a boolean to see if it's player 1's turn or not
     */
    private char checkForPlayer(boolean p1Turn) {
        char playPiece;
        if (p1Turn) {
            playPiece = 'O';
        } else {
            playPiece = 'X';
        }
        return playPiece;
    }

    /**
     * This method gets the user's chosen column, with validation
     *
     * @param playPiece takes in that player who is choosing
     * @param dimensions takes an int from the user and validates it
     */
    private int getUserCol(char playPiece, int dimensions) {
        int userCol;
        userCol = console.Console.getInt("Choose a col: ");
        // check if user selected valid row/col
        while(userCol < 0 || userCol > dimensions - 1){
            System.out.println("Please select a valid column. Max is " + (dimensions - 1) + ".");
            // ask user for row and col to choose
            System.out.println("Player " + playPiece + " turn.");
            userCol = console.Console.getInt("Choose a col: ");
        }
        return userCol;
    }

    /**
     * This method gets the user's chosen row, with validation
     *
     * @param playPiece takes in that player who is choosing
     * @param dimensions takes an int from the user and validates it
     */
    private int getUserRow(char playPiece, int dimensions) {
        int userRow;// ask user for row and col to choose
        System.out.println("Player " + playPiece + " turn.");
        userRow = console.Console.getInt("Choose a row: ");
        // check if user selected valid row/col
        while (userRow < 0 || userRow > dimensions - 1) {
            System.out.println("Please select a valid row. Max is " + (dimensions - 1) + ".");
            // ask user for row and col to choose
            System.out.println("Player " + playPiece + " turn.");
            userRow = console.Console.getInt("Choose a row: ");
        }
        return userRow;
    }

    // Generic toString added for linter
    @Override
    public String toString() {
        return "Match{" +
                "aiMatch=" + aiMatch +
                '}';
    }
}
