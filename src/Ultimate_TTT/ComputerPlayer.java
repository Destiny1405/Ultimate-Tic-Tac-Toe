package Ultimate_TTT;

public class ComputerPlayer extends Player {
    ComputerPlayer(String name, char mark) {
        super(name,mark);
    }

    int selectBoardNum(int boardNum, int boxNum) {
        if(boardNum == -1) {
            boardNum = (int) (Math.random() * 9);
        } else {
            boardNum = boxNum;
        }
        System.out.println("Board number is " + boardNum);
        return boardNum;
    }

    int selectBoxNum(int boardNum, int boxNum, MainBoard board) {
        do {
            boxNum = (int) (Math.random() * 9);
        } while(board.getSmallBoard(boardNum).getBox(boxNum).isFull());

        System.out.println("Box number is " + boxNum);
        return boxNum;
    }
}