package mx.habil.dummy.dropwizard.db.dao;

import mx.habil.dummy.dropwizard.dto.AlumnoDto;
import mx.habil.dummy.dropwizard.db.mapper.AlumnoDtoMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;
import java.util.Date;
import java.util.List;

@RegisterMapper(AlumnoDtoMapper.class)
public interface AlumnoDao {


    /**
     * Método que recupera una lista con todos los alumnos que se encuentran en la base de datos.
     *
     * Author: Prios, Habil-Group 30-07-2014
     * @return List<AlumnoDto> Una lista de tipo AlumnoDto que contiene toda la información referente al alumno.
     * @throws Exception Si ocurre un error en la persistencia.
     */
    @SqlQuery("SELECT * FROM ALUMNO")
    @SingleValueResult(AlumnoDto.class)
    public List<AlumnoDto> recuperarListaAlumnos()throws Exception;


    /**
     * Método que guarda un nuevo alumno en la base de datos.
     * Author: Prios 31-07-2014
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacionAlumno Calificación del alumno.
     * @param fechaRegistro Fecha de registro del alumno.
     * @throws Exception Si ocurre un error en la persistencia
     */
    @SqlUpdate("INSERT INTO ALUMNO(NOMBRE_ALUMNO, CLAVE_ALUMNO, CALIFICACION_ALUMNO, FECHA_REGISTRO) VALUES (:nombreAlumno, :claveAlumno, :calificacionAlumno, :fechaRegistro)")
    public void guardarAlumno(@Bind("nombreAlumno") String nombreAlumno, @Bind("claveAlumno") String claveAlumno, @Bind("calificacionAlumno") String calificacionAlumno, @Bind("fechaRegistro") Date fechaRegistro)throws Exception;


    /**
     * Método que modifica la información de un alumno en la base de datos por medio de la clave..
     * Author: PRIOS 31-07-2014
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacionAlumno Calificación del alumno.
     * @param fechaRegistro Fecha de registro del alumno.
     * @throws Exception Si ocurre un error en la persistencia.
     */
    @SqlUpdate("UPDATE ALUMNO SET NOMBRE_ALUMNO = :nombreAlumno, CALIFICACION_ALUMNO = :calificacionAlumno, FECHA_REGISTRO = :fechaRegistro WHERE CLAVE_ALUMNO = :claveAlumno")
    public void actualizarAlumno(@Bind("nombreAlumno") String nombreAlumno, @Bind("claveAlumno") String claveAlumno, @Bind("calificacionAlumno") String calificacionAlumno,@Bind("fechaRegistro") Date fechaRegistro) throws Exception;


    /**
     * Método que elimina un alumno de la base de datos por medio de su clave.
     * Author prios 31-07-2014.
     * @param claveAlumno Clave del alumno.
     * @throws Exception Si ocurre un error en la persistencia.
     */
    @SqlUpdate("DELETE FROM ALUMNO WHERE CLAVE_ALUMNO = :claveAlumno")
    public void aliminarAlumno(@Bind("claveAlumno") String claveAlumno)throws Exception;

}