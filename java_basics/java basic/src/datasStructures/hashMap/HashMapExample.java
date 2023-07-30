package datasStructures.hashMap;

import java.util.HashMap;

public class HashMapExample {
    public static  void  main(String[] args){
        HashMap<Integer, String> students = new HashMap<>();

        students.put(1, "Nimna");
        students.put(2, "Dimalka");
        students.put(3, "Sumudu");

        System.out.println(students);

        System.out.println("key 1 value : " + students.get(1));
        System.out.println("key 2 value : " + students.get(2));

        System.out.println("check hashmap contains key 1 : " + students.containsKey(1));
        System.out.println("check hashmap contains key 19 : " + students.containsKey(19));

        System.out.println("check hashmap contains value Nimna : " + students.containsValue("Nimna"));
        System.out.println("check hashmap contains key Ravindu : " + students.containsValue("Ravindu"));

        System.out.println("Before remove data : "+ students);
        students.remove(3);
        System.out.println("After remove data : "+ students);

        for(int key : students.keySet()){
            System.out.println("Print from for loop : " + students.get(key));
        }
    }
}
