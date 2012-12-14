package crazydrivers3



import org.junit.*
import grails.test.mixin.*

@TestFor(BestLapController)
@Mock(BestLap)
class BestLapControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/bestLap/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.bestLapInstanceList.size() == 0
        assert model.bestLapInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.bestLapInstance != null
    }

    void testSave() {
        controller.save()

        assert model.bestLapInstance != null
        assert view == '/bestLap/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/bestLap/show/1'
        assert controller.flash.message != null
        assert BestLap.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/bestLap/list'


        populateValidParams(params)
        def bestLap = new BestLap(params)

        assert bestLap.save() != null

        params.id = bestLap.id

        def model = controller.show()

        assert model.bestLapInstance == bestLap
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/bestLap/list'


        populateValidParams(params)
        def bestLap = new BestLap(params)

        assert bestLap.save() != null

        params.id = bestLap.id

        def model = controller.edit()

        assert model.bestLapInstance == bestLap
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/bestLap/list'

        response.reset()


        populateValidParams(params)
        def bestLap = new BestLap(params)

        assert bestLap.save() != null

        // test invalid parameters in update
        params.id = bestLap.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/bestLap/edit"
        assert model.bestLapInstance != null

        bestLap.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/bestLap/show/$bestLap.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        bestLap.clearErrors()

        populateValidParams(params)
        params.id = bestLap.id
        params.version = -1
        controller.update()

        assert view == "/bestLap/edit"
        assert model.bestLapInstance != null
        assert model.bestLapInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/bestLap/list'

        response.reset()

        populateValidParams(params)
        def bestLap = new BestLap(params)

        assert bestLap.save() != null
        assert BestLap.count() == 1

        params.id = bestLap.id

        controller.delete()

        assert BestLap.count() == 0
        assert BestLap.get(bestLap.id) == null
        assert response.redirectedUrl == '/bestLap/list'
    }
}
