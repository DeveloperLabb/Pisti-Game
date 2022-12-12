public class Board {
    public static Card[] onBoard;
    public static int onBoardCounter;
    public Board(){
        this.onBoard= new Card[52];
        this.onBoardCounter=0;
    }
    public void writer(){
        System.out.println("---------------------------");
        System.out.print(onBoardCounter+" cards on the board : ");
        for(int a = 0;a<onBoardCounter;a++){
            System.out.print(onBoard[a].getSuit()+"-"+onBoard[a].getRank()+" ");
        }
        System.out.println();

    }
    public void moveTo(Player player){
        int length = onBoardCounter;
        for(int a =0 ;a<length;a++){
            player.won[player.wonCounter]=onBoard[a];
            player.wonCounter+=1;
            onBoard[a]=null;
            onBoardCounter-=1;
        }
        System.out.println("Player got the cards.");
    }
    public void moveTo(Computer computer){
        int length = onBoardCounter;
        for(int a =0 ;a<length;a++){
            computer.won[computer.wonCounter]=onBoard[a];
            computer.wonCounter+=1;
            onBoard[a]=null;
            onBoardCounter-=1;
        }
        System.out.println("Computer got the cards.");
    }
}
