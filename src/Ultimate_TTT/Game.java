package Ultimate_TTT;

import java.util.Scanner;

public class Game {
    private Player[] players = new Player[2];
    private MainBoard board = new MainBoard();
    private int indexCurPlayer = 0;
    private int boardNum = -1;
    private int boxNum = -1;

    Game() {
        setPlayers();
    }

    void setPlayers() {
        players[0] = new HumanPlayer("Player X", 'X');
        players[1] = new ComputerPlayer("Player O", 'O');
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
        System.out.println(players[indexCurPlayer].getName() + " wins!!");
    }

    void makeMove() {
        boardNum = players[indexCurPlayer].selectBoardNum(boardNum,boxNum);
        boxNum = players[indexCurPlayer].selectBoxNum(boardNum,boxNum,board);

        board.getSmallBoard(boardNum).getBox(boxNum).setMark(players[indexCurPlayer].getMark());

        if(board.getSmallBoard(boxNum).isFull()) {boardNum = -1;}
    }
}
