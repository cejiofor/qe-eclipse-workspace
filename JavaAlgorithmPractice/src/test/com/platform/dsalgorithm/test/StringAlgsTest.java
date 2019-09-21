package com.platform.dsalgorithm.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.platform.dsalgorithm.StringAlg;

public class StringAlgsTest{
    @Test
    public void returnArrTest(){
        StringAlg sa = new StringAlg();
        assertTrue(sa.returnWord().length() == 3);
    }
}
