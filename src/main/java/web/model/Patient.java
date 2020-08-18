package web.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
import web.gson.PointSerializer;

import javax.persistence.*;

@Entity
@Table(
        name = "patient",
        indexes = {
                @Index( name="idx_patient_01_name", columnList = "name" ),
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name="patient_id", updatable = false, nullable = false)
    @Getter
    @Setter
    public Long id ;

    @Column( name="name", nullable = false)
    @Getter @Setter public String name ;

    @JsonSerialize(using = PointSerializer.class)
    @Column( name="geom", columnDefinition = "GEOGRAPHY(POINT,4326)", nullable = false )
    @Getter @Setter
    Point geom;

}
