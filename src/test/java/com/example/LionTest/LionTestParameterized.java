package com.example.LionTest;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameterized {
    private String sex;
    private boolean expected;

    public LionTestParameterized(String sex, boolean expected) {
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
    @Test
    public void doesHaveManeTrueAndFalseResult() throws Exception {
        Feline feline = new Feline();
        Lion lion=new Lion(sex,feline);
        assertEquals(expected,lion.doesHaveMane());

    }














}

