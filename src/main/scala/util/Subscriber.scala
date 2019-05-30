package util

import blocks.Blocks
import items.Items
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent.Register
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@EventBusSubscriber(modid = OverGamesMod.modId)
object Subscriber {

  @SubscribeEvent
  def registerBlocks(event: Register[Block]): Unit = {
    event.getRegistry.registerAll(Blocks.allModBlocks: _*)
  }

  @SubscribeEvent
  def registerItems(event: Register[Item]): Unit = {
    event.getRegistry.registerAll(Items.allModItems: _*)
    event.getRegistry.registerAll(Blocks.allModItemBlocks: _*)
  }
}
