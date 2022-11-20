package Ultimate_TTT;

public class MainBoard {
    private int size = 9;
    private SmallBoard[] board = new SmallBoard[size];

    MainBoard() {
        for (int i = 0; i < size; i++) {
            board[i] = new SmallBoard();
        }
    }

    SmallBoard getSmallBoard(int boardNum) {return board[boardNum];}

    boolean isFull() {
        for(int i = 0; i < size; i++) {
            if(!board[i].isFull()) {return false;}
        }
        return true;
    }

    void print() {
        int startingBoard = 0;
        int startingBox = 0;

        for(int i = 0; i < size; i++) {
            for (int j = startingBoard; j < startingBoard + 3; j++) {
                for (int k = startingBox; k < startingBox + 3; k++) {
                    System.out.print(board[j].getBox(k).getMark());
                    if((k + 1) % 3 != 0) {System.out.print(' ');}
                }
                System.out.print(((j + 1) % 3 != 0) ? "   " : '\n');
            }
            if((i + 1) % 3 == 0) {
                startingBoard += 3;
                startingBox = 0;
                System.out.println();
            } else {
                startingBox += 3;
            }
        }

    }

}
