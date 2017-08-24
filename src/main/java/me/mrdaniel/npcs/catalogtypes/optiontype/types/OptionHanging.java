package me.mrdaniel.npcs.catalogtypes.optiontype.types;

import java.util.Optional;

import me.mrdaniel.npcs.catalogtypes.optiontype.OptionType;
import me.mrdaniel.npcs.interfaces.mixin.NPCAble;
import me.mrdaniel.npcs.io.NPCFile;
import net.minecraft.entity.passive.EntityBat;

public class OptionHanging extends OptionType<Boolean> {

	public OptionHanging() {
		super("Hanging", "hanging");
	}

	@Override
	public boolean isSupported(final NPCAble npc) {
		return npc instanceof EntityBat;
	}

	@Override
	public void writeToNPC(final NPCAble npc, final Boolean value) {
		npc.setNPCHanging(value);
	}

	@Override
	public void writeToFile(final NPCFile file, final Boolean value) {
		file.setHanging(value).save();
	}

	@Override
	public Optional<Boolean> readFromFile(final NPCFile file) {
		return Optional.of(file.getHanging());
	}
}