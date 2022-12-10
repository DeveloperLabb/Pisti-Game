import java.util.Random;
import java.util.Scanner;

public class Card {
    private String rank;
    private String suit;
    private String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
    private String[] ranks ={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private Card[] deck;
    private int deckCounter; //deck.length

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String[] getSuits() {
        return suits;
    }

    public int getDeckCounter() {
        return deckCounter;
    }

    public String[] getRanks() {
        return ranks;
    }

    public Card[] getDeck() {
        return deck;
    }

    public Card(){
        this.deckCounter=52;
        this.deck=new Card[52];
    }
   /* private Card[] deckPlayer= new Card[4];
    private int deckPlayerCounter=0; //deckPlayer.length
    private Card[] deckComputer=new Card[4];
    private int deckComputerCounter=0;//deckComputer.length
    private Card[] deckComputerWon=new Card[52];  //computer gained cards deck.
    private int deckComputerWonCounter=0; //Computer gained card counter
    private Card[] deckBoard=new Card[52];
    private int deckBoardCounter=0;//deckBoard.length*/


    public void deckMaker(){
        System.out.println("Deck is preparing...");
        int count=0;
        for(int a = 0;a<suits.length;a++){
            for(int b = 0;b<ranks.length;b++){
                Card card = new Card();
                card.suit= suits[a];
                card.rank= ranks[b];
                deck[count]=card;
                count++;
            }
        }

    }
    public void deckShuffle(){
        System.out.println("Deck is shuffling...");
        Random random = new Random();
        Card empty= new Card();
        for(int i = 0;i<deck.length;i++){
            int randomIndex = random.nextInt(0,52);
            empty = deck[randomIndex];
            deck[randomIndex]=deck[i];
            deck[i]=empty;
        }

        }
    public void deckCutter(){
        Random random = new Random();
        int randomInt = random.nextInt(0,deck.length);
        Card[] deckTop = new Card[52-randomInt];
        Card[] deckBottom = new Card[randomInt];
        Card[] deckCutted = new Card[deck.length];
        int a = 0 ;
        for(int randomcopyy = randomInt;randomcopyy<deck.length;randomcopyy++){
            deckTop[a]=deck[randomcopyy];// Kesildikten sonra üstte yer alması gereken kartlar.
            a++;
        }
        a= 0;
        for(int b = 0;b<randomInt;b++) {
            deckBottom[a] = deck[b];//Kesildikten sonra altta yer alması gereken kartlar.
            a++;
        }
        a=0;
        for(int c = 0; c< deckTop.length;c++){
            deckCutted[a]=deckTop[c];
            a++;
        }
        a=0;
        for(int c = deckTop.length; c< deck.length;c++){
            deckCutted[c]=deckBottom[a];
            a++;
        }
        for (int d=0;d<deckCutted.length;d++){
            deck[d]=deckCutted[d];
        }
        System.out.println("Deck is cutted and ready to be played...");

    }
    /*public void deckWriter(){
        for(int a = 0;a<deckCounter;a++){
            System.out.print(deck[a].suit+"-"+deck[a].rank+" ");
        }
        System.out.println();
    }*/
    /*
    public void deckPlayerWriter(){
        System.out.print("Cards on your hand : ");
        for(int a = 0;a<deckPlayerCounter;a++){
            System.out.print(deckPlayer[a].suit+"-"+deckPlayer[a].rank+" ");
        }
        System.out.println();
    }
    public void deckComputerWriter(){
        System.out.print("Cards on the computer : ");
        for(int a = 0;a<deckComputerCounter;a++){
            System.out.print(deckComputer[a].suit+"-"+deckComputer[a].rank+" ");
        }
        System.out.println();
    }
    public void deckBoardWriter(){
        System.out.print("Cards on the board : ");
        for(int a = 0;a<deckBoardCounter;a++){
            System.out.print(deckBoard[a].suit+"-"+deckBoard[a].rank+" ");
        }
        System.out.println();
    }*/
    public void writer(Card deck){
        System.out.print("Cards on the deck : ");
        for(int a = 0;a<deck.deckCounter;a++){
            System.out.print(deck.deck[a].suit+"-"+deck.deck[a].rank+" ");
        }
        System.out.println();
        System.out.println(deck.deckCounter);
    }
    public void writer(Player player){
        System.out.print("Cards on the player : ");
        for(int a = 0;a<player.handCounter;a++){
            System.out.print(player.hand[a].suit+"-"+player.hand[a].rank+" ");
        }
        System.out.println();
        System.out.println(player.handCounter);
    }
    public void writer(Computer computer){
        System.out.print("Cards on the computer : ");
        for(int a = 0;a<computer.handCounter;a++){
            System.out.print(computer.hand[a].suit+"-"+computer.hand[a].rank+" ");
        }
        System.out.println();
        System.out.println(computer.handCounter);
    }
    public void dealTo(Player player){
        player.hand=new Card[4];
        for(int a =0 ;a< 4 ;a++){
            player.hand[player.handCounter]=deck[deckCounter-1];
            player.handCounter+=1;
            deck[deckCounter-1]=null;
            deckCounter-=1;
        }
    }
    public void dealTo(Board board){
        for(int a =0 ;a< 4 ;a++){
            board.onBoard[board.onBoardCounter]=deck[deckCounter-1];
            board.onBoardCounter+=1;
            deck[deckCounter-1]=null;
            deckCounter-=1;
        }
    }
    public void dealTo(Computer computer){
        computer.hand=new Card[4];
        for(int a =0 ;a< 4 ;a++){
            computer.hand[computer.handCounter]=deck[deckCounter-1];
            computer.handCounter+=1;
            deck[deckCounter-1]=null;
            deckCounter-=1;
        }
    }
    public void moveTo(Board board,Player player){
        int length = board.onBoardCounter;
        for(int a =0 ;a<length;a++){
            player.won[player.wonCounter]=board.onBoard[a];
            player.wonCounter+=1;
            board.onBoard[board.onBoardCounter-1]=null;
            board.onBoardCounter-=1;
        }
    }
    public void moveTo(Board board,Computer computer){
        if(board.onBoardCounter>0){
            int length = board.onBoardCounter;
            for(int a =0 ;a<length;a++){
                computer.won[computer.wonCounter]=board.onBoard[a];
                computer.wonCounter+=1;
                board.onBoard[board.onBoardCounter-1]=null;
                board.onBoardCounter-=1;
            }
        }
        else{
            System.out.println("Ortada kart yok");
        }

    }
    public void turnPlayer(Player player,Board board){
        Scanner scanner = new Scanner(System.in);
        board.writer();
        writer(player);
        System.out.println("Type number which card do you want to play from left to right 0-1-2-3");
        int ind = scanner.nextInt();
        int indBoard=board.onBoardCounter;
        board.onBoard[indBoard]=player.hand[ind];
        board.onBoardCounter +=1;
        player.hand[ind]=null;
        player.handCounter-=1;
        Card[] temp = new Card[player.handCounter];
        int count=0;
        for(int a =0;a<player.handCounter+1;a++){
            if(player.hand[a]!=null){
                temp[count]=player.hand[a];
                count++;
            }
        }
        player.hand=temp;
    }
    public void turnComputer(Computer computer,Board board){
        Scanner scanner = new Scanner(System.in);
        board.writer();
        writer(computer);
        System.out.println("Type number which card do you want to play from left to right 0-1-2-3");
        int ind = scanner.nextInt();
        int indBoard=board.onBoardCounter;
        board.onBoard[indBoard]=computer.hand[ind];
        board.onBoardCounter +=1;
        computer.hand[ind]=null;
        computer.handCounter-=1;
        Card[] temp = new Card[computer.handCounter];
        int count=0;
        for(int a =0;a<computer.handCounter+1;a++){
            if(computer.hand[a]!=null){
                temp[count]=computer.hand[a];
                count++;
            }
        }
        computer.hand=temp;
    }


    /* public void dealToComputer(){
        for(int a =0 ;a< 4 ;a++){
            deckComputer[deckComputerCounter]=deck[deckCounter-1];
            deckComputerCounter+=1;
            deck[deckCounter-1]=null;
            deckCounter-=1;
        }
    }
    public void dealToBoard(){
        for(int a =0 ;a< 4 ;a++){
            if (deckCounter>0){
                deckBoard[deckBoardCounter]=deck[deckCounter-1];
                deckBoardCounter+=1;
                deck[deckCounter-1]=null;
                deckCounter-=1;
            }
            else{
                System.out.println("No card in deck.");
            }
        }
    }
    public void gameInfo(){
        deckWriter();
        System.out.println(deckCounter);
        deckBoardWriter();
        System.out.println(deckBoardCounter);
        deckPlayerWriter();
        System.out.println(deckPlayerCounter);
        deckComputerWriter();
        System.out.println(deckComputerCounter);
    }*/


}

