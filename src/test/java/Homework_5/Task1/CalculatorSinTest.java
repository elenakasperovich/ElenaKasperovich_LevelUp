package Homework_5.Task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSinTest extends AbstractCalculatorTest {

    @Test(dataProvider = "SinData", dataProviderClass = DataProviderCalculator.class)
    public void sinTest(double a, double expectedResult) {
        double actualResult = calculator.sin(a);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
