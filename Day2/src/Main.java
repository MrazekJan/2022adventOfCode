import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var enemyData = GetDataFromFile("C:\\Users\\janmr\\Desktop\\AdventOfCode2022\\Day2\\src\\input.txt", 0);
        var playerData = GetDataFromFile("C:\\Users\\janmr\\Desktop\\AdventOfCode2022\\Day2\\src\\input.txt", 1);

        System.out.println("Součet RPS: "+ SumRPSCount(playerData, enemyData));

        System.out.println("2. cast "+ Part2(playerData, enemyData));
    }

    public static List<String> GetDataFromFile(String path, int type) //0:User 1: Enemy
    {
        List<String> list = new ArrayList<>();
        File myObj = new File(path);
        if (myObj.exists()) {
            try {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] tokens = data.split(" ");
                    list.add(tokens[type]);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        return list;
    }

    public static int Part2(List<String> playerData,List<String> enemyData){
        int count = 0;
        int rock = 1;
        int paper = 2;
        int scissors = 3;

        int lose = 0;
        int draw = 3;
        int win = 6;

        for (int i = 0; i < playerData.size(); i++) {

            if(playerData.get(i).equals("X") && enemyData.get(i).equals("A")){
                count+=lose;
                count+=scissors;
            }
            if(playerData.get(i).equals("X") && enemyData.get(i).equals("B")){
                count+=lose;
                count+=rock;
            }
            if(playerData.get(i).equals("X") && enemyData.get(i).equals("C")){
                count+=lose;
                count+=paper;
            }

            if(playerData.get(i).equals("Y") && enemyData.get(i).equals("A")){
                count+=draw;
                count+=rock;
            }
            if(playerData.get(i).equals("Y") && enemyData.get(i).equals("B")){
                count+=draw;
                count+=paper;
            }
            if(playerData.get(i).equals("Y") && enemyData.get(i).equals("C")){
                count+=draw;
                count+=scissors;
            }

            if(playerData.get(i).equals("Z")  && enemyData.get(i).equals("A")){
                count+=win;
                count+=paper;
            }
            if(playerData.get(i).equals("Z") && enemyData.get(i).equals("B")){
                count+=win;
                count+=scissors;
            }
            if(playerData.get(i).equals("Z")  && enemyData.get(i).equals("C")){
                count+=win;
                count+=rock;
            }
        }

        return count;

    }

    public static int SumRPSCount(List<String> playerData,List<String> enemyData){
        int count = 0;
        int rock = 1;
        int paper = 2;
        int scissors = 3;

        int lose = 0;
        int draw = 3;
        int win = 6;

        if(playerData.size() != enemyData.size()){
            throw  new RuntimeException("Lists are not even");
        }

        for (int i = 0; i < playerData.size(); i++) {
            if(playerData.get(i).equals("X") && enemyData.get(i).equals("A")){
                count+=draw;
                count+=rock;
            }
            if(playerData.get(i).equals("X") && enemyData.get(i).equals("B")){
                count+=lose;
                count+=rock;
            }
            if(playerData.get(i).equals("X") && enemyData.get(i).equals("C")){
                count+=win;
                count+=rock;
            }

            if(playerData.get(i).equals("Y") && enemyData.get(i).equals("A")){
                count+=win;
                count+=paper;
            }
            if(playerData.get(i).equals("Y") && enemyData.get(i).equals("B")){
                count+=draw;
                count+=paper;
            }
            if(playerData.get(i).equals("Y") && enemyData.get(i).equals("C")){
                count+=lose;
                count+=paper;
            }

            if(playerData.get(i).equals("Z")  && enemyData.get(i).equals("A")){
                count+=lose;
                count+=scissors;
            }
            if(playerData.get(i).equals("Z") && enemyData.get(i).equals("B")){
                count+=win;
                count+=scissors;
            }
            if(playerData.get(i).equals("Z")  && enemyData.get(i).equals("C")){
                count+=draw;
                count+=scissors;
            }
        }
        return count;
    }
}