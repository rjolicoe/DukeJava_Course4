
/**
 * Write a description of class MarkovRunner here.
 *
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {

    /**
    Method Type: public void
    Parameters: None
    Goal: Reads in a file that the user chooses - ("FileResource from edu.duke.* package"), creates an object and generate three sets of
          randomly generated text";

     **/

    public void runMarkovZero() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
    //    MarkovZero markov = new MarkovZero();
    //    MarkovOne markov = new MarkovOne();
    //     MarkovTwo markov = new MarkovTwo();
   //     MarkovFour markov = new MarkovFour();
        MarkovModel markov = new MarkovModel(7);
        markov.setRandom(953);
    //    markov.setRandom(88);
    //    markov.setRandom(25);
    //    markov.setRandom(42);
    //    markov.setRandom(101);
        markov.setTraining(st);
        for (int i = 0; i < 3; i++){
            String text = markov.getRandomText(500);
            printOut(text);
        }

    }

    /**
    Method Type: public void
    Parameters: One String named which calls from the runMarkovZero()
    Tip - The more characters you use in the prediction, the more likely the text will appear like the training text.

     **/


    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("-------------------------------------");
        for (int i=0; i< words.length; i++){
            System.out.print(words[i] + " ");
            psize += words[i].length()+ 1;
            if(psize > 60){
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n-------------------------------");
    }
}
