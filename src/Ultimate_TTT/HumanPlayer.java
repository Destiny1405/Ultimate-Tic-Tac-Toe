package Ultimate_TTT;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner input = new Scanner(System.in);

    HumanPlayer(String name, char mark) {
        super(name,mark);
    }

    // get user input for board number
    int selectBoard(int boardNum, int boxNum, MainBoard board) {
        // if boardNum is -1, then the last player sent the current player to a filled small board
        // so the player can pick any small board
        // else the current player has to choose the value of the last player's box number
        if(boardNum == -1) {
            // if the user enters invalid input or the board picked is filled, get user input again
            do {
                System.out.print("Please enter a valid board number: ");
                boardNum = input.nextInt();
            } while (boardNum < 0 || boardNum > 8 || board.getSmallBoard(boardNum).isFull());
        } else {
            boardNum = boxNum;
            System.out.println("Board number is " + boxNum);
        }

        return boardNum;
    }

    // get user input for box number
    int selectBox(int boardNum, int boxNum, MainBoard board) {
        // if the user enters invalid input or the board picked is filled, get user input again
        do {
            System.out.print("Please enter a valid box number: ");
            boxNum = input.nextInt();
        } while(boxNum < 0 || boxNum > 8 || board.getSmallBoard(boardNum).getBox(boxNum).isFull());

        return boxNum;
    }
}