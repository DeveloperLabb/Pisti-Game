public class Main {

    public static void main(String[] args) {
        Card game = new Card();
        Player player1 = new Player();
        Computer computer= new Computer();
        Board board = new Board();
        Player player2= new Player();
        game.deckMaker();
        game.deckShuffle();
        game.deckCutter();
        game.dealTo(board);
        game.dealTo(player1);
        game.dealTo(computer);
        game.writer(game);
        game.writer(player1);
        game.writer(computer);
        game.writer(board);
        Card game2 = new Card();
        game2.deckMaker();
        game2.deckCutter();
        game2.dealTo(board);
        game2.writer(game2);



    }



}