# Problem *H*:  Project File Dependencies  
Project managers, such as the UNIX utility make, are used to maintain large software projects made up
from many components. Users write a project file specifying which components (called tasks) depend
on others and the project manager can automatically update the components in the correct order.  
Write a program that reads a project file and outputs the order in which the tasks should be
performed.  

## Input   
The input begins with a single positive integer on a line by itself indicating the number of the cases  following, each of them as described below. This line is followed by a blank line, and there is also a blank line between two consecutive inputs. For simplicity we represent each task by an integer number from 1, 2, . . . , N (where N is the total number of tasks). The first line of input specifies the number N of tasks and the number M of rules, such that N ≤ 100, M ≤ 100. The rest of the input consists of M rules, one in each line, specifying dependencies using the following syntax: T0 k T1 T2 . . . Tk This rule means that task number T0 depends on k tasks T1, T2, . . . , Tk (we say that task T0 is the target and T1, . . . , Tk are dependents). Note that tasks numbers are separated by single spaces and that rules end with a newline. Rules can appear in any order, but each task can appear as target only once. Your program can assume that there are no circular dependencies in the rules, i.e. no task depends directly or indirectly on itself.  

## Output  
For each test case, the output must follow the description below. The outputs of two consecutive cases will be separated by a blank line. The output should be a single line with the permutation of the tasks 1 . . . N to be performed, ordered by dependencies (i.e. no task should appear before others that it depends on). To avoid ambiguity in the output, tasks that do not depend on each other should be ordered by their number (lower numbers first).  

## Sample Input  

```
1
5 4
3 2 1 5
2 2 5 3
4 1 3
5 1 1
```

## Sample Output  

``` 
1 5 3 2 4
```  
## Solução  
``` java 
import java.io.*;
import java.util.*;

class Main {
  static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
  static int M;
  static int N;
  static String[] aux;
  static int task;
  static int nOfTasks;
  static Project a;
  public static void main(String[] args) throws IOException
  {
    aux=br.readLine().split(" ");
    N=Integer.parseInt(aux[0]);
    M=Integer.parseInt(aux[1]);
    a= new Project(N);
    for(int i = 0; i < M ; ++i){
      a.addDependency(br.readLine().split(" "));
    }
    //a.print();
    int[] result = a.computeOrder();
    System.out.print(result[0]);
    for(int i = 1; i<result.length;++i){
      System.out.print(" "+result[i]);
    }
    System.out.println();
    
  
  }
}
  
  class Project {
    static int tasks;
    static List<Integer>[] dependencies;
    static int[] nOfDepends;
    static List<Integer> order;
    Queue<Integer> Q;
    @SuppressWarnings("unchecked")

    public Project(int tas){
      tasks = tas+1;
      dependencies = new List[tasks];
      nOfDepends = new int[tasks];
      for(int i = 0; i <  tasks; ++i){
        dependencies[i] = new ArrayList<Integer>();
      }
    }
  
    public void addDependency(String[] depend){
      int x = Integer.parseInt(depend[0]);
      int nOfd = Integer.parseInt(depend[1]);
      nOfDepends[x]=nOfd;   //numero de dependencias de x 
      // adicionar as dependencias ao contrario
      for(int i = 2; i < nOfd+2; ++i){
        dependencies[Integer.parseInt(depend[i])].add(x);
      }

    }

    public void print(){
      for (int i =1; i < tasks;++i){
        System.out.println(dependencies[i]);
      }
    }
    
    public int[] computeOrder(){
      int[] result = new int[tasks-1];
      Q = new PriorityQueue<Integer>();
      order = new ArrayList<Integer>();
      for(int i = 1; i<tasks;i++){
        if(nOfDepends[i]==0)
          Q.add(i);   // adicionar as que não tem dependencias
      }
      int actual;
      while(!Q.isEmpty()){
        actual=Q.poll();
        order.add(actual);
        for(int i : dependencies[actual]){
          --nOfDepends[i];
          if(nOfDepends[i]==0)
            Q.add(i);
        }
      }
      for(int i = 0; i < tasks-1; ++i){
        result[i] = order.get(i);
      }

      return result;

    }
      
  }
```
