package mx.habil.dummy.dropwizard.viewService;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import mx.habil.dummy.dropwizard.db.dao.AlumnoDao;
import mx.habil.dummy.dropwizard.health.AlumnoHealthCheck;
import mx.habil.dummy.dropwizard.health.JdbiHealthCheck;
import mx.habil.dummy.dropwizard.resources.ServicioRestDummySourceImpl;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServicioRestDummyApplication extends Application<ServicioRestDummyConfiguration> {

    private static final Logger log = LoggerFactory.getLogger(ServicioRestDummyApplication.class);

    public static void main(String[] args) throws Exception {

        new ServicioRestDummyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServicioRestDummyConfiguration> bootstrap) {

    }

    @Override
    public void run(ServicioRestDummyConfiguration configuration,Environment environment) throws ClassNotFoundException {

        {//SE RECUPERA LA CONEXION A LA BASE DE DATOS Y SE EJECUTA EL REST SERVICE
            final DBIFactory factory = new DBIFactory();
            final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
            final AlumnoDao alumnoDao = jdbi.onDemand(AlumnoDao.class);
            final ServicioRestDummySourceImpl resourceJdbi = new ServicioRestDummySourceImpl(alumnoDao);
            environment.jersey().register(resourceJdbi);

            //SE REALIZA LA VALIDACION DE SALUD PARA EL SERVICIO WEB
            final AlumnoHealthCheck alumnoHealthCheck = new AlumnoHealthCheck(configuration.getNombreAlumno(), configuration.getClaveAlumno(), configuration.getCalificacion());
            environment.healthChecks().register("nombreAlumno", alumnoHealthCheck);
            environment.healthChecks().register("claveAlumno", alumnoHealthCheck);
            environment.healthChecks().register("calificacion", alumnoHealthCheck);
            environment.jersey().register(resourceJdbi);

            //SE REALIZA LA VALIDACIÓN DE SALUD PARA LA BASE DE DATOS.
            log.debug("Valida query:" + configuration.getDataSourceFactory().getValidationQuery());
            final JdbiHealthCheck jdbiHealthCheck = new JdbiHealthCheck(jdbi, configuration.getDataSourceFactory().getValidationQuery());
            environment.healthChecks().register("validationQuery", jdbiHealthCheck);
            environment.jersey().register(resourceJdbi);






        }
    }


}