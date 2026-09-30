package net.masik.morearmortrims.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.masik.morearmortrims.item.ModItems;
import net.minecraft.advancements.criterion.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.predicates.DataComponentPredicates;
import net.minecraft.core.component.predicates.EnchantmentsPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.predicates.*;

import java.util.List;

public class ModLootTableModifiers {

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((resourceKey, builder, lootTableSource, provider) -> {
            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("blocks/spawner"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.3f))
                        .when(LocationCheck.checkLocation(LocationPredicate.Builder.inDimension(Level.OVERWORLD)));
                builder.pool(lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("chests/abandoned_mineshaft"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.GREED_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.3f))
                        .when(AnyOfCondition.anyOf(
                                LocationCheck.checkLocation(LocationPredicate.Builder.inBiome(provider.getOrThrow(ResourceKey.create(Registries.BIOME,
                                        Biomes.BADLANDS.identifier())))),
                                LocationCheck.checkLocation(LocationPredicate.Builder.inBiome(provider.getOrThrow(ResourceKey.create(Registries.BIOME,
                                        Biomes.ERODED_BADLANDS.identifier())))),
                                LocationCheck.checkLocation(LocationPredicate.Builder.inBiome(provider.getOrThrow(ResourceKey.create(Registries.BIOME,
                                        Biomes.WOODED_BADLANDS.identifier()))))
                        ));
                builder.pool(lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("chests/igloo_chest"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.BEAST_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.5f));
                builder.pool(lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("chests/ruined_portal"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.FEVER_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.2f))
                        .when(LocationCheck.checkLocation(LocationPredicate.Builder.inDimension(Level.NETHER)));
                builder.pool(lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/evoker"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.RAM_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.entity().vehicle(
                                        EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(null, EntityType.RAVAGER)))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer());
                builder.pool(lootPool.build());
            }
            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/ravager"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.RAM_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.entity().passenger(
                                        EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(null, EntityType.EVOKER)))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer());
                builder.pool(lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/wither"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LocationCheck.checkLocation(LocationPredicate.Builder.inBiome(provider.getOrThrow(ResourceKey.create(Registries.BIOME,
                                        Biomes.SOUL_SAND_VALLEY.identifier())))))
                        .when(LootItemKilledByPlayerCondition.killedByPlayer());
                builder.pool(lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/endermite"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.2f))
                        .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER,
                                EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(null, EntityType.ENDERMAN))));
                builder.pool(lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("blocks/creaking_heart"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.WITNESS_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .when(LootItemRandomChanceCondition.randomChance(0.2f))
                        .when(InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                .withComponents(DataComponentMatchers.Builder.components()
                                        .partial(DataComponentPredicates.ENCHANTMENTS,
                                                EnchantmentsPredicate.enchantments(List.of(new EnchantmentPredicate(
                                                        provider.getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Enchantments.SILK_TOUCH.identifier())), MinMaxBounds.Ints.ANY
                                                )))).build()))))
                        .when(TimeCheck.time(provider.getOrThrow(ResourceKey.create(Registries.WORLD_CLOCK, WorldClocks.OVERWORLD.identifier())),
                                IntRange.range(13000, 23000)).setPeriod(24000))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CREAKING_HEART).setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(BlockStateProperties.NATURAL, true)));
                builder.pool(lootPool.build());
            }
        });

        LootTableEvents.REPLACE.register((resourceKey, lootTable, lootTableSource, provider) -> {

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("archaeology/ocean_ruin_cold"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE));

                return mergePools(lootTable, lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("gameplay/fishing/treasure"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.STORM_ARMOR_TRIM_SMITHING_TEMPLATE)
                                .setWeight(3)
                                .when(WeatherCheck.weather().setThundering(true)));

                return mergePools(lootTable, lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("gameplay/sniffer_digging"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE)
                                .when(AnyOfCondition.anyOf(
                                        LocationCheck.checkLocation(LocationPredicate.Builder.inBiome(provider.getOrThrow(ResourceKey.create(Registries.BIOME,
                                                Biomes.OLD_GROWTH_PINE_TAIGA.identifier())))),
                                        LocationCheck.checkLocation(LocationPredicate.Builder.inBiome(provider.getOrThrow(ResourceKey.create(Registries.BIOME,
                                                Biomes.OLD_GROWTH_SPRUCE_TAIGA.identifier()))))
                                )));

                return mergePools(lootTable, lootPool.build());
            }

            if (resourceKey == ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("gameplay/cat_morning_gift"))) {
                LootPool.Builder lootPool = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE)
                                .setWeight(8));

                return mergePools(lootTable, lootPool.build());
            }

            return null;

        });

    }

    private static LootTable mergePools(LootTable original, LootPool lootPool) {

        LootPool.Builder pool = LootPool.lootPool()
                .add(original.pools.getFirst().entries)
                .add(lootPool.entries);

        return LootTable.lootTable().pools(List.of(pool.build())).build();

    }

}
