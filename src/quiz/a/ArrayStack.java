package quiz.a;

import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private Object[] data;
    private int size;

    public ArrayStack() {
        this.data = new Object[8];
        this.size = 0;
    }

    @Override
    public void push(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        T value = (T) data[--size];
        data[size] = null;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        T value = (T) data[size - 1];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
