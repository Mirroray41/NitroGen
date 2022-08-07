package net.zappfire.nitrogencore.mixin;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.WorldPreset;
import net.minecraft.world.gen.WorldPresets;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
import net.zappfire.nitrogencore.NitroGenCore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(WorldPresets.Registrar.class)
public abstract class WorldPresetMixin {
	private static final RegistryKey<WorldPreset> NITROGEN_CORE_DIM = RegistryKey.of(Registry.WORLD_PRESET_KEY, new Identifier(NitroGenCore.MODID, "nitrogen_core_dim_preset"));
	@Shadow
	protected abstract RegistryEntry<WorldPreset> register(RegistryKey<WorldPreset> key, DimensionOptions dimensionOptions);
	@Shadow protected abstract DimensionOptions createOverworldOptions(ChunkGenerator chunkGenerator);

	@Inject(method = "initAndGetDefault", at = @At("RETURN"))
	private void addPresets(CallbackInfoReturnable<RegistryEntry<WorldPreset>> cir) {
		this.register(NITROGEN_CORE_DIM, this.createOverworldOptions(
				new FlatChunkGenerator(
						// passing null will use the default structure set
						null,
						new FlatChunkGeneratorConfig(
								// we don't need to overwrite the structure set
								Optional.empty(),
								BuiltinRegistries.BIOME)
				)
			)
		);
	}
}
