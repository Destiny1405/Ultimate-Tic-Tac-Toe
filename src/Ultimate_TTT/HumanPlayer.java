package Ultimate_TTT;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner input = new Scanner(System.in);

    HumanPlayer(String name, char mark) {
        super(name,mark);
    }

    int selectBoardNum(int boardNum, int boxNum) {
        if(boardNum == -1) {
            do {
                System.out.print("Please enter a valid board number: ");
                boardNum = input.nextInt();
            } while (boardNum < 0 || boardNum > 8);
        } else {
            boardNum = boxNum;
            System.out.println("Board number is " + boxNum);
        }

        return boardNum;
    }

    int selectBoxNum(int boardNum, int boxNum, MainBoard board) {
        do {
            System.out.print("Please enter a valid box number: ");
            boxNum = input.nextInt();
        } while(boxNum < 0 || boxNum > 8 || board.getSmallBoard(boardNum).getBox(boxNum).isFull());

        return boxNum;
    }
}