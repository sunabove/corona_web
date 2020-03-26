package web.gson;

import java.io.IOException;

import org.locationtech.jts.geom.Point;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class PointSerializer extends JsonSerializer< Point >{

    @Override
 public void serialize( Point value, JsonGenerator gen, SerializerProvider provider) throws IOException {
     gen.writeStartObject();
     gen.writeNumberField("lat", value.getY());
     gen.writeNumberField("lon", value.getX());
     gen.writeEndObject();
 }
}