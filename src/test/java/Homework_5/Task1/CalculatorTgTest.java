package Homework_5.Task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTgTest extends AbstractCalculatorTest {

    @Test(dataProvider = "TgData", dataProviderClass = DataProviderCalculator.class)
    public void tgTest(double a, double expectedResult) {
        double actualResult = calculator.tg(a);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
