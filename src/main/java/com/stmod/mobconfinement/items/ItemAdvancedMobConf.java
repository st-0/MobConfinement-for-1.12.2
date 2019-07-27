package com.stmod.mobconfinement.items;

import java.util.List;

import javax.annotation.Nullable;

import com.stmod.mobconfinement.MobConfinement;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemAdvancedMobConf extends ItemMobConfinement {

	@Override
	public boolean isCatchable(Entity living, ItemStack pStack) {
		if(
				living instanceof EntityDragon ||
				living instanceof EntityWither) return false;
		if(((EntityLiving)living).getHealth() >
				40) return false;
		return true;
	}

	@Override
	public void executeCatch(EntityPlayer player, EntityLiving living) {
		executeCatch(MobConfinement.confinementAdv, player, living, false);
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
