package Homework_5.Task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPowTest extends AbstractCalculatorTest {

    @Test(dataProvider = "powData", dataProviderClass = DataProviderCalculator.class)
    public void powTest(double a, double b, double expectedResult) {
        double actualResult = calculator.pow(a, b);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
