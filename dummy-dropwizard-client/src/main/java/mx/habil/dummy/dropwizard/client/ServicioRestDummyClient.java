package mx.habil.dummy.dropwizard.client;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import mx.habil.dummy.dropwizard.exception.ServicioRestDummyException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class ServicioRestDummyClient {

    private static final Log log = LogFactory.getLog(ServicioRestDummyClient.class);
    private static String urlServicioRestDummy;
    private HttpClient httpClient;

    public ServicioRestDummyClient(String strUrl){
        urlServicioRestDummy = strUrl;
    }

    /**
     * Método que recupera la lista de los alumnos y sus calificaciones.
     *
     * @return String Respuesta con la lista de alumnos.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public String getAlumno()throws ServicioRestDummyException {
        log.debug("Inicio");

        String msjEx = null;
        String result = null;
        String urlMetodoServicio = null;
        GetMethod getMethod = null;
        int statusCode=0; // Código de la respuesta HTTP

        try{

            {//Generando la URL para el método del Servio REST a consumir
                urlMetodoServicio = urlServicioRestDummy + "/recuperaAlumno";
                log.debug("urlMetodoServicio: "+urlMetodoServicio);
            }

            {//Generar el proceso post con la URL generada.
                getMethod = new GetMethod(urlMetodoServicio);
                getMethod.setDoAuthentication(true);
                getMethod.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
                getMethod.addRequestHeader("Accept", "application/json;charset=UTF-8");
            }

            {//Agregando el usuario y la contraseña.
                String userpass = "admin" + ":" + "123456"; //Usuario Autorizado
                byte[] userpassCodificadoByte  = Base64.encodeBase64(userpass.getBytes());
                String userpassCodificado = new String(userpassCodificadoByte);
                log.debug("userpassCodificado= "+ userpassCodificado);
                getMethod.addRequestHeader("Authorization", "Basic " + userpassCodificado );
            }

            {//Generando el http Cliente.
                httpClient = new HttpClient();// Objeto a través del cual realizamos las peticiones
                statusCode = httpClient.executeMethod(getMethod);// Objeto para realizar las peticiine GET
                log.debug("Estatus Respuesta: " + statusCode);
                if (statusCode != HttpStatus.SC_OK) {
                    log.debug("POST método falló: " + getMethod.getStatusLine());
                    result = (getMethod.getStatusLine() != null ? getMethod.getStatusLine().toString() : "");
                    throw new ServicioRestDummyException ("POST método falló: " + getMethod.getStatusLine() + " : "+ getMethod.getResponseBodyAsString(), new Exception ("POST método falló: " + getMethod.getStatusLine()));
                } else {
                    log.debug("Conexion exitosa");
                    result = getMethod.getResponseBodyAsString();
                    log.debug("result(Cliente):"+result);
                }
                getMethod.releaseConnection(); //libera la conexión
            }

        }catch(ServicioRestDummyException serEx){
            throw serEx;
        }catch(Exception ex){
            msjEx = "Ocurrio un error al ejecutar el método getAlumno a nivel Service Rest.";
            throw new ServicioRestDummyException(msjEx,ex);
        }

        log.debug("Fin");
        return result;
    }

    /**
     * Método que agrega un nuevo alumno a la lista.
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacion Calificación.
     * @return String Respuesta satisfactoria.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public String addAlumno(String nombreAlumno, String claveAlumno,String calificacion)throws ServicioRestDummyException{
        log.debug("Inicio");

        String msjEx = null;
        String result = null;
        String urlMetodoServicio = null;
        PostMethod postMethod = null;
        int statusCode=0; // Código de la respuesta HTTP

        try{

            {//Generando la URL para el método del Servio REST a consumir
                urlMetodoServicio = urlServicioRestDummy + "/agregaAlumno/"+nombreAlumno+"/"+claveAlumno+"/"+calificacion;
                log.debug("urlMetodoServicio: "+urlMetodoServicio);
            }

            {//Generar el proceso post con la URL generada.
                postMethod = new PostMethod(urlMetodoServicio);
                postMethod.setDoAuthentication(true);
                postMethod.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
                postMethod.addRequestHeader("Accept", "application/json;charset=UTF-8");
            }

            {//Agregando el usuario y la contraseña.
                String userpass = "admin" + ":" + "123456"; //Usuario Autorizado
                byte[] userpassCodificadoByte  = Base64.encodeBase64(userpass.getBytes());
                String userpassCodificado = new String(userpassCodificadoByte);
                log.debug("userpassCodificado= "+ userpassCodificado);
                postMethod.addRequestHeader("Authorization", "Basic " + userpassCodificado );
            }

            {//Generando el http Cliente.
                httpClient = new HttpClient();// Objeto a través del cual realizamos las peticiones
                statusCode = httpClient.executeMethod(postMethod);// Objeto para realizar las peticiine GET
                log.debug("Estatus Respuesta: " + statusCode);
                if (statusCode != HttpStatus.SC_OK) {
                    log.debug("POST método falló: " + postMethod.getStatusLine());
                    result = (postMethod.getStatusLine() != null ? postMethod.getStatusLine().toString() : "");
                    throw new ServicioRestDummyException ("POST método falló: " + postMethod.getStatusLine() + " : "+ postMethod.getResponseBodyAsString(), new Exception ("POST método falló: " + postMethod.getStatusLine()));
                } else {
                    log.debug("Conexion exitosa");
                    result = postMethod.getResponseBodyAsString();
                    log.debug("result(Cliente):"+result);
                }
                postMethod.releaseConnection(); //libera la conexión
            }

        }catch(ServicioRestDummyException serEx){
            throw serEx;
        }catch(Exception ex){
            msjEx = "Ocurrio un error al ejecutar el método getAlumno a nivel Service Rest.";
            throw new ServicioRestDummyException(msjEx,ex);
        }
        log.debug("Fin");
        return result;
    }

    /**
     * Método que elimina un alumno de la lista.
     *
     * @param claveAlumno Clave del alumno.
     * @return String Respuesta satisfactoria.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public String dropAlumno(String claveAlumno)throws ServicioRestDummyException{
        log.debug("Inicio");

        String msjEx = null;
        String result = null;
        String urlMetodoServicio = null;
        DeleteMethod deleteMethod = null;
        int statusCode=0; // Código de la respuesta HTTP

        try{

            {//Generando la URL para el método del Servio REST a consumir
                urlMetodoServicio = urlServicioRestDummy + "/eliminaAlumno/"+claveAlumno;
                log.debug("urlMetodoServicio: "+urlMetodoServicio);
            }

            {//Generar el proceso post con la URL generada.
                deleteMethod = new DeleteMethod(urlMetodoServicio);
                deleteMethod.setDoAuthentication(true);
                deleteMethod.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
                deleteMethod.addRequestHeader("Accept", "application/json;charset=UTF-8");
            }

            {//Agregando el usuario y la contraseña.
                String userpass = "admin" + ":" + "123456"; //Usuario Autorizado
                byte[] userpassCodificadoByte  = Base64.encodeBase64(userpass.getBytes());
                String userpassCodificado = new String(userpassCodificadoByte);
                log.debug("userpassCodificado= "+ userpassCodificado);
                deleteMethod.addRequestHeader("Authorization", "Basic " + userpassCodificado );
            }

            {//Generando el http Cliente.
                httpClient = new HttpClient();// Objeto a través del cual realizamos las peticiones
                statusCode = httpClient.executeMethod(deleteMethod);// Objeto para realizar las peticiine GET
                log.debug("Estatus Respuesta: " + statusCode);
                if (statusCode != HttpStatus.SC_NO_CONTENT) {
                    log.debug("POST método falló: " + deleteMethod.getStatusLine());
                    result = (deleteMethod.getStatusLine() != null ? deleteMethod.getStatusLine().toString() : "");
                    throw new ServicioRestDummyException ("POST método falló: " + deleteMethod.getStatusLine() + " : "+ deleteMethod.getResponseBodyAsString(), new Exception ("POST método falló: " + deleteMethod.getStatusLine()));
                } else {
                    log.debug("Conexion exitosa");
                    result = deleteMethod.getResponseBodyAsString();
                    log.debug("result(Cliente):"+result);
                }
                deleteMethod.releaseConnection(); //libera la conexión
            }

        }catch(ServicioRestDummyException serEx){
            throw serEx;
        }catch(Exception ex){
            msjEx = "Ocurrio un error al ejecutar el método dropAlumno a nivel Service Rest.";
            throw new ServicioRestDummyException(msjEx,ex);
        }
        log.debug("Fin");
        return result;
    }


    /**
     * Método que modifica la informacion de un alumno.
     *
     * @param nombreAlumno Nombre del alumno.
     * @param claveAlumno Clave del alumno.
     * @param calificacion Calificación del alumno.
     * @return String Respuesta satisfactoria.
     * @throws ServicioRestDummyException Si ocurre un error en tiempo de ejecución.
     */
    public String alterAlumno(String nombreAlumno, String claveAlumno, String calificacion)throws ServicioRestDummyException{
        log.debug("Inicio");

        String msjEx = null;
        String result = null;
        String urlMetodoServicio = null;
        PutMethod putMethod = null;
        int statusCode=0; // Código de la respuesta HTTP

        try{

            {//Generando la URL para el método del Servio REST a consumir
                urlMetodoServicio = urlServicioRestDummy + "/modificaAlumno/"+nombreAlumno+"/"+claveAlumno+"/"+calificacion;
                log.debug("urlMetodoServicio: "+urlMetodoServicio);
            }

            {//Generar el proceso post con la URL generada.
                putMethod = new PutMethod(urlMetodoServicio);
                putMethod.setDoAuthentication(true);
                putMethod.addRequestHeader("Content-Type", "application/json;charset=UTF-8");
                putMethod.addRequestHeader("Accept", "application/json;charset=UTF-8");
            }

            {//Agregando el usuario y la contraseña.
                String userpass = "admin" + ":" + "123456"; //Usuario Autorizado
                byte[] userpassCodificadoByte  = Base64.encodeBase64(userpass.getBytes());
                String userpassCodificado = new String(userpassCodificadoByte);
                log.debug("userpassCodificado= "+ userpassCodificado);
                putMethod.addRequestHeader("Authorization", "Basic " + userpassCodificado );
            }

            {//Generando el http Cliente.
                httpClient = new HttpClient();// Objeto a través del cual realizamos las peticiones
                statusCode = httpClient.executeMethod(putMethod);// Objeto para realizar las peticiine GET
                log.debug("Estatus Respuesta: " + statusCode);
                if (statusCode != HttpStatus.SC_OK) {
                    log.debug("POST método falló: " + putMethod.getStatusLine());
                    result = (putMethod.getStatusLine() != null ? putMethod.getStatusLine().toString() : "");
                    throw new ServicioRestDummyException ("POST método falló: " + putMethod.getStatusLine() + " : "+ putMethod.getResponseBodyAsString(), new Exception ("POST método falló: " + putMethod.getStatusLine()));
                } else {
                    log.debug("Conexion exitosa");
                    result = putMethod.getResponseBodyAsString();
                    log.debug("result(Cliente):"+result);
                }
                putMethod.releaseConnection(); //libera la conexión
            }

        }catch(ServicioRestDummyException serEx){
            throw serEx;
        }catch(Exception ex){
            msjEx = "Ocurrio un error al ejecutar el método alterAlumno a nivel Service Rest.";
            throw new ServicioRestDummyException(msjEx,ex);
        }
        log.debug("Fin");
        return result;
    }

    //Getters & Setters


    public String getUrlServicioRestDummy() {
        return urlServicioRestDummy;
    }

    public void setUrlServicioRestDummy(String urlServicioRestDummy) {
        this.urlServicioRestDummy = urlServicioRestDummy;
    }
}
