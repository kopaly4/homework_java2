package hw3;

import java.util.*;

public class PhoneBook {
    Map<String, List<Integer>> phonebook = new HashMap<>();


    public void add(String name, Integer number) {
        if (phonebook.containsKey(name)) {
            List<Integer> value = phonebook.get(name);
            value.add(number);
            phonebook.put(name, value);
            System.out.println("Phone number " + number + " successfully added to user " + name);
        } else {
            List<Integer> value = new ArrayList<>();
            value.add(number);
            phonebook.put(name, value);
            System.out.println("User " + name + " successfully added. Phone number: " + number);
        }
    }
    public void get(String name) {
        System.out.println(name + " 's number is/are: " + phonebook.get(name));
    }
    public void soutpb() {
        System.out.println(phonebook);
    }
}
