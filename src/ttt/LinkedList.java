package ttt;

import java.util.*;



public class LinkedList<T> implements List<T> {

    private Item<T> firstInList = null;
    private Item<T> lastInList_TEMP1=null;
    private Item<T> lastInList = null;
    private boolean first=false;
    private boolean f=true;
    private int size=0;

    T[] m=(T[]) new Object[1];

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)
        if(o==null ){
            for(int i=0;i<size;i++){
                System.out.println("-----III--++i"+get(i)+" "+size);
                if(get(i)==null){
                    return true;
                }
            }
            return false;
        }

        for(int i=0;i<size;i++){
            System.out.println("-----III--"+get(i)+" "+size);
            if(o.equals(this.get(i))){
                return true;
            }

        }
        return false;
        // END
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator(0);
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)
        T[] m=(T[]) new Object[size];
        for(int i=0;i<size;i++){
          m[i]=this.get(i);
        }
        return m;
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        m= (T[]) this.toArray();
        int newsize;
        if(a==null){
            throw new NullPointerException();
        }
        if(size<a.length){
            newsize=a.length;
        } else {
            newsize=size;
        }


        T1[] m1=(T1[]) new Object[newsize];
        int ni=0;
        for(T i:m){
            for(T1 q:a){
                if(i.equals(q)){
                    if(ni<size){
                        m1[ni++]=q;
                    }else {
                       m1= Arrays.copyOf(m1,newsize);
                    }
                }
            }
        }
        return m1;

        // END
    }

    @Override
    public boolean add(final T newElement) {
        // BEGIN (write your solution here)
        Item<T> newitems=new Item<>(newElement,lastInList,firstInList,size);
        if(f){
            newitems.prevItem=newitems.nextItem=newitems;
            firstInList=newitems;
            f=false;
        }
        if( lastInList!=null){
            lastInList.nextItem=newitems;
        }
        lastInList=newitems;
        size++;
        return true;
         // END
    }

    @Override
    public boolean remove(final Object o) {

        // BEGIN (write your solution here)
        for(int i=0;i<size;i++){
            if(o!=null){

            }
            System.out.println("-----III---O---"+lastInList.element);
            //   System.out.println("-----III---T----"+lastInList.element);

            if(o.equals(lastInList.element)){
                System.out.println("-----III--------");
                lastInList.nextItem.prevItem=lastInList.prevItem;
                lastInList.prevItem.nextItem=lastInList.nextItem;
                lastInList_TEMP1=lastInList.prevItem;
                lastInList.nextItem=lastInList.prevItem=null;
                lastInList.element=null;
                lastInList=lastInList_TEMP1;
                size--;
                break;

            }
            lastInList=lastInList.getNextItem();
        }

        return true; //////////END

        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final T item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)
        lastInList=null;
        firstInList=null;
        size=0;
        // END
    }

    @Override
    public T remove(final int index) throws IndexOutOfBoundsException{
        // BEGIN (write your solution here)
        remove(get(index));


        return (T) lastInList_TEMP1; //////////END
        // END
    }


    private void remove(final Item<T> current) {
        // BEGIN (write your solution here)
        remove(current);
        // END
    }

    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object o) {
        // BEGIN (write your solution here)


        for(int i=0;i<size;i++){
            Object r=get(i);
            System.out.println("E"+r+" "+i);
//            if(r==null){
//                if(o.equals(r)){
//
//                    return i;
//                }
//            } else  if(r.equals(o)){
//
//                return i;
//            }

        }

        System.out.println("--------------- ");
        return -1;
 //////////END
        // END
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        // BEGIN (write your solution here)
        return m[1]; //////////END
        // END
    }

    @Override
    public T get(final int in) {
        // BEGIN (write your solution here)
        if(in>=size || in <0){
            System.out.println("FAAAACK!!!");
        }
        Item<T> element=lastInList;
        if(in<1){
            //System.out.println("firstInList.element");
            return firstInList.element;
        }
        if(in==size-1){
           // System.out.println("lastInList.element");
            return lastInList.element;
        }
        if(in<(size/2)){
            for(int i=0;i<(size-in-1)/*2*/;i++){
                element=element.getNextItem();
            }

        }else {
            for(int i=in;i<size;i++){
                element=element.getNextItem();
            }
        }
        return  element.element;
        // END
    }

    private Item<T> getItemByIndex(final int index) {
        // BEGIN (write your solution here) An auxiliary method for searching for node by index.
        return (Item<T>) m[1]; //////////END
        // END
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> currentItemInIterator;

        private Item<T> lastReturnedItemFromIterator;

        private int index;

        ElementsIterator(final int index) {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public boolean hasNext() {
            // BEGIN (write your solution here)
            return true; //////////END
            // END
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)
            return m[1]; //////////END
            // END
        }

        @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)
            return true; //////////END
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
            return m[1]; //////////END
            // END
        }

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public int previousIndex(){
            // BEGIN (write your solution here)
            return 1; //////////END
            // END
        }
        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
            return 1; //////////END
            // END
        }


        @Override
        public void remove() {
            // BEGIN (write your solution here)

            // END
        }
    }

    private static class Item<T> {

        private T element;
        private int index;

        private Item<T> nextItem;

        private Item<T> prevItem;

        Item(final T element, final Item<T> prevItem, final Item<T> nextItem, int index) {
            this.element = element;
            this.nextItem = nextItem;
            this.prevItem = prevItem;
            this.index=index;
        }


        public Item<T> getNextItem() {
            return nextItem;
        }

        public Item<T> getPrevItem() {
            return prevItem;
        }
    }
}

