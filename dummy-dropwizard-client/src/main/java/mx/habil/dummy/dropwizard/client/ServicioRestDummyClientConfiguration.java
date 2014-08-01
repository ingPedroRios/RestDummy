package mx.habil.dummy.dropwizard.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by prios on 30/07/2014.
 */
public class ServicioRestDummyClientConfiguration extends Configuration{

    @NotEmpty
    private String urlServicioRestDummy;

    @JsonProperty
    public String getUrlServicioRestDummy() {
        return urlServicioRestDummy;
    }

    @JsonProperty
    public void setUrlServicioRestDummy(String urlServicioRestDummy) {
        this.urlServicioRestDummy = urlServicioRestDummy;
    }
}
