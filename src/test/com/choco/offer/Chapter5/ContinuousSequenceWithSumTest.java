package com.choco.offer.Chapter5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContinuousSequenceWithSumTest {

    ContinuousSequenceWithSum continuousSequenceWithSum;

    @Before
    public void init(){
        continuousSequenceWithSum = new ContinuousSequenceWithSum();
    }

    @Test
    public void findContinuousSequence() {
        continuousSequenceWithSum.FindContinuousSequence(9);
    }
}