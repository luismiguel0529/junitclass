import org.junit.Assert;
import org.junit.Test;

public class MoneyUtilsTest {

    @Test
    public void moneyTest(){
        String money = MoneyUtil.format(1000,"$");
        Assert.assertEquals("$1000.00",money);
    }

    @Test
    public void negativeMoneytest(){
        String money = MoneyUtil.format(-1000,"$");
        Assert.assertEquals("-$1000.00",money);
    }

    @Test
    public void euroMoneytest(){
        String money = MoneyUtil.format(-1000,"€");
        Assert.assertEquals("-€1000.00",money);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notNullExceptionMoneytest(){
        MoneyUtil.format(-1000,null);
    }
}
