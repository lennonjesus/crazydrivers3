package crazydrivers3
/**
 * Representa uma temporada
 */
class Season {

    Integer year

    static hasMany = {
        races:Race
    }

    static constraints = {

        year(unique:true, range: 2012..2014)

    }

    String toString() {
        "Campeonato de Kart - Temporada ${year}"
    }
}
