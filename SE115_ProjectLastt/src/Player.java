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

}
