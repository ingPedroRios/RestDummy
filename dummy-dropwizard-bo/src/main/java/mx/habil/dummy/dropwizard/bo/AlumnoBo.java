package mx.habil.dummy.dropwizard.bo;


import mx.habil.dummy.dropwizard.db.dao.AlumnoDao;
import mx.habil.dummy.dropwizard.dto.AlumnoDto;
import mx.habil.dummy.dropwizard.vo.AlumnoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlumnoBo {

    private final Logger log = LoggerFactory.getLogger(AlumnoBo.class);
    private AlumnoDao alumnoDao;

    public AlumnoBo(AlumnoDao alumnoDaoAux) {
        this.alumnoDao = alumnoDaoAux;
    }


    /**
     * Método que recupera la lista con los alumnos.
     * Author prios 01-08-2014.
     *
     * @return List<AlumnoDto> Una lista de tipo AlumnoDto que contiene toda la información de los alumnos.
     * @throws Exception Si ocurre un error en tiempo de ejecución.
     */
    public List<AlumnoVo> recuperarListaAlumnos()throws Exception{
        log.debug("Inicio");

        String msjEx = null;
        List<AlumnoVo> listAlumnosVo = null;
        List<AlumnoDto> listAlumnoDto = null;
        AlumnoVo alumnoVo = null;

        try{

            {//REcuperamos la lista de alumnos de la base de datos.
                listAlumnoDto = alumnoDao.recuperarListaAlumnos();
            }

            {//Generamos la lista de alumnos para el Servicio REST.
                listAlumnosVo = new ArrayList<AlumnoVo>();
                for (AlumnoDto alumnoDto : listAlumnoDto){
                    alumnoVo = new AlumnoVo();
                    alumnoVo.setIdAlumno(alumnoDto.getIdAlumno().toString());
                    alumnoVo.setNombreAlumno(alumnoDto.getNombreAlumno());
                    alumnoVo.setClaveAlumno(alumnoDto.getClaveAlumno());
                    alumnoVo.setCalificacionAlumno(alumnoDto.getCalificacionAlumno().toString());
                    alumnoVo.setFechaRegistro(alumnoDto.getFechaRegistro().toString());
                    listAlumnosVo.add(alumnoVo);
                }
            }

        }catch(Exception ex){
            msjEx = "Ocurrió un error inesperado al ejecutar el método recuperarListaAlumnos a nivel Bo.";
            throw new Exception(msjEx,ex);
        }

        log.debug("Fin");
        return listAlumnosVo;
    }


    /**
     * Método que guarda un nuevo alumno.
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacionAlumno Calificación del alumno.
     * @throws Exception Si ocurre un error en tiempo de ejecución.
     */
    public void guardarAlumno(String nombreAlumno, String claveAlumno, String calificacionAlumno)throws Exception{
        log.debug("Inicio");

        String msjEx = null;
        Date fechaRegistro = null;

        {//Validaciones
            if(nombreAlumno == null || nombreAlumno.trim().isEmpty()){
                msjEx = "El nombre del alumno no debe ser nulo o vacío.";
                throw new Exception(msjEx);
            }
            if(claveAlumno == null || claveAlumno.trim().isEmpty()){
                msjEx = "La clave del alumno no debe ser nula o vacía.";
                throw new Exception(msjEx);
            }
            if(calificacionAlumno == null || calificacionAlumno.trim().isEmpty()){
                msjEx = "La calificación del alumno no debe ser nula o vacía.";
                throw new Exception(msjEx);
            }
        }

        try{

            {//Recuperando la fecha
                fechaRegistro = new Date();
            }

            {//Guardando el alumno.
                log.debug("Nombre:" + nombreAlumno);
                log.debug("Clave:" + claveAlumno);
                log.debug("Calificación:" + calificacionAlumno);
                log.debug("Fecha: " + fechaRegistro);
                alumnoDao.guardarAlumno(nombreAlumno, claveAlumno, calificacionAlumno, fechaRegistro);
            }

        }catch(Exception ex){
            msjEx = "Ocurrió un error inesperado al ejecutar el método guardarAlumno a nivel Bo.";
            throw new Exception(msjEx,ex);
        }
        log.debug("Fin");
    }


    /**
     * Método que realiza la actualización de la información del alumno por medio de su clave.
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacionAlumno Calificación del alumno.
     * @throws Exception Si ocurre un error en tiempo de ejecución.
     */
    public void actualizarAlumno(String nombreAlumno, String claveAlumno, String calificacionAlumno)throws Exception{
        log.debug("Inicio");

        String msjEx = null;
        Date fechaRegistro = null;

        {//Validaciones
            if(nombreAlumno == null || nombreAlumno.trim().isEmpty()){
                msjEx = "El nombre del alumno no debe ser nulo o vacío.";
                throw new Exception(msjEx);
            }
            if(claveAlumno == null || claveAlumno.trim().isEmpty()){
                msjEx = "La clave del alumno no debe ser nula o vacía.";
                throw new Exception(msjEx);
            }
            if(calificacionAlumno == null || calificacionAlumno.trim().isEmpty()){
                msjEx = "La calificación del alumno no debe ser nula o vacía.";
                throw new Exception(msjEx);
            }
        }

        try{

            {//Recuperando la fecha
                fechaRegistro = new Date();
            }

            {//Actualizando el alumno.
                log.debug("Nombre:" + nombreAlumno);
                log.debug("Clave:" + claveAlumno);
                log.debug("Calificación:" + calificacionAlumno);
                log.debug("Fecha: " + fechaRegistro);
                alumnoDao.actualizarAlumno(nombreAlumno, claveAlumno, calificacionAlumno, fechaRegistro);
            }

        }catch(Exception ex){
            msjEx = "Ocurrió un error inesperado al ejecutar el método actualizarAlumno a nivel Bo.";
            throw new Exception(msjEx,ex);
        }
        log.debug("Fin");
    }


    /**
     * Método que alimina un alumno por medio de su clave.
     *
     * @param claveAlumno Clave del alumno.
     * @throws Exception Si ocurre un error en tiempo de ejecución.
     */
    public void aliminarAlumno(String claveAlumno)throws Exception{
        log.debug("Inicio");

        String msjEx = null;

        {//Validaciones
            if(claveAlumno == null || claveAlumno.trim().isEmpty()){
                msjEx = "La clave del alumno no debe ser nula o vacía.";
                throw new Exception(msjEx);
            }
        }

        try{

            {//Eliminando alumno.
                alumnoDao.aliminarAlumno(claveAlumno);
            }

        }catch(Exception ex){
            msjEx = "Ocurrió un error inesperado al ejecutar el método aliminarAlumno a nivel Bo.";
            throw new Exception(msjEx,ex);
        }
        log.debug("Fin");
    }
}
