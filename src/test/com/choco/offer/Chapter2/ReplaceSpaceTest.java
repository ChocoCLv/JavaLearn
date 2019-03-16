package com.choco.offer.Chapter2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReplaceSpaceTest {

    @Test
    public void replaceSpace() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("asda  asd  aion mlm ");
        System.out.println(new ReplaceSpace().replaceSpace(stringBuffer));
    }
}