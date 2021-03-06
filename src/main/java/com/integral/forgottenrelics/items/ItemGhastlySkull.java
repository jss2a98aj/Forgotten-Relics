package com.integral.forgottenrelics.items;

import java.util.ArrayList;
import java.util.List;

import com.integral.forgottenrelics.Main;
import com.integral.forgottenrelics.handlers.SuperpositionHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thaumcraft.api.IWarpingGear;
import vazkii.botania.common.core.helper.Vector3;

public class ItemGhastlySkull extends Item implements IWarpingGear {
	
 public ItemGhastlySkull() {

	 this.maxStackSize = 1;
	 this.setUnlocalizedName("ItemGhastlySkull");
	 this.setCreativeTab(Main.tabForgottenRelics);

 }


 @Override
 public void registerIcons(IIconRegister iconRegister)
 {
 itemIcon = iconRegister.registerIcon("forgottenrelics:Ghastly_Skull");
 }


 @Override
 @SideOnly(Side.CLIENT)
 public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
 {
	 if(GuiScreen.isShiftKeyDown()){
		 par3List.add(StatCollector.translateToLocal("item.ItemGhastlySkull1.lore")); 
		 par3List.add(StatCollector.translateToLocal("item.ItemGhastlySkull2.lore")); 
	 }
	 else {
		 par3List.add(StatCollector.translateToLocal("item.FRShiftTooltip.lore")); 
		
	 }
	 
	 par3List.add(StatCollector.translateToLocal("item.FREmpty.lore")); 
 }
 	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setHealth(1);
		
		Vector3 vec = Vector3.fromEntityCenter(player);
		Vector3 look = new Vector3(player.getLookVec()).multiply(16.0D);
		look.add(vec.copy());
		
		if (world.isRemote) {
			//Main.log.info(Main.forgottenKnowledge);
			
			List<List> selfContainedArray = new ArrayList<List>();
			selfContainedArray.add(Main.darkRingDamageNegations);
			selfContainedArray.add(selfContainedArray);
			
			Main.log.info("The array: " + selfContainedArray);
			
		}

 		return stack;
 		
 		/*
 		System.out.println("Research list: " + ResearchCategories.researchCategories);
 		System.out.println("Researches in BASICS category: " + ResearchCategories.getResearchList("BASICS").research);
 		System.out.println("Researches in THAUMATURGY category: " + ResearchCategories.getResearchList("THAUMATURGY").research);
 		System.out.println("Researches in ALCHEMY category: " + ResearchCategories.getResearchList("ALCHEMY").research);
 		System.out.println("Researches in ARTIFICE category: " + ResearchCategories.getResearchList("ARTIFICE").research);
 		System.out.println("Researches in GOLEMANCY category: " + ResearchCategories.getResearchList("GOLEMANCY").research);
 		System.out.println("Researches in BASICS category: " + ResearchCategories.getResearchList("ELDRITCH").research);
		System.out.println("Lul: " + player.inventory.getStackInSlot(0));
		return stack;
		*/
	}


 @Override
 public EnumRarity getRarity(ItemStack itemStack)
 {
 return EnumRarity.epic;
 }

@Override
public int getWarp(ItemStack arg0, EntityPlayer arg1) {
	
	return 3;
}
 
 
}
