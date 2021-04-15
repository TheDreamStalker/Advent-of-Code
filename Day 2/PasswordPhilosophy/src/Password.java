import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public int min;
    public int max;
    public String character;
    public String thePassword;

    //Do all the splitting calculations in the constructor:
    public Password(String s) {
        //First split the String into 2 parts: the policy and the password itself:  
        String[] strArr = s.split(":");
        String policy = strArr[0].trim();
        thePassword = strArr[1].trim();

        //Now split the policy into length and target character:
        strArr = policy.split(" ");
        String passLength = strArr[0].trim();
        character = strArr[1].trim();

        //And finally, split the length into minimum and maximum:
        strArr = passLength.split("-");
        min = Integer.valueOf(strArr[0].trim()); //Also have to convert the ints to strings
        max = Integer.valueOf(strArr[1].trim());
    }

    //Function that checks whether the password is valid according to its own policy (for the first half of the puzzle):
    public boolean checkPassword(){
        Matcher m = Pattern.compile(character).matcher(thePassword);
        int matches = 0;
        while(m.find()) matches++;
        return min <= matches && max >= matches;
    }

    //Same as the previous method but this one is changed slightly for the second half of the puzzle:
    public boolean realCheckPassword(){
        //Check that the min and max values are inside the length of the string (aka, the string isn't shorter than the given values):
        if(thePassword.length() < min || thePassword.length() < max){
            return false;
        }
        //Now get the character at the given positions (min and max):
        String first;
        String second;

        first = new String(new char[]{thePassword.charAt(min-1)});
        second = new String(new char[]{thePassword.charAt(max-1)});

        //
        if(character.equals(first) && character.equals(second)){
            return false;
        }
        if(!character.equals(first) && !character.equals(second)){
            return false;
        }
        return true;
    }
}
