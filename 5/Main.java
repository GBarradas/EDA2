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