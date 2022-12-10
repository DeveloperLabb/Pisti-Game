import java.util.Random;

public class Card {
    private String rank;
    private String suit;
    private String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
    private String[] ranks ={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private Card[] deck = new Card[52];
    private int deckCounter=52; //deck.length
    private Card[] deckPlayer= new Card[4];
    private int deckPlayerCounter=0; //deckPlayer.length
    private Card[] deckComputer=new Card[4];
    private int deckComputerCounter=0;//deckComputer.length
    private Card[] deckComputerWon=new Card[52];  //computer gained cards deck.
    private int deckComputerWonCounter=0; //Computer gained card counter
    private Card[] deckBoard=new Card[52];
    private int deckBoardCounter=0;     //deckBoard.length


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
    public void deckWriter(){
        for(int a = 0;a<deckCounter;a++){
            System.out.print(deck[a].suit+"-"+deck[a].rank+" ");
        }
        System.out.println();
    }
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
    public void dealToPlayer(){
        for(int a =0 ;a< 4 ;a++){
            deckPlayer[deckPlayerCounter]=deck[deckCounter-1];
            deckPlayerCounter+=1;
            deck[deckCounter-1]=null;
            deckCounter-=1;
        }
    }
    public void dealToComputer(){
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
    public void moveToComputer(){
        if(deckBoardCounter>0){
            for(int a = 0;a<deckBoardCounter;a++){
                deckComputerWon[deckComputerWonCounter]=deckBoard[deckBoardCounter];
                deckComputerWonCounter+=1;
                deckBoard[deckBoardCounter]=null;
                deckBoardCounter-=1;
            }
        }
    }
    public void gameInfo(){
        deckWriter();
        deckBoardWriter();
        deckPlayerWriter();
        deckComputerWriter();
    }
}

