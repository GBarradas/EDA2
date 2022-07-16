import java.io.*;
import java.util.*;
class Main{
    static BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
    static String[] aux;
    static int T;
    static int C;
    public static void Main(String[] Args) throws IOException
    {
        aux = br.readLine().split(" ");
        T = Integer.parseInt(aux[0]);
        C = Integer.parseInt(aux[11]);

    }
}
//arcos
class Edge{

}
//Vertices
class Vertex{

}
// grafo
class Christmas{
    int T;
    int C;
    Vertex start;
    Vertex end;
    List<Vertex> toys;
    List<Vertex> childrens;
    Christmas(int T, int C){
        this.T = T;
        this.C = C; 
        start = new Vertex();
        end = new Vertex();
        toys = new ArrayList<Vertex>();
        childrens = new ArrayList<Vertex>();
    }

}