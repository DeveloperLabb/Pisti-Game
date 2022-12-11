import java.util.Scanner;

public class Computer {
    public static Card[] hand;
    public static int handCounter;
    public static Card[] won;
    public static int wonCounter;
    public static Card[] pisti;
    public static int pistiCounter;
    public Computer(){
        this.hand=new Card[4];
        this.handCounter=0;
        this.won = new Card[52];
        this.wonCounter = 0;
        this.pisti = new Card[52];
        this.pistiCounter=0;
    }
    public void writer(){
        System.out.print(handCounter+" cards on the computer : ");
        for(int a = 0;a<handCounter;a++){
            System.out.print(hand[a].suit+"-"+hand[a].rank+" ");
        }
        System.out.println();

    }
    public void turn(Board board){
        Scanner scanner = new Scanner(System.in);
        board.writer();
        writer();
        System.out.print("Type number which card do you want to play from left to right ");
        for (int a = 1;a<handCounter+1;a++){
            System.out.print(a+" ");
        }
        int ind = scanner.nextInt()-1;
        int indBoard=board.onBoardCounter;
        board.onBoard[indBoard]=hand[ind];
        board.onBoardCounter +=1;
        hand[ind]=null;
        handCounter-=1;
        Card[] temp = new Card[handCounter];
        int count=0;
        for(int a =0;a<handCounter+1;a++){
            if(hand[a]!=null){
                temp[count]=hand[a];
                count++;
            }
        }
        hand=temp;
    }

}
