# Problema 7: Social Network  
# Problem I: MIUP 2010  
## Intruction  
Social networks are a growing phenomena all over the world. These networks allow people to
become more connected by allowing an easy way to share information.  

A social network N can be defined as a pair (P, R) where P is the set of people in the network
and R is the set of direct relations between people in the network.  

In a social network, there are some relations that are older than others. Consider that it is
known how many days any direct relation has existed between two people in the network and that
defines its weight. For each relation (pi, pj ) ∈ R, let wij denote the number of days that person pi
has been directly related to person pj in the network. The total weight of the network connections,
also called the weight of the network, is the sum of all direct relation weights.  

A social network is said to be connected if, for any two people pi and pj , there is a path
between them in the network. Let us define a backbone of a connected social network as a subnet
SN = (P, Rb) with only |P| − 1 connections (Rb ⊆ R and |Rb| = |P| − 1) such that it is still a
connected network. A maximum backbone can be defined as a backbone for which the total weight
of the connections is maximized.  

## Problem  
Given a weighted connected social network, your objective is to find the weight of a maximum
backbone of that network.

## Input  
The input is a weighted connected social network defined as follows:
• one line with two positive integers |P| and |R|, such that |P| is the number of people in the
social network and |R| denotes the number of direct relations in the network;
• a sequence of |R| lines where each line denotes a weighted relation in the network. Each
line contains three positive integers pi, pj and wij . The first two (pi and pj ) denote the
people in direct connection and wij denotes the number of days pi and pj have been directly
connected in the network. All pi and pj are integers between 1 and |P|.  

## Constrains  
- 0 < \|P\| ≤ 10000 
- 0 < \|R\| ≤ 200000 
- 0 < wij ≤ 10000 

## Sample Input and Output 1  
``` 
4 5
1 2 3
1 3 4
2 3 5
2 4 4
3 4 3
```

``` 
13
```
## Sample Input and Output 2  
```
5 8
1 2 15
1 3 10
1 4 11
2 3 12
2 4 8
2 5 3
3 4 9
4 5 1
 ```

``` 
41
```
