package com.example.liontest;

import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;


    @Test
    public void getKittensPositiveNumbersPositiveResult() throws Exception {
        Lion lion = new Lion("Самец",feline);
        Mockito.when(feline.getKittens()).thenReturn(5);
        assertEquals(5,lion.getKittens());
 }


    @Test
    public void doesHaveManeIncorrectSexShowTextException()  {
        Exception exception= Assert.assertThrows(Exception.class,()-> new Lion("самец", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",exception.getMessage());

    }

    @Test
    public void getFoodShowPositiveOutput() throws Exception {
        Lion lion = new Lion("Самец",feline);
        List<String> expected =Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
       assertEquals(expected, lion.getFood());

    }
}