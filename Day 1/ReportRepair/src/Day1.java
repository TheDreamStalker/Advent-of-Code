import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day1 {
    //Read the list file and put it in an ArrayList
    public static void main(String[] args) throws FileNotFoundException{
        Scanner s = new Scanner(new File("list.txt"));
        ArrayList<Integer> theList = new ArrayList<Integer>();
        while(s.hasNext()){
            theList.add(s.nextInt());
        }
        findTheNumbers(theList, 2020);
        //System.out.println(theList);
    }

    //Iterate through this Arraylist and attempt to find the matching pair.
    public static void findTheNumbers(ArrayList<Integer> numbers, int target){
        for(int i=0; i<numbers.size(); i++){
            for(int j=i+1; j<numbers.size(); j++){
                for(int z=i+2; z<numbers.size(); z++){
                    int tempSum = numbers.get(i) + numbers.get(j) + numbers.get(z);
                if(tempSum == target){
                    System.out.println("Your numbers are: "+ numbers.get(i) + " , " + numbers.get(j) + " and "+ numbers.get(z));
                    int solution = numbers.get(i) * numbers.get(j) * numbers.get(z);
                    System.out.println("Which gives the solution: "+ solution);
                }
                }
            }
        }
    }
}
