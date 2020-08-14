

import edu.duke.*;

public class MarkovRunner {

    /**
     * Method: public void
     *
     * @param markov
     * @param text
     * @param size
     *
     *
     */
    public void runModel(IMarkovModel markov, String text, int size){
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int i = 0; i < 3; i++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed){
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int i=0; i <3; i++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n',' ');
    //    MarkovWordOne markovWord = new MarkovWordOne();
        MarkovWordTwo markovWordTwo = new MarkovWordTwo();
      //  runModel(markovWord, st, 200);
      //    runModel(markovWord, st, 120, 139 );
        runModel(markovWordTwo, st, 120,832);
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("--------------------------------------");
        for(int i=0; i < words.length; i++){
            System.out.print(words[i] + " ");
            psize += words[i].length() + 1;
            if(psize > 60){
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n-------------------------------------");
    }

    public void testGetFollows(){
        String s = "this is just a test, this this is simple test";
        MarkovWordOne markovWord = new MarkovWordOne();
        markovWord.setTraining(s);
        System.out.println(markovWord.getFollows("test")+"\n");
        System.out.println(markovWord.getFollows("is")+"\n");
    }
}
