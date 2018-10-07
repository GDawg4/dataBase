
import com.github.kittinunf.fuel.Fuel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.like
import kotlin.concurrent.thread
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    val list: ArrayList<Song> = ArrayList()

    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"

    println("lol")

    val (request, response, result) = Fuel.get(url).responseObject(Song.SongArrayDeserializer())
    val (songs, err) = result

    Database.connect(
            "jdbc:postgresql:test",
            "org.postgresql.Driver",
            "postgres",
            "2x4x6x8x10"
    )
    transaction {
        SchemaUtils.create(TableSong)

        if (songs != null) {
            for (song in songs) {
                TableSong.insert {
                    it[songName] = song.song
                    it[year] = song.year
                    it[country] = song.country
                    it[region] = song.region
                    it[artistName] = song.artistName
                    it[artistGender] = song.artistGender
                    it[groupOrSolo] = song.groupOrSolo
                    it[place] = song.place
                    it[points] = song.points
                    it[isFinal] = song.isFinal
                    it[isSongInEnglish] = song.isSongInEnglish
                    it[songQuality] = song.songQuality
                    it[normalizedPoints] = song.normalizedPoints
                    it[energy] = song.energy
                    it[duration] = song.duration
                    it[acousticness] = song.acousticness
                    it[danceability] = song.danceability
                    it[tempo] = song.tempo
                    it[speechiness] = song.speechiness
                    it[key] = song.key
                    it[liveness] = song.liveness
                    it[timeSignature] = song.timeSignature
                    it[mode] = song.mode
                    it[loudness] = song.loudness
                    it[valence] = song.valence
                    it[happiness] = song.happiness
                    it[favourite] = song.isFavorite
                }
            }
        }
        val wantsToContinue = true

        while (wantsToContinue){
            println("""
                1. Buscar canciones por nombre
                2. Buscar canciones por artista
                3. Mostrar todas mis canciones favoritas
                4. Salir
            """.trimIndent())
            val ingreso = readLine()!!
            when (ingreso) {
                "1" -> {
                    var contador = 1
                    println("Ingrese su búsqueda")
                    val name = readLine()!!
                    (TableSong).slice(TableSong.songName).select { TableSong.songName.like("%${name}%") }.forEach {
                        println("$contador ${it[TableSong.songName]}")
                        contador++
                        TableSong.update ({TableSong.songName.like("%${name}%")}){
                            it[favourite] = true
                        }
                    }
                }
                "2" -> {
                    var contador = 1
                    println("Ingrese su búsqueda")
                    val artistName = readLine()!!
                    (TableSong).slice(TableSong.artistName).select { TableSong.artistName.like("%${artistName}%") }.forEach {
                        println("$contador ${it[TableSong.artistName]}")
                        contador++
                    }
                }
            }
        }
    }
}