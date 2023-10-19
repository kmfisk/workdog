package com.github.kmfisk.workdog.client.gui;

import com.github.kmfisk.workdog.entity.core.WorkDogEntity;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;

public class WorkDogScreen extends Screen {
    public WorkDogScreen(WorkDogEntity dog, PlayerEntity player) {
        super(NarratorChatListener.NO_TITLE);
    }
}
