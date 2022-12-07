import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String[] alphabetUC = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    static String[] alphabetLC  = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    static List<String> alphabetUCList = Arrays.asList(alphabetUC);
    static List<String> alphabetLCList = Arrays.asList(alphabetLC);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        var list = GetDataFromFile("C:\\Users\\janmr\\Desktop\\Advent Of Code 2022\\Day3\\src\\input.txt");
        var part1 = SolvePart1(list);

        System.out.println("Part 1: " + part1);

        var part2 = SolvePart2(list);
        System.out.printf("Part2: " + part2);

    }


    public static int SolvePart1(List<String> list){

        int count =0;
        List<Character> letters = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String[] parts = {list.get(i).substring(0, list.get(i).length() / 2), list.get(i).substring(list.get(i).length() / 2)};
            if (parts[0].length() != parts[1].length()) {
                throw new RuntimeException("Not halved");
            }
            for (int j = 0; j < parts[0].length(); j++) {
                var letter = parts[0].charAt(j);
                if (parts[1].indexOf(letter) != -1) {
                    letters.add(letter);
                    break;
                }
            }
        }

        for (int i = 0; i < letters.size(); i++) {
            if (Character.isUpperCase(letters.get(i))) {
                for (int j = 0; j < alphabetUC.length; j++){
                    if(letters.get(i) == alphabetUCList.get(j).toCharArray()[0]){
                        var x = letters.get(i);
                        count+=j+26+1;
                    }
                }
            } else {
                for (int j = 0; j < alphabetLC.length; j++){
                    if(letters.get(i) == alphabetLCList.get(j).toCharArray()[0]){
                        var x = letters.get(i);
                        count+=j+1;
                    }
                }
            }
        }

        return count;
    }

    public static int SolvePart2(List<String> list){
        int count = 0;
        int inc = 0;
        List<String> letters = new ArrayList<>();

        for (int i = 0; i < list.size() / 3; i++) {
            List<String> first = new ArrayList<String>(Arrays.asList(list.get(i + inc).split("")));
            List<String> second = new ArrayList<String>(Arrays.asList(list.get(i+1+ inc).split("")));
            List<String> third = new ArrayList<String>(Arrays.asList(list.get(i+2+ inc).split("")));

            for (int j = 0; j < first.size(); j++) {
                var letter = first.get(j);
                if(second.stream().filter(let -> let.equals(letter)).findFirst().isPresent()){
                    if(third.stream().filter(let -> let.equals(letter)).findFirst().isPresent()){
                            letters.add(letter);
                            break;
                    }
                }
            }
            inc += 2;
        }

        for (int i = 0; i < letters.size(); i++) {
            if (letters.get(i) == (letters.get(i).toUpperCase())){
                for (int j = 0; j < alphabetUC.length; j++){
                    if(letters.get(i).equals(alphabetUCList.get(j))){
                        var x = letters.get(i);
                        count+=j+26+1;
                    }
                }
            }
            else{
                for (int j = 0; j < alphabetLC.length; j++){
                    if(letters.get(i).equals(alphabetLCList.get(j))){
                        var x = letters.get(i);
                        count+=j+1;
                    }
                }
            }
        }
        return count;
    }
    public static List<String> GetDataFromFile(String path)
    {
        List<String> list = new ArrayList<>();
        File myObj = new File(path);
        if (myObj.exists()) {
            try {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    list.add(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        return list;
    }
}