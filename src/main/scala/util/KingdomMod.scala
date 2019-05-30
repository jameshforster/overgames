package util

import blocks.Blocks
import net.minecraft.block.Block
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(modid = KingdomMod.modId, name = KingdomMod.name, version = KingdomMod.version, modLanguage = "scala")
object KingdomMod {

  val modId = "tol_og"
  val name = "Overgames"
  val version = "0.0.1"

  @EventHandler def preInit(event: FMLPreInitializationEvent): Unit = {

  }

  @EventHandler def init(event: FMLInitializationEvent): Unit = {
    // some example code
  }

  @SubscribeEvent def registerBlocks(event: RegistryEvent.Register[Block]): Unit = {
    event.getRegistry.registerAll(Blocks.allModBlocks:_*)
  }
}
