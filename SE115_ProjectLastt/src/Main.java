public class Main {

    public static void main(String[] args) {
        Card game = new Card();
        Player player = new Player();
        Computer computer= new Computer();
        Board board = new Board();

        game.deckMaker();
        game.deckShuffle();
        game.deckCutter();
        game.dealTo(board);
        game.dealTo(player);
        game.dealTo(computer);
        game.writer(game);
        game.writer(player);
        game.writer(computer);
        game.writer(board);
        game.moveTo(board,player);
        game.writer(board);
        game.moveTo(board,computer);




    }



}