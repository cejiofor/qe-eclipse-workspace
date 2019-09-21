package org.platform.testproject.junit_test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import org.platform.testproject.StringAlg;

public class StringAlgsTest{
    @Test
    public void returnArrTest(){
        StringAlg sa = new StringAlg();
        assertTrue(sa.returnWord().length() == 3);
    }
}
