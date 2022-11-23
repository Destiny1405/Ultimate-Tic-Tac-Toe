package Ultimate_TTT;

public class SmallBoard {
    private int size = 9;
    private Box[] board = new Box[size];
    boolean isFinished = false;
    char winner = '-';

    public SmallBoard() {
        for(int i = 0; i < size; i++) {
            board[i] = new Box();
        }
    }

    Box getBox(int boxNum) {return board[boxNum];}

    char getWinner() {return winner;}

    boolean isFull() {
        for(int i = 0; i < size; i++) {
            if(!board[i].isFull()) {return false;}
        }
        return true;
    }

    boolean checkRow() {
        for(int i = 0; i < size; i += 3) {
            if((board[i].getMark() != '-') && (board[i].getMark() == board[i + 1].getMark()) && (board[i].getMark() == board[i + 2].getMark())) {
                if(!isFinished) {
                    winner = board[i].getMark();
                    isFinished = true;
                }
                return true;
            }
        }
        return false;
    }

    boolean checkCol() {
        for(int i = 0; i < 3; i++) {
            if((board[i].getMark() != '-') && (board[i].getMark() == board[i + 3].getMark()) && (board[i].getMark() == board[i + 6].getMark())) {
                if(!isFinished) {
                    winner = board[i].getMark();
                    isFinished = true;
                }
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonal() {
        if((board[0].getMark() != '-') && (board[0].getMark() == board[4].getMark()) && (board[0].getMark() == board[8].getMark())) {
            if(!isFinished) {
                winner = board[0].getMark();
                isFinished = true;
            }
            return true;
        }
        if((board[2].getMark() != '-') && (board[2].getMark() == board[4].getMark()) && (board[2].getMark() == board[6].getMark())) {
            if(!isFinished) {
                winner = board[0].getMark();
                isFinished = true;
            }
            return true;
        }
        return false;
    }

    // Check winner of each small board
    boolean checkWinner() {
        return (checkRow() || checkCol() || checkDiagonal()) ? true : false;
    }
}