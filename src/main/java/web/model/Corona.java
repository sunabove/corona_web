package web.model; 
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import web.gson.PointSerializer;

@Entity 
@Table(name = "corona") 
public class Corona {
	private static final long serialVersionUID = 7651442912976880520L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column( name="corona_id", updatable = false, nullable = false)
	@Getter @Setter public Long id ;   
	
	@Getter @Setter public String place ;
	@ManyToOne
	@JoinColumn( name="patient_id" )
	@Getter @Setter public Patient patient ;
	
	@JsonSerialize(using = PointSerializer.class)
	@Getter @Setter Point geom;

	@Getter @Setter public transient int rno = 0 ;

	@Getter @Setter  
	public Timestamp visitFr ;
	
	@Getter @Setter  
	public Timestamp visitTo ;

	@UpdateTimestamp
	@Getter @Setter public Timestamp upDt ;

	@Getter @Setter public Integer deleted = 0 ;

	public Corona() {  
	}   
	
}