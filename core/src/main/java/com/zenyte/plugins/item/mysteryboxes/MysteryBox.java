package com.zenyte.plugins.item.mysteryboxes;

import com.zenyte.game.item.ItemId;
import com.zenyte.game.model.item.ImmutableItem;
import com.zenyte.game.model.item.pluginextensions.ItemPlugin;
import com.zenyte.game.world.entity.npc.drop.viewerentry.DropViewerEntry;
import com.zenyte.game.world.entity.npc.drop.viewerentry.OtherDropViewerEntry;
import com.zenyte.plugins.PluginPriority;
import com.zenyte.plugins.interfaces.MysteryBoxInterface;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;

/**
 * @author Kris | 10/06/2019 06:31
 * @see <a href="https://www.rune-server.ee/members/kris/">Rune-Server profile</a>
 */
@PluginPriority(9990)
public class MysteryBox extends ItemPlugin {

    public static int totalWeight;
    public static MysteryItem[] rewards;
    public static MysterySupplyItem[] supplies;

    public static ObjectArrayList<DropViewerEntry> entries = new ObjectArrayList<>();
    public static ObjectArrayList<DropViewerEntry> toEntries() {
        if(entries.size() == 0) {
            calculateEntries();
        }
        return entries;
    }

    private static void calculateEntries() {
        for (final MysteryItem reward : rewards) {
            OtherDropViewerEntry entry = new OtherDropViewerEntry(reward.getId(), reward.getMinAmount(), reward.getMaxAmount(), reward.getWeight(), totalWeight, "");
            entries.add(entry);
        }
    }

    @Override
    public void handle() {
        bind("Open", (player, item, container, slotId) -> MysteryBoxInterface.openBox(player, item.getId(), rewards, totalWeight, supplies));
        bind("Quick-Open", (player, item, container, slotId) -> MysteryBoxInterface.openBoxQuick(player, item.getId(), rewards, totalWeight, supplies));

        rewards = new MysteryItem[] {
                //Crystal Chest
                new MysteryItem(6916, 1, 1, 500),
                new MysteryItem(6924, 1, 1, 500),
                new MysteryItem(6922, 1, 1, 500),
                new MysteryItem(6920, 1, 1, 500),
                new MysteryItem(6918, 1, 1, 500),
                //OTHER
                new MysteryItem(19707, 1, 1, 100),
                new MysteryItem(13288, 1, 1, 100),
                new MysteryItem(1961, 1, 1, 100),
                new MysteryItem(981, 1, 1, 100),
                new MysteryItem(1989, 1, 1, 100),
                new MysteryItem(1959, 1, 1, 100),
                new MysteryItem(13655, 1, 1, 100),
                new MysteryItem(6739, 1, 1, 1000),
                new MysteryItem(11840, 1, 1, 1000),
                new MysteryItem(12771, 1, 1, 1000),
                new MysteryItem(12769, 1, 1, 1000),
                new MysteryItem(6573, 1, 1, 750),
                //BARROWS
                new MysteryItem(4724, 1, 1, 200),
                new MysteryItem(4726, 1, 1, 200),
                new MysteryItem(4728, 1, 1, 200),
                new MysteryItem(4730, 1, 1, 200),
                new MysteryItem(4753, 1, 1, 200),
                new MysteryItem(4755, 1, 1, 200),
                new MysteryItem(4757, 1, 1, 200),
                new MysteryItem(4759, 1, 1, 200),
                new MysteryItem(4716, 1, 1, 200),
                new MysteryItem(4718, 1, 1, 200),
                new MysteryItem(4720, 1, 1, 200),
                new MysteryItem(4722, 1, 1, 200),
                new MysteryItem(4745, 1, 1, 200),
                new MysteryItem(4747, 1, 1, 200),
                new MysteryItem(4749, 1, 1, 200),
                new MysteryItem(4751, 1, 1, 200),
                new MysteryItem(4708, 1, 1, 200),
                new MysteryItem(4710, 1, 1, 200),
                new MysteryItem(4712, 1, 1, 200),
                new MysteryItem(4714, 1, 1, 200),
                new MysteryItem(4732, 1, 1, 200),
                new MysteryItem(4734, 1, 1, 200),
                new MysteryItem(4736, 1, 1, 200),
                new MysteryItem(4738, 1, 1, 200),
                new MysteryItem(12851, 1, 1, 500),
                //Donation Store Items
                new MysteryItem(11862, 1, 1, 20).announce(),
                new MysteryItem(962, 1, 1, 20).announce(),
                new MysteryItem(1037, 1, 1, 50).announce(),
                new MysteryItem(1419, 1, 1, 30).announce(),
                new MysteryItem(4151, 1, 1, 100),
                new MysteryItem(11838, 1, 1, 100),
                new MysteryItem(11824, 1, 1, 100).announce(),
                new MysteryItem(ItemId.DRAGON_DEFENDER, 1, 1, 1000).setCheckHasItem(),
                new MysteryItem(ItemId.FIGHTER_TORSO, 1, 1, 1000).setCheckHasItem(),
                new MysteryItem(ItemId.FIRE_CAPE, 1, 1, 500).setCheckHasItem(),
                new MysteryItem(6585, 1, 1, 1000),
                new MysteryItem(6889, 1, 1, 500),
                new MysteryItem(990, 1, 10, 1000),
                //Extra
                new MysteryItem(11284, 1, 1, 100).announce(),
                new MysteryItem(20724, 1, 1, 100).announce(),
                new MysteryItem(ItemId.BLACK_TOURMALINE_CORE, 1, 1, 50).announce(),
                new MysteryItem(ItemId.ANCIENT_SHARD, 1, 7, 200),
                new MysteryItem(ItemId.SPIRIT_SHIELD, 1, 1, 100),
                new MysteryItem(ItemId.BLESSED_SPIRIT_SHIELD, 1, 1, 40),
                new MysteryItem(ItemId.ANCIENT_WYVERN_SHIELD_21634, 1, 1, 42).announce(),
                new MysteryItem(30030, 1, 1, 60),
                new MysteryItem(ItemId.DRAGON_PICKAXE, 1, 1, 75),
                new MysteryItem(ItemId.DRAGON_CROSSBOW, 1, 1, 75).announce(),
                new MysteryItem(30031, 1, 1, 80),
                new MysteryItem(ItemId.DRAGON_KITESHIELD, 1, 1, 35).announce(),
                new MysteryItem(ItemId.DRAGON_PLATEBODY, 1, 1, 35).announce(),
                new MysteryItem(ItemId.DRAGON_FULL_HELM, 1, 1, 35).announce()
        };

        totalWeight = MysteryItem.calculateTotalWeight(rewards);

        supplies = new MysterySupplyItem[] {
                new MysterySupplyItem(11232, 100, 150),
                new MysterySupplyItem(22804, 100, 150),
                new MysterySupplyItem(20849, 100, 150),
                new MysterySupplyItem(384, 100, 225),
                new MysterySupplyItem(13440, 100, 150),
                new MysterySupplyItem(390, 100, 150),
                new MysterySupplyItem(1632, 25, 35),
                new MysterySupplyItem(1618, 40, 60),
                new MysterySupplyItem(1620, 50, 70),
                new MysterySupplyItem(2360, 120, 200),
                new MysterySupplyItem(2362, 100, 150),
                new MysterySupplyItem(2364, 50, 75),
                new MysterySupplyItem(1514, 100, 150),
                new MysterySupplyItem(537, 75, 100),
                new MysterySupplyItem(2, 400, 500),
                new MysterySupplyItem(10033, 150, 300),
                new MysterySupplyItem(10034, 150, 300),
                new MysterySupplyItem(11959, 120, 200),
                new MysterySupplyItem(9243, 300, 500),
                new MysterySupplyItem(9244, 250, 350),
                new MysterySupplyItem(5315, 5, 10),
                new MysterySupplyItem(5316, 3, 5),
                new MysterySupplyItem(5289, 3, 5),
                new MysterySupplyItem(5288, 5, 10),
                new MysterySupplyItem(12626, 15, 25),
                new MysterySupplyItem(12696, 15, 20),
                new MysterySupplyItem(10926, 15, 25),
                new MysterySupplyItem(ItemId.ZULRAHS_SCALES, 500, 2500),
                new MysterySupplyItem(20718, 30, 50)
        };
    }

    @Override
    public int[] getItems() {
        return new int[] {6199};
    }
}
