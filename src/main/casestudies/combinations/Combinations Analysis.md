# A Case Study of 77. Combinations

## Combinations V1
![img.png](img.png)
### Why so slow?
Recursion with too much array creating, resizing and copying.
## Combinations V2
![img_1.png](img_1.png)
### Why better memory usage?
By adding backtracking to reuse already allocated ArrayLists
### Why much faster?
Less ArrayList operations = significantly less operations