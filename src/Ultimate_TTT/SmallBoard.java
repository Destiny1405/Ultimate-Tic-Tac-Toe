package Ultimate_TTT;

public class SmallBoard implements Board{
    private int size = 9;
    private Box[] board = new Box[size];
    boolean isWon = false;                          // keep track if there is a winner at the small board
    char winner = '-';                              // store winner of the small board

    public SmallBoard() {
        for(int i = 0; i < size; i++) {
            board[i] = new Box();
        }
    }

    Box getBox(int boxNum) {return board[boxNum];}

    char getWinner() {return winner;}

    @Override
    public boolean isFull() {
        for(int i = 0; i < size; i++) {
            if(!board[i].isFull()) {return false;}
        }
        return true;
    }

    @Override
    public boolean checkRow() {
        // check if the boxes have the same mark but not empty
        for (int i = 0; i < size; i += 3) {
            if ((board[i].getMark() != '-') && (board[i].getMark() == board[i + 1].getMark()) && (board[i].getMark() == board[i + 2].getMark())) {
                winner = board[i].getMark();
                isWon = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkCol() {
        // check if the boxes have the same mark but not empty
        for (int i = 0; i < 3; i++) {
            if ((board[i].getMark() != '-') && (board[i].getMark() == board[i + 3].getMark()) && (board[i].getMark() == board[i + 6].getMark())) {
                winner = board[i].getMark();
                isWon = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDiagonal() {
        // check if the boxes have the same mark but not empty
        if ((board[0].getMark() != '-') && (board[0].getMark() == board[4].getMark()) && (board[0].getMark() == board[8].getMark())) {
            winner = board[0].getMark();
            isWon = true;
            return true;
        }
        if ((board[2].getMark() != '-') && (board[2].getMark() == board[4].getMark()) && (board[2].getMark() == board[6].getMark())) {
            winner = board[0].getMark();
            isWon = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkWinner() {
        // if board is already won, return true
        // else check
        if(!isWon) {
            return (checkRow() || checkCol() || checkDiagonal()) ? true : false;
        } else {
            return true;
        }
    }
}