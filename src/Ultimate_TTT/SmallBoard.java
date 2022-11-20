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
}
