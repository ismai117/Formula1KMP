package f1AdditionalData


val countryName = mapOf(
    "usa" to "United States of America",
    "tha" to "Thailand",
    "ned" to "Netherlands",
    "mon" to "Monaco",
    "mex" to "Mexico",
    "jpn" to "Japan",
    "ger" to "Germany",
    "gbr" to "United Kingdom",
    "fra" to "France",
    "fin" to "Finland",
    "esp" to "Spain",
    "den" to "Denmark",
    "chn" to "China",
    "can" to "Canada",
    "aus" to "Australia"
)

fun getTeamName(name: String): String {
    return when(name.lowercase()){
        "alfa romeo" -> {
            "Kick Sauber"
        }
        "alphatauri" -> {
            "RB"
        }
        else -> {
            name
        }
    }
}
