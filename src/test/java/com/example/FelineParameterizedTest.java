package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "Количество котят: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {{0}, {1}, {3}};
    }

    @Test
    public void getKittensReturnsSpecifiedCount() {
        Feline feline = new Feline();
        Assert.assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
