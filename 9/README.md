# Problem 9: Toys for Christmas  
# Problem D : MIUP 2009  
## Intruduction
A network of children care institutions is preparing Christmas. They have received many toys
from some manufacturers and they already know which of them are suitable for each child. Now,
they need to find out how those toys should be distributed to the children so as to maximise the
number of children with a suitable toy.  

Notice that, in most cases, there are several units of the same toy. Therefore, the same toy
might be given to several children. Besides, each child’s supervisor selected the suitable toys for
the child from the list of existing toys, taking into account age, preferences, and personality, but
disregarding the number of units of each toy. There may be children for which no toy is suitable.  

To ensure that all children will be happy, it has been decided that every child will receive
an appropriate toy, even if this requires some more toys to be acquired. So, at this moment, it
is crucial to find a distribution of the existing toys that maximises the number of children with
a suitable toy (that is to say, a distribution of the existing toys that maximises the number of
children with a toy selected by the supervisor). The number of children with a suitable toy in
such a distribution will be called _the maximum number of happy children_.

## Problem  
Given a set of toys, the number of units of each toy, a list of children, and a set of suitable toys
for each child, the goal is to compute the maximum number of happy children.  

## Input
The first line of the input contains two integers, T and C, separated by a single space. T is the
number of toys and C is the number of children. Toys and children are identified by integers,
ranging, respectively, from 1 to T and from 1 to C.  

Each of the following T lines contains an integer U, which denotes the number of units of a
toy (from toy 1 to toy T).  

Each of the following C lines specifies the set of suitable toys for a child (from child 1 to child
C). A set of toys contains the number N of toys, followed by N distinct integers representing the
toys. All integers are separated by a single space.

## Constraints  
- 1 ≤ T ≤ 100  
- 1 ≤ C ≤ 600  
- 1 ≤ U ≤ 20  
- 0 ≤ N ≤ 30  

## Output
The output has a single line with the maximum number of happy children.  

## Sample Input

``` 
3 7
6
1
2
3 1 2 3
2 2 1
0
1 2
1 3
2 2 3
1 2
```

## Sample Output

``` 
5
```

