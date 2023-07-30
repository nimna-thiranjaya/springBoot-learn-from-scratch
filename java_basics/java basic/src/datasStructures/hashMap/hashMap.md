# HashMap Documentation
A HashMap is a part of the Java Collections Framework and is used to store key-value pairs. It provides a way to associate a value with a unique key and enables efficient retrieval and manipulation of data based on those keys. Here's everything you need to know about HashMap in Java:

## 1. Creating HashMap

```agsl
HashMap<KeyType, ValueType> mapName = new HashMap<>();
```
example - 
```agsl
import java.util.HashMap;

HashMap<String, Integer> ageMap = new HashMap<>();
HashMap<Integer, String> nameMap = new HashMap<>();
```

## 2. Special inbuilt functions in HashMap
### 1. put()
You can add key-value pairs to the HashMap using the put() method.
```agsl
mapName.put(key, value);

// Example
ageMap.put("Nimna", 30);
ageMap.put("Dima", 25);

```

### 2. get()
You can retrieve the value associated with a specific key using the get() method.
```agsl
ValueType value = mapName.get(key);

int aliceAge = ageMap.get("Nimna"); // Retrieves 30
```

### 3. containsKey()
You can check if a specific key exists in the HashMap using the containsKey() method, which returns a boolean.
```agsl
boolean containsKey = mapName.containsKey(key);

// Example
boolean hasAlice = ageMap.containsKey("Nimna"); // true
boolean hasDavid = ageMap.containsKey("Ravindu"); // false
```

### 4. containsValue()
You can check if a specific value exists in the HashMap using the containsValue() method, which returns a boolean.
```agsl
boolean containsValue = mapName.containsValue(value);

// Example
boolean hasAge30 = ageMap.containsValue(30); // true
boolean hasAge40 = ageMap.containsValue(40); // false
```

### 5. remove()
You can remove a key-value pair from the HashMap using the remove() method.
```agsl
mapName.remove(key);

// Example
ageMap.remove("Nimna"); // Removes the key-value pair for "Nimna"
```

### 6. size()
You can get the number of key-value pairs in the HashMap using the size() method.

```agsl
int size = mapName.size();

//example
int numberOfEntries = ageMap.size();
```

## Iterating Over HashMap:
```agsl
for (KeyType key : mapName.keySet()) {
    ValueType value = mapName.get(key);
    // Do something with the key and value
}
```