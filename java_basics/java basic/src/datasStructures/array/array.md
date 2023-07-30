# Array Documentation
## Declaring an array:
To declare an array in Java, you need to specify the data type of its elements, followed by []. You can declare an array with or without initialization.
```agsl
dataType[] arrayName;
dataType[] arrayName = new dataType[arrayLength];
```
example - 
```agsl
String[] array1;
String[] array2 = new String[10]
```

## Initializing an Array:
Arrays can be initialized at the time of declaration or later. You can use curly braces {} to specify the initial values of the array elements.

```agsl
int[] numbers = {1, 2, 3, 4, 5};
String[] names = new String[]{"Alice", "Bob", "Charlie"};
```

## Accessing Array Elements:
```agsl
int[] numbers = {10, 20, 30};
int firstElement = numbers[0]; // 10
int secondElement = numbers[1]; // 20
```

## Iterating Over an Array:
```agsl
int[] numbers = {1, 2, 3, 4, 5};
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

int[] numbers = {1, 2, 3, 4, 5};
for (int number : numbers) {
    System.out.println(number);
}

```