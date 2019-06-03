package commands

import games.{ArenaGame, GameManager}
import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.server.MinecraftServer
import net.minecraft.util.text.TextComponentString

case class CreateGameCommand() extends CommandBase {
  override def getName: String = "createGame"

  override def getUsage(sender: ICommandSender): String = ""

  override def execute(server: MinecraftServer, sender: ICommandSender, args: Array[String]): Unit = {
    args.toList match {
      case head :: Nil if sender.isInstanceOf[EntityPlayer] => conditionalCreateGame(sender.asInstanceOf[EntityPlayer].dimension, head, sender)
      case head :: additional :: Nil  if additional.forall(_.isDigit) => ???
      case head :: additional :: Nil  if head.forall(_.isDigit) => ???
      case _ => sender.sendMessage(new TextComponentString("Invalid arguments"))
    }
  }

  def uniqueDimensionCheck(dimensionId: Int): Boolean = !GameManager.allGames.exists(_.dimensionId == dimensionId)

  def gameTypeMatcher(gameType: String, dimensionId: Int): Option[ArenaGame] = {
    gameType match {
      case "Arena" | "arena" => Some(ArenaGame(dimensionId))
      case _ => None
    }
  }

  def conditionalCreateGame(dimensionId: Int, gameType: String, sender: ICommandSender): Unit = {
    if (uniqueDimensionCheck(dimensionId)) {
      gameTypeMatcher(gameType, dimensionId) match {
        case Some(game) => GameManager.createGame(game)
        case _ => sender.sendMessage(new TextComponentString(s"Game type $gameType does not exist"))
      }
    } else sender.sendMessage(new TextComponentString(s"Dimension id $dimensionId already has an existing game!"))
  }
}
