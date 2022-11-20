package Ultimate_TTT;

public class Box {
    private char mark = '-';

    Box() {}

    char getMark() {
        return mark;
    }

    void setMark(char mark) {
        this.mark = mark;
    }

    boolean isFull() {
        return (mark != '-') ? true: false;
    }
}