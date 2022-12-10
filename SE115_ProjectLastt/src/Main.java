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

        int whoplay=0;
        while(whoplay%2==0){
            game.turnPlayer(player,board);
            if(board.onBoard[board.onBoardCounter-1].rank==board.onBoard[board.onBoardCounter-2].rank){
                game.moveTo(board,player);
                whoplay++;
                break;
            }
            whoplay++;
        }







    }



}