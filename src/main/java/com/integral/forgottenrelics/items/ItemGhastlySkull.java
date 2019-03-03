package com.integral.forgottenrelics.items;

import java.awt.Color;
import java.util.List;

import com.integral.forgottenrelics.Main;
import com.integral.forgottenrelics.packets.BurstMessage;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.research.ScanResult;
import thaumcraft.client.fx.beams.FXBeam;
import thaumcraft.client.fx.beams.FXBeamWand;
import thaumcraft.client.lib.PlayerNotifications;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.playerdata.PacketResearchComplete;
import thaumcraft.common.lib.research.ScanManager;
import vazkii.botania.common.core.helper.Vector3;
import vazkii.botania.common.item.ModItems;

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
 /*
 public void beam(final World worldObj, final double sx, final double sy, final double sz, final double tx, final double ty, final double tz, final int type, final int color, final boolean reverse, final float endmod, final int age) {
     FXBeam beamcon = null;
     final Color c = new Color(color);
     beamcon = new FXBeam(worldObj, sx, sy, sz, tx, ty, tz, c.getRed() / 255.0f, c.getGreen() / 255.0f, c.getBlue() / 255.0f, age);
     beamcon.setType(type);
     beamcon.setEndMod(endmod);
     beamcon.setReverse(reverse);
     beamcon.setPulse(false);
     beamcon.width = 8.0F;
     FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)beamcon);
 }
 */
 	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setHealth(1);
		
		Vector3 vec = Vector3.fromEntityCenter(player);
		Vector3 look = new Vector3(player.getLookVec()).multiply(16.0D);
		look.add(vec.copy());
		
		//if (world.isRemote)
		//PlayerNotifications.addNotification(StatCollector.translateToLocal("notification.soul_gain") + " " + 20.0F);
		
		if (world.isRemote) {
			//this.beam(world, vec.x, vec.y, vec.z, look.x, look.y, look.z, 2, 65382, false, 1.0F, 100);
			//this.beam(world, vec.x, vec.y, vec.z, look.x, look.y, look.z, 2, 65382, true, 1.0F, 100);
		}
		if (!world.isRemote) {
			//Main.packetInstance.sendToAllAround(new BurstMessage(vec.x, vec.y, vec.z, 1.0F), new TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 128.0D));
			Main.castingCooldowns.put(player, 20);
			//player.attackEntityFrom(new DamageRegistryHandler.DamageSourceMagic(player), 100.0F);
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
