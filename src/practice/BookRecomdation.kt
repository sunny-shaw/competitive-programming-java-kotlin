package practice

import java.util.*

fun main() {
    val userBooksListenedTo = mapOf(
        "Fred" to listOf("mass", "world", "stress"),
        "Jenie" to listOf("happy", "pride"),
        "Rone" to listOf("alexander")
    )

    val bookGenres = mapOf(
        "Horror" to listOf("mass", "stress"),
        "Comedy" to listOf("happy"),
        "Romance" to listOf("world", "pride", "alexander")
    )

    println(bookRecommendation(userBooksListenedTo, bookGenres))
}

fun bookRecommendation(
    userBooksListenedTo: Map<String, List<String>>,
    bookGenres: Map<String, List<String>>
): MutableMap<String, MutableList<String>> {
    val bookRecommendation = mutableMapOf<String, MutableList<String>>()

    userBooksListenedTo.forEach { userToBooksMap ->
        val countOfListenedBookGenre = mutableMapOf<String, Int>()
        val books = userToBooksMap.value

        books.forEach { book ->
            bookGenres.forEach { bookGenre ->
                if (bookGenre.value.contains(book)) {
                    if (countOfListenedBookGenre.containsKey(bookGenre.key))
                        countOfListenedBookGenre[bookGenre.key] = countOfListenedBookGenre[bookGenre.key]!!.plus(1)
                    else
                        countOfListenedBookGenre[bookGenre.key] = 1
                }
            }
        }

        val bookGenreListenedMax = Collections.max(countOfListenedBookGenre.values)

        countOfListenedBookGenre.forEach { bookGenreToListenedCountMap ->
            if (bookGenreToListenedCountMap.value == bookGenreListenedMax) {
                if (bookRecommendation.containsKey(userToBooksMap.key))
                    bookRecommendation[userToBooksMap.key]!!.add(bookGenreToListenedCountMap.key)
                else
                    bookRecommendation[userToBooksMap.key] = mutableListOf(bookGenreToListenedCountMap.key)
            }
        }
    }

    return bookRecommendation
}
