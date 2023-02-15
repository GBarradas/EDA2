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

```` java 
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
```
