class Circuit {

    String name

    CircuitType type

    static hasMany = [races:Race]

    static constraints = {
    }

    String toString() {
        "${name}"
    }
}
