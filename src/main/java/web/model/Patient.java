package web.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;
import web.gson.PointSerializer;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name="patient_id", updatable = false, nullable = false)
    @Getter
    @Setter
    public Long id ;

    @Column( name="name", updatable = false, nullable = false)
    @Getter @Setter public String name ;

    @JsonSerialize(using = PointSerializer.class)
    @Column( name="geom", updatable = false, nullable = false)
    @Getter @Setter
    Point geom;

}
