package stack;

import java.util.EmptyStackException;

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

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public void push(E newItem) {
        if (size() == stack.length) {
            resize(2* stack.length);
        }
        stack[++top] = newItem;
    }

    private void resize(int newSize) {
        Object[] newStack = new Object[newSize];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = (E[]) newStack;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E item = stack[top];
        stack[top--] = null;
        if (size() > 0 && size() == stack.length/4) {
            resize(stack.length/2);
        }
        return item;
    }

}
