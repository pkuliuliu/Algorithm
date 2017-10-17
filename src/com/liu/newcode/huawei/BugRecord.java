package com.liu.newcode.huawei;

import java.util.*;

/**
 * Created by liu on 17-8-22.
 */
public class BugRecord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Elem> map = new LinkedHashMap<>();
        int i = 0;
        while(in.hasNext()){
            String[] temp = in.nextLine().split("\\\\");
            String key = temp[temp.length-1];
            if(map.containsKey(key)){
                Elem elem = map.get(key);
                elem.cnt++;
            }else {
                Elem elem = new Elem(1,i);
                map.put(key,elem);
            }
            i++;
        }
        List<Map.Entry<String,Elem>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Elem>>() {
            @Override
            public int compare(Map.Entry<String, Elem> o1, Map.Entry<String, Elem> o2) {
                int res =o2.getValue().cnt - o1.getValue().cnt;
                if(res==0){
                    res = o1.getValue().first - o2.getValue().first;
                }
                return res;
            }
        });

        int size = list.size()>8?8:list.size();
        for (int j = 0; j < size; j++) {
            Map.Entry<String,Elem> entry = list.get(j);
            String[] key = entry.getKey().split("\\s");
            System.out.println(key[0].substring(Math.max(key[0].length()-16,0))+" "+key[1]+" "+entry.getValue().cnt);
        }
    }
    static class Elem{
        public int cnt;
        public int first;
        public Elem(int cnt,int first){
            this.cnt = cnt;
            this.first = first;
        }
    }
}