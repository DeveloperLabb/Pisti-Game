public class Main {

    public static void main(String[] args) {
        Card card = new Card();
        Card[] deck = card.deckMaker();
        Card[] shuffledDeck = card.deckShuffle();
        Card[] cuttedDeck = card.deckCutter(shuffledDeck);
        card.deckWriter(deck);
        System.out.println();
        card.deckWriter(shuffledDeck);
        System.out.println();
        card.deckWriter(cuttedDeck);



    }



}