package Homework_5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsPositiveTest extends AbstractCalculatorTest {

    @Test(dataProvider = "PositiveData", dataProviderClass = DataProviderCalculator.class)
    public void isPositieTest(long a, boolean expectedResult) {
        boolean actualResult = calculator.isPositive(a);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
