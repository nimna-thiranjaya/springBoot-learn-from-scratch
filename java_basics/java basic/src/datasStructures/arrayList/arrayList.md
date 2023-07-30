# Array List  Documentation
An ArrayList is a dynamic array implementation in Java that is part of the java.util package. It provides a flexible and convenient way to store and manipulate collections of elements of any data type. 

## Creating an ArrayList:
```agsl
ArrayList<DataType> listName = new ArrayList<>();
```
example - 
```agsl
import java.util.ArrayList;

ArrayList<Integer> numbersList = new ArrayList<>();
ArrayList<String> namesList = new ArrayList<>();
```

## Special inbuilt functions in array list

### 1. add()
this use to add new element to array list. The elements will be appended to the end of the list.
```agsl
listName.add(element);
```

example - 
```agsl
ArrayList<String> namesList = new ArrayList<>();
namesList.add("Nimna");
namesList.add("Nimna 2");
namesList.add("Nimna 3");
```

### 2. get()
You can access elements in the ArrayList using the get() method, which takes the index of the element as an argument. Remember that the index starts from 0.
```agsl
DataType element = listName.get(index);
```

example - 
```agsl
String name = namesList.get(1); // Retrieves "Bob"
```

### 3. remove()
You can remove elements from the ArrayList using the remove() method. It takes either the index of the element you want to remove or the element itself.

```agsl
listName.remove(index);
listName.remove(element);
```

example -
```agsl
namesList.remove(0); // Removes the first element ("Nimna")
namesList.remove("Nimna 1"); // Removes the element "Nimna 1"
```

### 4. size()
You can get the number of elements in the ArrayList using the size() method.
```agsl
int size = listName.size();
```

### 5. isEmpty()
You can check if the ArrayList is empty using the isEmpty() method, which returns a boolean.
```agsl
boolean isEmpty = listName.isEmpty();
```
