package exercise.chapter3;

// 有序符号表
public interface ComparableST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
    // 最小的key
    Key min();

    // 最大的key
    Key max();

    // 小于等于k的最大key
    Key floor(Key k);

    // 大于等于k的最小key
    Key ceiling(Key k);

    // 小于k的键的数量，所有k需要满足key==select(rank(k))
    int rank(Key k);

    // 排名为rank的键， 所有i需要满足rank(select(i))
    Key select(int rank);
}
