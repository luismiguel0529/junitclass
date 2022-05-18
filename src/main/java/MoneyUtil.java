import java.math.BigDecimal;

public class MoneyUtil {

    public static String format(double salary, String symbol){

        if (symbol == null){
            throw new IllegalArgumentException("Error symbol es nulo");
        }

        if (salary < 0){
            symbol = "-".concat(symbol);
            salary = salary * -1;
        }
        BigDecimal rounded = BigDecimal.valueOf(salary).setScale(2, BigDecimal.ROUND_HALF_UP);
        return symbol + rounded;
    }
}
