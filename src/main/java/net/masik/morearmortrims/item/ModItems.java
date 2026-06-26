package net.masik.morearmortrims.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {

    public static final Item STORM_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("storm_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.EPIC));
    public static final Item RAM_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("ram_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.RARE));
    public static final Item MYTH_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("myth_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.RARE));
    public static final Item GREED_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("greed_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.UNCOMMON));
    public static final Item BEAST_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("beast_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.UNCOMMON));
    public static final Item FEVER_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("fever_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.UNCOMMON));
    public static final Item WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("wraith_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.EPIC));
    public static final Item NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("nihility_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.RARE));
    public static final Item HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("horizon_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.UNCOMMON));
    public static final Item ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("origin_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.RARE));
    public static final Item TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("twilight_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.RARE));
    public static final Item PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("parasite_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.RARE));
    public static final Item WITNESS_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("witness_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, (new Item.Properties()).rarity(Rarity.RARE));

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreArmorTrims.MOD_ID, name));

        Item item = itemFactory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreArmorTrims.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(fabricCreativeModeTabOutput -> {
            fabricCreativeModeTabOutput.insertAfter(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE, STORM_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(STORM_ARMOR_TRIM_SMITHING_TEMPLATE, RAM_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(RAM_ARMOR_TRIM_SMITHING_TEMPLATE, MYTH_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(MYTH_ARMOR_TRIM_SMITHING_TEMPLATE, GREED_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(GREED_ARMOR_TRIM_SMITHING_TEMPLATE, BEAST_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(BEAST_ARMOR_TRIM_SMITHING_TEMPLATE, FEVER_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(FEVER_ARMOR_TRIM_SMITHING_TEMPLATE, WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE, NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE, HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE, ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE, TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE, PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE);
            fabricCreativeModeTabOutput.insertAfter(PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE, WITNESS_ARMOR_TRIM_SMITHING_TEMPLATE);
        });
    }

}
