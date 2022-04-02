# A Case Study of 582. Kill Process

## V1 Performance
![img.png](img.png)
## V2 Performance 
![img_1.png](img_1.png)

### What's so interesting?
The only difference between V2 and V1 is that, by realizing the fact 
that processes could not form a cyclic graph, the ArrayList to track visited 
nodes is removed (hence the very small memory improvement). Interestingly,
after removing those ArrayList manipulation operations, we actually can see
a decent performance improvement. At the end of the day, maybe ArrayList is 
not as free as what we normally assume. 