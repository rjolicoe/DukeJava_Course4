/**
 * Write a description of interface IMarkovModel here
 *
 * @author Ryan Jolicoeur
 * @version 06/27/2020
 */

public interface IMarkovModel {

    public void setTraining(String text);

    public void setRandom(int seed);

    public String getRandomText(int numChars);


}
