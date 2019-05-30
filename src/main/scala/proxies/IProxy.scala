package proxies

import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

trait IProxy {

  def preInit(event: FMLPreInitializationEvent): Unit

  def init(event: FMLInitializationEvent): Unit

  def postInit(event: FMLPostInitializationEvent): Unit
}
