package mx.habil.dummy.dropwizard.resources;
import mx.habil.dummy.dropwizard.bo.AlumnoBo;
import mx.habil.dummy.dropwizard.db.dao.AlumnoDao;
import mx.habil.dummy.dropwizard.exception.ServicioRestDummyException;
import mx.habil.dummy.dropwizard.vo.AlumnoVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.ws.rs.core.Response;
import java.util.List;

public class ServicioRestDummySourceImpl implements ServicioRestDummySource{

    private static final Log log = LogFactory.getLog(ServicioRestDummySourceImpl.class);
    private AlumnoBo alumnoBo;

    public ServicioRestDummySourceImpl(AlumnoDao alumnoDao){
        this.alumnoBo = new AlumnoBo(alumnoDao);
    }

    public Response getAlumno() throws ServicioRestDummyException {
        log.debug("Inicio");

        String msjEx = null;
        Response result = null;
        List<AlumnoVo> listAlumnosVo = null;

        try{

            {//Recuperando la lista de alumnos.
                listAlumnosVo = alumnoBo.recuperarListaAlumnos();
            }

            {//Respuesta Satisfactoria.
                result = Response.status(Response.Status.OK).entity(listAlumnosVo).header("Accept", "application/json;charset=UTF-8").header("Content-Type", "application/json;charset=UTF-8").build();
            }

        }catch(ServicioRestDummyException resEx){
            throw resEx;
        }catch(Exception ex){
            msjEx = "Se genero un error al ejecutar el método getAlumno a nivel Service.";
            throw new ServicioRestDummyException(msjEx,ex);
        }

        log.debug("Fin");
        return result;
    }


    public Response addAlumno(String nombreAlumno, String claveAlumno, String calificacionAlumno) throws ServicioRestDummyException {
        log.debug("Inicio");

        String msjEx = null;
        Response result = null;

        {//Validaciones.
            if(nombreAlumno == null || nombreAlumno.trim().isEmpty()){
                msjEx = "El nombre del alumno no debe ser nulo o vacío.";
                throw new ServicioRestDummyException(msjEx);
            }
            if(claveAlumno == null || claveAlumno.trim().isEmpty()){
                msjEx = "La clave del alumno no debe ser nula o vacía.";
                throw new ServicioRestDummyException(msjEx);
            }
            if(calificacionAlumno == null || calificacionAlumno.trim().isEmpty()){
                msjEx = "La calificación del alumno no debe ser nulo o vacío.";
                throw new ServicioRestDummyException(msjEx);
            }
        }

        try{

            {//Guardando
                alumnoBo.guardarAlumno(nombreAlumno, claveAlumno, calificacionAlumno);
            }

            {//Respuesta correcta.
                result = Response.status(Response.Status.OK).build();
            }

        }catch(ServicioRestDummyException resEx){
            throw resEx;
        }catch(Exception ex){
            msjEx = "Se genero un error al ejecutar el método addAlumno a nivel Service.";
            throw new ServicioRestDummyException(msjEx,ex);
        }

        log.debug("Fin");
        return result;
    }


    public Response dropAlumno(String claveAlumno) throws ServicioRestDummyException {
        log.debug("Inicio");

        String msjEx = null;
        Response result = null;
        Boolean isExiste = Boolean.FALSE;

        {//Validaciones.
            if(claveAlumno == null || claveAlumno.trim().isEmpty()){
                msjEx = "La clave del alumno no debe ser nula o vacía.";
                throw new ServicioRestDummyException(msjEx);
            }
        }

        try{

            {//Aliminando al alumno
                alumnoBo.aliminarAlumno(claveAlumno);
            }

            {//Respuesta Correcta.
                result = Response.status(Response.Status.OK).build();
            }

        }catch(ServicioRestDummyException resEx){
            throw resEx;
        }catch(Exception ex){
            msjEx = "Se genero un error al ejecutar el método dropAlumno a nivel Service.";
            throw new ServicioRestDummyException(msjEx,ex);
        }

        log.debug("Fin");
        return null;
    }


    public Response alterAlumno(String nombreAlumno, String claveAlumno, String calificacionAlumno) throws ServicioRestDummyException {
        log.debug("Inicio");

        String msjEx = null;
        Response result = null;

        {//Validaciones.
            if(nombreAlumno == null || nombreAlumno.trim().isEmpty()){
                msjEx = "El nombre del alumno no debe ser nulo o vacío.";
                throw new ServicioRestDummyException(msjEx);
            }
            if(claveAlumno == null || claveAlumno.trim().isEmpty()){
                msjEx = "La clave del alumno no debe ser nula o vacía.";
                throw new ServicioRestDummyException(msjEx);
            }
            if(calificacionAlumno == null || calificacionAlumno.trim().isEmpty()){
                msjEx = "La calificación del alumno no debe ser nulo o vacío.";
                throw new ServicioRestDummyException(msjEx);
            }
        }

        try{

            {//Actualizando los datos del alumno.
                alumnoBo.actualizarAlumno(nombreAlumno, claveAlumno, calificacionAlumno);
            }

            {//Respuesta correcta.
                result = Response.status(Response.Status.OK).build();
            }

        }catch(ServicioRestDummyException resEx){
            throw resEx;
        }catch(Exception ex){
            msjEx = "Se genero un error al ejecutar el método alterAlumno a nivel Service.";
            throw new ServicioRestDummyException(msjEx,ex);
        }

        log.debug("Fin");
        return result;
    }
}

