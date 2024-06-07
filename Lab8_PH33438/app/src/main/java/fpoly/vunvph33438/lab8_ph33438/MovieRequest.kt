package fpoly.vunvph33438.lab8_ph33438

data class MovieRequest(
    val filmId: Int? = null,
    val filmName: String,
    val duration: Int,
    val releaseDate: String,
    val genre: String,
    val national: String,
    val description: String,
    val image: String
)
data class StatusResponse(
    val status: Int,
    val message: String
)
