package com.choco.offer.Chapter2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueWithTwoStacksTest {

    @Test
    public void test(){
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();

        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        Assert.assertTrue(queue.deleteHead()==1);

        queue.appendTail(4);

        Assert.assertTrue(queue.deleteHead()==2);
    }

}