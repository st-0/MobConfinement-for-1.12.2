package com.stmod.mobconfinement.items;

import java.util.List;

import javax.annotation.Nullable;

import com.stmod.mobconfinement.MobConfinement;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemUltimateMobConf extends ItemMobConfinement {

	@Override
	public boolean isCatchable(Entity living, ItemStack pStack) {
		return true;
	}

	@Override
	public void executeCatch(EntityPlayer player, EntityLiving living) {
		executeCatch(MobConfinement.confinementUltimate, player, living, false);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, @Nullable World worldIn, List<String> list, ITooltipFlag flag)
	{
		NBTTagCompound nbttagcompound = itemStack.getTagCompound();

		if (nbttagcompound != null)
		{
			// Mob
			NBTTagCompound entityNBT = nbttagcompound.getCompoundTag("Mob");

			if (entityNBT != null)
			{
				list.add(entityNBT.getString("id"));
				String nameTag = nbttagcompound.getString("NameTag");

				if (nameTag != null && !nameTag.equals(""))
				{
					list.add(nameTag);
				}
			}
		}
	}

}
