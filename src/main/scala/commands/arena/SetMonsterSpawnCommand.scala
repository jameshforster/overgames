package commands.arena

import games.{ArenaGame, GameManager}
import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.TextComponentString

case class SetMonsterSpawnCommand() extends CommandBase {
  override def getName: String = "arenaMonsterSpawn"

  override def getUsage(sender: ICommandSender): String = ""

  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]): Unit = {
    sender match {
      case player: EntityPlayer =>
        GameManager.allGames.find(_.dimensionId == player.dimension).fold(sender.sendMessage(new TextComponentString("No active game in current world"))){
          case arena: ArenaGame =>
            sender.sendMessage(new TextComponentString("Setting monster spawn to current coordinates"))
            arena.monsterSpawnPos = player.getPosition
          case _ =>
            sender.sendMessage(new TextComponentString("Invalid game type for setting monster spawn"))
        }
      case _ =>
        sender.sendMessage(new TextComponentString("Command sender is not a player"))
    }
  }
}
