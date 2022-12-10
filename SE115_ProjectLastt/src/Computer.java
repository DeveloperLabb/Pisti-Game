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

}
