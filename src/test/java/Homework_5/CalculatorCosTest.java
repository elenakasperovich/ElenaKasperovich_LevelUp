package Homework_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCosTest extends AbstractCalculatorTest {

    @Test(dataProvider = "CosData", dataProviderClass = DataProviderCalculator.class)
    public void cosTest(double a, double expectedResult) {
        double actualResult = calculator.cos(a);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
