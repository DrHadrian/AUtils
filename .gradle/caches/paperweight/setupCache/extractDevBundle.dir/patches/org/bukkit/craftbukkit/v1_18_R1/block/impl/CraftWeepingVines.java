/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_18_R1.block.impl;

public final class CraftWeepingVines extends org.bukkit.craftbukkit.v1_18_R1.block.data.CraftBlockData implements org.bukkit.block.data.Ageable {

    public CraftWeepingVines() {
        super();
    }

    public CraftWeepingVines(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.CraftAgeable

    private static final net.minecraft.world.level.block.state.properties.IntegerProperty AGE = getInteger(net.minecraft.world.level.block.WeepingVinesBlock.class, "age");

    @Override
    public int getAge() {
        return get(CraftWeepingVines.AGE);
    }

    @Override
    public void setAge(int age) {
        set(CraftWeepingVines.AGE, age);
    }

    @Override
    public int getMaximumAge() {
        return getMax(CraftWeepingVines.AGE);
    }
}
