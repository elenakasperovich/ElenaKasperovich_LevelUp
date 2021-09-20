package Homework_5.Task1;

import org.testng.annotations.DataProvider;

public class DataProviderCalculator {
    @DataProvider(name = "sumLongData")
    public static Object[][] sumLongData() {
        return new Object[][] {
            {5L, 5L, 10L},
            {2147483648L, 0, 2147483648L},
            {-10, -10, -20},
        };
    }

    @DataProvider(name = "sumDoubleData")
    public static Object[][] sumDoubleData() {
        return new Object[][] {
            {0, 2.5, 2.5},
            {100.55, 50.55, 151.1},
            {-20.20, -10.10, -30.299999999999997},
        };
    }

    @DataProvider(name = "subLongData")
    public static Object[][] subLongData() {
        return new Object[][] {
            {0, 300L, -300L},
            {200000L, 0, 200000L},
            {-20, -10, -10},
        };
    }

    @DataProvider(name = "subDoubleData")
    public static Object[][] subDoubleData() {
        return new Object[][] {
            {0, 2.5, -2.5},
            {3.5, 0, 3.5},
            {5.10, 3.10, 1.9999999999999996},
        };
    }

    @DataProvider(name = "multLongData")
    public static Object[][] multLongData() {
        return new Object[][] {
            {3L, 3L, 9L},
            {20000000L, 1, 20000000L},
            {-20, -10, 200},
        };
    }

    @DataProvider(name = "multDoubleData")
    public static Object[][] multDoubleData() {
        return new Object[][] {
            {-2.33, 3.222, -8.0},
            {3.33, -2.222, -8.0},
            {0, 0.1, 0.0},
        };
    }

    @DataProvider(name = "divLongData")
    public static Object[][] divLongData() {
        return new Object[][] {
            {3000L, 3000L, 1L},
            {2000L, 1, 2000L},
            {-20, -10, 2},
            {0, 1234L, 0},
        };
    }

    @DataProvider(name = "divDoubleData")
    public static Object[][] divDoubleData() {
        return new Object[][] {
            {2.5, 2.5, 1},
            {3.0, 1.5, 2.0},
            {-10.50, -5.25, 2.0}
        };
    }

    @DataProvider(name = "powData")
    public static Object[][] powDoubleData() {
        return new Object[][] {
            {2, 4, 16},
            {0, 4.666, 0},
            {-2, 9, -512},
            {-2, -5, -0.03125},
            {5.5, 0, 1},
        };
    }

    @DataProvider(name = "SqrtData")
    public static Object[][] sqrtData() {
        return new Object[][] {
            {0, 0},
            {4, 2},
            {0.49, 0.7},
            {0.25, 0.5},
        };
    }

    @DataProvider(name = "TgData")
    public static Object[][] tgData() {
        return new Object[][] {
            {45, 1},
            {30, 1}
        };
    }

    @DataProvider(name = "CtgData")
    public static Object[][] ctgData() {
        return new Object[][] {
            {30, 1},
            {45, 1},
        };
    }

    @DataProvider(name = "CosData")
    public static Object[][] cosData() {
        return new Object[][] {
            {0, 0},
            {60, 0.5},
            {360, 1},
        };
    }

    @DataProvider(name = "SinData")
    public static Object[][] sinData() {
        return new Object[][] {
            {0, 0},
            {30, 0.5},
            {90, 1},
        };
    }

    @DataProvider(name = "PositiveData")
    public static Object[][] positiveData() {
        return new Object[][] {
            {1, true},
            {-1, false},
            {0, false},
        };
    }

    @DataProvider(name = "NegativeData")
    public static Object[][] negativeData() {
        return new Object[][] {
            {-1, true},
            {-1, true},
            {0, false},
        };
    }
}