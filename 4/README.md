# Problem E: Spreading The News  
In a large organization, everyone knows a lot of colleagues.  However, friendship relationsare kept with only a few of them, to whom news are told.Suppose  that  whenever  an  employee  knows  of  a  piece  of  news,  he  tells  it  to  all  hisfriends on the following day.  So, on the first day, the source of the information tells it tohis friends; on the second day, the source’s friends tell it to their friends; on the third day,the friends of the source’s friends’ tell it to their friends; and so on.  
&emsp;The goal is to determine:    

- _the maximum daily boom size_, which is the largest number of employees that, on asingle day, hear the piece of news for the first time; and  
- _the  first  boom  day_, which is the first day on which the maximum daily boom sizeoccurs  

## Problem  
Write a program that, given the friendship relations between the employees and the sourceof a piece of news,  computes the maximum daily boom size and the first boom day ofthat information spreading process.  
## Input  
The first line of the input contains the number E of employees (1≤E≤2500). Employeesare numbered from 0 to E−1.Each of the followingElines specifies the set of friends of an employee’s (from employee 0  to  employeeE−1).   A  set  of  friends  contains  the  number  of  friends N (0≤N≤15), followed by N distinct integers representing the employee’s friends.  All integers areseparated by a single space.The next line contains an integerT(1≤T <60), which is the number of test cases.Each  of  the  following T lines  contains  an  employee,  which  represents  the  (unique)source of the piece of news in the test case.  
## Output  
The output consists of T lines, one for each test case.If no employee (but the source) hears the piece of news, the output line contains theinteger 0.O therwise,  the  output  line  contains  two  integers,M and D,  separated  by  a  singlespace, where M is the maximum daily boom size andDis the first boom day.   
## Sample Input  

``` 
6
2 1 2
2 3 4
3 0 4 5
1 4
0
2 0 2
3
0
4
5
```

## Sample Output  

``` 
3 2
0
2 1
```

# MIUP’2004: Fourth Portuguese National Programming Contest


