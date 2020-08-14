/**
 * Interface for the IMarkovModel
 *
 * @author Ryan Jolicoeur
 * @version 06/30/2020
 */

public interface IMarkovModel {

    public void setTraining(String text);

    public void setRandom(int seed);

    public String getRandomText(int numChars);


}
