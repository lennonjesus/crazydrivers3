class Season {

    Integer year

    static hasMany = {
        races:Race
    }

    static constraints = {

        year(unique:true)

    }

    String toString() {
        "Campeonato de Kart ${year}"
    }
}
