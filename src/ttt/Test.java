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

    static int hash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private List KayAndValues = new ArrayList();


    public static void main(String [] args){
        Test test=new Test();
        ArrayBasedMap arrayBasedMap =new ArrayBasedMap();

        for(int i=0;i<1000;i++){
            arrayBasedMap.put(i,"O"+i);

        }
        System.out.println("--------------");
        for(int i=0;i<100;i++){
            if(i*2<20){
              //  System.out.println(arrayBasedMap.get(i*2));
             //   arrayBasedMap.remove(i*2);
            }
        }
        System.out.println("--------------");


        Map<String, Student> map =test.makePopulatedMap();
        map.clear();
        Set<String> keySet = map.keySet();
       // arrayBasedMap.size();
        for(int i=0;i<5;i++){
            System.out.println(keySet.size()+"  "+map.size());
        }














    }
}
