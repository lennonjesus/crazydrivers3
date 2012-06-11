class Position {

    Integer number

    Driver driver

    PositionType type

    BestLap bestLap

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
        "${number} - ${driver} - ${bestLap} - ${type}"
    }

    int compareTo(Position position) {
        number.compareTo position.number
    }


	
}

class BestLap {

    BigDecimal minutes

    BigDecimal seconds

    BigDecimal miliseconds

    static constraints = {
        minutes(range: 0..59)
        seconds(range: 0..59)
        miliseconds(range: 0..999)
    }

    String toString() {
        "${minutes}:${seconds}:${miliseconds}"
    }

}

