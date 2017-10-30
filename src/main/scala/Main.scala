package main.scala

object Main extends App {
    val CARDS_IN_PACK = 52
    val SPACES = 13
    val GAMES_PLAYED = 1000

    def shuffle(n: Int): Seq[Int] = {
        val numberSet = 1 to CARDS_IN_PACK toSet
        val shuffledDeck = numberSet.toSeq
        shuffledDeck
    }

    def playPairsSolitare(shuffledDeck: Seq[Int], spaces: Int): Boolean = {
        false
    }

    def solitareWinPercentage(cardsInPacks: Int, spaces: Int, gamesPlayed: Int): Double = {
        val gameOutcomes = (1 to gamesPlayed).toSeq.map((i: Int) => playPairsSolitare(shuffle(cardsInPacks), spaces))
        val gamesWon = gameOutcomes.filter((b: Boolean) => b).size
        100.0 * gamesWon / gamesPlayed
    }

    println("Cards in Packs")
    println(CARDS_IN_PACK)
    println("Spaces")
    println(SPACES)
    println("Win Percentage")
    println(solitareWinPercentage(CARDS_IN_PACK, SPACES, GAMES_PLAYED))
}
