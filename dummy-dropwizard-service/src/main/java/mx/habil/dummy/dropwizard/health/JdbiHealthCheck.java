package mx.habil.dummy.dropwizard.health;

import com.codahale.metrics.health.HealthCheck;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 * Created by prios on 31/07/2014.
 */
public class JdbiHealthCheck extends HealthCheck {
    private final DBI dbi;
    private final String validationQuery;

    public JdbiHealthCheck(DBI dbi, String validationQuery) {
        this.dbi = dbi;
        this.validationQuery = validationQuery;
    }

    protected Result check() throws Exception {
        Handle handle = dbi.open();
        try{
            handle.execute(validationQuery);
        }catch(Exception ex){
            return Result.unhealthy("Imposible conectar a la base de datos.");
        }
        return Result.healthy();
    }
}