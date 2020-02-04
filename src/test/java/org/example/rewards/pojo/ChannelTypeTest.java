package org.example.rewards.pojo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Test ChannelType POJO
 */
public class ChannelTypeTest {

    /**
     * Validate ChannelType class using constructor based instantiation
     */
    @Test
    public void shouldValidateConstructorAndGetters() {
        ChannelType channelType = new ChannelType("MUSIC");
        assertEquals("MUSIC", channelType.getName());
    }

    /**
     * Validate overridden equals Method
     */
    @Test
    public void shouldValidateEquals() {
        assertEquals(new ChannelType("MUSIC"), new ChannelType("MUSIC"));
        assertNotEquals(new ChannelType("MUSIC"), new ChannelType("MOVIES"));
    }


}
