package datasStructures.linkedList;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String args[]) {
        LinkedList<String> names = new LinkedList<>();

        names.add("Nimna");
        names.add("Dimalka");
        names.add("Ravindu");
        names.add("Hasith");
        names.add("Sumudu");

        System.out.println(names);
        System.out.println("Print element 0 : " + names.get(0));

        System.out.println("Before remove data from list : " + names);
        names.remove(0);
        System.out.println("After remove data from list : " + names);

        System.out.println("Before remove data from list : " + names);
        names.removeFirst();
        System.out.println("After remove data from list : " + names);

        System.out.println("Before remove data from list : " + names);
        names.removeLast();
        System.out.println("After remove data from list : " + names);

        System.out.println("Linked List size : " + names.size());

        for (int i  = 0; i<names.size(); i++){
            System.out.println("Print from for : " + names.get(i));
        }

        for (String name: names
             ) {
            System.out.println("Print from forEach : " + name);
        }

    }
}
