package Actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int top;

    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        top = -1;
    }

    public void push(E x) {
        array[++top] = x;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        return array[top--];
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty");
        return array[top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == array.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            sb.append(array[i]).append("\n");
        }
        return sb.toString();
    }
}
