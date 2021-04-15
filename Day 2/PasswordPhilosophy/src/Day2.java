import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//Ended up deciding to follow a tutorial since I really struggled with this one.
public class Day2 {
    public static void main(String[] args) throws Exception {
        try{
            //Read from the file:
            BufferedReader br = new BufferedReader(new FileReader("passwords.txt"));
            List<String> contents = new ArrayList<>();
            int validPasswords = 0;
            String line;
            while((line = br.readLine()) != null){
                //Validate each line:
                if(new Password(line).realCheckPassword()){
                    validPasswords++;
                }
                contents.add(line);
            }
            System.out.println("Number of valid passwords: "+ validPasswords);
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
