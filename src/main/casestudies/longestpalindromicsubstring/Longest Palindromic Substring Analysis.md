# A Case Study of 77. Combinations

## V1 Code
![img.png](img.png)

## V2 Code
![img_1.png](img_1.png)

### What's so interesting?

The only difference between V1 and V2 is all about the two following code blocks:
```java
StringBuilder builder = new StringBuilder();
        for (int i = left; i <= right; i++) {
            builder.append(charArray[i]);
        }
        return builder.toString();
```
```java
return s.substring(left, right+1);
```
This means that in Java, `StringBuilder` and `String.substring(x, y)` have similar
performance both from the perspective of memory and runtime.