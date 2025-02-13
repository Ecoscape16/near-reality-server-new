package com.zenyte.game.content.donation;

import com.zenyte.game.content.skills.magic.spells.teleports.Teleport;
import com.zenyte.game.content.skills.magic.spells.teleports.TeleportType;
import com.zenyte.game.item.Item;
import com.zenyte.game.world.entity.Location;
import com.zenyte.game.world.entity.player.Player;
import com.zenyte.game.world.entity.player.privilege.MemberRank;

import static com.zenyte.game.world.entity.player.privilege.MemberRank.Pyrite;

public enum HomeTeleport {
    HOME(new Location(3087, 3490), "Regular Home", Pyrite),
    MAGE_BANK(new Location(2539, 4716), "Mage's Bank", Pyrite),
    FOREX_ENCLAVE(new Location(3150, 3636), "Forex Enclave", Pyrite),
    DI(DonatorZoneTeleports.DI.getLocation(), "Donator Island", Pyrite),
    DIE(DonatorZoneTeleports.DIE.getLocation(), "Pyrite Island", Pyrite),
    RDI(DonatorZoneTeleports.RDI.getLocation(), "Ruby Island", MemberRank.Ruby),
    LDI(DonatorZoneTeleports.LDI.getLocation(), "Sapphire Island", MemberRank.Sapphire),
    UDI(DonatorZoneTeleports.UDI.getLocation(), "Amethyst Island", MemberRank.Amethyst),
    ;

    HomeTeleport(Location location, String name, MemberRank required) {
        this.location = location;
        this.name = name;
        this.required = required;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public MemberRank getRequired() {
        return required;
    }
    public static HomeTeleport get(Player player) {
        return VALUES[((Number)player.getAttributeOrDefault("HOME_TELEPORT", 0)).intValue()];
    }

    public Teleport getTeleport() {
        return new Teleport() {
            @Override
            public TeleportType getType() {
                return TeleportType.HOME_TELEPORT;
            }

            @Override
            public Location getDestination() {
                return getLocation();
            }

            @Override
            public int getLevel() {
                return 0;
            }

            @Override
            public double getExperience() {
                return 0;
            }

            @Override
            public int getRandomizationDistance() {
                return 0;
            }

            @Override
            public Item[] getRunes() {
                return new Item[0];
            }

            @Override
            public int getWildernessLevel() {
                return 20;
            }

            @Override
            public boolean isCombatRestricted() {
                return false;
            }
        };
    }

    public static HomeTeleport[] VALUES = values();

    private Location location;
    private String name;
    private MemberRank required;


}
