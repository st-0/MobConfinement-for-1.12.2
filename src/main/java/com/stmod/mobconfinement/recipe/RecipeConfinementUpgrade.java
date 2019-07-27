package com.stmod.mobconfinement.recipe;

import com.stmod.mobconfinement.MobConfinement;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeConfinementUpgrade extends ShapedRecipes {

	public RecipeConfinementUpgrade() {
		super("", 3, 3, NonNullList.from(Ingredient.EMPTY,
				Ingredient.EMPTY, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 4)), Ingredient.EMPTY,
				Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 4)), Ingredient.fromStacks(new ItemStack(MobConfinement.confinementItem, 1, OreDictionary.WILDCARD_VALUE)), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 4)),
				Ingredient.EMPTY, Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 4)), Ingredient.EMPTY
		), new ItemStack(MobConfinement.confinementItem));
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		// 現在のレベル
		int lCurrentTier = 0;
		NBTTagCompound lCompound = null;

		ItemStack lStack = inv.getStackInRowAndColumn(1, 1).copy();
		lStack.setCount(1);

		if (lStack != null && lStack.getItem() == MobConfinement.confinementItem) {
			// 該当アイテムなら
			lCompound = lStack.getTagCompound();
			if (lCompound != null) {
				// 現在のTierを取得
				lCurrentTier = lCompound.getInteger(MobConfinement.TIER_KEY);
			} else {
				lCompound = new NBTTagCompound();
			}

			// 新たなTierを設定
			lCompound.setInteger(MobConfinement.TIER_KEY, ++lCurrentTier);
			lStack.setTagCompound(lCompound);

			return lStack;
		}

		return super.getCraftingResult(inv);
	}

}
