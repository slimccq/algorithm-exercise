package exercise.chapter3.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter3.ST;

import java.util.Iterator;

// 无序数组实现的符号表
public class Exercise2_ArrayST<Key, Value> implements ST<Key, Value> {
    private Key keys[];
    private Value values[];
    private int N;

    public Exercise2_ArrayST()
    {
        this.keys = (Key[])new Object[8];
        this.values = (Value[])new Object[8];
    }

    private void grow() {
        int capacity = this.keys.length;
        Key[] keys = (Key[])new Object[capacity*2];
        Value[] values = (Value[])new Object[capacity*2];
        for (int i = 0;i < capacity; i++) {
            keys[i] = this.keys[i];
            values[i] = this.values[i];
        }
        this.keys = keys;
        this.values = values;
    }

    private int find(Key key) {
        for (int i = 0; i < this.N; i++) {
            if (this.keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void put(Key key, Value val)
    {
        if (this.N >= this.keys.length) {
            grow();
        }
        int i = find(key);
        if (i >= 0) {
            this.values[i] = val;
            return ;
        }
        this.keys[this.N] = key;
        this.values[this.N] = val;
        this.N++;
    }

    public Value get(Key key) {
        int i = find(key);
        if (i >= 0) {
            return this.values[i];
        }
        return null;
    }

    public void delete(Key key) {
        int i = find(key);
        if (i >= 0) {
            int last = this.N - 1;
            this.keys[i] = this.keys[last];
            this.values[i] = this.values[last];
            this.keys[last] = null;
            this.values[last] = null;
            this.N--;
        }
    }

    public boolean contains(Key key) {
        int i = find(key);
        return i >= 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public Iterator<Key> iterator() {
        return new STIterator();
    }

    private class STIterator implements Iterator<Key> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Key next() {
            int old = i;
            i++;
            return keys[old];
        }
    }

}
