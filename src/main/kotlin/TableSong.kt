

import org.jetbrains.exposed.sql.Table

object TableSong: Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val songName = varchar("song", length = 50)
    val year= varchar("year", length = 50)
    val country= varchar("country", length = 50)
    val region= varchar("region", length = 50)
    val artistName= varchar("artistName", length = 50)
    val artistGender= varchar("artistGender", length = 50)
    val groupOrSolo= varchar("groupOrSolo", length = 50)
    val place= varchar("place", length = 50)
    val points= varchar("points", length = 50)
    val isFinal= varchar("isFinal", length = 50)
    val isSongInEnglish= varchar("isSongInEnglish", length = 50)
    val songQuality= varchar("songQuality", length = 50)
    val normalizedPoints= varchar("normalizedPoints", length = 50)
    val energy= varchar("energy", length = 50)
    val duration= varchar("duration", length = 50)
    val acousticness= varchar("acousticness", length = 50)
    val danceability= varchar("danceability", length = 50)
    val tempo= varchar("tempo", length = 50)
    val speechiness= varchar("speechiness", length = 50)
    val key= varchar("key", length = 50)
    val liveness= varchar("liveness", length = 50)
    val timeSignature= varchar("timeSignature", length = 50)
    val mode= varchar("mode", length = 50)
    val loudness= varchar("loudness", length = 50)
    val valence= varchar("valence", length = 50)
    val happiness= varchar("happiness", length = 50)
    val favourite= bool("favourite")
}