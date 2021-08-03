package hw3;


import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        String arrstring[] = {"black", "orange", "black", "orange", "yellow", "yellow", "orange", "red", "white"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arrstring.length; i++) {
            String key = arrstring[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) <= 1) System.out.println(arrstring[i]); } // для вывода уникальных слов
        System.out.println(map); // для вывода подсчета случаев повтора слов


        PhoneBook phbook = new PhoneBook();
        phbook.add("Smolensky", 54145151);
        phbook.add("Smolensky", 34134141);
        phbook.get("Smolensky");
        phbook.add("Mishina", 2141414);
        phbook.add("Mishina", 134010401);
        phbook.add("Stroganov", 01231314);
        phbook.soutpb();

    }
}

