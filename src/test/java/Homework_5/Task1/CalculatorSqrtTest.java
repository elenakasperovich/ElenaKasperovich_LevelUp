package Homework_5.Task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSqrtTest extends AbstractCalculatorTest {

    @Test(dataProvider = "SqrtData", dataProviderClass = DataProviderCalculator.class)
    public void sqrtTest(double a, double expectedResult) {
        double actualResult = calculator.sqrt(a);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
