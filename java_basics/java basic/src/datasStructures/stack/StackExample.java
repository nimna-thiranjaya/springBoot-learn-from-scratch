package datasStructures.stack;

import java.util.Stack;

public class StackExample {
    public static void main(String args[]){
        Stack<String> names = new Stack<>();

        names.push("Nimna");
        names.push("Dimalka");
        names.push("Ravindu");
        names.push("Hasith");
        names.push("Sumudu");

        System.out.println("Pop : " + names.pop());
        System.out.println("Peek : "  + names.peek());

        System.out.println("Is empty : " + names.isEmpty());

        System.out.println("Size : " + names.size());

    }
}
