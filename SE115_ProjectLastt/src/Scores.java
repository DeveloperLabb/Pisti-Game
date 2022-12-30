import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Scores {
    public String name;
    public int score;
    public static Scores[] scoreArr = new Scores[100];
    public static int scoreCounter=0;

    public void highScoreList(Player player){
        try {
            try {
                File myObj = new File("scores.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }catch (Exception e ){
                e.getMessage();
            }
            Scanner reader = new Scanner(Paths.get("scores.txt"));
            Scanner scanner = new Scanner(System.in);
            while (reader.hasNextLine()) {
                Scores empty = new Scores();
                String[] data = reader.nextLine().split("-");
                empty.name = data[0];
                empty.score = Integer.parseInt(data[1]);
                scoreArr[scoreCounter]=empty;
                scoreCounter++;
            }
            reader.close();
            if(scoreCounter>=10){
                for(int a=0;a<scoreCounter;a++){
                    for(int b =0;b<scoreCounter-1;b++){
                        if(scoreArr[b].score>scoreArr[b+1].score){
                            Scores emptyy= new Scores();
                            emptyy=scoreArr[b];
                            scoreArr[b]=scoreArr[b+1];
                            scoreArr[b+1]=emptyy;
                        }
                    }
                }
                if(player.endScore>scoreArr[0].score){
                    System.out.println("You get a high score please input your name :");
                    String namee = scanner.nextLine().trim();
                    Scores emptye = new Scores();
                    emptye.name = namee;
                    emptye.score = player.endScore;
                    scoreArr[scoreCounter]=emptye;
                    scoreCounter++;
                    for(int a=0;a<scoreCounter;a++){
                        for(int b =0;b<scoreCounter-1;b++){
                            if(scoreArr[b].score>scoreArr[b+1].score){
                                Scores emptyy= new Scores();
                                emptyy=scoreArr[b];
                                scoreArr[b]=scoreArr[b+1];
                                scoreArr[b+1]=emptyy;
                            }
                        }
                    }
                }
            }
            else if(scoreCounter>0){
                for(int a=0;a<scoreCounter;a++){
                    for(int b =0;b<scoreCounter-1;b++){
                        if(scoreArr[b].score>scoreArr[b+1].score){
                            Scores emptyy= new Scores();
                            emptyy=scoreArr[b];
                            scoreArr[b]=scoreArr[b+1];
                            scoreArr[b+1]=emptyy;
                        }
                    }
                }
                System.out.println("You get a high score please input your name :");
                String name = scanner.nextLine().trim();
                Scores empty = new Scores();
                empty.name = name;
                empty.score = player.endScore;
                scoreArr[scoreCounter]=empty;
                scoreCounter++;
                for(int a=0;a<scoreCounter;a++){
                    for(int b =0;b<scoreCounter-1;b++){
                        if(scoreArr[b].score>scoreArr[b+1].score){
                            Scores emptyy= new Scores();
                            emptyy=scoreArr[b];
                            scoreArr[b]=scoreArr[b+1];
                            scoreArr[b+1]=emptyy;
                        }
                    }
                }
            }
            if(scoreCounter==0){
                System.out.println("You get a high score please input your name :");
                String name = scanner.nextLine().trim();
                Scores empty = new Scores();
                empty.name = name;
                empty.score = player.endScore;
                scoreArr[scoreCounter]=empty;
                scoreCounter++;
            }


            FileWriter fw = new FileWriter ("scores.txt");
            Formatter f = new Formatter (fw);
            if(scoreCounter<=10){
                for(int a =scoreCounter-1;a>=0;a--){
                    f.format(scoreArr[a].name+"-"+scoreArr[a].score+"\n");
                }
                fw. close();
                f.close();
            } else if (scoreCounter>10) {
                for(int a =scoreCounter-1;a>=scoreCounter-10;a--){
                    f.format(scoreArr[a].name+"-"+scoreArr[a].score+"\n");
                }
                fw. close();
                f.close();
            }


        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

