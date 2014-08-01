package mx.habil.dummy.dropwizard.resources;

import mx.habil.dummy.dropwizard.exception.ServicioRestDummyException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;


@Provider
@Produces("application/json")
@Path("/posts")
public interface ServicioRestDummySource {


    /**
     * Método que recupera la lista de los alumnos y sus calificaciones.
     *
     * @return Response Respuesta con la lista de alumnos.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    @GET
    @Path("/recuperaAlumno")
    public Response getAlumno()throws ServicioRestDummyException;

    /**
     * Método que agrega un nuevo alumno a la lista.
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacion Calificación.
     * @return Response Respuesta satisfactoria.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    @POST
    @Path("/agregaAlumno/{nombreAlumno}/{claveAlumno}/{calificacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAlumno(@PathParam("nombreAlumno")String nombreAlumno,
                              @PathParam("claveAlumno")String claveAlumno,
                              @PathParam("calificacion")String calificacion)throws ServicioRestDummyException;

    /**
     * Método que elimina un alumno de la lista.
     *
     * @param claveAlumno Clave del alumno.
     * @return Response Respuesta satisfactoria.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    @DELETE
    @Path("/eliminaAlumno/{claveAlumno}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dropAlumno( @PathParam("claveAlumno")String claveAlumno)throws ServicioRestDummyException;


    /**
     * Método que modifica la informacion de un alumno.
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacion Calificación del alumno.
     * @return Response Respuesta satisfactoria.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    @PUT
    @Path("/modificaAlumno/{nombreAlumno}/{claveAlumno}/{calificacion}")
    public Response alterAlumno(@PathParam("nombreAlumno")String nombreAlumno,
                                @PathParam("claveAlumno")String claveAlumno,
                                @PathParam("calificacion")String calificacion)throws ServicioRestDummyException;


}
