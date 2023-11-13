import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ModulusTest {
    
    @Test
    public void lastDigitTest() {
        int value = 12923;
        int lastDigit = value % 10;
        System.out.println( "Last Digit = " + lastDigit );
        assertEquals( 3, lastDigit);
    }
}