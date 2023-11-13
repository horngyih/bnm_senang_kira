package tech.coderonin.bnm.senangkira;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized; 
import static org.junit.Assert.assertEquals;

import tech.coderonin.bnm.senangkira.SenangKiraRounding;

@RunWith(Parameterized.class)
public class RoundingTest {

    @Parameterized.Parameters(name="{0}")
    public static Iterable<Object[]> testParameters(){
        return Arrays.asList(
            new Object[]{ "No Rounding", new BigDecimal("82.00"), new BigDecimal("82.00")},
            new Object[]{ "No Rounding", new BigDecimal("82.05"), new BigDecimal("82.05")},
            new Object[]{ "Round Down 5", new BigDecimal("100.01"), new BigDecimal("100.00")},
            new Object[]{ "Round Down 5", new BigDecimal("1928.02"), new BigDecimal("1928.00")},
            new Object[]{ "Round Up 5", new BigDecimal("100.23"), new BigDecimal("100.25")},
            new Object[]{ "Round Up 5", new BigDecimal("1928.94"), new BigDecimal("1928.95")},
            new Object[]{ "Round Down 5", new BigDecimal("100.27"), new BigDecimal("100.25")},
            new Object[]{ "Round Down 5", new BigDecimal("1928.96"), new BigDecimal("1928.95")},
            new Object[]{ "Round Up 10", new BigDecimal("1928.98"), new BigDecimal("1929.00")},
            new Object[]{ "Round Up 10", new BigDecimal("1928.99"), new BigDecimal("1929.00")}
        );
    }

    private String testName;
    private BigDecimal value;
    private BigDecimal expected;

    public RoundingTest( String testName, BigDecimal value, BigDecimal expected ){
        this.testName = testName;
        this.value = value;
        this.expected = expected;
    }

    @Test
    public void defaultTest(){
        BigDecimal actual = SenangKiraRounding.round( value );
        System.out.println( testName + "\t:\t" + value + "\t->\t" + actual );
        assertEquals( expected, actual );
    }
}