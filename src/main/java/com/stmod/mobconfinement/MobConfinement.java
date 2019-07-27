package com.stmod.mobconfinement;

import com.stmod.mobconfinement.util.Util;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
	modid = MobConfinement.MODID,
	name = MobConfinement.NAME,
	version = MobConfinement.VERSION,
	acceptedMinecraftVersions = MobConfinement.ACCEPTED_MCVERSIONS
)
public class MobConfinement
{
    public static final String MODID = "mobconfinement";
    public static final String NAME = "MobConfinement_ST";
    public static final String VERSION = "1.12.2-1.0";
	public static final String ACCEPTED_MCVERSIONS = "[1.12.2]";
	public static String TIER_KEY = "MCONF_TIER";
	public static int HP_PER_TIER = 20;

	public static Item confinementItem;
	public static Item confinementAdv;
	public static Item confinementUltimate;

	//@Instance(MobConfinement.MODID)
	//public static MobConfinement instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Util.register();

		if (event.getSide().isClient()) {
			Util.renderInstances();
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		Util.addRecipe();
	}
}
