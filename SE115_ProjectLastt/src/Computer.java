import java.util.Random;
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
        /*System.out.print(handCounter+" cards on the computer : ");
        for(int a = 0;a<handCounter;a++){
            System.out.print(hand[a].suit+"-"+hand[a].rank+" ");
        }
        System.out.println();*/
        System.out.println("Computer has played.");

    }
    public void turn(Board board){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        board.writer();
        writer();
        /*System.out.print("Type number which card do you want to play from left to right ");
        for (int a = 1;a<handCounter+1;a++){
            System.out.print(a+" ");
        }*/
        int ind = random.nextInt(0,handCounter);
        if(board.onBoardCounter>0) {
            if(board.onBoardCounter==1){
                for (int a = 0; a < handCounter; a++) {
                    if (board.onBoard[board.onBoardCounter - 1].getRank().equals(hand[a].getRank())) {
                        ind = a;
                    }
                    if (hand[a].getRank() == "J") {
                        ind = a;
                    }
                }
            }
            else {
                for (int a = 0; a < handCounter; a++) {
                    if (hand[a].getRank() == "J") {
                        ind = a;
                    }
                    if (board.onBoard[board.onBoardCounter - 1].getRank().equals(hand[a].getRank())) {
                        ind = a;
                    }
                }
            }
        }
        //ind = scanner.nextInt()-1;
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
