package ttt;

import java.util.*;
import java.util.LinkedList;

public class Test<T> {
    Map<String, Student> makePopulatedMap() {
        return new ArrayBasedMap<String, Student>(){{
            for (int i = 0; i < 1_000; i++) {
                put(String.valueOf(i), new Student(String.valueOf(i)));
            }
        }};
    }
    Student getValueNotInPopulatedMap() {
        return new Student("notInMap");
    }

    static int hash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private List KayAndValues = new ArrayList();


    public static void main(String [] args){
        Test test=new Test();
        ArrayBasedMap arrayBasedMap =new ArrayBasedMap();
        int sizes=10000;
        for(int ip=0;ip<5;ip++) {
            arrayBasedMap =new ArrayBasedMap();
            int is = (int) new Date().getTime();
            // System.out.println(is);
            System.out.println("--------------");
            for (int i = 0; i < sizes; i++) {
                arrayBasedMap.put(i, "O" + i);

            }
            int isl = (int) new Date().getTime();
            System.out.println(isl - is + " put ");
            is = (int) new Date().getTime();

            for (int i = 0; i < sizes; i++) {
                arrayBasedMap.get(i);
            }
            isl = (int) new Date().getTime();
            System.out.println(isl - is + " get ");
            System.out.println("--------------");
        }
    }
}

//--------------
//        444 put
//        215 get
//        --------------
//        --------------
//        450 put
//        204 get
//        --------------
//        --------------
//        323 put
//        149 get
//        --------------
//        --------------
//        290 put
//        142 get
//        --------------
//        --------------
//        299 put
//        144 get
//        --------------