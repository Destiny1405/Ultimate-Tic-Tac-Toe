package Ultimate_TTT;

public class SmallBoard {
    private int size = 9;
    private Box[] board = new Box[size];

    public SmallBoard() {
        for(int i = 0; i < size; i++) {
            board[i] = new Box();
        }
    }

    Box getBox(int boxNum) {return board[boxNum];}

    boolean isFull() {
        for(int i = 0; i < size; i++) {
            if(!board[i].isFull()) {return false;}
        }
        return true;
    }

    boolean checkWinner() {
        // check row
        for(int i = 0; i < size; i += 3) {
            if((board[i].getMark() != '-') && (board[i].getMark() == board[i + 1].getMark()) && (board[i].getMark() == board[i + 2].getMark())) {
                return true;
            }
        }
        // check column
        for(int i = 0; i < 3; i++) {
            if((board[i].getMark() != '-') && (board[i].getMark() == board[i + 3].getMark()) && (board[i].getMark() == board[i + 6].getMark())) {
                return true;
            }
        }
        // check diagonal
        if((board[0].getMark() != '-') && (board[0].getMark() == board[4].getMark()) && (board[0].getMark() == board[8].getMark())) {
            return true;
        }
        if((board[2].getMark() != '-') && (board[2].getMark() == board[4].getMark()) && (board[2].getMark() == board[6].getMark())) {
            return true;
        }
        return false;
    }
}
