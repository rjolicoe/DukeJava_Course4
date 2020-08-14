import edu.duke.FileResource;

import java.util.*;


public class Tester {

    /**
    Method Type: public void
    Parameters: None
     Goal:
            1. Method should create a MarkovOne Object
            2. Set the training text as "this is a test yes this a test"
            3. Have the call getFollows() and printout the resulting ArrayList & size.
     Tip: Make sure to do the test from above and three examples and also on the strings"." and "t."
     **/

    public void testGetFollows(){
        MarkovOne mo = new MarkovOne();
        String text = "this is a test yes this a test.";
        mo.setTraining(text);
        ArrayList<String> list = mo.getFollows("t");
        System.out.println("The result of calling getFollows(\"t\") which is test 1 : " + list + ", and its size: " + list.size());
        System.out.println("------------------------------------------------------------------------------------------------------");
        ArrayList<String> list2 = mo.getFollows("e");
        System.out.println("The result of calling getFollows(\"e\") which is test 2: " + list2 + ", and its size: " + list2.size());
        System.out.println("------------------------------------------------------------------------------------------------------");
        ArrayList<String> list3 = mo.getFollows("h");
        System.out.println("The result of calling getFollows (\"h\") which is test 3: " + list3 + ", and its size: " + list3.size() );
        System.out.println("------------------------------------------------------------------------------------------------------");
        ArrayList<String> list4 = mo.getFollows(".");
        System.out.println("The result of calling getFollows (\".\") which is test 4: " + list4 + ", and its size: " + list4.size());
        System.out.println("------------------------------------------------------------------------------------------------------");
        ArrayList<String> list5 = mo.getFollows("es");
        System.out.println("The result of calling getFollows (\"es\") whics is test 5: " + list5 + ", and its size: " + list5.size());
    }

    /**
     * Method Type: public void
     * Parameters: None
     * Goal:
     *      1. Create a MarkovOne object
     *      2. Set the training text to a file the user selects - (similar to the methods in MarkovRunner)
     *      3. Then get follows
     * Tip: run program on confucius.txt and look for the charcters that follow "t".  You should get 11548
     */
    public void testGetFollowsWithFile(){
        MarkovOne mo = new MarkovOne();
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        mo.setTraining(st);
        ArrayList<String> list = mo.getFollows("he");
        System.out.println("The result of getFollow (\"he\") and its size: " + list.size());
    }
}
