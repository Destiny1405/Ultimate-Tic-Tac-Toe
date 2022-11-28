package Ultimate_TTT;

public class ComputerPlayer extends Player {
    ComputerPlayer(String name, char mark) {
        super(name,mark);
    }

    // generate input for board number
    int selectBoard(int boardNum, int boxNum, MainBoard board) {
        // if boardNum is -1, then the last player sent the current player to a filled small board
        // so the input will be randomly generated
        // else the current player has to choose the value of the last player's box number
        if(boardNum == -1) {
            // if the small board picked is filled, then generate input again
             do {
                 boardNum = (int) (Math.random() * 9);
             } while(board.getSmallBoard(boardNum).isFull());
        } else {
            boardNum = boxNum;
        }
        System.out.println("Board number is " + boardNum);
        return boardNum;
    }

    // generate input for box number
    int selectBox(int boardNum, int boxNum, MainBoard board) {
        // if the small box is filled, then generate input again
        do {
            boxNum = (int) (Math.random() * 9);
        } while(board.getSmallBoard(boardNum).getBox(boxNum).isFull());

        System.out.println("Box number is " + boxNum);
        return boxNum;
    }
}