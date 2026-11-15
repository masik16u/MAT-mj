package net.masik.morearmortrims.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.masik.morearmortrims.MoreArmorTrims;
import net.masik.morearmortrims.util.TrimHelper;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, BootstrapContext<Recipe<?>> bootstrapContext, BootstrapContext<Advancement> bootstrapContext1) {
        return new RecipeProvider(bootstrapContext, bootstrapContext1) {
            @Override
            public void buildRecipes() {
                for (int i = 0; i < TrimHelper.SMITHING_TEMPLATES.size(); i++) {

                    copySmithingTemplate(TrimHelper.SMITHING_TEMPLATES.get(i), TrimHelper.TRIM_MATERIALS.get(i));

                }

                for (int i = 0; i < TrimHelper.SMITHING_TEMPLATES.size(); i++) {

                    Item item = TrimHelper.SMITHING_TEMPLATES.get(i);
                    trimSmithing(item,
                            TrimHelper.TRIM_PATTERNS.get(i),
                            ResourceKey.create(Registries.RECIPE,
                                    Identifier.fromNamespaceAndPath(MoreArmorTrims.MOD_ID,
                                            item.toString().substring(17) + "_smithing_trim")));

                }
            }
        };
    }

    @Override
    public String getName() {
        return "MAT Recipes";
    }
}
