package net.masik.morearmortrims.trim;

import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.TrimPattern;

public class ModTrimPatterns {

    public static final ResourceKey<TrimPattern> STORM = of("storm");
    public static final ResourceKey<TrimPattern> RAM = of("ram");
    public static final ResourceKey<TrimPattern> MYTH = of("myth");
    public static final ResourceKey<TrimPattern> GREED = of("greed");
    public static final ResourceKey<TrimPattern> BEAST = of("beast");
    public static final ResourceKey<TrimPattern> FEVER = of("fever");
    public static final ResourceKey<TrimPattern> WRAITH = of("wraith");
    public static final ResourceKey<TrimPattern> NIHILITY = of("nihility");
    public static final ResourceKey<TrimPattern> HORIZON = of("horizon");
    public static final ResourceKey<TrimPattern> ORIGIN = of("origin");
    public static final ResourceKey<TrimPattern> TWILIGHT = of("twilight");
    public static final ResourceKey<TrimPattern> PARASITE = of("parasite");
    public static final ResourceKey<TrimPattern> WITNESS = of("witness");

    public static void bootstrap(final BootstrapContext<TrimPattern> context) {
        register(context, STORM);
        register(context, RAM);
        register(context, MYTH);
        register(context, GREED);
        register(context, BEAST);
        register(context, FEVER);
        register(context, WRAITH);
        register(context, NIHILITY);
        register(context, HORIZON);
        register(context, ORIGIN);
        register(context, TWILIGHT);
        register(context, PARASITE);
        register(context, WITNESS);
    }

    public static void register(final BootstrapContext<TrimPattern> context, final ResourceKey<TrimPattern> registryKey) {
        TrimPattern pattern = new TrimPattern(registryKey.identifier(), Component.translatable(Util.makeDescriptionId("trim_pattern", registryKey.identifier())), false);
        context.register(registryKey, pattern);
    }

    private static ResourceKey<TrimPattern> of(String id) {
        return ResourceKey.create(Registries.TRIM_PATTERN, Identifier.fromNamespaceAndPath(MoreArmorTrims.MOD_ID, id));
    }

}
