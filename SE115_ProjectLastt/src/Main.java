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


        int whoplay = 0;
        while(game.getDeckCounter()>0){
                if(whoplay==0||whoplay==8||whoplay==16||whoplay==24||whoplay==32||whoplay==40||whoplay==48){
                    game.dealTo(player);
                    game.dealTo(computer);
                }
                while (whoplay % 2 == 0) {
                    player.turn(board);
                    if (board.onBoardCounter == 2 && board.onBoard[1].getRank() == board.onBoard[0].getRank()) {
                        for (int a = 0; a < 2; a++) {
                            board.onBoard[a] = null;
                            board.onBoardCounter--;
                        }
                        System.out.println("Pişti yaptınız");
                        player.pistiCounter++;
                        whoplay++;
                    }
                    if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank().equals("J")){
                        board.moveTo(player);
                    }
                    if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank() == board.onBoard[board.onBoardCounter - 2].getRank()) {
                        board.moveTo(player);
                        whoplay++;
                        break;
                    }
                    whoplay++;
                }
                while (whoplay % 2 == 1) {
                    computer.turn(board);
                    if (board.onBoardCounter == 2 && board.onBoard[1].getRank() == board.onBoard[0].getRank()) {
                        for (int a = 0; a < 2; a++) {
                            board.onBoard[a] = null;
                            board.onBoardCounter--;
                        }
                        System.out.println("Pişti yaptınız.");
                        computer.pistiCounter++;
                        whoplay++;
                        break;
                    }
                    if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank().equals("J")){
                        board.moveTo(computer);
                    }
                    if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank() == board.onBoard[board.onBoardCounter - 2].getRank()) {
                        board.moveTo(computer);
                        whoplay++;
                        break;
                    }
                    whoplay++;
                }
            }
        }
    }
