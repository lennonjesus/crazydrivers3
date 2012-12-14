package crazydrivers3
class Race {

    Date date

    static belongsTo = [season:Season]

    static hasOne = [circuit:Circuit]

    static hasMany = [positions:Position, bestLaps:BestLap]



    static constraints = {

    }

    String toString() {
        "GP ${circuit} ${season.year}"
    }

}
