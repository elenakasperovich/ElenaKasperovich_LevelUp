package Homework_5.Task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorIsNegativeTest extends AbstractCalculatorTest {

    @Test(dataProvider = "NegativeData", dataProviderClass = DataProviderCalculator.class)
    public void isNegativeTest(long a, boolean expectedResult) {
        boolean actualResult = calculator.isNegative(a);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect result");
    }
}
