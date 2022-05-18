import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZ_BUZZ = "FizzBuzz";
    private FizzBuzz game;

    @Before
    public void before(){
        game = new FizzBuzz();
    }

    @Test
    public void shouldReturnNumberWhenNotMultipleOf3or5() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals("1", numbersList.get(0));
        Assert.assertEquals("2", numbersList.get(1));
        Assert.assertEquals("7", numbersList.get(6));
        Assert.assertEquals("13", numbersList.get(12));
    }

    @Test
    public void shouldReturnFizzWhenIsMultipleOf3() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(FIZZ, numbersList.get(2));
        Assert.assertEquals(FIZZ, numbersList.get(5));
        Assert.assertEquals(FIZZ, numbersList.get(8));
        Assert.assertEquals(FIZZ, numbersList.get(11));

    }

    @Test
    public void shouldReturnBuzzWhenIsMultipleOf5() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(BUZZ, numbersList.get(4));
        Assert.assertEquals(BUZZ, numbersList.get(9));
        Assert.assertEquals(BUZZ, numbersList.get(19));
        Assert.assertEquals(BUZZ, numbersList.get(24));
    }

    @Test
    public void shouldReturnFizzBuzzWhenIsMultipleOf3And5() {
        List<String> numbersList = game.getNumbers();
        Assert.assertEquals(FIZZ_BUZZ, numbersList.get(14));
        Assert.assertEquals(FIZZ_BUZZ, numbersList.get(29));
        Assert.assertEquals(FIZZ_BUZZ, numbersList.get(59));
        Assert.assertEquals(FIZZ_BUZZ, numbersList.get(89));
    }
}
