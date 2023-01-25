package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    private String sex;
    private boolean expected;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;
    Animal animal;

    @Test
    public void getKittensPositiveNumbersPositiveResult() {
        Lion lion = new Lion(feline, animal);
        Mockito.when(feline.getKittens()).thenReturn(5);
        assertEquals(5,lion.getKittens());
 }

    @Test
    public void doesHaveManeTrueAndFalseResult() throws Exception {
        Lion lion=new Lion(sex);
        assertEquals(expected,lion.doesHaveMane());

    }

    @Test
    public void doesHaveManeShowException() throws Exception {
        Exception exception= Assert.assertThrows(Exception.class,()-> new Lion("самец"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",exception.getMessage());

    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline, animal);
        List<String> expected =Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(animal.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        assertEquals(expected, lion.getFood());

    }
}