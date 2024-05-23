package f1AdditionalData

import formula1kmp.composeapp.generated.resources.Res
import formula1kmp.composeapp.generated.resources._1
import formula1kmp.composeapp.generated.resources._10
import formula1kmp.composeapp.generated.resources._10logo
import formula1kmp.composeapp.generated.resources._10profile
import formula1kmp.composeapp.generated.resources._11
import formula1kmp.composeapp.generated.resources._11logo
import formula1kmp.composeapp.generated.resources._11profile
import formula1kmp.composeapp.generated.resources._14
import formula1kmp.composeapp.generated.resources._14logo
import formula1kmp.composeapp.generated.resources._14profile
import formula1kmp.composeapp.generated.resources._16
import formula1kmp.composeapp.generated.resources._16logo
import formula1kmp.composeapp.generated.resources._16profile
import formula1kmp.composeapp.generated.resources._18
import formula1kmp.composeapp.generated.resources._18logo
import formula1kmp.composeapp.generated.resources._18profile
import formula1kmp.composeapp.generated.resources._1logo
import formula1kmp.composeapp.generated.resources._1profile
import formula1kmp.composeapp.generated.resources._2
import formula1kmp.composeapp.generated.resources._20
import formula1kmp.composeapp.generated.resources._20logo
import formula1kmp.composeapp.generated.resources._20profile
import formula1kmp.composeapp.generated.resources._22
import formula1kmp.composeapp.generated.resources._22logo
import formula1kmp.composeapp.generated.resources._22profile
import formula1kmp.composeapp.generated.resources._23
import formula1kmp.composeapp.generated.resources._23logo
import formula1kmp.composeapp.generated.resources._23profile
import formula1kmp.composeapp.generated.resources._24
import formula1kmp.composeapp.generated.resources._24logo
import formula1kmp.composeapp.generated.resources._24profile
import formula1kmp.composeapp.generated.resources._27
import formula1kmp.composeapp.generated.resources._27logo
import formula1kmp.composeapp.generated.resources._27profile
import formula1kmp.composeapp.generated.resources._2logo
import formula1kmp.composeapp.generated.resources._2profile
import formula1kmp.composeapp.generated.resources._3
import formula1kmp.composeapp.generated.resources._31
import formula1kmp.composeapp.generated.resources._31logo
import formula1kmp.composeapp.generated.resources._31profile
import formula1kmp.composeapp.generated.resources._38
import formula1kmp.composeapp.generated.resources._38logo
import formula1kmp.composeapp.generated.resources._3logo
import formula1kmp.composeapp.generated.resources._3profile
import formula1kmp.composeapp.generated.resources._4
import formula1kmp.composeapp.generated.resources._44
import formula1kmp.composeapp.generated.resources._44logo
import formula1kmp.composeapp.generated.resources._44profile
import formula1kmp.composeapp.generated.resources._4logo
import formula1kmp.composeapp.generated.resources._4profile
import formula1kmp.composeapp.generated.resources._55
import formula1kmp.composeapp.generated.resources._55logo
import formula1kmp.composeapp.generated.resources._55profile
import formula1kmp.composeapp.generated.resources._63
import formula1kmp.composeapp.generated.resources._63logo
import formula1kmp.composeapp.generated.resources._63profile
import formula1kmp.composeapp.generated.resources._77
import formula1kmp.composeapp.generated.resources._77logo
import formula1kmp.composeapp.generated.resources._77profile
import formula1kmp.composeapp.generated.resources._81
import formula1kmp.composeapp.generated.resources._81logo
import formula1kmp.composeapp.generated.resources._81profile
import formula1kmp.composeapp.generated.resources.alpine
import formula1kmp.composeapp.generated.resources.alpine_logo
import formula1kmp.composeapp.generated.resources.aston_martin
import formula1kmp.composeapp.generated.resources.aston_martin_logo
import formula1kmp.composeapp.generated.resources.aus
import formula1kmp.composeapp.generated.resources.can
import formula1kmp.composeapp.generated.resources.chn
import formula1kmp.composeapp.generated.resources.den
import formula1kmp.composeapp.generated.resources.esp
import formula1kmp.composeapp.generated.resources.ferrari
import formula1kmp.composeapp.generated.resources.ferrari_logo
import formula1kmp.composeapp.generated.resources.fin
import formula1kmp.composeapp.generated.resources.fra
import formula1kmp.composeapp.generated.resources.gbr
import formula1kmp.composeapp.generated.resources.ger
import formula1kmp.composeapp.generated.resources.haas
import formula1kmp.composeapp.generated.resources.haas_logo
import formula1kmp.composeapp.generated.resources.jpn
import formula1kmp.composeapp.generated.resources.kick_sauber
import formula1kmp.composeapp.generated.resources.kick_sauber_logo
import formula1kmp.composeapp.generated.resources.mclaren
import formula1kmp.composeapp.generated.resources.mclaren_logo
import formula1kmp.composeapp.generated.resources.mercedes
import formula1kmp.composeapp.generated.resources.mercedes_logo
import formula1kmp.composeapp.generated.resources.mex
import formula1kmp.composeapp.generated.resources.mon
import formula1kmp.composeapp.generated.resources.ned
import formula1kmp.composeapp.generated.resources.rb
import formula1kmp.composeapp.generated.resources.rb_logo
import formula1kmp.composeapp.generated.resources.red_bull_racing
import formula1kmp.composeapp.generated.resources.red_bull_racing_logo
import formula1kmp.composeapp.generated.resources.tha
import formula1kmp.composeapp.generated.resources.usa
import formula1kmp.composeapp.generated.resources.williams
import formula1kmp.composeapp.generated.resources.williams_logo
import org.jetbrains.compose.resources.DrawableResource

fun getFlag(code: String?): DrawableResource? {

    if (code == null) return null

    val images = mapOf(
        "usa" to Res.drawable.usa,
        "tha" to Res.drawable.tha,
        "ned" to Res.drawable.ned,
        "mon" to Res.drawable.mon,
        "mex" to Res.drawable.mex,
        "jpn" to Res.drawable.jpn,
        "ger" to Res.drawable.ger,
        "gbr" to Res.drawable.gbr,
        "fra" to Res.drawable.fra,
        "fin" to Res.drawable.fin,
        "esp" to Res.drawable.esp,
        "den" to Res.drawable.den,
        "chn" to Res.drawable.chn,
        "can" to Res.drawable.can,
        "aus" to Res.drawable.aus
    )

    return images[code]

}

fun getDriverNumberLogo(driverNumber: Int?): DrawableResource? {

    if (driverNumber == null) return null

    val images = mapOf(
        81 to Res.drawable._81logo,
        63 to Res.drawable._63logo,
        77 to Res.drawable._77logo,
        55 to Res.drawable._55logo,
        44 to Res.drawable._44logo,
        38 to Res.drawable._38logo,
        31 to Res.drawable._31logo,
        27 to Res.drawable._27logo,
        24 to Res.drawable._24logo,
        23 to Res.drawable._23logo,
        22 to Res.drawable._22logo,
        20 to Res.drawable._20logo,
        16 to Res.drawable._16logo,
        14 to Res.drawable._14logo,
        18 to Res.drawable._18logo,
        11 to Res.drawable._11logo,
        10 to Res.drawable._10logo,
        4 to Res.drawable._4logo,
        3 to Res.drawable._3logo,
        2 to Res.drawable._2logo,
        1 to Res.drawable._1logo
    )

    return images[driverNumber]

}

fun getHeadshot(driverNumber: Int?): DrawableResource? {

    if (driverNumber == null) return null

    val images = mapOf(
        81 to Res.drawable._81,
        63 to Res.drawable._63,
        77 to Res.drawable._77,
        55 to Res.drawable._55,
        44 to Res.drawable._44,
        38 to Res.drawable._38,
        31 to Res.drawable._31,
        27 to Res.drawable._27,
        24 to Res.drawable._24,
        23 to Res.drawable._23,
        22 to Res.drawable._22,
        20 to Res.drawable._20,
        16 to Res.drawable._16,
        14 to Res.drawable._14,
        18 to Res.drawable._18,
        11 to Res.drawable._11,
        10 to Res.drawable._10,
        4 to Res.drawable._4,
        3 to Res.drawable._3,
        2 to Res.drawable._2,
        1 to Res.drawable._1
    )

    return images[driverNumber]

}

fun getProfile(driverNumber: Int?): DrawableResource? {

    if (driverNumber == null) return null

    val images = mapOf(
        81 to Res.drawable._81profile,
        63 to Res.drawable._63profile,
        77 to Res.drawable._77profile,
        55 to Res.drawable._55profile,
        44 to Res.drawable._44profile,
        31 to Res.drawable._31profile,
        27 to Res.drawable._27profile,
        24 to Res.drawable._24profile,
        23 to Res.drawable._23profile,
        22 to Res.drawable._22profile,
        20 to Res.drawable._20profile,
        16 to Res.drawable._16profile,
        14 to Res.drawable._14profile,
        18 to Res.drawable._18profile,
        11 to Res.drawable._11profile,
        10 to Res.drawable._10profile,
        4 to Res.drawable._4profile,
        3 to Res.drawable._3profile,
        2 to Res.drawable._2profile,
        1 to Res.drawable._1profile
    )

    return images[driverNumber]

}

fun getTeamCar(teamName: String?): DrawableResource? {

    if (teamName == null) return null

    val images = mapOf(
        "Red Bull Racing" to Res.drawable.red_bull_racing,
        "Williams" to Res.drawable.williams,
        "McLaren" to Res.drawable.mclaren,
        "Alpine" to Res.drawable.alpine,
        "Aston Martin" to Res.drawable.aston_martin,
        "Ferrari" to Res.drawable.ferrari,
        "Haas F1 Team" to Res.drawable.haas,
        "AlphaTauri" to Res.drawable.rb,
        "Alfa Romeo" to Res.drawable.kick_sauber,
        "Mercedes" to Res.drawable.mercedes,
    )
    return images[teamName]

}

fun getTeamLogo(teamName: String?): DrawableResource? {

    if (teamName == null) return null

    val images = mapOf(
        "Red Bull Racing" to Res.drawable.red_bull_racing_logo,
        "Williams" to Res.drawable.williams_logo,
        "McLaren" to Res.drawable.mclaren_logo,
        "Alpine" to Res.drawable.alpine_logo,
        "Aston Martin" to Res.drawable.aston_martin_logo,
        "Ferrari" to Res.drawable.ferrari_logo,
        "Haas F1 Team" to Res.drawable.haas_logo,
        "AlphaTauri" to Res.drawable.rb_logo,
        "Alfa Romeo" to Res.drawable.kick_sauber_logo,
        "Mercedes" to Res.drawable.mercedes_logo
    )
    return images[teamName]

}