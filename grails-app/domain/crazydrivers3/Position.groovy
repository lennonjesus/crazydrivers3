package crazydrivers3

class Position {

    Integer number

    Driver driver

    PositionType type

    static belongsTo = [race:Race, driver:Driver]

    static embedded = ['bestLap']

    static constraints = {
        number(range: 1..12)
        driver(validator : { driver, obj ->
            if (Position.findAllWhere(driver: driver, type: obj.type, race: obj.race)) {
                "erro"
            }
        })
    }

    static mapping = {
        table "`POSITION`"
    }

    String toString() {
        "${number} - ${driver} - ${type}"
    }

    int compareTo(Position position) {
        number.compareTo position.number
    }


	
}



