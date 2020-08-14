/**
 * Write a description of interface IMarkovModel here
 *
 * @author Ryan Jolicoeur
 * @version 06/29/2020
 */

/**
 * Method: Interface
 * Details: Has three signatures
 *
 *          1. The void method set training that has one string parameter
 *              named text
 *          2. The void method setRandom that has one int parameter named
 *              seed
 *          3. The method getRandom text has one parameter named numChars
 *              and returns a String
 *
 */

public interface IMarkovModel {

    public void setTraining(String text);

    public void setRandom(int seed);

    public String getRandomText(int numChars);
}
