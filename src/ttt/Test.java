package ttt;

import java.util.LinkedList;
public class Test<T> {
    private Items<T> firstInList = null;
    Items<T> lastInList_TEMP1=null;
    private Items<T> lastInList = null;
    private Items<T> header;
    private boolean f=true;



    private int size;

    public void add(T r){

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

        }
        Items<T> element=lastInList;
        Items<T> elementF=firstInList;
        if(in==0){

        return firstInList.element;
        }
        if(in==size-1){

            return lastInList.element;

        }

        if(in<(size/2)){
            for(int i=0;i<(size-in-1)/*2*/;i++){

                element=elementF.getNextItem();
            }
         //   System.out.println(element.element+"F");
        }else {
            for(int i=in;i<size;i++){
                element=element.getNextItem();
            }
        //    System.out.println(element.element+"E");
        }
        return  element.element;
    }

    public boolean remove(final Integer o) {
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





return false;
        // END
    }

    public static void main(String [] args){
        Test test=new Test();
         Items lastInList = test.lastInList;

        int n=7;
//        for(int i=0;i<n;i++){
//            test.add(i);
//        }
        test.add("trololo1");
        test.add("trololo2");
        test.add("trololo3");
        test.add("trololo4");
        test.add("trololo5");
//        test.add(1);
//        test.add(2);
//        test.add("trololo");
//        test.add(null);

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
