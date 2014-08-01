package mx.habil.dummy.dropwizard.db.test;


import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.lifecycle.setup.LifecycleEnvironment;
import io.dropwizard.setup.Environment;
import mx.habil.dummy.dropwizard.db.dao.AlumnoDao;
import mx.habil.dummy.dropwizard.dto.AlumnoDto;
import org.skife.jdbi.v2.DBI;

import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AlumnoDaoTestCase extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(AlumnoDaoTestCase.class);
    AlumnoDao alumnoDao;


    /**
     * Contructor de la conexión. Author prios 01-08-2014
     * @throws ClassNotFoundException Si ocurre un error en la conexión
     */
    public AlumnoDaoTestCase() throws ClassNotFoundException {
        DataSourceFactory mysqlConfig = new DataSourceFactory();
        //Datos de conexión.
        mysqlConfig.setUrl("jdbc:mysql://127.0.0.1:3306/alumno?autoReconnect=true");
        mysqlConfig.setUser("dropwizard");
        mysqlConfig.setPassword("123456");
        mysqlConfig.setDriverClass("com.mysql.jdbc.Driver");
        mysqlConfig.setValidationQuery("SELECT 1");

        //Varibales de conexión.
        HealthCheckRegistry healthChecks = mock(HealthCheckRegistry.class);
        LifecycleEnvironment lifecycleEnvironment = mock(LifecycleEnvironment.class);
        Environment environment = mock(Environment.class);
        DBIFactory factory = new DBIFactory();
        MetricRegistry metricRegistry = new MetricRegistry();
        when(environment.healthChecks()).thenReturn(healthChecks);
        when(environment.lifecycle()).thenReturn(lifecycleEnvironment);
        when(environment.metrics()).thenReturn(metricRegistry);

        //Generando la conexión para la BD.
        DBI jdbi = factory.build(environment, mysqlConfig, "mysql");
        this.alumnoDao = jdbi.onDemand(AlumnoDao.class);
    }


    /**
     * Método que realia la prueba unitaria al método del Dao, recuperarListaAlumnos.
     * Author prios 01/08/2014.
     *
     * @see mx.habil.dummy.dropwizard.db.dao.AlumnoDao#recuperarListaAlumnos().
     * @throws Exception Si ocurre un error en la persistencia.
     */
    public void testRecuperarListaAlumnos()throws Exception{
        log.debug("Inicio");

        List<AlumnoDto> listResult = alumnoDao.recuperarListaAlumnos();

        if(listResult != null){
            for(AlumnoDto alumnoDdtoResp : listResult){
                log.debug("Identificador: " + alumnoDdtoResp.getIdAlumno());
                log.debug("Nombre: " + alumnoDdtoResp.getNombreAlumno());
                log.debug("Clave: " + alumnoDdtoResp.getClaveAlumno());
                log.debug("calificación: " + alumnoDdtoResp.getCalificacionAlumno());
                log.debug("Fecha Registro: " + alumnoDdtoResp.getFechaRegistro());
                log.debug("============================================================================================");
            }
            log.debug("Número de registros: " + listResult.size());
        }
        log.debug("Fin");
    }


    /**
     * Método que realiza la prueba unitaria al método del DAO, guardarAlumno.
     * Author prios 01-08-2014.
     *
     * @see mx.habil.dummy.dropwizard.db.dao.AlumnoDao#guardarAlumno(String, String, String, java.util.Date).
     * @throws Exception Si ourre un error en la persistencia.
     */
    public void testGuardarAlumno()throws Exception{
        log.debug("Inicio");

        String nombreAlumno = "Pedro Rios";
        String claveAlumno = "002";
        String calificacionAlumno = "9.8";
        Date fechaRegistro = new Date();

        alumnoDao.guardarAlumno(nombreAlumno, claveAlumno, calificacionAlumno, fechaRegistro);

        log.debug("El alumno se guardo de manera correcta.");

        log.debug("Fin");
    }


    /**
     * Método que realiza la prueba unitaria al método del Dao, actualizarAlumno.
     * Author prios 01-08-2014.
     *
     * @see mx.habil.dummy.dropwizard.db.dao.AlumnoDao#actualizarAlumno(String, String, String, java.util.Date).
     * @throws Exception Si ocurre un error en la persistencia.
     */
    public void testActualizarAlumno() throws Exception {
        log.debug("Inicio");

        String nombreAlumno = "Pedro Rios Lopez";
        String claveAlumno = "003";
        String calificacionAlumno = "6.8";
        Date fechaRegistro = new Date();

        alumnoDao.actualizarAlumno(nombreAlumno, claveAlumno, calificacionAlumno, fechaRegistro);

        log.debug("La informacion del alumno se actualizo de manera correcta.");

        log.debug("Fin");
    }


    /**
     * Método que realiza la prueba unitaria al método del Dao, aliminarAlumno.
     * Author prios 01-08-2014.
     *
     * @see mx.habil.dummy.dropwizard.db.dao.AlumnoDao#aliminarAlumno(String).
     * @throws Exception Si ocurre un error en la persistencia.
     */
    public void testAliminarAlumno() throws Exception {
        log.debug("Inicio");

        String claveAlumno = "020";

        alumnoDao.aliminarAlumno(claveAlumno);

        log.debug("El alumno se elimino de manera correcta.");

        log.debug("Fin");
    }
}