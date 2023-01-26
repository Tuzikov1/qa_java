package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void eatMeatShowPositiveOutput() throws Exception {
        Feline feline1= new Feline();
        List<String> expected =Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(expected,feline1.eatMeat());


    }

    @Test
    public void getFamilyFelinePositiveResult() {
        Feline feline =new Feline();
        String expected = "Кошачьи";
        assertEquals("Изменилась семья",expected, feline.getFamily());
    }

    @Test
    public void getKittensOneCountShowResult() {
        Feline feline1=new Feline();
       assertEquals(5,feline1.getKittens(5));

    }

    @Test
    public void getKittensPositiveNumbersPositiveResult() {
        Feline feline =new Feline();
        assertEquals(6, feline.getKittens(6));
    }
}