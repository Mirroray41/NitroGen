package net.zappfire.nitrogencore.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.zappfire.nitrogencore.NitroGenCore;

public class ModDimensions {
    public static final RegistryKey<World> NITROGEN_CORE_DIM_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(NitroGenCore.MODID,"core_dim"));
    public static final RegistryKey<DimensionType> NITROGEN_CORE_DIM_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, NITROGEN_CORE_DIM_KEY.getValue());


    public static void register() {
        NitroGenCore.LOGGER.debug("Registering Dimension Configurator!");
    }
}
