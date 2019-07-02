package ttt;

import java.util.LinkedList;
public class Test<T> {
    private Items<T> firstInList = null;
    private Items<T> firstInList_TEMP11 = null;
    Items<T> lastInList_TEMP11=null;
    private Items<T> lastInList = null;
    private Items<T> header;
    private boolean f=true;



    private int size;

    public void add(T r){
System.out.println("Add");
        Items<T> newitems=new Items<>(r,lastInList,firstInList);
        if(f){
            newitems.prevItem=newitems.nextItem=newitems;
            firstInList=newitems;
            f=false;
        }

        if( lastInList!=null){
            lastInList.nextItem=newitems;
//            if(lastInList.prevItem!=null){
//                System.out.println(lastInList.element+" "+lastInList.nextItem.element+"N "
//                        +lastInList.prevItem.element+"L "+" FAAAACK!!!");
//            }else {
//                System.out.println(lastInList.element+" "+lastInList.nextItem.element+"N "
//                        +lastInList.prevItem+"L "+" FAAAACK!!!");
//            }
        }
        lastInList=newitems;

        size++;
    }

    public T get(int in){

        if(in>=size || in <0){
            throw new IndexOutOfBoundsException();
        }
        Items<T> el=lastInList;
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
    }

    public boolean remove(final T o) {
    /*----------------remove end---------------------------*/
//    lastInList.prevItem.nextItem=lastInList.nextItem;
//    lastInList.nextItem.prevItem=lastInList.prevItem;
//    lastInList_TEMP1=lastInList.prevItem;
//    lastInList.nextItem=lastInList.prevItem=null;
//    lastInList.element=null;
//    lastInList=lastInList_TEMP1;
//    size--;
//    System.gc();
     /*---------------------------------------------------*/






        if(o.equals(lastInList.element)) {
            if(size>0){
                lastInList_TEMP11 = lastInList.getPrevItem();
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
            lastInList_TEMP11 = lastInList;
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
        lastInList=lastInList_TEMP11;
return false;
        // END
    }



    public static void main(String [] args){
        Test test=new Test();


        int n=7;
//        for(int i=0;i<n;i++){
//            test.add(i);
//        }
        test.add("trololo1");
        test.add("trololo2");
        test.add("trololo3");
        test.add("trololo4");

//        test.add(1);
//        test.add(2);
//        test.add("trololo");
//        test.add(null);
       test.remove(test.get(3));

      //  test.remove(test.get(2));

        for(int i=0;i<test.size;i++){
//            if(test.get(i)==null){
//                System.out.println(test.get(i));
//            }
            System.out.println(test.get(i)+" "+i);


//            System.out.println(test.lastInList.getNextItem().element+" "+i);
//            test.lastInList=test.lastInList.getNextItem();
        }




//        for(int i=0;i<test.size;i++){
//
//           // System.out.println(test.lastInList);
//            System.out.println("name "+test.lastInList+" next="+test.lastInList.getNextItem()+
//                    " prev "+test.lastInList.getPrevItem()+" element "+test.lastInList.element );
//
//
//
//            test.lastInList=test.lastInList.getNextItem();
//
////            if(test.get(i).equals(i)){
////                //  System.out.println("Yes !!!"+i);
////            //    System.out.println("Yes !!!");
////            }else {
////
////            //    System.out.println("Noo !!!"+test.get(i)+" "+test.get(i+1));
////                return;
////            }
//
//        }




























    }
}
