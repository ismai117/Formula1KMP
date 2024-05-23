package f1AdditionalData


data class TeamInformation(
    val name: String,
    val base: String,
    val teamChief: String,
    val technicalChief: String,
    val chassis: String,
    val powerUnit: String,
    val firstTeamEntry: Int,
    val worldChampionships: Int,
    val highestRaceFinish: String,
    val polePositions: Int,
    val fastestLaps: Int
)

fun teamInformation(name: String): TeamInformation? {
    return teams[name.lowercase()]
}

private val teams = mapOf(
    "red bull racing" to TeamInformation(
        name = "Oracle Red Bull Racing",
        base = "Milton Keynes, United Kingdom",
        teamChief = "Christian Horner",
        technicalChief = "Pierre Waché",
        chassis = "RB20",
        powerUnit = "Honda RBPT",
        firstTeamEntry = 1997,
        worldChampionships = 6,
        highestRaceFinish = "1 (x118)",
        polePositions = 103,
        fastestLaps = 97
    ),
    "ferrari" to TeamInformation(
        name = "Scuderia Ferrari HP",
        base = "Maranello, Italy",
        teamChief = "Frédéric Vasseur",
        technicalChief = "Enrico Cardile / Enrico Gualtieri",
        chassis = "SF-24",
        powerUnit = "Ferrari",
        firstTeamEntry = 1950,
        worldChampionships = 16,
        highestRaceFinish = "1 (x245)",
        polePositions = 249,
        fastestLaps = 261
    ),
    "mclaren" to TeamInformation(
        name = "McLaren Formula 1 Team",
        base = "Woking, United Kingdom",
        teamChief = "Andrea Stella",
        technicalChief = "Peter Prodromou / Neil Houldey",
        chassis = "MCL38",
        powerUnit = "Mercedes",
        firstTeamEntry = 1966,
        worldChampionships = 8,
        highestRaceFinish = "1 (x184)",
        polePositions = 157,
        fastestLaps = 166
    ),
    "mercedes" to TeamInformation(
        name = "Mercedes-AMG PETRONAS F1 Team",
        base = "Brackley, United Kingdom",
        teamChief = "Toto Wolff",
        technicalChief = "James Allison",
        chassis = "W15",
        powerUnit = "Mercedes",
        firstTeamEntry = 1970,
        worldChampionships = 8,
        highestRaceFinish = "1 (x116)",
        polePositions = 129,
        fastestLaps = 97
    ),
    "aston martin" to TeamInformation(
        name = "Aston Martin Aramco F1 Team",
        base = "Silverstone, United Kingdom",
        teamChief = "Mike Krack",
        technicalChief = "Dan Fallows",
        chassis = "AMR24",
        powerUnit = "Mercedes",
        firstTeamEntry = 2018,
        worldChampionships = 0,
        highestRaceFinish = "1 (x1)",
        polePositions = 1,
        fastestLaps = 2
    ),
    "rb" to TeamInformation(
        name = "Visa Cash App RB Formula One Team",
        base = "Faenza, Italy",
        teamChief = "Laurent Mekies",
        technicalChief = "Jody Egginton",
        chassis = "VCARB 01",
        powerUnit = "Honda RBPT",
        firstTeamEntry = 1985,
        worldChampionships = 0,
        highestRaceFinish = "1 (x2)",
        polePositions = 1,
        fastestLaps = 3
    ),
    "haas f1 team" to TeamInformation(
        name = "MoneyGram Haas F1 Team",
        base = "Kannapolis, United States",
        teamChief = "Ayao Komatsu",
        technicalChief = "Andrea De Zordo",
        chassis = "VF-24",
        powerUnit = "Ferrari",
        firstTeamEntry = 2016,
        worldChampionships = 0,
        highestRaceFinish = "4 (x1)",
        polePositions = 1,
        fastestLaps = 2
    ),
    "alpine" to TeamInformation(
        name = "BWT Alpine F1 Team",
        base = "Enstone, United Kingdom",
        teamChief = "Bruno Famin",
        technicalChief = "David Sanchez",
        chassis = "A524",
        powerUnit = "Renault",
        firstTeamEntry = 1986,
        worldChampionships = 2,
        highestRaceFinish = "1 (x21)",
        polePositions = 20,
        fastestLaps = 15
    ),
    "williams" to TeamInformation(
        name = "Williams Racing",
        base = "Grove, United Kingdom",
        teamChief = "James Vowles",
        technicalChief = "Pat Fry",
        chassis = "FW46",
        powerUnit = "Mercedes",
        firstTeamEntry = 1978,
        worldChampionships = 9,
        highestRaceFinish = "1 (x114)",
        polePositions = 128,
        fastestLaps = 133
    ),
    "kick sauber" to TeamInformation(
        name = "Stake F1 Team Kick Sauber",
        base = "Hinwil, Switzerland",
        teamChief = "Alessandro Alunni Bravi",
        technicalChief = "James Key",
        chassis = "C44",
        powerUnit = "Ferrari",
        firstTeamEntry = 1993,
        worldChampionships = 0,
        highestRaceFinish = "1 (x1)",
        polePositions = 1,
        fastestLaps = 7
    )
)