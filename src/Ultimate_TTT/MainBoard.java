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

    boolean checkWinner() {
        // check row
        for(int i = 0; i < size; i+=3) {
            if((board[i].checkWinner() != '-') && (board[i].checkWinner() == board[i + 1].checkWinner()) && (board[i].checkWinner() == board[i + 2].checkWinner())) {
                return true;
            }
        }
        // check column
        for(int i = 0; i < 3; i++) {
            if((board[i].checkWinner() != '-') && (board[i].checkWinner() == board[i + 3].checkWinner()) && (board[i].checkWinner() == board[i + 6].checkWinner())) {
                return true;
            }
        }
        // check diagonal
        if((board[0].checkWinner() != '-') && (board[0].checkWinner() == board[4].checkWinner()) && (board[0].checkWinner() == board[8].checkWinner())) {
            return true;
        }
        if((board[2].checkWinner() != '-') && (board[2].checkWinner() == board[4].checkWinner()) && (board[2].checkWinner() == board[6].checkWinner())) {
            return true;
        }

        return false;
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
