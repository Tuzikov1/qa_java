package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

@Mock
Feline feline;
    @Test
    public void getSoundMeowPositiveResult() {

        Cat cat=new Cat(feline);
        String expected= "Мяу";
        assertEquals("Кот говорит не \"Мяу\"",expected,cat.getSound());
            }

    @Test
    public void getFoodPositiveResult() throws Exception {
        Cat cat = new Cat(feline);
        List <String> expected =Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        assertEquals(expected, cat.getFood());
    }
}