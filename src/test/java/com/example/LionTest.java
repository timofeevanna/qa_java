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
public class LionTest {

    @Mock
    private FelineBehavior feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensReturnsCountFromFeline() {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Assert.assertEquals(3, lion.getKittens());
    }

    @Test
    public void getKittensCallsFeline() {
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> expected = List.of("Животные");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Assert.assertEquals(expected, lion.getFood());
    }

    @Test
    public void getFoodCallsFelineWithPredator() throws Exception {
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
