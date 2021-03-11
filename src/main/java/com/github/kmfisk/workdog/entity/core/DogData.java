package com.github.kmfisk.workdog.entity.core;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DogData {
    @SerializedName("max_health")
    private int maxHealth = 20;

    @SerializedName("coats")
    private int maxVariants = 0;

    @SerializedName("hunting_skill")
    private List<WeightedValue> huntingSkill = new ArrayList<>();
    private List<WeightedValue> gaminess = new ArrayList<>();
    private List<WeightedValue> aggression = new ArrayList<>();
    private List<WeightedValue> wariness = new ArrayList<>();
    private List<WeightedValue> voice = new ArrayList<>();
    private List<WeightedValue> courage = new ArrayList<>();
    private List<WeightedValue> playfulness = new ArrayList<>();
    private List<WeightedValue> speed = new ArrayList<>();
    private List<WeightedValue> damage = new ArrayList<>();

    private List<Genetic> genetics = new ArrayList<>();

    public static class WeightedValue{
        public boolean min, max;
        public int value, weight;
    }

    public static class Genetic{
        public int variant;
        public int[] carries = new int[0];
    }

    public List<Genetic> getGenetics() {
        return genetics;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxVariants() {
        return maxVariants;
    }

    public void setMaxVariants(int maxVariants) {
        this.maxVariants = maxVariants;
    }
}
