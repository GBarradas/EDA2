import java.io.*;

class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int nCases = Integer.parseInt(br.readLine());
        String aux;
        String[] arrAux;
        int nBlocks;
        for(int i=0;i<nCases;i++){
            int size = Integer.parseInt(br.readLine());
            aux= br.readLine()+" "+ br.readLine();
            nBlocks=Integer.parseInt(br.readLine());
            String[][] works_x= new String[size+1][size+1];
            String[][] works_y= new String[size+1][size+1];
            long[][] ways = new long[size+1][size+1];
            for(int j = 0;j<nBlocks;j++){
                arrAux=br.readLine().split(" ");
                int pos_x = Integer.parseInt(arrAux[0])-1;
                int pos_y = Integer.parseInt(arrAux[1])-1;
                String direction = arrAux[2];
                if(direction.equals("S") ){
                    works_y[pos_x][pos_y-1]="N";
                }
                else if(direction.equals("W")){
                    works_x[pos_x-1][pos_y]="E";
                }
                else if(direction.equals("E")){
                    works_x[pos_x][pos_y]="E";
                }
                else if(direction.equals("N")){
                    works_y[pos_x][pos_y]="N";
                }
            }
            arrAux=aux.split(" ");
            int sx=Integer.parseInt(arrAux[0])-1,
                sy=Integer.parseInt(arrAux[1])-1,
                ex=Integer.parseInt(arrAux[2])-1,
                ey=Integer.parseInt(arrAux[3])-1;
            
            ways[ex][ey]=1;

            for(int k=ex ; k>=sx ;k--){
                for(int j=ey; j>=sy;j--){
                    if(works_x[k][j]!="E") ways[k][j]+= ways[k+1][j];
                    if(works_y[k][j]!="N") ways[k][j]+=ways[k][j+1];
                }
            }
            System.out.println(ways[sx][sy]);

            }
          
        

    }
}

