public class Main {

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        MarkovRunner mr  = new MarkovRunner();
        mr.runMarkovZero();

        /**
         *
         * Now let's instantiate the tester class
         */

        Tester tst = new Tester();
       // tst.testGetFollowsWithFile();
    }
}
