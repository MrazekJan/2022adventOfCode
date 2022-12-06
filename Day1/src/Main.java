import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = GetDataFromFile("C:\\Users\\janmr\\Desktop\\AdventOfCode2022\\Day1\\src\\input.txt");
        int maxValue = GetMaxValue(list);
        System.out.printf("Max Value: " + maxValue);

        var sumtopThree = SumTopThreeValues(list);

        System.out.printf("Sum of top three: " + sumtopThree);

    }

    public static List<String> GetDataFromFile(String path){
        List<String> list = new ArrayList<>();
        File myObj = new File(path);
        if (myObj.exists()) {
            System.out.println("File size in bytes " + myObj.length());
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

    public static int SumTopThreeValues(List<String> list){
        List<Integer> values = new ArrayList<>();
        var count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("")) {
                values.add(count);
                count = 0;
            }
            else {
                count+=Integer.parseInt(list.get(i));
            }
        }

        values.sort(Comparator.reverseOrder());

        return values.get(0) + values.get(1) + values.get(2);
    }


    public static int GetMaxValue(List<String> list){
        var count = 0;
        var maxValue = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("")) {
                if(maxValue < count || maxValue == 0){
                    maxValue = count;
                }
                count = 0;
            }
            else {
                count+=Integer.parseInt(list.get(i));
            }
        }

        return maxValue;
    }
}