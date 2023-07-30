package datasStructures.array;

public class arrays {
    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7};

        //access array element
        System.out.println("element 0 : " + numbers[0]);
        System.out.println("element 1 : " + numbers[1]);

        //change array elemnt
        numbers[0] = 10;
        numbers[1] = 20;

        System.out.println("element 0 after change : " + numbers[0]);
        System.out.println("element 1 after change : " + numbers[1]);

        //get array length
        System.out.println("Array length : " + numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Print with for loop : " + numbers[i]);
        }

        for (int number:
             numbers
        ) {
            System.out.println("Print with foreach : " + number);
        }
    }
}
