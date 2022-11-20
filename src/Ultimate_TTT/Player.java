package Ultimate_TTT;

public class Player {
    private String name;
    private char mark;

    Player(String name, char mark) {
        setName(name);
        setMark(mark);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    char getMark() {return mark;}

    void setMark(char mark) {this.mark = mark;}

}