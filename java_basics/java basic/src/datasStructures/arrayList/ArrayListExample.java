package datasStructures.arrayList;
import java.util.ArrayList;
public class ArrayListExample {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //Add to array list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        System.out.println(numbers);

        //get element
        System.out.println("3rd element In array list : " + numbers.get(2));

        //remove from array list
        numbers.remove(0);
        System.out.println("After remove : " + numbers);

        //size of array
        System.out.println("Size of array list : " + numbers.size());

        //Check is empty
        System.out.println("Check is empty : " + numbers.isEmpty());
    }
}
