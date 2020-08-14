import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MarkovTwo {

    private String myText;
    private Random myRandom;

    public MarkovTwo(){
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){

        myText = s.trim();
    }

    public String getRandomText(int numChars){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 2);
        String key = myText.substring(index, index+2);
        sb.append(key);

        for(int i=0; i < numChars -2; i++){
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

    private ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length()){
            int start = myText.indexOf(key, pos);
            if (start == -1){
                break;
            }
            if (start + key.length() >= myText.length() - 1){
                break;
            }
            String next = myText.substring(start+key.length(), start+key.length()+1);
            follows.add(next);
            pos = start+key.length();
        }
        return follows;
    }

}
