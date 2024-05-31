package fpoly.vunvph33438.lab6_ph33438

data class Movie(
    val title: String,
    val year: String,
    val posterUrl: String,
    val duration: String,
    val releaseDate: String,
    val genre: String,
    val shortDescription: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie(
                "The Shawshank Redemption", "1994",
                "https://m.media-amazon.com/images/I/71JxA6I+sgL._AC_SL1000_.jpg",
                "142 min", "September 22, 1994", "Drama",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."
            ),
            Movie(
                "The Godfather", "1972",
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
                "175 min", "March 24, 1972", "Crime, Drama",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."
            ),
            Movie(
                "The Dark Knight", "2008",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3ekE6Hhz9gvIbiFSUPxt-FyAh4zXTXX0bjQ&s",
                "152 min", "July 18, 2008", "Action, Crime, Drama",
                "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham."
            ),
            Movie(
                "12 Angry Men", "1957",
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/12_Angry_Men_%281957_film_poster%29.jpg",
                "96 min", "April 10, 1957", "Drama",
                "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence."
            ),
            Movie(
                "Schindler's List", "1993",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ3aeH4quODDvLaY8PhMPgZWIfuxCgjrIaRg&s",
                "195 min", "December 15, 1993", "Biography, Drama, History",
                "In German-occupied Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis."
            ),
            Movie(
                "The Lord of the Rings: The Return of the King", "2003",
                "https://cdn.europosters.eu/image/1300/posters/the-lord-of-the-rings-the-return-of-the-king-i104633.jpg",
                "201 min", "December 17, 2003", "Action, Adventure, Drama",
                "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."
            )
        )
    }
}