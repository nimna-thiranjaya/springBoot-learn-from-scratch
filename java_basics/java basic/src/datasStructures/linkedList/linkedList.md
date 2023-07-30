# LinkedList Documentation
A LinkedList is a data structure in Java that represents a linear collection of elements. Unlike arrays, which store elements in contiguous memory locations, LinkedList elements are stored in individual nodes, where each node contains a reference to the next node in the sequence

## 1. Creating a LinkedList:
```agsl
LinkedList<DataType> listName = new LinkedList<>();

//example 
import java.util.LinkedList;

LinkedList<Integer> numbersList = new LinkedList<>();
LinkedList<String> namesList = new LinkedList<>();
```

## 2. Special inbuilt functions in LinkedList

### 1. add()
You can add elements to the LinkedList using various methods like add(), addFirst(), and addLast().

```agsl
listName.add(element);
listName.addFirst(element);
listName.addLast(element);

//Example
numbersList.add(10);
namesList.add("Nimna");
namesList.addFirst("Dima");
namesList.addLast("Ravi");
```

### 2. get()
You can access elements in the LinkedList using the get() method, which takes the index of the element as an argument.
```agsl
DataType element = listName.get(index);

//Example
int number = numbersList.get(0); // Retrieves the first element (index 0)
String name = namesList.get(1); // Retrieves the second element (index 1)
```

### 3. remove()
You can remove elements from the LinkedList using methods like remove(), removeFirst(), and removeLast()
```agsl
listName.remove(element);
listName.removeFirst();
listName.removeLast();

numbersList.remove(0); // Removes the first element (index 0)
namesList.removeFirst(); // Removes the first element in the list
namesList.removeLast(); // Removes the last element in the list
```

### 4. size()
You can get the number of elements in the LinkedList using the size() method.
```agsl
int size = listName.size();
```

## 3. Iterating Over LinkedList:
```agsl
for (int i = 0; i < listName.size(); i++) {
    DataType element = listName.get(i);
    // Do something with the element
}
```
