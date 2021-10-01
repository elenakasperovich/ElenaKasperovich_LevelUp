package Homework_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test (dataProvider = "sumLongData", dataProviderClass = DataProviderCalculator.class)
    public void sumLongTest(long a, long b, long expectedResult) {
        long actualSum = calculator.sum(a, b);
        Assert.assertEquals(actualSum, expectedResult, "Incorrect result");
    }

    @Test (dataProvider = "sumDoubleData", dataProviderClass = DataProviderCalculator.class)
    public void sumDoubleTest(double a, double b, double expectedResult) {
        double actualSum = calculator.sum(a, b);
        Assert.assertEquals(actualSum, expectedResult, "Incorrect result");
    }
}
