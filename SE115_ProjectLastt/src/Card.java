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
}
