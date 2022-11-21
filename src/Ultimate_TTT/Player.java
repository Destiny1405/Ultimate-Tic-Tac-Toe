package Ultimate_TTT;

public abstract class Player {
    private String name;
    private char mark;

    Player(String name, char mark) {
        setMark(mark);
        setName(name);
    }

    void setMark(char mark) {this.mark = mark;}

    void setName(String name) {this.name = name;}

    char getMark() {return mark;}

    String getName() {return name;}

    abstract int selectBoardNum(int boardNum, int boxNum);

    abstract int selectBoxNum(int boardNum, int boxNum, MainBoard board);

}
