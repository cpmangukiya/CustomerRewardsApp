package org.example.rewards.pojo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.example.rewards.pojo.ChannelType;

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

}
