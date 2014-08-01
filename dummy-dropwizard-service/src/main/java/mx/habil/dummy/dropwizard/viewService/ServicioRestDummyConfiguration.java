package mx.habil.dummy.dropwizard.viewService;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ServicioRestDummyConfiguration extends Configuration {

    /*CONFIGURACIÓN SERVICIO REST*/
    @NotEmpty
    private String nombreAlumno;
    @NotEmpty
    private String claveAlumno;
    @NotEmpty
    private String calificacion;


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
    public String getCalificacion() {
        return calificacion;
    }
    @JsonProperty
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    /*CONFIGURACÓN DE LA BASE DE DATOS*/
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}