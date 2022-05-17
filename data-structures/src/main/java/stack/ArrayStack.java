package stack;

public class ArrayStack<E> {

    private E stack[];
    private int top;

    public ArrayStack() {
        stack = (E[]) new Object[1];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
