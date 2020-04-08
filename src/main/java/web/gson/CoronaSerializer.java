package web.gson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.locationtech.jts.geom.Point;
import org.springframework.boot.jackson.JsonComponent;
import web.model.Corona;

import java.io.IOException;

@JsonComponent
public class CoronaSerializer extends JsonSerializer<Corona> {

    @Override
    public void serialize(Corona corona, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        String patient = "" ;
        if( null != corona.patient ) {
            patient = corona.patient.name;
        }

        gen.writeNumberField("rno", corona.rno );

        gen.writeNumberField("id", corona.id );
        gen.writeStringField( "place", corona.place );
        gen.writeStringField( "patient", patient );

        // geom
        gen.writeObjectFieldStart( "geom" );
        gen.writeNumberField( "lat", corona.geom.getY() );
        gen.writeNumberField( "lon", corona.geom.getX() );
        gen.writeEndObject();
        // geom

        gen.writeNumberField("visitFr", corona.visitFr.getTime() );
        gen.writeNumberField("visitTo", corona.visitTo.getTime() );

        gen.writeNumberField("upDt", corona.upDt.getTime() );
        gen.writeNumberField("deleted", corona.deleted );

        gen.writeEndObject();
    }

}