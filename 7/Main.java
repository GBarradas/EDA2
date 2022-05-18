import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
    static String[] aux;
    static int P;
    static int N;
    static SocialNetwork fb;
    static int p_i;
    static int p_j;
    static int w_ij;
    public static void main(String[] args) throws IOException
    {
      aux = br.readLine().split(" ");
      P = Integer.parseInt(aux[0]);
      N = Integer.parseInt(aux[1]);
      fb = new SocialNetwork(P);
      for(int i = 0; i < N; ++i){
        aux = br.readLine().split(" ");
        p_i = Integer.parseInt(aux[0]);
        p_j = Integer.parseInt(aux[1]);
        w_ij = Integer.parseInt(aux[2]);
        fb.addRelation(p_i,p_j,w_ij);
      }
      System.out.println(fb.maximumBackboneWeight());

    }
  }
  
  /*
    Pessoas numa rede social e a idade das suas relações (em dias).
  */
  class Edge implements Comparable<Edge>{
    Vertice start;
    Vertice end;
    int weight;
    boolean used;
    public Edge(Vertice start, Vertice end ,int weigth){
      this.start = start;
      this.end = end;
      this.weight = weigth;
      used = false;
    }
    public int compareTo(Edge a){
      if (this.weight > a.weight)
        return 1;
      else if(this.weight == a.weight)
        return 0;
      else
        return -1;
    }
  }
  class Vertice implements Comparable<Vertice>{
    int id;
    int key;
    Edge p;
    List<Edge> adj;
    List<Edge> inAdj;
    boolean visited;
    public Vertice(int id){
      this.id = id;
      visited = false;
      adj = new ArrayList<Edge>();
      inAdj = new ArrayList<Edge>();
    }
    public int compareTo(Vertice a){
      if (a.id > this.id)
        return -1;
      else if(a.id<this.id)
        return 1;
      else
        return 0;
    }
  }
  class SocialNetwork {
    int nPersons;
    Vertice[] vertex;
    Queue<Edge> allEdges;
    @SuppressWarnings("unchecked")
    

    public SocialNetwork(int nPersons){
      this.nPersons = nPersons+1;
      vertex = new Vertice[this.nPersons];
      allEdges =  new PriorityQueue<Edge>();
      for(int i =0;i< this.nPersons;++i){
        vertex[i] = new Vertice(i);
      }
    }   
    
    public void addRelation(int person1, int person2, int days){
      Edge a = new Edge(vertex[person1],vertex[person2],-days);
      Edge b = new Edge(vertex[person2],vertex[person1],-days);
      vertex[person1].adj.add(a);
      vertex[person1].inAdj.add(b);
      vertex[person2].adj.add(b);
      vertex[person2].inAdj.add(a);
      allEdges.add(a);
      allEdges.add(b);
      
    }
      public int maximumBackboneWeight(){
      int result = 0;
      Queue<Vertice> Q = new PriorityQueue<Vertice>();
      for(Vertice a :vertex){
          a.key = Integer.MAX_VALUE;
          a.p = null;
          Q.add(a);
      }
      Vertice actual;
      vertex[1].visited = true;
      vertex[1].key =0;
      while(!allEdges.isEmpty()){
        Edge a= allEdges.poll();
          Vertice end = a.end;
          if(!a.used){

            if(!end.visited  && a.weight < end.key ){
              if(end.p != null){
                Q.add(end.p.end);
                end.p.end.visited = false;
              }
              a.used = true;
              end.p = a;
              end.key=a.weight;
              end.visited=true;
              
            }
          }
        }
      for(int i =1; i< nPersons;++i){
        Vertice a = vertex[i];
        result -= a.key;
        System.out.println(a.id+" "+(-a.key)+" "+result);
      }
      return result;
    }
  }