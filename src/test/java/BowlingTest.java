import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class BowlingTest {

    // input validation tests

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenHasNoSeparators() {
        new BowlingGame("0000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenHasNotEnoughSeparators() {
        new BowlingGame("0|0|00000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenHasTooManySeparators() {
        new BowlingGame("0|0|0|0|0|0|0|0|0|0|0|");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenValuesAreCharacters() {
        new BowlingGame("s|s|s|s|s|s|s|s|s|s||");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenValuesAreCharacters2() {
        new BowlingGame("*|*|*|*|*|*|*|*|*|*||");
    }

    // Game mechanics tests

    @Test
    public void gutterGame() {
        BowlingGame game = new BowlingGame("0|0|0|0|0|0|0|0|0|0||");
        assertThat(game.result(), is(0));
    }
}