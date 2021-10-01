package Homework_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorCtgTest extends AbstractCalculatorTest{

    @Test(dataProvider = "CtgData", dataProviderClass = DataProviderCalculator.class)
    public void ctgTest(double a, double expectedResult) {
        double actualResult = calculator.ctg(a);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
