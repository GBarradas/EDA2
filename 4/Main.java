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