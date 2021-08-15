package exercise.chapter3;

import java.util.Iterator;

// 有序链表实现
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private LinkedNode first = new LinkedNode(); // 从小到大的顺序
    private int N = 0;

    private LinkedNode findNode(Key key) {
        return null;
    }

    public void put(Key key, Value val) {
        LinkedNode prev = first;
        LinkedNode node = first.next;
        for (; node != null; node = node.next) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                node.val = val;
                return;
            } else if (cmp < 0) {
                LinkedNode newnode = new LinkedNode(key, val);
                newnode.next = node;
                prev.next = newnode;
                this.N++;
                return;
            }
            prev = node;
        }
        LinkedNode newnode = new LinkedNode(key, val);
        prev.next = newnode;
        this.N++;
    }

    public Value get(Key key) {
        for (LinkedNode node = first.next; node != null; node = node.next) {
            int cmp = node.key.compareTo(key);
            if (cmp == 0) {
                return node.val;
            } else if (cmp > 0) {
                break;
            }
        }
        return null;
    }

    public void delete(Key key) {
        LinkedNode prev = first;
        for (LinkedNode node = prev.next; node != null; node = node.next) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                prev.next = node.next; // delete node
                return;
            } else if (cmp > 0) {
                break;
            }
            prev = node;
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 最小的key
    public Key min() {
        if (first.next != null) {
            return first.next.key;
        }
        return null;
    }

    // 最大的key
    public Key max() {
        LinkedNode node = first.next;
        while (node != null && node.next != null) {
            node = node.next;
        }
        if (node != null) {
            return node.key;
        }
        return null;
    }

    // 小于等于k的最大key
    public Key floor(Key k) {
        LinkedNode prev = first;
        for (LinkedNode node = prev.next; node != null; node = node.next) {
            int cmp = k.compareTo(node.key);
            if (cmp > 0) {
                return prev.key;
            }
        }
        return null;
    }

    // 大于等于k的最小key
    public Key ceiling(Key k) {
        for (LinkedNode node = first.next; node != null; node = node.next) {
            int cmp = node.key.compareTo(k);
            if (cmp >= 0) {
                return node.key;
            }
        }
        return null;
    }

    // 小于k的键的数量，所有k需要满足key==select(rank(k))
    public int rank(Key k) {
        int count = 0;
        for (LinkedNode node = first.next; node != null; node = node.next) {
            int cmp = k.compareTo(node.key);
            if (cmp > 0) {
                break;
            }
            count++;
        }
        return count;
    }

    // 排名为rank的键， 所有i需要满足rank(select(i))
    public Key select(int rank) {
        LinkedNode node = first.next;
        while (rank >= 0 && node != null) {
            node = node.next;
            rank--;
        }
        if (node != null) {
            return node.key;
        }
        return null;
    }

    public Iterator<Key> iterator() {
        return new STIterator();
    }

    public class LinkedNode {
        public LinkedNode next = null;
        public Key key;
        public Value val;

        public LinkedNode() {
        }

        public LinkedNode(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
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
}
