package main.scala

class PairsSolitare(shuffledDeck: Seq[Int], spaces: Int) {

    def spacesRequiredForPairs(shuffledDeck: Seq[Int]): Int = {
        var activeCards = Set[Int]()
        var spacesUsed = 0
        shuffledDeck.foreach((i: Int) => {
            activeCards = if (activeCards(i)) activeCards - i else activeCards + i
            spacesUsed = math.max(spacesUsed, activeCards.size)
        })
        spacesUsed
    }

    def play(): Boolean = {
        spacesRequiredForPairs(shuffledDeck) < spaces
    }
}
