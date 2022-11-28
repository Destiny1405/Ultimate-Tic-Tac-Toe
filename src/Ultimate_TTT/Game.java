package Ultimate_TTT;

import java.util.Scanner;

// controls game flow
public class Game {
    private Player[] players = new Player[2];       // create 2 players
    private MainBoard board = new MainBoard();
    private int indexCurPlayer = -1;                // keep track of current player
    private int boardNum = -1;                      // store board number
    private int boxNum = -1;                        // store box number

    Game() {
        setPlayers();
    }

    void setPlayers() {
        Scanner input = new Scanner(System.in);
        int mode;

        do {
            System.out.println("Choose game mode:");
            System.out.println("1. Player vs. Player");
            System.out.println("2. Player vs. Computer");
            System.out.println("3. Computer vs. Computer");
            mode = input.nextInt();
        } while(mode < 1 || mode > 3);

        switch (mode) {
            case 1:
                players[0] = new HumanPlayer("Player X", 'X');
                players[1] = new HumanPlayer("Player O", 'O');
                break;
            case 2:
                players[0] = new HumanPlayer("Player X", 'X');
                players[1] = new ComputerPlayer("Player O", 'O');
                break;
            case 3:
                players[0] = new ComputerPlayer("Player X", 'X');
                players[1] = new ComputerPlayer("Player O", 'O');
                break;
        }
    }

    void start() {
        System.out.println("Game started...");
        board.print();

        // continue the game until the main board is full or there is a winner
        do {
            indexCurPlayer = (indexCurPlayer != 0) ? 0 : 1;                         // switch between players
            System.out.println(players[indexCurPlayer].getName() + "'s turn");
            makeMove();
            board.print();
        } while(!board.isFull() && !board.checkWinner());
        if(board.checkWinner()) {
            System.out.println(players[indexCurPlayer].getName() + " wins!!");
        } else {
            System.out.println("Tied!");
        }
    }

    void makeMove() {
        // get board number input and box number input
        boardNum = players[indexCurPlayer].selectBoard(boardNum,boxNum,board);
        boxNum = players[indexCurPlayer].selectBox(boardNum,boxNum,board);

        // set mark
        board.getSmallBoard(boardNum).getBox(boxNum).setMark(players[indexCurPlayer].getMark());

        // set boardNum to -1 if small board at index boxNum is filled
        if(board.getSmallBoard(boxNum).isFull()) {boardNum = -1;}
    }
}
