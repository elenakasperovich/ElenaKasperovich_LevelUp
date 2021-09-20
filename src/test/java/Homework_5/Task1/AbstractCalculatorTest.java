package Homework_5.Task1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class AbstractCalculatorTest {
    protected Calculator calculator;

    @BeforeSuite
    public void beforeTestMethod() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void afterTestMethod() {
        calculator = null;
    }
}
