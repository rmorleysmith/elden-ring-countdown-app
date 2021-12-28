package com.example.eldenringcountdown;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

public class CountDownHelperTest {

    @Test
    public void testGetRemainingTimeAsText() {
        Assert.assertEquals("785:18:28:33" ,CountDownHelper.getRemainingTimeAsText(1577856687));
    }

}