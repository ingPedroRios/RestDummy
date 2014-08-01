package mx.habil.dummy.dropwizard.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * Created by prios on 30/07/2014.
 */
public class AlumnoVo  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Length(max = 25)
    private String idAlumno;
    @Length(max = 120)
    private String nombreAlumno;
    @Length(max = 45)
    private String claveAlumno;
    @Length(max = 5)
    private String calificacionAlumno;
    @Length(max = 30)
    private String fechaRegistro;

    @JsonProperty
    public String getIdAlumno() {
        return idAlumno;
    }
    @JsonProperty
    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    @JsonProperty
    public String getNombreAlumno() {
        return nombreAlumno;
    }
    @JsonProperty
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    @JsonProperty
    public String getClaveAlumno() {
        return claveAlumno;
    }
    @JsonProperty
    public void setClaveAlumno(String claveAlumno) {
        this.claveAlumno = claveAlumno;
    }
    @JsonProperty
    public String getCalificacionAlumno() {
        return calificacionAlumno;
    }
    @JsonProperty
    public void setCalificacionAlumno(String calificacionAlumno) {
        this.calificacionAlumno = calificacionAlumno;
    }
    @JsonProperty
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    @JsonProperty
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
