package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

@Mock
Feline feline;
    @Test
    public void getSound() {

        Cat cat=new Cat(feline);
        String expected= "Мяу";
        assertEquals("Кот говорит не \"Мяу\"",expected,cat.getSound());

            }

    @Test
    public void getFood() {
    }
}