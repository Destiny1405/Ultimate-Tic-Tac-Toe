package Ultimate_TTT;

public interface Board {
    boolean isFull();

    boolean checkRow();

    boolean checkCol();

    boolean checkDiagonal();

    boolean checkWinner();
}
