import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetCheckTest {
    @Test
    public void checks() throws Exception
    {
        AlphabetCheck alphabetCheck = new AlphabetCheck();
        assertTrue(alphabetCheck.checks("abcdeFGHiJkl m 2345t45 noPQ  rxxvxvdes tuV WXyyz"));
        assertFalse(alphabetCheck.checks("kjdhkjcz"));
    }

}