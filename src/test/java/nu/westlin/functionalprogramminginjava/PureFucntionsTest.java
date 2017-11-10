package nu.westlin.functionalprogramminginjava;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PureFucntionsTest {

    /*
    A pure function is a function which:
    Given the same inputs, always returns the same output, and
    Has no side-effects
     */

    int count = 0;

    // This is not a pure function because it has an side effect - it increases the the external variable count.
    // Secondly it does not return the same output for the same input:
    // First call: inccementCount(2) returns 2.
    // Second call: inccementCount(2) returns 4.
    // Third call: inccementCount(2) returns 6.
    int incrementCount(int increment) {
        return count += increment;
    }

    @Test
    public void incrementCount() {
        // This is not easy to test because I can not be sure which value count has at all times...
        // assertThat(incrementCount(2), is(?)
    }

    // This is a pure function because it has no side effects and
    // it returns the same output for the same input:
    // First call: square(4) returns 16.
    // Second call: square(4) returns 16.
    // Third call: square(4) returns 16.
    int square(int number) {
        return number * number;
    }

    @Test
    public void square() {
        int number = 4;

        assertThat(square(number), is(16));
        assertThat(square(number), is(16));
        assertThat(square(number), is(16));
    }
}
