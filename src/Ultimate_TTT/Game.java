package Ultimate_TTT;

import java.util.Scanner;

public class Game {
    private Player[] players = new Player[2];
    private MainBoard board = new MainBoard();
    private int indexCurPlayer = 0;

    Game() {
        setPlayers();
    }

    void setPlayers() {
        players[0] = new Player("Player X", 'X');
        players[1] = new Player("Player O", 'O');
    }

    void start() {
        System.out.println("Game started...");
        board.print();

        do {
            indexCurPlayer = (indexCurPlayer != 0) ? 0 : 1;
            System.out.println(players[indexCurPlayer].getName() + "'s turn");
            makeMove();
            board.print();
        } while(!board.isFull() && !board.checkWinner());
        System.out.println(players[indexCurPlayer] + " wins!!");
    }

    void makeMove() {
        Scanner input = new Scanner(System.in);
        int boardNum;
        int boxNum;

        do {
            System.out.print("Please enter a valid board number: ");
            boardNum = input.nextInt();
        } while(boardNum < 0 || boardNum > 8 || board.getSmallBoard(boardNum).isFull());

        do {
            System.out.print("Please enter a valid box number: ");
            boxNum = input.nextInt();
        } while(boxNum < 0 || boxNum > 8 || board.getSmallBoard(boardNum).getBox(boxNum).isFull());

        board.getSmallBoard(boardNum).getBox(boxNum).setMark(players[indexCurPlayer].getMark());
    }
}
