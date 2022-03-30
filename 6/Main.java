import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    static String[] aux;
    static int A;
    static int B;
    static int E;
    static int P;  
    public static void main(String[] args) throws IOException
    {
        aux= br.readLine().split(" ");
        A = Integer.parseInt(aux[0]);
        B = Integer.parseInt(aux[1]);
        E = Integer.parseInt(aux[2]);
        P = Integer.parseInt(aux[3]);
        Organisation a = new Organisation(E);
        for(int i = 0; i< P; ++i){
          aux=br.readLine().split(" ");
          a.setOutperformed(              //set vertex
            Integer.parseInt(aux[0]),
            Integer.parseInt(aux[1])
          );
        }
        Promotions c = a.promotions(A,B);
        System.out.println(c.mProm);
        System.out.println(c.MProm);
        System.out.println(c.NProm);

        

    }
  }
  
  /*
    Promotions é um objecto que contém o número de funcionários que
    serão certamente promovidos nos limites de um intervalo de possíveis
    promoções e o número de funcionários que não serão promovidos mesmo
    no limite superior do intervalo.
  */
  class Promotions {
    int min;
    int max;
    Organisation a;
    Boolean[] visited0;
    Boolean[] visited1;
    int MProm = 0;
    int mProm = 0;
    int NProm = 0;
    public Promotions(int min, int max, Organisation a){
      this.min=min;
      this.max=max;
      this.a=a;
      int actual;
      int df;
      for(int i =0; i < a.employees;++i){
        visited0= new Boolean[a.employees];
        visited1= new Boolean[a.employees];
        for(int j = 0; j < a.employees; ++j){
          visited0[j] = false; 
          visited1[j] = false; 
        }
        df = dfs(i,a.invertex,visited1);
        actual = a.employees-dfs(i,a.vertex,visited0)+1;
        if(actual <= min) 
          ++mProm;
          if(actual<= max)
          ++MProm;
        if(df > max)
          ++NProm;
      }
    }
    
    
    public int dfs(int emploee, List<Integer>[] vert, Boolean[] vis ){
      if(vis[emploee]){
        return 0;
      }
      else{
        vis[emploee]=true;
        int result=1;
        for(int i: vert[emploee]){
          result += dfs(i,vert,vis);
        }
        return result;
      }


    }
    
  }
  
  class Organisation {
    /*
      Cria uma organização com EMPLOYEES funcionários.
    */
    int employees;
    List<Integer>[] vertex;
    List<Integer>[] invertex;
    @SuppressWarnings("unchecked")
    public Organisation(int employees){
        this.employees=employees;
        vertex = new List[employees];
        invertex = new List[employees];
        for(int i = 0; i<employees;i++){ 
          vertex[i]=new ArrayList<Integer>();
          invertex[i]=new ArrayList<Integer>();
        }
    }
    public void setOutperformed(int employee, int other){
        vertex[employee].add(other);
        invertex[other].add(employee);
    }
  
    public Promotions promotions(int min, int max){
      Promotions a = new Promotions(min,max,this);
      return a;
    }
    public void print(){
      for (int i =0; i < employees;++i){
        System.out.println(i+" "+vertex[i]);
      }
    }
  }