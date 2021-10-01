package Homework_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AbstractCalculatorTest {

    @Test(dataProvider = "subLongData", dataProviderClass = DataProviderCalculator.class)
    public void subLongTest(long a, long b, long expectedResult) {
        long actualSum = calculator.sub(a, b);
        Assert.assertEquals(actualSum, expectedResult, "Incorrect result");
    }

    @Test(dataProvider = "subDoubleData", dataProviderClass = DataProviderCalculator.class)
    public void subDoubleTest(double a, double b, double expectedResult) {
        double actualSum = calculator.sub(a, b);
        Assert.assertEquals(actualSum, expectedResult, "Incorrect result");
    }
}
