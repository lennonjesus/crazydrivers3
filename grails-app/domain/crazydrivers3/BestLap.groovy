package crazydrivers3

class BestLap {

    BigDecimal minutes

    BigDecimal seconds

    BigDecimal milliseconds

    static belongsTo = [race:Race, driver:Driver]

    static constraints = {
        minutes(range: 0..59)
        seconds(range: 0..59)
        milliseconds(range: 0..999)
    }

    String toString() {
        "${minutes}:${seconds}:${milliseconds}"
    }

}
