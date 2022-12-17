package observer;

import java.io.Serializable;
import java.util.Stack;


/**
 * @author sagi yosef azulay
 * StringBuilder with undo support
 * java.lang.StringBuilder - class with modifier <b>final</b>,
 * so no inheritance, use delegation.
 */


interface Action {
    void undo();
}

public class UndoableStringBuilder {

    private final Stack<Action> actions = new Stack<>();
    private final StringBuilder str;

    public UndoableStringBuilder(UndoableStringBuilder s) {
        this.str = new StringBuilder(s.toString());



    }


    public UndoableStringBuilder() {
        this.str = new StringBuilder();

    }

    public UndoableStringBuilder(String s) {
        this.str = new StringBuilder(s);
    }

    public UndoableStringBuilder append(String s) {
        str.append(s);

        Action action = () -> str.delete(str.length() - s.length(), str.length());
        actions.add(action);
        return this;
    }


    public String toString() {
        return this.str.toString();
    }

    public UndoableStringBuilder delete(int start, int end) {
        String deleted = str.substring(start, end);
        str.delete(start, end);
        Action action = () -> str.insert(start, deleted);
        return this;
    }

    public UndoableStringBuilder insert(int offset, String s) {
        this.str.insert(offset, s);
        Action action = () -> str.delete(offset, offset + s.length());
        actions.add(action);
        return this;
    }

    public UndoableStringBuilder replace(int start, int end, String s) {
        String deleted = this.str.substring(start, end);
        this.str.replace(start, end, s);
        Action action = () -> this.str.replace(start, start + s.length(), deleted);
        actions.add(action);
        return this;
    }

    public UndoableStringBuilder reverse() {
        str.reverse();
        Action action = () -> str.reverse();
        actions.add(action);
        return this;
    }

    public void undo() {
        if (!actions.isEmpty())
            actions.pop().undo();


    }


}
