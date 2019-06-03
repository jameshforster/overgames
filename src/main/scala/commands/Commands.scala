package commands

import commands.arena.SetMonsterSpawnCommand
import net.minecraft.command.CommandBase

object Commands {

  val allCommands: Seq[CommandBase] = Seq(CreateGameCommand(), SetMonsterSpawnCommand(), GameStartCommand())
}
