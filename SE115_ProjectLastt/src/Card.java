import java.util.Random;

public class Card {
    public String rank;
    public String suit;
    public String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
    public String[] ranks ={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Card[] deck = new Card[52];

   /* public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    */
    public Card[] deckMaker(){
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
        return deck;
    }
    public Card[] deckShuffle(){
        Random random = new Random();
        Card a = new Card();
        Card[] deck = a.deckMaker();
        Card empty= new Card();
        for(int i = 0;i<deck.length;i++){
            int randomIndex = random.nextInt(0,52);
            empty = deck[randomIndex];
            deck[randomIndex]=deck[i];
            deck[i]=empty;
        }
        return deck;
        }
    public void deckWriter(Card[] deck){
        for(int a = 0;a<deck.length;a++){
            System.out.println(deck[a].suit+" "+deck[a].rank);
        }
    }
    }

