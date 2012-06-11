class Race {

    Date date

    static belongsTo = [season:Season]

    static hasOne = [circuit:Circuit]

    static hasMany = [positions:Position]

    static constraints = {

    }

    String toString() {
        "GP ${circuit} ${season.year}"
    }

}
