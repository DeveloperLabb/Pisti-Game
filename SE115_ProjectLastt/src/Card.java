import java.util.Random;

public class Card {
    public String rank;
    public String suit;
    public String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
    public String[] ranks ={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Card[] deck = new Card[52];
    public Card[] deckPlayer=new Card[52];
    public Card[] deckBoard=new Card[52];
    public Card[] deckComputer=new Card[52];
    public int playerCardCounter=0;
    public int computerCardCounter=0;
    public int boardCardCounter=0;
    public int deckCardCounter=0;


    public void deckMaker(){
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
        for(int a = 0;a<deck.length;a++){
            System.out.print(deck[a].suit+"-"+deck[a].rank+" ");
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

    }
    public void moveToPlayerFromBoard(Card[] deckPlayer){

        for (int a=0;a<deckBoard.length;a++) {
            deckPlayer[playerCardCounter] = deckBoard[boardCardCounter];
            playerCardCounter += +1;
            deckBoard[boardCardCounter]=null;
            boardCardCounter -= +1;
        }

    }

    public void moveToBoardFromDeck(Card[] deck){
        for (int a=0;a<deckBoard.length;a++) {
            deckBoard[boardCardCounter] = deck[deckCardCounter];
            boardCardCounter += +1;
            deck[deckCardCounter]=null;
            deckCardCounter -= +1;
        }
    }
    }

