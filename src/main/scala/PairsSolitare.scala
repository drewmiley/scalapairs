package main.scala

object PairsSolitare {

    case class State(activeCards: Set[Int] = Set(), spacesUsed: Int = 0)

    def spacesRequiredForPairs(shuffledDeck: Seq[Int]): Int = {
        shuffledDeck.foldLeft(State()) { (acc, i) =>
            val activeCards = if (acc.activeCards(i)) acc.activeCards - i else acc.activeCards + i
            val spacesUsed = math.max(acc.spacesUsed, activeCards.size)
            State(activeCards, spacesUsed)
        }.spacesUsed
    }

    def play(shuffledDeck: Seq[Int], spaces: Int): Boolean = spacesRequiredForPairs(shuffledDeck) < spaces
}
