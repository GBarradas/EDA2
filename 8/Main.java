
import java.io.*;
import java.util.*;

public class Main {	
    static Map<String, Point> find = new HashMap<String, Point>();	

    static BufferedReader br = new BufferedReader( new InputStreamReader(System.in))	;
    static int drawnLines;
    static int numSegments;
    public static void main(String[] args) throws IOException {	
        drawnLines = 0;				
        numSegments = Integer.parseInt(br.readLine());				
         for (int i = 0; i < numSegments; i++) {		
             String[] aux = br.readLine().split(" ")	;
             String p1 = aux[0] + aux[1]; 			
             String p2 = aux[2] + aux[3]; 			
             Point point1 = find(p1);			
             Point point2 = find(p2);			
             if (point1 != point2) {				
                 union(point1, point2);				
                 drawnLines++;			
                }		
            }		
            System.out.println( drawnLines);	
    }	
    static void union(Point p1, Point p2) {		
        if (p1 != p2) {			
            p2.setAdj(p1);		
        }	
    }	
    static Point find(String key) {		
        Point tmp;		
        if (find.containsKey(key)) {			
            tmp = find.get(key);			
            while (tmp.adj != null)				
            tmp = tmp.adj;		
        }		
        else {			
            tmp = new Point();			
            find.put(key, tmp);		
        }		
        return tmp;	
    }
}
class Point {	
    Point adj;	
    Point () {		
        this.adj= null;	
    }	
    Point (Point p) {		
        this.adj = p;	
    }	
    void setAdj(Point p) {		
        this.adj = p;	
    }	
    
}
