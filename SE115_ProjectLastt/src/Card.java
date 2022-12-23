import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Card {
    public String rank;
    public String suit;
    private String[] suits = {"C","D","H","S"};
    private String[] ranks ={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private Card[] deck;
    private int deckCounter; //deck.length

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public Card(){
        this.deckCounter=52;
        this.deck=new Card[52];
    }
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
        Scanner scanner = new Scanner(System.in);
        while(true){
            boolean done = false;
            int randomInt = 25;
            while(!done){
                try{
                    System.out.println("Input an integer number where you want to cut the deck (0-52): ");//randomdan kullanıcı girişliye çevirdim.
                    randomInt = scanner.nextInt();
                    done = true;
                }catch(InputMismatchException e){
                    scanner.nextLine();
                    System.out.println("Please type an integer!");
                }
            }
            if(randomInt>0&&randomInt<52){
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
                break;
            }
            else{
                System.out.print("Misstyped ");
                continue;
            }
        }
        System.out.println("Deck is cutted and ready to be played...");

    }
    public void writer(Card deck){
        System.out.print("Cards on the deck : ");
        for(int a = 0;a<deck.deckCounter;a++){
            System.out.print(deck.deck[a].suit+"-"+deck.deck[a].rank+" ");
        }
        System.out.println();
        System.out.println(deck.deckCounter);
    }
    public void dealTo(Player player,Computer computer){
        player.hand=new Card[4];
        computer.hand=new Card[4];
        player.handCounter=0;
        computer.handCounter=0;
        for(int a =0 ;a< 4 ;a++){
            player.hand[player.handCounter]=deck[deckCounter-1];
            player.handCounter+=1;
            deck[deckCounter-1]=null;
            deckCounter-=1;
            computer.hand[computer.handCounter]=deck[deckCounter-1];
            computer.handCounter+=1;
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
}

