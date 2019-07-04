package ttt.jdk_src.test;

import java.util.Map;

class Pair <K, V> implements Map.Entry<K, V> {

    private final K key;

    private V value;

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        final V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Map.Entry<K, V> pair = (Map.Entry<K, V>) o;


        if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
        return !(value != null ? !value.equals(pair.getValue()) : pair.getValue() != null);

    }

    @Override
    public int hashCode() {
        return (key   == null ? 0 :   key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }
}