import grails.test.mixin.*
import crazydrivers3.Circuit
import crazydrivers3.CircuitController

@TestFor(CircuitController)
@Mock(Circuit)
class CircuitControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/circuit/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.circuitInstanceList.size() == 0
        assert model.circuitInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.circuitInstance != null
    }

    void testSave() {
        controller.save()

        assert model.circuitInstance != null
        assert view == '/circuit/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/circuit/show/1'
        assert controller.flash.message != null
        assert Circuit.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/circuit/list'


        populateValidParams(params)
        def circuit = new Circuit(params)

        assert circuit.save() != null

        params.id = circuit.id

        def model = controller.show()

        assert model.circuitInstance == circuit
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/circuit/list'


        populateValidParams(params)
        def circuit = new Circuit(params)

        assert circuit.save() != null

        params.id = circuit.id

        def model = controller.edit()

        assert model.circuitInstance == circuit
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/circuit/list'

        response.reset()


        populateValidParams(params)
        def circuit = new Circuit(params)

        assert circuit.save() != null

        // test invalid parameters in update
        params.id = circuit.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/circuit/edit"
        assert model.circuitInstance != null

        circuit.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/circuit/show/$circuit.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        circuit.clearErrors()

        populateValidParams(params)
        params.id = circuit.id
        params.version = -1
        controller.update()

        assert view == "/circuit/edit"
        assert model.circuitInstance != null
        assert model.circuitInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/circuit/list'

        response.reset()

        populateValidParams(params)
        def circuit = new Circuit(params)

        assert circuit.save() != null
        assert Circuit.count() == 1

        params.id = circuit.id

        controller.delete()

        assert Circuit.count() == 0
        assert Circuit.get(circuit.id) == null
        assert response.redirectedUrl == '/circuit/list'
    }
}
