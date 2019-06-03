package commands

import games.GameManager
import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.{ITextComponent, TextComponentString}

case class GameStartCommand() extends CommandBase {
  override def getName: String = "gameStart"

  override def getUsage(sender: ICommandSender): String = ""

  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]): Unit = {
    args.headOption match {
      case Some(dimensionId) if dimensionId.forall(_.isDigit) => {
        val trueId = dimensionId.toInt
        GameManager.allGames.find(_.dimensionId == trueId) match {
          case Some(game) => game.startGame(server, sender)
          case _ => sender.sendMessage(new TextComponentString(s"Game with dimension ID $trueId does not exist"))
        }
      }
      case Some(errorId) => sender.sendMessage(new TextComponentString(s"Invalid dimension ID parameter: $errorId"))
      case _ => sender.sendMessage(new TextComponentString("Missing dimension ID parameter"))
    }
  }
}
