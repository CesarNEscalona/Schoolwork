package board;

import java.util.Arrays;

/**
 * Represents game board class that creates a board based on row and column inputs. This class contains all
 * methods that help with the specific board.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class GameBoard {

    private char[][] board;
    private int row;
    private int col;


    /**
     * Default parameterized constructor that creates a game board with
     * passed in rows and columns
     *
     * @param row an int used to create the game board's row
     * @param col an int used to create a game board's column
     */
    public GameBoard(int row, int col) {
        // create a board as a 2d array with size and row as i or j
        board = new char[row][col];
        this.row = row;
        this.col = col;
    }

    /**
     * This method creates the first stage of the board, empty with dashes
     *
     * @param row takes an int as a parameter to fill the board with dashes down
     * @param col takes an int as a parameter to fill the board with dashes across
     */
    public void fillBoard(int row, int col) {
        // iterate through and place dashes inside the board for initial stage
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = '_';
            }
        }
    }

    /**
     * This method iterates through the board and prints it out, added
     * the extra space on line 57 for a clearer display
     *
     * no params
     */
    public void printBoard(){
        // iterate through and print out the element at [i][j]
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            // go to next line when done printing row, for the next row
            System.out.println();
        }
    }

    /**
     * This method will change the symbol on the board at the location
     * passed in, for that player(char)
     *
     * @param row takes in an int for a row in the board
     * @param col takes in an int for a column in the board
     * @param player takes in a character for the player that is making the move
     */
    public void changePlay(int row, int col, char player){
        // iterate through and change the symbol at the passed in location
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[row][col] = player;
            }
        }
    }

    /**
     * This method will take ints in as parameters to check if the space
     * chosen is taken or not. If there is room available this method will always return true
     *
     * @param row takes in an int for a row in the board
     * @param col takes in an int for a col in the board
     * @return true if the space is available
     */
    public boolean isAvailable(int row, int col) {
        for (char[] chars : board) {
            for (int j = 0; j < chars.length; j++) {
                if (board[row][col] == '_') {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method will loop through all elements until an "empty" space
     * is found, if none are found, the board is full and the game is over
     *
     * @return true if the board is full, false otherwise
     */
    public boolean isBoardFull(){
        for (char[] chars : board) {
            for (char filled : chars) {
                if (filled == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks every cell to see if the player has 3 symbols in a row from the current
     * cell to the right for every cell
     *
     * @param player takes in a char for the player we are checking the points for
     * @return total points for the player if they scored from right to left
     */
    public int rightPoints(char player) {
        // introduce variables
        int pointsRight = 0;
        int total = 0;
        char current;
        char right1;
        char right2;

        // check the current cell, then move right if available
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                if (chars[j] == player) {
                    current = chars[j];
                    if (j < board.length - 2 && chars[j + 1] == player) {
                        right1 = chars[j + 1];
                        if (j < board.length - 1 && chars[j + 2] == player) {
                            right2 = chars[j + 2];
                            if (current == right1 && right1 == right2) {
                                pointsRight += 1;
                            }
                        }
                    }
                }
            }
            // save the total points
            total = pointsRight;
        }
        return total;
    }

    /**
     * This method checks every cell to see if the player has 3 symbols in a row from the
     * current cell down
     *
     * @param player takes in a char for the player we are checking the points for
     * @return total points for the player if they scored from top to bottom
     */
    public int downPoints(char player){
        // introduce variables
        int pointsDown = 0;
        int total = 0;
        char current;
        char down1;
        char down2;

        // check the points from cell down
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == player) {
                    current = board[i][j];
                    if(i < board.length - 2 && board[i+1][j] == player){
                        down1 = board[i+1][j];
                        if(i < board.length - 1 && board[i+2][j] == player){
                            down2 = board[i+2][j];
                            if(current == down1 && down1 == down2){
                                pointsDown += 1;
                            }
                        }
                    }
                }
            }
            // save total points
            total = pointsDown;
        }
        return total;
    }

    /**
     * This method checks every cell to see if the player has 3 symbols in a row from the current
     * cell over to the right and down, checks right diagonally
     *
     * @param player Takes in the player we are checking points for
     * @return total points for the player if they scored from current to diagonal right
     *
     */
    public int diagonalRPoints(char player){
        int diagRPoints = 0;
        int total = 0;
        char current;
        char rightDown1;
        char rightDown2;

        // check the points from cell down and over to the right
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == player) {
                    current = board[i][j];
                    if(i < board.length - 2 && j < board.length - 2 && board[i+1][j+1] == player){
                        rightDown1 = board[i+1][j+1];
                        if(i < board.length - 1 && j < board.length - 1 && board[i+2][j+2] == player){
                            rightDown2 = board[i+2][j+2];
                            if(current == rightDown1 && rightDown1 == rightDown2){
                                diagRPoints += 1;
                            }
                        }
                    }
                }
            }
            // save total points
            total = diagRPoints;
        }
        return total;
    }

    /**
     * This method checks every cell to see if the player has 2 symbols in a row from the current
     * cell to the left and down, checks left diagonally
     *
     * @param player takes in the player we are checking points for
     * @return total points for the player if they scored from current cell to diagonal left
     */
    public int diagonalLPoints(char player){
        int diagLPoints = 0;
        int total = 0;
        char current;
        char leftDown1;
        char leftDown2;

        // check the points from cell down and over to the left
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == player){
                    current = board[i][j];
                    if(i < board.length - 2 && j > board.length - 3 && board[i+1][j-1] == player){
                        leftDown1 = board[i+1][j-1];
                        if(i < board.length - 1 && j > board.length - 2 && board[i+2][j-2] == player){
                            leftDown2 = board[i+2][j-2];
                            if(current == leftDown1 && leftDown1 == leftDown2){
                                diagLPoints += 1;
                            }
                        }
                    }
                }
            }
            // save total points
            total = diagLPoints;
        }
        return total;
    }

    // Generic toString added for linter
    @Override
    public String toString() {
        return "GameBoard{" +
                "board=" + Arrays.toString(board) +
                ", row=" + row +
                ", col=" + col +
                '}';
    }
}