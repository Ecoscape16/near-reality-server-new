package com.zenyte.game.content.alternatetables.impl;

import com.zenyte.game.content.alternatetables.AlternateTableDropProvider;
import com.zenyte.game.world.entity.npc.drop.viewerentry.DropViewerEntry;
import com.zenyte.plugins.item.mysteryboxes.CosmeticMysteryBox;
import com.zenyte.plugins.item.mysteryboxes.RegalMysteryBox;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

public class MysteryBoxCosmeticTable implements AlternateTableDropProvider {

    static ObjectArrayList<DropViewerEntry> entries = new ObjectArrayList<>();

    @Override
    public ObjectArrayList<DropViewerEntry> getEntries() {
        if(entries.isEmpty())
            entries.addAll(CosmeticMysteryBox.toEntries());
        return entries;
    }

    @Override
    public String getName() {
        return "M.Box - Cosmetic";
    }
}
