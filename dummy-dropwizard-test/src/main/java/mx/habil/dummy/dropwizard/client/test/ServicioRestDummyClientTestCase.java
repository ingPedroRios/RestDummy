package mx.habil.dummy.dropwizard.client.test;

import junit.framework.TestCase;
import mx.habil.dummy.dropwizard.client.ServicioRestDummyClient;
import mx.habil.dummy.dropwizard.exception.ServicioRestDummyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServicioRestDummyClientTestCase extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(ServicioRestDummyClientTestCase.class);
    private ServicioRestDummyClient servicioRestDummyClient;
    private String urlServicioRestDummy = "http://localhost:8081/posts";

    /**
     * Método que realiza la prueba unitaria al método del Client, getAlumno
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public void testGetAlumno ()throws ServicioRestDummyException{
        log.debug("Inicio");

        servicioRestDummyClient = new ServicioRestDummyClient(urlServicioRestDummy);
        String result = null;

        result = servicioRestDummyClient.getAlumno();

        log.debug("El resultado es :" + result);

        log.debug("Fin");
    }


    /**
     * Método que realiza la prueba unitaria al método del Client, addAlumno
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public void testAddAlumno ()throws ServicioRestDummyException{
        log.debug("Inicio");

        servicioRestDummyClient = new ServicioRestDummyClient(urlServicioRestDummy);
        String result = null;
        String nombreAlumno = "Pedro%20Rios%20Lopez";
        String claveAlumno = "029FTHT3";
        String calificacion = "10.0";

        result = servicioRestDummyClient.addAlumno(nombreAlumno, claveAlumno, calificacion);

        log.debug("El alumno se guardo de manera correcta:" + result);

        log.debug("Fin");
    }


    /**
     * Método que realiza la prueba unitaria al método del Client, dropAlumno
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public void testDropAlumno ()throws ServicioRestDummyException{
        log.debug("Inicio");

        servicioRestDummyClient = new ServicioRestDummyClient(urlServicioRestDummy);
        String result = null;
        String claveAlumno = "004";

        result = servicioRestDummyClient.dropAlumno(claveAlumno);

        log.debug("El resultado es :" + result);

        log.debug("Fin");


    }


    /**
     * Método que realiza la prueba unitaria al método del Client, alterAlumno.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public void testAlterAlumno ()throws ServicioRestDummyException{
        log.debug("Inicio");

        servicioRestDummyClient = new ServicioRestDummyClient(urlServicioRestDummy);
        String result = null;
        String nombreAlumno = "Elvia";
        String claveAlumno = "021";
        String calificacion = "5.5";

        result = servicioRestDummyClient.alterAlumno(nombreAlumno, claveAlumno, calificacion);

        log.debug("El resultado es :" + result);

        log.debug("Fin");
    }
}

