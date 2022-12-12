import java.util.Scanner;

public class Player {
    public static Card[] hand= new Card[4];
    public static int handCounter = 0;
    public static Card[] won = new Card[52];
    public static int wonCounter = 0;
    public static Card[] pisti= new Card[52];
    public static int pistiCounter = 0;
    public Player(){
        this.hand=new Card[4];
        this.handCounter=0;
        this.won = new Card[52];
        this.wonCounter = 0;
        this.pisti = new Card[52];
        this.pistiCounter=0;
    }
    public void writer(){
        System.out.print(handCounter+" cards on the player : ");
        for(int a = 0;a<handCounter;a++){
            System.out.print(hand[a].suit+"-"+hand[a].rank+" ");
        }
        System.out.println();

    }
    public void turn(Board board){
        Scanner scanner = new Scanner(System.in);
        board.writer();
        writer();
        System.out.print("Type number which card do you want to play from left to right: ");
        for (int a = 1;a<handCounter+1;a++){
            System.out.print(a+" ");
        }
        int ind = scanner.nextInt()-1;
        board.onBoard[board.onBoardCounter]=hand[ind];
        board.onBoardCounter +=1;
        hand[ind]=null;
        handCounter-=1;
        /*if(board.onBoard[board.onBoardCounter]==board.onBoard[board.onBoardCounter-1]){
            board.moveTo(player);
        }*/
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
    public int score(){
        int score = 0;
        for(int a =0 ;a<wonCounter;a++){
            if(won[a].suit.equals("Clubs")&&won[a].suit.equals("2")){
                score+=2;
                continue;
            }
            if(won[a].suit.equals("Diamonds")&&won[a].suit.equals("10")){
                score+=3;
                continue;
            }
            score+=1;
        }
        score+=pistiCounter*10;
        return score;
    }

}
