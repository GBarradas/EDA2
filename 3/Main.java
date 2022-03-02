import java.io.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        String aux;
        String[] arrAux;
        int nBlocks;
        int[] cords = new int[4];
        for(int i=0;i<nCases;i++){
            City a = new City(Integer.parseInt(br.readLine()));
            aux= br.readLine()+" "+ br.readLine();
            nBlocks=Integer.parseInt(br.readLine());
            for(int j = 0;j<nBlocks;j++){
                arrAux=br.readLine().split(" ");
                a.addBlockage(Integer.parseInt(arrAux[0])-1,Integer.parseInt(arrAux[1])-1,arrAux[2]);
            }
            arrAux=aux.split(" ");
            for(int k= 0;k<arrAux.length;k++){{
                cords[k]=Integer.parseInt(arrAux[k])-1;
            }

            }
            System.out.println(a.numberOfWays(cords[0], cords[1], cords[2], cords[3]));
            //a.printW();
            //a.printB();
        }

    }
}

class City {
    String cityWorks[][];
    int size;
    long[][] ways;
    public City(int size){
        this.size=size;
        cityWorks=new String[size+1][size+1];
        ways=new long[size+1][size+1];
    }

    void printW(){
        for(int i=0;i<size+1 ;  i++){
            for(int j=0;j< size+1;j++){
                System.out.print(cityWorks[i][j]+" ");
            }
            System.out.println();
        }
    }
    void printB(){
        for(int i=size;i>=0 ;  i--){
            for(int j=0;j< size+1;j++){
                System.out.print(ways[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void addBlockage(int x, int y, String direction){
        if(direction.equals("S")){
            cityWorks[x][y]="N";
        }
        else if(direction.equals("W")){
            cityWorks[x][y]="E";
        }
        else if(direction.equals("E")){
            cityWorks[x][y-1]="E";
        }
        else if(direction.equals("N")){
            cityWorks[x-1][y]="N";
        }
    }

    public long numberOfWays(int sx, int sy, int ex, int ey){
       ways[ex][ey]=1;
       // sx==ex
       for(int i=ey-1;i>=sy;i--){
           if(cityWorks[ex][i]!="E") ways[ex][i]=ways[ex][i+1];
       }
       //sy==ey
       for(int i=ex-1;i>=sx;i--){
        if(i<ex && cityWorks[i][ey]!="N") ways[i][ey]=ways[i+1][ey];
       }
       // sx<ex && sy<ey
       for(int i=ex-1;i>=sx;i--){
        for(int j=ey-1;j>=sy;j--){
            if(cityWorks[i][j]!="N"){
                ways[i][j]+= ways[i+1][j];
            }
            if(cityWorks[i][j]!="E"){
                ways[i][j]+=ways[i][j+1];
            }
       }
    }
      
       return ways[sx][sy];
       
    }
}