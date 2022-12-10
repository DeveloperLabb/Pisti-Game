public class Board {
    public static Card[] onBoard;
    public static int onBoardCounter;
    public Board(){
        this.onBoard= new Card[52];
        this.onBoardCounter=0;
    }


    public void writer(){
        System.out.print("Cards on the board : ");
        for(int a = 0;a<onBoardCounter;a++){
            System.out.print(onBoard[a].getSuit()+"-"+onBoard[a].getRank()+" ");
        }
        System.out.println();
        System.out.println(onBoardCounter);
    }
}
