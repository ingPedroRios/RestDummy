package mx.habil.dummy.dropwizard.db.mapper;

import mx.habil.dummy.dropwizard.dto.AlumnoDto;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoDtoMapper implements ResultSetMapper<AlumnoDto> {

    /**
     * Método que realiza el mapeado de la tabla Alumno.
     * Author prios 31-07-2014.
     *
     * @param index indice.
     * @param rs Result set.
     * @param ctx Context
     * @return AlumnoDto Un objeto que contiene toda la información referente al alumno.
     * @throws SQLException Si ocurre un error en la persistencia.
     */
    public AlumnoDto map(int index, ResultSet rs, StatementContext ctx) throws SQLException {

        return new AlumnoDto(rs.getInt("ID_ALUMNO"),
                rs.getString("NOMBRE_ALUMNO"),
                rs.getString("CLAVE_ALUMNO"),
                rs.getString("CALIFICACION_ALUMNO"),
                rs.getDate("FECHA_REGISTRO"));
    }
}