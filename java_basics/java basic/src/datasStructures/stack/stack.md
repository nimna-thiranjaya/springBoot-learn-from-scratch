# Stack Documentation
A stack is a data structure in Java that follows the Last In, First Out (LIFO) principle. This means that the last element added to the stack will be the first one to be removed. It is used to implement various algorithms and is an essential part of many programming tasks. Here's everything you need to know about stacks in Java:



## 1. Creating a Stack:
   You can create a stack by using the `Stack` class.

```agsl
Stack<DataType> stackName = new Stack<>();

//Example
import java.util.Stack;

Stack<Integer> intStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
```

## 2. Special inbuilt functions in Stack

### 1. push()
   You can add elements to the stack using the `push()` method.

```agsl
stackName.push(element);

// Example
intStack.push(10);
stringStack.push("Alice");
```

### 2. pop()
You can remove and retrieve the top element from the stack using the `pop()` method.

```agsl
DataType topElement = stackName.pop();

//Example:
int poppedInt = intStack.pop();
String poppedString = stringStack.pop();
```
### 3. peek()
You can peek at the top element of the stack (retrieve it without removing it) using the `peek()` method.

```agsl
DataType topElement = stackName.peek();

//Example
int topInt = intStack.peek();
String topString = stringStack.peek();

```

### 3. isEmpty
You can check if the stack is empty using the `isEmpty()` method, which returns a boolean.
```agsl
boolean isEmpty = stackName.isEmpty();

// Example
boolean isIntStackEmpty = intStack.isEmpty();
boolean isStringStackEmpty = stringStack.isEmpty();
```

### 4. size()
You can get the number of elements in the stack using the `size()` method.
```agsl
int size = stackName.size();

//Example
int intStackSize = intStack.size();
int stringStackSize = stringStack.size();
```
