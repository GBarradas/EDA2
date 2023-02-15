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

## Solução  

``` java
import java.io.*;
import java.util.*;
import java.lang.*;
class Main {
    public static void main(String[] args) throws IOException
    {
      BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
      int employees = Integer.parseInt(br.readLine());
      Organisation a = new Organisation(employees);
      String[] aux;
      for (int i=0;i<employees;i++){
        aux=br.readLine().split(" ");
        for(int j=1;j<=Integer.parseInt(aux[0]);++j){
          a.addFriend(i,Integer.parseInt(aux[j]));
        }

      }
      int nTeste= Integer.parseInt(br.readLine());
      for(int i=0;i< nTeste;i++){
        Boom b= a.firstMaxBoom(Integer.parseInt(br.readLine()));
        if(b.max==0){
          System.out.println(0);
        }
        else{
          System.out.println(b.max+" "+b.boom);
        }
      }
    }
  }
  
  /*
    Um Boom é constituído pelo número de empregados que recebe a notícia
    num dia e o dia em que isso acontece.
  */
  class Boom {
    int source;
    Organisation a;
    boolean[] know;
    int max;
    int boom;
    public Boom(int source , Organisation a){
      this.source=source;
      this.a=a;

      know= new boolean[a.employees];


    }
    public void calc(){
      int[] arr = new int[2];
      if(a.adj[source].isEmpty())
        return arr;
      LinkedList<Integer> spread = new LinkedList<Integer>();
      spread.add(source);
      int[] dayFindOut = new int[a.employees];
      int[] heardPerDay = new int[a.employees];
      int noFriends=0;
      know[source]= true;
      while(!spread.isEmpty()){
        int e = spread.removeFirst();
        for( int i : a.adj[e]){
          if(!know[i]){
            know[i]= true;
            dayFindOut[i]=dayFindOut[e]+1;
            ++heardPerDay[dayFindOut[i]];
            spread.addLast(i);
          }
        }
        for(int i=0;i< a.employees;++i){
          noFriends+=heardPerDay[i];
        }
      }
     
      if(noFriends==1){
        max=0;
        boom=0;
      }
      else{
        for(int i=0;i<a.employees;i++){
          if (heardPerDay[i]>max){
            max=heardPerDay[i];
          }
        }
        for(int i = 1;i<a.employees;++i){
          if(heardPerDay[i]==max){
            boom=i;
            break;
          }
        }

      }
      
    }
  }
  
  class Organisation {
    int employees;
    List<Integer>[] adj;
    @SuppressWarnings("unchecked")
    public Organisation(int employees){
        this.employees=employees;
        adj = new List[employees];
        for(int i = 0; i<employees;i++){ 
          adj[i]=new ArrayList<Integer>();
        }
    }
  
    /*
      Acrescenta o empregado FRIEND aos amigos de EMPLOYEE.
    */
    public void addFriend(int employee, int friend){
      adj[employee].add(friend);
    }
    
  
    /*
      Calcula e devolve o Boom correspondente ao primeiro dia em que o
      número de funcionários que recebe a notícia é máximo.
  
      SOURCE é o funcionário que inicia a divulgação da notícia.
    */
    public Boom firstMaxBoom(int source){
      Boom a = new Boom( source , this);
      a.calc();
      return a;
    }
  }
```

# MIUP’2004: Fourth Portuguese National Programming Contest


