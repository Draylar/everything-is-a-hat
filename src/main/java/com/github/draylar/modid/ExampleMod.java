package com.github.draylar.modid;

import com.github.draylar.modid.common.Blocks;
import com.github.draylar.modid.common.Items;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		Blocks.init();
		Items.init();
	}
}
