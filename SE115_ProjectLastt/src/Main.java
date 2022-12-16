import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        game();
        //getFileScore();

    }
    public static void game(){
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
                if (board.onBoardCounter == 2 && board.onBoard[1].getRank().equals(board.onBoard[0].getRank())) {
                    for (int a = 0; a < 2; a++) {
                        player.pisti[player.pistiCounter]=board.onBoard[a];
                        player.pistiCounter++;
                        board.onBoard[a] = null;
                        board.onBoardCounter--;

                    }
                    System.out.println("You 've done Pişti");
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
                if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank().equals(board.onBoard[board.onBoardCounter - 2].getRank())) {
                    board.moveTo(player);
                    whoplay++;
                    lastplayed=0;
                    break;
                }
                whoplay++;
            }
            while (whoplay % 2 == 1) {
                computer.turn(board);
                if (board.onBoardCounter == 2 && board.onBoard[1].getRank().equals(board.onBoard[0].getRank())) {
                    for (int a = 0; a < 2; a++) {
                        computer.pisti[computer.pistiCounter]=board.onBoard[a];
                        computer.pistiCounter++;
                        board.onBoard[a] = null;
                        board.onBoardCounter--;

                    }
                    System.out.println("Computer has done Pişti");
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
                if (board.onBoardCounter>2 && board.onBoard[board.onBoardCounter-1].getRank().equals(board.onBoard[board.onBoardCounter - 2].getRank())) {
                    board.moveTo(computer);
                    whoplay++;
                    lastplayed=1;
                    break;
                }
                whoplay++;
            }
        }
        if(lastplayed==0&&board.onBoardCounter>0){      //Masada en son kalan kartları playera atar eğer masadaki kartları son toplayan playersa.
            board.moveTo(player);
        }
        if(lastplayed==1&&board.onBoardCounter>0){      //Masada en son kalan kartları computera atar eğer masadaki kartları son toplayan computersa
            board.moveTo(computer);
        }
        int computerScore = computer.score();
        if(computer.wonCounter+computer.pistiCounter>player.wonCounter+player.pistiCounter){
            computerScore+=3;

        }
        int playerScore=player.score();
        if(player.wonCounter+player.pistiCounter>computer.wonCounter+computer.pistiCounter){
            playerScore+=3;

        }
        System.out.println("The game is finished.");
        System.out.println("Player score is : " + playerScore);
        player.endScore=playerScore;//classa attık
        System.out.println("Computer score is : " + computerScore);
        computer.endScore=computerScore;//classa attık

        if(playerScore>computerScore){
            System.out.println("You win!");
        }
        if(playerScore<computerScore){
            System.out.println("You lose!");
        }
        if(playerScore==computerScore){
            System.out.println("Draw!");
        }
    }
    public static void getFileScore(){
        Scanner reader=null;
        try {
            reader = new Scanner(Paths.get("scores.txt"));
            while(reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        }catch(Exception e){
            System.out.println("Error");
        }finally{
            if (reader != null) {
                reader.close();
            }
        }

    }
    public static void setFileScore(Player player){
        Scanner sc = new Scanner(System.in);
        String name;
        int score;
        System.out.print("Enter name: " );
        name = sc.nextLine();
        score = player.endScore;
        Formatter f = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter ("scores.txt" , true);
            f = new Formatter (fw);
            f. format( name, score+"\n");
            fw.close();
        } catch (Exception e) {
            System.err.println("Something went wrong." );
        }

    }

}
