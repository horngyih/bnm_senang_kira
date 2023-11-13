package tech.coderonin.bnm.senangkira;

import java.math.BigDecimal;

public final class SenangKiraRounding {

    public static BigDecimal HUNDRED = new BigDecimal("100");

    public static BigDecimal round( BigDecimal value ){
        if( value == null ) return null;
        if( BigDecimal.ZERO.equals( value ) ) return BigDecimal.ZERO;
        int decimalValue = value.multiply(HUNDRED).intValue();
        int lastDigit = decimalValue % 10;
        int baseValue = decimalValue - lastDigit;
        BigDecimal result = value;
        switch(lastDigit){
            case 1:
            case 2:
                result = new BigDecimal(baseValue).divide(HUNDRED).setScale(2); //Round Down
                break;
            case 3:
            case 4:
            case 6:
            case 7:
                result = new BigDecimal(baseValue + 5).divide(HUNDRED).setScale(2); //Round Up 5
                break;
            case 8:
            case 9:
                result = new BigDecimal(baseValue + 10).divide(HUNDRED).setScale(2); //Round Up 10
                break;
        }
        return result;
    }
}