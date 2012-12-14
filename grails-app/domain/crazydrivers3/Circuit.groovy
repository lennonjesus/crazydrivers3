package crazydrivers3
class Circuit {

    String name

//    crazydrivers3.CircuitType type

    static hasMany = [races:Race]

    static constraints = {
    }

    String toString() {
        "${name}"
    }
}
