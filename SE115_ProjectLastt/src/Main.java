public class Main {

    public static void main(String[] args) {
        Card game = new Card();
        Player player = new Player();
        Computer computer = new Computer();
        Board board = new Board();

        game.deckMaker();
        game.deckShuffle();
        game.deckCutter();
        game.dealTo(board);
        game.dealTo(player);
        game.dealTo(computer);

        int whoplay = 0;
        while (true) {
            while (whoplay % 2 == 0) {
                game.turnPlayer(player, board);
                if (board.onBoardCounter == 2 && board.onBoard[1].rank == board.onBoard[0].rank) {
                    for (int a = 0; a < 2; a++) {
                        board.onBoard[a] = null;
                    }
                    player.pistiCounter++;
                    whoplay++;
                }
                if (board.onBoard[board.onBoardCounter - 1].rank == board.onBoard[board.onBoardCounter - 2].rank) {
                    game.moveTo(board, player);
                    whoplay++;
                    break;
                }
                game.writer(board);
                whoplay++;
            }
            while (whoplay % 2 == 1) {
                game.turnComputer(computer, board);
                if (board.onBoardCounter == 2 && board.onBoard[1].rank == board.onBoard[0].rank) {
                    for (int a = 0; a < 2; a++) {
                        board.onBoard[a] = null;
                    }
                    computer.pistiCounter++;
                    whoplay++;
                    break;
                }
                if (board.onBoard[board.onBoardCounter - 1].rank == board.onBoard[board.onBoardCounter - 2].rank) {
                    game.moveTo(board, computer);
                    whoplay++;
                    break;
                }
                game.writer(board);
                whoplay++;
            }
        }

    }
}