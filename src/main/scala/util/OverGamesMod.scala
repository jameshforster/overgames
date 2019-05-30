package util

import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import org.apache.logging.log4j.{LogManager, Logger}
import proxies._

@Mod(modid = OverGamesMod.modId, name = OverGamesMod.name, version = OverGamesMod.version, modLanguage = "scala")
object OverGamesMod {

  final val modId = "tol_og"
  final val name = "Overgames"
  final val version = "0.0.1"

  val logger: Logger = LogManager.getLogger(modId)

  final val clientProxy = "proxies.ClientProxy"
  final val serverProxy = "proxies.ServerProxy"

  @SidedProxy(clientSide = clientProxy, serverSide = serverProxy)
  var proxy: IProxy = _

  @EventHandler def preInit(event: FMLPreInitializationEvent): Unit = {

  }

  @EventHandler def init(event: FMLInitializationEvent): Unit = {
    logger.info("Welcome, to the OVERGAMES!")
  }
}
