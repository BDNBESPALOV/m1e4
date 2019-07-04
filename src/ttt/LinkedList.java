package ttt;
import java.util.*;

public class LinkedList<T> implements List<T> {

    private Item<T> firstInList = null;
    private Item<T> lastInList_TEMP1=null;
    private Item<T> firstInList_TEMP11 = null;
    private Item<T> lastInList_TEMPRem=null;
    private Item<T> lastInList = null;
    private boolean first=false;
    private boolean f=true;
    private int size=0;

    T[] m=(T[]) new Object[1];

    @Override
    public int size() {
        return size ;
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

                if(get(i)==null){
                    return true;
                }
            }
            return false;
        }

        for(int i=0;i<size;i++){
            System.out.println("contains"+o+" g"+get(i));
            if(o.equals(get(i))){
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
            m[i]=get(i);
        }
        return m;
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] aa) {
        // BEGIN (write your solution here)
        m= (T[]) toArray();
        //  int ch=aa.length;
        if(aa.length==m.length){
            return aa;
        }

//        for(int i=0;i<aa.length;i++){
//
//
//            if( aa[i]==null){
//                ch--;
//            }
//            if(ch==0){
//                return aa;
//            }
//
//        }



        m= (T[]) toArray();

        /*если размер входящего массива меньше размера текущего
         * то уделить размер  входящего до размера текущего
         * */
        if (aa.length <= m.length){

            aa=  Arrays.copyOf(aa, size);}
        /*скопировать все элементы из текущего, в входящий  */
        System.arraycopy(m, 0, aa, 0, size);
        if (aa.length > m.length){
            aa[size] = null;
        }
        return aa;

        // END
    }

    @Override
    public boolean add(final T newElement) {
        // BEGIN (write your solution here)

        System.out.println("Add "+newElement);
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
        if(o.equals(lastInList.element)) {
            if(size>0){
                lastInList_TEMP1 = lastInList.getPrevItem();
            }else {
                lastInList.nextItem=null;
                lastInList.prevItem=null;
                lastInList.element=null;
                size--;
                return true;
            }

        }else if(o.equals(firstInList.element)){

            firstInList_TEMP11=firstInList.nextItem;
            firstInList.nextItem.prevItem=firstInList.nextItem;
            lastInList.nextItem=firstInList.nextItem;
            firstInList.nextItem=null;
            firstInList.element=null;
            firstInList=firstInList_TEMP11;
            size--;
            return true;
        }
        else {
            lastInList_TEMP1 = lastInList;
        }

        for(int i=0;i<size;i++){
            if(o!=null){
            }
            if(o.equals(lastInList.element)){
                lastInList.nextItem.prevItem=lastInList.prevItem;
                lastInList.prevItem.nextItem=lastInList.nextItem;
                lastInList.nextItem=lastInList.prevItem=null;
                lastInList.element=null;
                size--;
                break;

            }
            lastInList=lastInList.getNextItem();
        }
        lastInList=lastInList_TEMP1;

        return true; //////////END

        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (int i=0;i<size;i++) {
            if (!this.contains(get(i))) return false;
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
        T[] a= (T[]) c.toArray();
        for (Object i: a) {

            remove(i);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (int i=0;i<size;i++) {
            if (!c.contains(get(i))) {
                this.remove(get(i));}
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
        T e=get(index);
        System.out.println("remove "+e);
        remove(e);

        for (int i=0;i<size;i++){
            System.out.println("r_"+get(i)+" "+i);
        }


        return  e; //////////END
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

            if(r==null){
                if(o.equals(r)){

                    return i;
                }
            } else  if(r.equals(o)){

                return i;
            }

        }

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
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        T elementF = null;
        T elementI = get(index);
        Item<T> lastInList_T=lastInList;
        for(int i=0;i<size;i++){
            if(elementI.equals(lastInList.element)){

                elementF=lastInList.element;
                lastInList.element =element;

                break;

            }
            lastInList=lastInList.getNextItem();
        }
        lastInList=lastInList_T;



        return  elementF; //////////END
        // END
    }

    @Override
    public T get(final int in) {
        // BEGIN (write your solution here)
        if(in>=size || in <0){
            throw new IndexOutOfBoundsException();
        }
        Item<T> el=lastInList;
        if(in<1){
            //System.out.println("firstInList.element");
            return firstInList.element;
        }
        if(in==size-1){
            //  System.out.println("lastInList.element");
            return lastInList.element;
        }
        int y=size-in-1;
        for(int i=0;i<size-y;i++){
            el=el.getNextItem();
        }
        return  el.element;
        // END
    }

    private Item<T> getItemByIndex(final int index) {
        // BEGIN (write your solution here) An auxiliary method for searching for node by index.
        return (Item<T>) m[1]; //////////END
        // END
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T>  currentItemInIterator=lastInList;

        private Item<T> lastReturnedItemFromIterator;
        int n;



        private int index;
        private boolean check=false;

        ElementsIterator(final int index) {
            // BEGIN (write your solution here)
            this.index=index;
            for (int i=0;i<index;i++){
                //   currentItemInIterator=lastInList.getNextItem();
            }


            // END
        }

        @Override
        public boolean hasNext() {
            // BEGIN (write your solution here)

            return size>index;
            // END
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)
            n++;
            check=true;
            index++;
            currentItemInIterator=lastInList;

            if(size==0){

                throw new NoSuchElementException();
            }
            return currentItemInIterator.element;
            // END
        }

        @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)
            try{

                if(index>0){
                    previous();
                    return true;
                }
                return false;
            }catch (Exception e){
                return false;
            }
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
            n--;
            check=true;
            index--;
            lastReturnedItemFromIterator=currentItemInIterator;
            if(currentItemInIterator==null){
                throw new NoSuchElementException();
            }
            return lastReturnedItemFromIterator.element; //////////END
            // END
        }

        @Override
        public void add(final T element) {
            check=false;
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here).
            if(check){
                System.out.println(n+"!!!!!!!!!!"+index+" si"+size);
                // lastInList.getNextItem().getNextItem().getNextItem().element=element;
                lastInList_TEMPRem=LinkedList.this.lastInList;
                for(int i=0;i<size;i++){

                    LinkedList.this.lastInList=LinkedList.this.lastInList.getNextItem();
                    if(i==(n)){

                        LinkedList.this.lastInList.getNextItem().element=element;
                        System.out.println("lastInList.element!! "+LinkedList.this.lastInList.element);
                        break;
                    }
                }
                LinkedList.this.lastInList=lastInList_TEMPRem;
                n++;
            } else {
                throw new IllegalStateException();
            }
            // END
        }

        @Override
        public int previousIndex(){
            // BEGIN (write your solution here)
            if(index>0){
                return index-1;
            }else
                return -1; //////////END
            // END
        }
        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
            return index; //////////END
            // END
        }


        @Override
        public void remove() {
            // BEGIN (write your solution here)
            if(size==0){
                throw new UnsupportedOperationException();
            }
            if( index==0 ){
                throw new IllegalStateException();
            }




            if (size==1){
                currentItemInIterator.element=null;
                currentItemInIterator.nextItem=null;
                check=false;
                index--;
                size--;
            } else {
                currentItemInIterator.nextItem.prevItem=currentItemInIterator.prevItem;
                currentItemInIterator.prevItem.nextItem=currentItemInIterator.nextItem;
                lastInList_TEMP1=currentItemInIterator.prevItem;
                currentItemInIterator.nextItem=currentItemInIterator.prevItem=null;
                currentItemInIterator.element=null;
                lastInList=lastInList_TEMP1;
                check=false;
                index--;
                size--;
            }






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

