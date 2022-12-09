public class Main {

    public static void main(String[] args) {
        Card card = new Card();
        Card[] deck = card.deckMaker();
        Card[] shuffledDeck = card.deckShuffle();
        for(int a = 0;a<shuffledDeck.length;a++){
            System.out.println(shuffledDeck[a].rank+" "+shuffledDeck[a].suit);
        }



    }



}