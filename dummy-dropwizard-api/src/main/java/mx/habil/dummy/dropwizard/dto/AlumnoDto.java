package mx.habil.dummy.dropwizard.dto;

import java.io.Serializable;
import java.util.Date;


public class AlumnoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idAlumno;//PK
    private String nombreAlumno;
    private String claveAlumno;
    private String calificacionAlumno;
    private Date fechaRegistro;

    public AlumnoDto(){

    }

    public AlumnoDto(Integer idAlumno, String nombreAlumno, String claveAlumno, String calificacionAlumno, Date fechaRegistro){

        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.claveAlumno = claveAlumno;
        this.calificacionAlumno = calificacionAlumno;
        this.fechaRegistro = fechaRegistro;

    }

    public Integer getIdAlumno() {

        return idAlumno;
    }

    /*public void setIdAlumno(Integer idAlumno) {

        this.idAlumno = idAlumno;
    }*//*El SET no se pone por que el campo de la base de datos es un auto increment, de lo contrario se agrega.*/

    public String getNombreAlumno() {

        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {

        this.nombreAlumno = nombreAlumno;
    }

    public String getClaveAlumno() {

        return claveAlumno;
    }

    public void setClaveAlumno(String claveAlumno) {

        this.claveAlumno = claveAlumno;
    }

    public String getCalificacionAlumno() {
        return calificacionAlumno;
    }

    public void setCalificacionAlumno(String calificacionAlumno) {
        this.calificacionAlumno = calificacionAlumno;
    }

    public Date getFechaRegistro() {

        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {

        this.fechaRegistro = fechaRegistro;
    }
}

