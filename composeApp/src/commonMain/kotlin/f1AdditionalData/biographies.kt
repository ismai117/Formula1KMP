package f1AdditionalData

import formula1kmp.composeapp.generated.resources.Res
import formula1kmp.composeapp.generated.resources._1
import formula1kmp.composeapp.generated.resources._10
import formula1kmp.composeapp.generated.resources._11
import formula1kmp.composeapp.generated.resources._14
import formula1kmp.composeapp.generated.resources._16
import formula1kmp.composeapp.generated.resources._18
import formula1kmp.composeapp.generated.resources._2
import formula1kmp.composeapp.generated.resources._20
import formula1kmp.composeapp.generated.resources._22
import formula1kmp.composeapp.generated.resources._23
import formula1kmp.composeapp.generated.resources._24
import formula1kmp.composeapp.generated.resources._27
import formula1kmp.composeapp.generated.resources._3
import formula1kmp.composeapp.generated.resources._31
import formula1kmp.composeapp.generated.resources._38
import formula1kmp.composeapp.generated.resources._4
import formula1kmp.composeapp.generated.resources._44
import formula1kmp.composeapp.generated.resources._55
import formula1kmp.composeapp.generated.resources._63
import formula1kmp.composeapp.generated.resources._77
import formula1kmp.composeapp.generated.resources._81
import org.jetbrains.compose.resources.StringResource


fun getBiography(driverNumber: Int?): StringResource? {

    if (driverNumber == null) return null

    val biographies = mapOf(
        81 to Res.string._81,
        63 to Res.string._63,
        77 to Res.string._77,
        55 to Res.string._55,
        44 to Res.string._44,
        38 to Res.string._38,
        31 to Res.string._31,
        27 to Res.string._27,
        24 to Res.string._24,
        23 to Res.string._23,
        22 to Res.string._22,
        20 to Res.string._20,
        16 to Res.string._16,
        14 to Res.string._14,
        18 to Res.string._18,
        11 to Res.string._11,
        10 to Res.string._10,
        4 to Res.string._4,
        3 to Res.string._3,
        2 to Res.string._2,
        1 to Res.string._1
    )

    return biographies[driverNumber]

}

/**
 *
 * 1
 * 16
 *
 *
 */