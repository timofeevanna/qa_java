package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> expected = List.of("Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        Assert.assertEquals(expected, cat.getFood());
    }

    @Test
    public void getFoodCallsEatMeat() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
