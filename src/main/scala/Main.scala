package main.scala

object Main extends App {
    val PAIRS_OF_VALUES = 1 to 2
    val NUMBER_OF_CARD_VALUES = 1 to 26
    val SPACES = 1 to 26
    val GAMES_PLAYED = 1000

    private def formSpacesHeader(spaces: Range): String = {
        spaces.map((i: Int) => {
            s"\t$i"
        }).reduce(_ + _)
    }

    private def calculateWinPercentage(spaces: Int, numberOfCardValues: Int, pairsOfValues: Int, gamesPlayed: Int): Long = {
        if (spaces <= numberOfCardValues) {
            Math.round(100.0 * (1 to gamesPlayed).count((i: Int) =>
                PairsSolitare.play(Deck.shuffle(pairsOfValues, numberOfCardValues), spaces)
            ) / gamesPlayed)
        } else {
            100
        }
    }

    private def formSpacesRow(spaces: Range, numberOfCardValues: Int, pairsOfValues: Int, gamesPlayed: Int): String = {
        val spacesRow: String = spaces.map((i: Int) => {
            val winPercentage = calculateWinPercentage(i, numberOfCardValues, pairsOfValues, gamesPlayed)
            s"\t$winPercentage"
        }).reduce(_ + _)
        s"$numberOfCardValues$spacesRow\n"
    }

    private def formValueTable(spaces: Range, numberOfCardValues: Range, pairsOfValues: Int, gamesPlayed: Int): String = {
        numberOfCardValues.map((numberOfCardValues: Int) => {
            formSpacesRow(spaces, numberOfCardValues, pairsOfValues, gamesPlayed)
        }).reduce(_ + _)
    }

    val results: String = PAIRS_OF_VALUES.map((pairsOfValues: Int) => {
        val spacesHeader: String = formSpacesHeader(SPACES)
        val valueTable: String = formValueTable(SPACES, NUMBER_OF_CARD_VALUES, pairsOfValues, GAMES_PLAYED)
        Seq(
            s"\nPairs of Values: $pairsOfValues",
            s"\nC\\S$spacesHeader",
            s"\n$valueTable"
        ).reduce(_ + _)
    }).reduce(_ + _)

    print(results)
}
