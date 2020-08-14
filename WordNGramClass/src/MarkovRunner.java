
import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){
        markov.setTraining(text);
        System.out.println("running with: " + markov);
        for(int i=0; i < 3; i++){
            String st = markov.getRandomText(size);
            printOut(st);

        }
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed){
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("runing with " + markov);
        for(int i=0; i <3; i++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
    }

    public void runMarkovWord(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWord markovWord = new MarkovWord(5);
       // runModel(markovWord, st, 120, 643);
        runModel(markovWord, st, 120, 844);

    }

    public void testHashMap(){
        FileResource fr = new FileResource();
        String st = fr.asString();
       // String st = "this is a test yes this is really a test";
       //  st = st.replace('\n', ' ');
        EfficientMarkovWord emw = new EfficientMarkovWord(6);
        runModel(emw, st, 50, 792);
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------------------");
        for(int i =0; i< words.length; i++){
            System.out.print(words[i]+ " ");
            psize += words[i].length() + 1;
            if(psize > 60){
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------------------");
    }
}
