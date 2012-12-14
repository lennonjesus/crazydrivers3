class BootStrap {

    def init = { servletContext ->

        new crazydrivers3.Driver(name: 'Lennon Jesus', email: 'lennon.jesus@gmail.com', age: 28).save()
        new crazydrivers3.Driver(name: 'Paulo Vaz', email: 'phdorio3@gmail.com', age: 44).save()

        new crazydrivers3.Circuit(name: 'Kartódromo Internacional de Guapimirim').save()

        new crazydrivers3.Season(year: 2013).save()

    }
    def destroy = {
    }
}
