package com.company;




import org.junit.Test;

import java.util.*;

/**
 * @Author xhx
 * @Date 2020/7/20 11:55
 */

public class MapTest {
    @Test
    public void MapRun(){
        Map<String,Integer> map = new HashMap<>() ;

        map.put("xhx",4);
        map.put("ljy",1);
        map.put("lyw",3);

        Set<Map.Entry<String,Integer>> set = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry<String ,Integer> entry = iterator.next();
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
    }
    @Test
    public void KeyAndValueMap(){
        Map<String,Integer> map = new HashMap<>() ;

        map.put("xhx",4);
        map.put("ljy",1);
        map.put("lyw",3);

        Set<String> set = map.keySet();

        Collection<Integer> connection =  map.values();
        Iterator<Integer> iterator = connection.iterator();

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (iterator.hasNext()){
            arrayList.add(iterator.next());

        }
        System.out.println(arrayList);
    }
}

