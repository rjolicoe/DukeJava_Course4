
/**
 * Write a description of class MarkovZero here.
 *
 * @author Duke Software
 * @version 1.0
 */


import java.util.Random;

public class MarkovZero implements IMarkovModel{
    private String myText;
    private Random myRandom;

    public MarkovZero() {
        myRandom = new Random();
    }

    /*
    Parameters: One integer parameter named seed.
    Goal: Allow you to generate the same random text each time
     */
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    /*
    Parameters: One String parameter names s.
    Goal: Initialize the training text.
    Tip: Don't change line myText = s.trim();
     */
    public void setTraining(String s){

        myText = s.trim();
    }

    /**
     Parameters: One Integer parameter named numChars.
     Goal: Generates and returns random text that is numChars long.
     Tip: Generates each letter by randomly choosing a letter from the training text.
     */

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numChars; i++){
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }
        return sb.toString();
    }

    /*
    @Override
    public String toString(){
        return String.format("MarkovModel of order %d", 0);
    }
    */

}
