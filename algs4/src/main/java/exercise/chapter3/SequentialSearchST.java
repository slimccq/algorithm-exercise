package exercise.chapter3;


import java.util.Iterator;

// 基于无序链表的符号表
public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

    private LinkedNode first = new LinkedNode(); // 链表
    private int size = 0;

    public SequentialSearchST()
    {
    }

    public void put(Key key, Value val) {
        if (key == null) {
            return ;
        }
        LinkedNode prev = first;
        for (LinkedNode node = prev.next; node != null; node = node.next) {
            if (node.key.equals(key)) {
                if (val == null) {
                    prev.next = node.next; // 删除这个节点
                    size--;
                } else {
                    node.val = val; // 更新
                }
                return ;
            }
            prev = node;
        }
        LinkedNode node = new LinkedNode(key, val);
        node.next = first.next;
        first.next = node;
        size++;
    }

    public Value get(Key key) {
        for (LinkedNode node = first.next; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.val;
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            return ;
        }
        LinkedNode prev = first;
        for (LinkedNode node = prev.next; node != null; node = node.next) {
            if (node.key.equals(key)) {
                prev.next = node.next; // 删除这个节点
                size--;
                return ;
            }
            prev = node;
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

    public Iterator<Key> keys() {
        return new STIterator();
    }

    private class STIterator implements Iterator<Key> {
        LinkedNode node = first;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Key next() {
            node = node.next;
            return node.key;
        }
    }

    public class LinkedNode {
        public LinkedNode next = null;
        public Key key;
        public Value val;

        public LinkedNode()
        {
        }

        public LinkedNode(Key k, Value val) {
            this.key = k;
            this.val = val;
        }

        public LinkedNode(LinkedNode next, Key k, Value val) {
            this.next = next;
            this.key = k;
            this.val = val;
        }
    }
}
