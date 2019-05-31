package games

import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.WorldServer

case class ArenaGame(dimensionId: Int) extends Game {

  var currentWave: Int = 0
  var monsterSpawnPos: BlockPos = new BlockPos(0, 0 ,0)

  def startGame(server: MinecraftServer, sender: ICommandSender): Unit = {
    inProgress = true
    Option(server.getWorld(dimensionId)) match {
      case Some(dimension) => triggerNextWave(dimension)
      case _ => sender.sendMessage(new TextComponentString(s"Dimension of id $dimensionId does not exist"))
    }
  }

  def endGame(): Unit = {
    inProgress = false
    currentWave = 0
    //TODO evict players from dimension
    players = Seq()
    spectators = Seq()
  }

  def triggerNextWave(dimension: WorldServer): Unit = {
    currentWave = currentWave + 1
    (players ++ spectators).foreach(_.sendMessage(new TextComponentString(s"STARTING WAVE $currentWave")))
    val spawnChunk = dimension.getChunkFromBlockCoords(monsterSpawnPos)
    //TODO spawn wave mechanics
  }

  def playerJoin(player: EntityPlayer): Unit = {
    //TODO handle rejoins from disconnects
    if (inProgress) spectators = spectators ++ Seq(player)
    else players = players ++ Seq(player)
  }

  def playerQuit(player: EntityPlayer): Unit = {
    players = players.filterNot(_.getName == player.getName)
    spectators = spectators.filterNot(_.getName == player.getName)
  }
}
