import java.io.*;


class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        Coins algoland = new Coins(Integer.parseInt(br.readLine()));
        String[] values=br.readLine().split(" ");
        algoland.setValues(values);;
        int numChanges = Integer.parseInt(br.readLine());
        int amount;
        for(int i=0;i<numChanges;i++){
            amount=Integer.parseInt(br.readLine());
            System.out.println(amount+": "+"["+algoland.change(amount)+"]");
        }
  
    }
  }

  class Coins {
    int[] coinsValues;
    int numCoins;
    public Coins(int coins){
        this.numCoins=coins;
        coinsValues= new int[coins];
    }

    /* Inicializa os valores das moedas existentes. */
    public void setValues(String[] values){
        for(int i =0; i<coinsValues.length;i++){
            coinsValues[i]=Integer.parseInt(values[i]);
        }
    }

    /*
  Calcula e devolve o número mínimo de moedas necessário para
  obter a quantia AMOUNT.
    */
    public int change(int amount){
        int[] coins=new int[amount+1];
        coins[0]=0;
        for(int i=1;i<=amount;i++){
            coins[i]=i/coinsValues[0];
            //System.out.println(i+" "+coins[i]);
            for( int j=0;j<numCoins;j++){
                if(coinsValues[j]<=i && 1+coins[i-coinsValues[j]]<coins[i]){
                    coins[i]=1+coins[i-coinsValues[j]];
                }
            }
        }
        return coins[amount];
    }
  }