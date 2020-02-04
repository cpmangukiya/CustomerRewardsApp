package org.example.rewards.pojo;

import java.util.Objects;

/**
 *
 */
public class ChannelType {

    private String name;

    public ChannelType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ChannelType)) {
            return false;
        }
        ChannelType channelType = (ChannelType) o;
        return Objects.equals(name, channelType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
