package Ultimate_TTT;

/*
Name: Duyen Do
Section: 001
Test: use two computer players to test winning cases and use a human player to test input validation and specific scenario
Analysis:
Create an Ultimate TTT game with these features:
- in each of the nine boxes of the original game, embed a smaller TTT game
- in order to win, the player must win three smaller boards (horizontally, vertically, or diagonally)
- player's board number is determined by the opponent's last placed mark
- if the last player sent the current player to a filled smaller board, the current player can choose any smaller board

Design:
Board implementation:
- board has hierarchy of Box -> SmallBoard -> MainBoard
- MainBoard object is composed of an array of SmallBoard
- SmallBoard object is composed of an array of Box
- SmallBoard and MainBoard share similar methods, so Board interface is implemented
- to check if there is a winner in a small board, check if there are three boxes with the same mark and set variable
isWon to true so the compiler will simply return true next time instead of performing a check again
- to check if there is a winner in the main board, check if there are three small boards with the same winner

Player implementation:
- an abstract Player class is implemented since there are two types of players: HumanPlayer & ComputerPlayer
- in HumanPlayer, the user is asked to enter a valid board number if the last player sent the user to a filled small
board and to enter a valid box number
- in ComputerPlayer, a valid board number is randomly generated if the last player sent the current player to a filled
small board and a valid box number is randomly generated

Game implementation:
- let the user decides game mode
- create a MainBoard and an array of Player
- create a do while loop to keep the game going until the main board is full or there is a winner
- inside the loop, current player is switched and makeMove method is called to get inputs and place mark
 */

public class DriverMain {
    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
}