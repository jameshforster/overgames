package games

import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer

trait Game {
  val dimensionId: Int
  var inProgress: Boolean = false
  var players: Seq[EntityPlayer] = Seq()
  var spectators: Seq[EntityPlayer] = Seq()

  def startGame(server: MinecraftServer, sender: ICommandSender): Unit
  def endGame(): Unit
  def playerJoin(player: EntityPlayer): Unit
  def playerQuit(player: EntityPlayer): Unit
}
