package games

object GameManager {

  var allGames: Seq[Game] = Seq()

  def createGame(game: Game): Unit = allGames = allGames ++ Seq(game)

  def shutdownGame(dimensionId: Int): Unit = allGames = allGames.filterNot(_.dimensionId == dimensionId)
}
