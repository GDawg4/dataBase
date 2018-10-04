

data class Song(
        val song: String,
        val year: Int,
        val country: String,
        val region: String,
        val artistName: String,
        val artistGender: String,
        val groupOrSolo: String,
        val place: Int,
        val points: Int,
        val isFinal: Int,
        val isSongInEnglish: Int,
        val songQuality: String,
        val normalizedPoints: String,
        val energy: String,
        val duration: String,
        val acousticness: String,
        val danceability: String,
        val tempo: String,
        val speechiness: String,
        val key: Int,
        val liveness: String,
        val timeSignature: Int,
        val mode: Int,
        val loudness: String,
        val valence: String,
        val happiness: String

) {
}