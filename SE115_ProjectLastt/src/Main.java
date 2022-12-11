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
        //
        int whoplay = 0;
        int round =1;
        int lastplayed=0; //0 player için 1 computer için.
        while (whoplay<48){
                if(whoplay==0||whoplay==8||whoplay==16||whoplay==24||whoplay==32||whoplay==40){
                    System.out.println("Round : "+round);
                    round++;
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
                        lastplayed=0;
                        break;
                    }
                    if (board.onBoardCounter>1 && board.onBoard[board.onBoardCounter-1].getRank().equals("J")){
                        board.moveTo(player);
                        whoplay++;
                        lastplayed=0;
                        break;
                    }
                    if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank() == board.onBoard[board.onBoardCounter - 2].getRank()) {
                        board.moveTo(player);
                        whoplay++;
                        lastplayed=0;
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
                        lastplayed=1;
                        break;
                    }
                    if (board.onBoardCounter>1 && board.onBoard[board.onBoardCounter-1].getRank().equals("J")){
                        board.moveTo(computer);
                        whoplay++;
                        lastplayed=1;
                        break;
                    }
                    if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank() == board.onBoard[board.onBoardCounter - 2].getRank()) {
                        board.moveTo(computer);
                        whoplay++;
                        lastplayed=1;
                        break;
                    }
                    whoplay++;
                }
            }
        if(lastplayed==0&&board.onBoardCounter>0){
            board.moveTo(player);
        }
        if(lastplayed==1&&board.onBoardCounter>0){
            board.moveTo(computer);
        }
        int computerScore= computer.score();
        if(computer.wonCounter+computer.pistiCounter*2>player.wonCounter+player.pistiCounter*2){
            computerScore+=3;
        }
        int playerScore=player.score();
        if(player.wonCounter+player.pistiCounter*2>computer.wonCounter+computer.pistiCounter*2){
            playerScore+=3;
        }
        System.out.println("The game is finished.");
        System.out.println("Player score is : " + playerScore);
        System.out.println("Computer score is : " + computerScore);

    }

    }
