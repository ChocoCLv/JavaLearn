package com.choco.offer.Chapter2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackWithTwoQueuesTest {

    @Test
    public void test(){
        StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(stack.pop(),new Integer(3));

        stack.push(4);

        Assert.assertEquals(stack.pop(),new Integer(4));
    }

}