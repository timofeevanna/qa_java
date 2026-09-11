package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionInvalidSexParameterizedTest {

    private final String sex;

    public LionInvalidSexParameterizedTest(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters(name = "Недопустимый пол: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {{""}, {null}, {"Кот"}, {"самец"}, {"самка"}};
    }

    @Test
    public void constructorThrowsExceptionForInvalidSex() {
        FelineBehavior feline = Mockito.mock(FelineBehavior.class);
        try {
            new Lion(sex, feline);
            Assert.fail("Ожидалось исключение для недопустимого пола");
        } catch (Exception exception) {
            Assert.assertEquals(
                    "Используйте допустимые значения пола животного - самей или самка",
                    exception.getMessage());
        }
    }
}
