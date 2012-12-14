package crazydrivers3
class Driver {

    String name

    Integer age

    String email

//    static hasMany = [position:crazydrivers3.Position]


    static constraints = {

    }

    String toString() {
        "${name}"
    }
}
