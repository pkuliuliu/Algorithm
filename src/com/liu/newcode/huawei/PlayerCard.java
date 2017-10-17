package com.liu.newcode.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liu on 17-8-22.
 */
public class PlayerCard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            System.out.println(compare(in.nextLine()));
        }
    }
    static String compare(String line){
        Map<String,Integer> map = new HashMap<>();
        map.put("3",0);
        map.put("4",1);
        map.put("5",2);
        map.put("6",3);
        map.put("7",4);
        map.put("8",5);
        map.put("9",6);
        map.put("10",7);
        map.put("J",8);
        map.put("Q",9);
        map.put("K",10);
        map.put("A",11);
        map.put("2",12);
        map.put("joker",13);
        map.put("JOKER",14);

        String[] cards = line.split("-");
        String first = cards[0];
        String second = cards[1];
        String[] _first = first.split("\\s");
        String[] _second = second.split("\\s");
        if(_first.length==_second.length||_first.length==4||_second.length==4||first.equals("joker JOKER")||second.equals("joker JOKER")){
            if(first.equals("joker JOKER")||second.equals("joker JOKER")){
                return "joker JOKER";
            }
            if(_first.length==4&&_second.length!=4){
                return first;
            }
            if(_second.length==4&&_first.length!=4){
                return second;
            }
            if(map.get(_first[0])<map.get(_second[0])){
                return second;
            }else
                return first;
        }else
            return "ERROR";
    }
}
