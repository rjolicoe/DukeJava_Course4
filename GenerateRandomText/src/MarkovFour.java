import java.util.ArrayList;
import java.util.Random;

/**
 * Method: Class for Markov four to use four characters to predict the next
 *        character.
 * Goal: Copy and paste MarkovOne and the modify it
 */
public class MarkovFour {

    private String myText;
    private Random myRandom;

    /**
     Method Type: Constructor - w3schools.com/java/java_constructors.asp
     Parameters: None
     Goal:
     **/
    public MarkovFour(){

        myRandom = new Random();
    }

    /**
     Method Type: public void
     Parameters: One int named seed
     Goal: Instantiate a random seed for the training text.  Setting the seed similar to cases in ML allows for reproducibility of random text
     **/
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    /**
     Method Type: public void
     Parameters: One String named s
     Goal: Initialize the training text
     Tip: To insure output insure that myText = s.trim() is not changed
     **/

    public void setTraining(String s){

        myText = s.trim();
    }

    /**
     Method Type: public String
     Parameters: One integer named numChars
     Goal: Predict the next character by finding all the characters that follow
     the current character in the training text and then randomly picking
     one of them as the next character
     **/

    public String getRandomText(int numChars){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 4);
        String key = myText.substring(index, index+4);
        sb.append(key);

        for(int i=0; i < numChars -4; i++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }
        return sb.toString();

    }

    /**
     Method Type: ArrayList<String>
     Parameters: One String named key
     Goal: Find all characters from private variable myText(defined earlier) that follow key ad put all these characters into an ArrayList.
     Tip: if myText were "this is a test yes this is a test", then getFollows("t) should reutn an ArrayList with teh Strings "h", "e", "", ,"h", "e,"" as
     "t" appears 6 times.
     **/
    public ArrayList<String> getFollows(String key){
        int len = key.length();
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0; i < myText.length()-len; i++){
            if(key.equals(myText.substring(i, i+len))){
                result.add(myText.substring(i+len, i+len+1));
            }

        }
        return result;
    }
}
