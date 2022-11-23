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

    boolean checkRow() {
        for(int i = 0; i < size; i+=3) {
            if (board[i].checkWinner() && board[i + 1].checkWinner() && board[i + 2].checkWinner()) {
                if((board[i].getWinner() == board[i + 1].getWinner()) && board[i].getWinner() == board[i + 2].getWinner()) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkCol() {
        for(int i = 0; i < 3; i++) {
            if (board[i].checkWinner() && board[i + 3].checkWinner() && board[i + 6].checkWinner()) {
                if((board[i].getWinner() == board[i + 3].getWinner()) && board[i].getWinner() == board[i + 6].getWinner()) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkDiagonal() {
        if (board[0].checkWinner() && board[4].checkWinner() && board[8].checkWinner()) {
            if((board[0].getWinner() == board[4].getWinner()) && board[0].getWinner() == board[8].getWinner()) {
                return true;
            }
        }
        if (board[2].checkWinner() && board[4].checkWinner() && board[6].checkWinner()) {
            if((board[2].getWinner() == board[4].getWinner()) && board[2].getWinner() == board[6].getWinner()) {
                return true;
            }
        }
        return false;
    }

    boolean checkWinner() {
        return (checkRow() || checkCol() || checkDiagonal()) ? true : false;
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
