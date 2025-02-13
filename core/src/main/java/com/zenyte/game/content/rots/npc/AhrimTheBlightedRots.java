package com.zenyte.game.content.rots.npc;

import com.zenyte.game.content.rots.RotsInstance;
import com.zenyte.game.content.skills.prayer.Prayer;
import com.zenyte.game.util.Utils;
import com.zenyte.game.world.World;
import com.zenyte.game.world.entity.Entity;
import com.zenyte.game.world.entity.Location;
import com.zenyte.game.world.entity.masks.Graphics;
import com.zenyte.game.world.entity.masks.Hit;
import com.zenyte.game.world.entity.masks.HitType;
import com.zenyte.game.world.entity.npc.combat.CombatScript;
import com.zenyte.game.world.entity.player.Player;
import com.zenyte.game.world.entity.player.SkillConstants;
import com.zenyte.game.world.entity.player.action.combat.magic.CombatSpell;

public class AhrimTheBlightedRots extends RotsBrother implements CombatScript {

	private static final Graphics AHRIMS_GFX = new Graphics(400, 0, 96);
	private static final Graphics SPLASH_GRAPHICS = new Graphics(85, 0, 124);
	private static final CombatSpell[] spells = {CombatSpell.CONFUSE, CombatSpell.WEAKEN, CombatSpell.CURSE};

	public AhrimTheBlightedRots(final Location tile, RotsInstance instance) {
		super(16035, tile, instance);
	}

	@Override
	public int attack(final Entity target) {
		final CombatSpell spell;
		if (Utils.randomBoolean(10)) {
			spell = CombatSpell.ICE_RUSH;
			setForceTalk("Got you!");
		} else if (Utils.randomBoolean(7)) {
			spell = Utils.getRandomElement(spells);
		} else {
			spell = CombatSpell.FIRE_WAVE;
		}

		setAnimation(spell.getAnimation());
		setGraphics(spell.getCastGfx());
		this.delayHit(World.sendProjectile(this, target, spell.getProjectile()), target, new Hit(this, this.getRandomMaxHit(this, combatDefinitions.getMaxHit(), MAGIC, target), HitType.MAGIC).onLand(hit -> {
			if (hit.getDamage() <= 0) {
				target.setGraphics(SPLASH_GRAPHICS);
				return;
			}
			target.setGraphics(spell.getHitGfx());
			if (spell != CombatSpell.FIRE_WAVE) {
				spell.getEffect().spellEffect(this, target, hit.getDamage());
				return;
			}
			if (target instanceof final Player player) {
				if (!player.getPrayerManager().isActive(Prayer.PROTECT_FROM_MAGIC)) {
					if (Utils.random(3) == 0) {
						target.setGraphics(AHRIMS_GFX);
						target.drainSkill(SkillConstants.STRENGTH, 5);
					}
				}
			}
		}));
		return combatDefinitions.getAttackSpeed();
	}

}
