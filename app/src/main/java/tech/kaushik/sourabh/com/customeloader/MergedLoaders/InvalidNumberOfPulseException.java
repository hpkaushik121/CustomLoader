package tech.kaushik.sourabh.com.customeloader.MergedLoaders;

/**
 * Created by Sourabh kaushik on 8/5/2019.
 */
public class InvalidNumberOfPulseException extends Exception {

    @Override public String getMessage() {
        return "The number of pulse must be between 2 and 6";
    }
}
