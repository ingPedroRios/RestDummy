package mx.habil.dummy.dropwizard.health;


import com.codahale.metrics.health.HealthCheck;

public class AlumnoHealthCheck extends HealthCheck{

    private final String nombreAlumno;
    private final String claveAlumno;
    private final String calificacion;

    public AlumnoHealthCheck(String nombreAlumno, String claveAlumno, String calificacion) {
        this.nombreAlumno = nombreAlumno;
        this.claveAlumno = claveAlumno;
        this.calificacion = calificacion;
    }


    protected Result check() throws Exception {
        final String nombreAlumnoAux = String.format(nombreAlumno,"TEST");
        final String claveAlumnoAux = String.format(claveAlumno,"TEST");
        final String calificacionAux = String.format(calificacion,"TEST");

        if(!nombreAlumnoAux.contains("TEST")){
            return Result.unhealthy("Name student doesn't include.");
        }else if(!claveAlumnoAux.contains("TEST")){
            return Result.unhealthy("Clave student doesn't include.");
        }else if(!calificacion.contains("TEST")){
            return Result.unhealthy("Result student doesn't include.");
        }else{
            return Result.healthy();
        }
    }
}
