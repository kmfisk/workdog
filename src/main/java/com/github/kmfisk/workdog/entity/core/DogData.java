package com.github.kmfisk.workdog.entity.core;

import com.google.gson.annotations.SerializedName;
import net.minecraft.network.PacketByteBuf;

public class DogData {
    @SerializedName("max_health")
    public int maxHealth = 20;
    public int coats = 0;

    @SerializedName("hunting_skill")
    public IntRange huntingSkill;
    public IntRange gaminess;
    public IntRange aggression;
    public IntRange wariness;
    public IntRange voice;
    public IntRange courage;
    public IntRange playfulness;
    public FloatRange speed;
    public IntRange damage;

    public int[][] genetics = new int[0][];

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxVariants() {
        return coats;
    }

    public static class IntRange {
        public int min, max;

        public void write(PacketByteBuf packetByteBuf) {
            packetByteBuf.writeVarInt(min);
            packetByteBuf.writeVarInt(max);
        }

        public static IntRange read(PacketByteBuf packetByteBuf) {
            IntRange intRange = new IntRange();
            intRange.min = packetByteBuf.readVarInt();
            intRange.max = packetByteBuf.readVarInt();
            return intRange;
        }
    }

    public static class FloatRange {
        public float min, max;

        public void write(PacketByteBuf packetByteBuf) {
            packetByteBuf.writeFloat(min);
            packetByteBuf.writeFloat(max);
        }

        public static FloatRange read(PacketByteBuf packetByteBuf) {
            FloatRange floatRange = new FloatRange();
            floatRange.min = packetByteBuf.readFloat();
            floatRange.max = packetByteBuf.readFloat();
            return floatRange;
        }
    }
}
