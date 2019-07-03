package ttt;

import java.util.*;

public class ArrayBasedMap<K, V> implements Map<K, V> {

    private List<Pair> KayAndValues = new ArrayList<Pair>();
    int size=KayAndValues.size();

    @Override
    public int size() {
        // BEGIN (write your solution here)
        if(size>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else {

            return size;
        }
        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)
        return size()==0;

        // END
    }

    @Override
    public boolean containsKey(Object key) {
        // BEGIN (write your solution here)
        return get(key)!=null;

        // END
    }

    @Override
    public boolean containsValue(Object value) {
        // BEGIN (write your solution here)
        for(int i=0;i<size();i++){
            Pair p=KayAndValues.get(i);
            V pv=p.value;
            if(value.equals(pv)){
                return true;
            }
        }
        return false;

        // END
    }

    @Override
    public V get(Object key) {
        // BEGIN (write your solution here)
        for(int i=0;i<KayAndValues.size();i++){
            Pair p=KayAndValues.get(i);
            K pk=p.key;
            if(key.equals(pk)){
                return  p.getValue();
            }
        }
        return null;

        // END
    }

    @Override
    public V put(K key, V value) {
        // BEGIN (write your solution here)

        KayAndValues.add(new Pair(key,value));

        return (V) this;

        // END
    }

    @Override
    public V remove(Object key) {
        // BEGIN (write your solution here)
        V vel=get(key);
        if(vel==null){
            return null;
        }

        KayAndValues.remove(new Pair((K) key,vel));


        return vel;

        // END
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<K, V> e : (Set<Map.Entry<K, V>>)(Set)m.entrySet())
            put(e.getKey(), e.getValue());
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)


        for(int i=0;i<size;i++){
          //  KayAndValues.add();

        }
        KayAndValues.clear();
     //   KayAndValues=new ArrayList<>();

size=0;
        // END
    }

    @Override
    public Set<K> keySet() {
        final Set<K> keys = new HashSet<K>();
        for (Pair p : KayAndValues) keys.add(p.getKey());
        return keys;
    }

    @Override
    public Collection<V> values() {
        // BEGIN (write your solution here)
        ArrayList<V> e=new ArrayList<V>();

        for(int i=0;i<size();i++){
            e.add(KayAndValues.get(i).value);
        }
        return e;

        // END
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return (Set<Entry<K, V>>)(Set)new HashSet<>(KayAndValues);
    }

    private class Pair implements Map.Entry<K, V> {

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
}