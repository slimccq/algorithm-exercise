package exercise.chapter3;

import java.util.Iterator;

public class BinarySearchST <Key extends Comparable<Key>, Value> implements ComparableST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size = 0;

    public BinarySearchST() {
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

    public void put(Key key, Value val) {
        if (size >= keys.length) {
            grow();
        }
        int i = rank(key);
        if (i < this.size) {
            // 已经存在，更新值
            if (this.keys[i].equals(key)) {
                this.values[i] = val;
                return;
            }
            // 在中间插入
            for (int j = this.size; j > i; j--) {
                this.keys[j] = this.keys[j-1];
                this.values[j] = this.values[j-1];
            }
            this.keys[i] = key;
            this.values[i] = val;
        } else {
            // 在末尾插入
            this.keys[this.size] = key;
            this.values[this.size] = val;
        }
        this.size++;
    }

    public Value get(Key key) {
        int i = rank(key);
        if (i < this.size && this.keys[i].equals(key)) {
            return this.values[i];
        }
        return null;
    }

    public void delete(Key key) {
        if (isEmpty()) {
            return ;
        }
        int i = rank(key);
        if (i >= this.size) {
            return ;
        }
        // 移动后续的项
        for (int j = i; j < this.size - 1; j++) {
            this.keys[j] = this.keys[j++];
            this.values[j] = this.values[j++];
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Key min() {
        if (this.size > 0) {
            return this.keys[0];
        }
        return null;
    }

    // 最大的key
    public Key max() {
        if (this.size > 0) {
            return this.keys[this.size-1];
        }
        return null;
    }

    // 小于等于k的最大key
    public Key floor(Key k) {
        int i = rank(k);
        if (i < this.size) {
            return this.keys[i];
        }
        return null;
    }

    // 大于等于k的最小key
    public Key ceiling(Key k) {
        return null;
    }

    // 小于k的键的数量，所有k需要满足key==select(rank(k))
    public int rank(Key k) {
        int lo = 0;
        int hi = this.size;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean less = keys[mid].compareTo(k) < 0;
            if (less) { // lo <= mid < j
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 排名为rank的键， 所有i需要满足rank(select(i))
    public Key select(int rank) {
        return this.keys[rank];
    }

    @Override
    public Iterator<Key> iterator() {
        return new STIterator();
    }

    private class STIterator implements Iterator<Key> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Key next() {
            int old = i;
            i++;
            return keys[old];
        }
    }
}
