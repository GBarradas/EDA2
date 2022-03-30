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
      aux = br.readLine().split(" ");
      task = Integer.parseInt(aux[0]);
      nOfTasks = Integer.parseInt(aux[1]);
      for( int j=0;j<nOfTasks;++j){
        a.addDependency(task,Integer.parseInt(aux[j+2]));
      }
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
    static int current;
    static List< Integer> order;
    static List<Integer> aux;
    static Boolean[] executed ;
    @SuppressWarnings("unchecked")
    public Project(int tas){
      tasks = tas+1;
      dependencies= new List[tasks];
      
      for(int i = 0; i <  tasks; ++i){
        dependencies[i] = new ArrayList<Integer>();
      }
    }
  
    /*
      Acrescenta a tarefa PRECEDENT às tarefas de que a tarefa TASK depende.
      */
      public void addDependency(int task, int precedent){
        dependencies[task].add(precedent);
      }

      public void print(){
      for (int i =1; i < tasks;++i){
        System.out.println(dependencies[i]);
      }
    }
    public List<Integer> dfs(int no){
      executed[no]=true;
      for(int v : dependencies[no]){
        if(!executed[v]){
          System.out.println(v);
          dfs(v);
        }
      }
      aux.add(no);
      return aux;
    }
    
    public int[] computeOrder(){
      int[] result = new int[tasks-1];
      executed= new Boolean[tasks];
      order= new ArrayList<Integer>();
      aux = new ArrayList<Integer>();
      for(int i= 0; i<tasks;++i){
        executed[i]=false;
      }
      

      for(int i = 1; i<tasks;++i){
        if(!executed[i]){
          aux.clear();
          order.addAll( dfs(i));
        }
        System.out.println(order);
      }



      for(int i = 0; i<tasks-1;++i){
        result[i]=order.get(i);
      }
      return result;
    }
      
  }