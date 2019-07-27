package com.stmod.mobconfinement.util;

import com.stmod.mobconfinement.MobConfinement;
import com.stmod.mobconfinement.items.ItemAdvancedMobConf;
import com.stmod.mobconfinement.items.ItemMobConfinement;
import com.stmod.mobconfinement.items.ItemUltimateMobConf;
import com.stmod.mobconfinement.recipe.RecipeConfinementUpgrade;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Util {
	//各種設定

	public static void register(){
		//登録作業
		MobConfinement.confinementItem = (new ItemMobConfinement()).
				setUnlocalizedName("mobconfinement").setCreativeTab(CreativeTabs.MISC).setRegistryName("mobconfinement");
		MobConfinement.confinementAdv = (new ItemAdvancedMobConf()).
				setUnlocalizedName("mobconfinementadvanced").setCreativeTab(CreativeTabs.MISC).setRegistryName("mobconfinementadvanced");
		MobConfinement.confinementUltimate = (new ItemUltimateMobConf()).
				setUnlocalizedName("mobconfinementultimate").setCreativeTab(CreativeTabs.MISC).setRegistryName("mobconfinementultimate");
		//総登録
	    ForgeRegistries.ITEMS.register(MobConfinement.confinementItem);
	    ForgeRegistries.ITEMS.register(MobConfinement.confinementAdv);
	    ForgeRegistries.ITEMS.register(MobConfinement.confinementUltimate);
	}

	public static void addRecipe(){
		GameRegistry.addShapedRecipe(new ResourceLocation(MobConfinement.MODID, "mobconfinement"), null,
				new ItemStack(MobConfinement.confinementItem,1,0),
				" X ",
				"XYX",
				" X ",
				'X',Items.EGG,'Y',Items.REDSTONE);
		GameRegistry.addShapedRecipe(new ResourceLocation(MobConfinement.MODID, "mobconfinementadvanced"), null,
				new ItemStack(MobConfinement.confinementAdv,1,0),
				" X ",
				"YZY",
				" X ",
				'X',Items.ENDER_PEARL,'Y',Items.BLAZE_ROD,'Z',MobConfinement.confinementItem);
		GameRegistry.addShapedRecipe(new ResourceLocation(MobConfinement.MODID, "mobconfinementultimate"), null,
				new ItemStack(MobConfinement.confinementUltimate,1,0),
				"XXX",
				"XYX",
				"XXX",
				'X',Blocks.DIAMOND_BLOCK,'Y',MobConfinement.confinementAdv);

		ForgeRegistries.RECIPES.register(new RecipeConfinementUpgrade().setRegistryName(MobConfinement.MODID, "mobconfinement_upgrade"));

	}

	public static void renderInstances(){
		ModelResourceLocation confinementR[] = new ModelResourceLocation[]{
				new ModelResourceLocation(MobConfinement.MODID + ":" + "mobconfinement0", "inventory"),
				new ModelResourceLocation(MobConfinement.MODID + ":" + "mobconfinement1", "inventory")
		};
		ModelResourceLocation confinementAR[] = new ModelResourceLocation[]{
				new ModelResourceLocation(MobConfinement.MODID + ":" + "adv_mobconfinement0", "inventory"),
				new ModelResourceLocation(MobConfinement.MODID + ":" + "adv_mobconfinement1", "inventory")
		};
		ModelResourceLocation confinementUR[] = new ModelResourceLocation[]{
				new ModelResourceLocation(MobConfinement.MODID + ":" + "ult_mobconfinement0", "inventory"),
				new ModelResourceLocation(MobConfinement.MODID + ":" + "ult_mobconfinement1", "inventory")
		};
		ModelLoader.registerItemVariants(MobConfinement.confinementItem, confinementR);
		ModelLoader.setCustomModelResourceLocation(MobConfinement.confinementItem, 0, confinementR[0]);
		ModelLoader.setCustomModelResourceLocation(MobConfinement.confinementItem, 1, confinementR[1]);
		ModelLoader.registerItemVariants(MobConfinement.confinementAdv, confinementAR);
		ModelLoader.setCustomModelResourceLocation(MobConfinement.confinementAdv, 0, confinementAR[0]);
		ModelLoader.setCustomModelResourceLocation(MobConfinement.confinementAdv, 1, confinementAR[1]);
		ModelLoader.registerItemVariants(MobConfinement.confinementUltimate, confinementUR);
		ModelLoader.setCustomModelResourceLocation(MobConfinement.confinementUltimate, 0, confinementUR[0]);
		ModelLoader.setCustomModelResourceLocation(MobConfinement.confinementUltimate, 1, confinementUR[1]);
	}
}
