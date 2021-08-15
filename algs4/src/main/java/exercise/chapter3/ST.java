package exercise.chapter3;

import java.util.Iterator;

// 无序符号表
public interface ST<Key, Value> extends Iterable<Key> {
    void put(Key key, Value val);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();
}