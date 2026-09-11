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
public class AlexTest {

    @Mock
    private FelineBehavior feline;
    private Alex alex;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void getFriendsReturnsAlexFriends() {
        Assert.assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo() {
        Assert.assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() {
        Assert.assertEquals(0, alex.getKittens());
    }

    @Test
    public void getKittensDoesNotCallFeline() {
        alex.getKittens();
        Mockito.verify(feline, Mockito.times(0)).getKittens();
    }

    @Test
    public void doesHaveManeReturnsTrue() {
        Assert.assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Assert.assertEquals(expected, alex.getFood());
    }
}
