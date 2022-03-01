import java.io.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        String aux;
        String[] cord;
        int nBlocks;
        for(int i=0;i<nCases;i++){
            City a = new City(Integer.parseInt(br.readLine()));
            aux= br.readLine()+" "+ br.readLine();
            nBlocks=Integer.parseInt(br.readLine());
            for(int j = 0;j<nBlocks;j++){
                cord=br.readLine().split(" ");
                a.addBlockage(Integer.parseInt(cord[0])-1,Integer.parseInt(cord[1])-1,cord[2]);
            }
            cord=aux.split(" ");
            System.out.println(a.numberOfWays(Integer.parseInt(cord[0])-1, Integer.parseInt(cord[1])-1, Integer.parseInt(cord[2])-1, Integer.parseInt(cord[3])-1));
        }
    }
}

class City {
  String cityWorks[][];
  int size;
    public City(int size){
        this.size=size;
        cityWorks=new String[size][size];
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
        long[][] ways=new long[size][size];
        ways[ex][ey]=1;
        for(int i=ex;i>=sx;i--){
            for(int j=ey;j>=sy;j--){
                if(i<ex && cityWorks[i][j]!="N"){
                    ways[i][j]+= ways[i+1][j];
                }
                if(j<ey && cityWorks[i][j]!="E"){
                    ways[i][j]+=ways[i][j+1];
                }
            }
        }
        return ways[sx][sy];
    }
}