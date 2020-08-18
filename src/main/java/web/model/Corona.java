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
import web.gson.CoronaSerializer;
import web.gson.PointSerializer;

@Entity 
@Table(
		name = "corona",
		indexes = {
				@Index( name="idx_corona_01_geom", columnList = "geom" ),
				@Index( name="idx_corona_02_place", columnList = "place" ),
				@Index( name="idx_corona_03_visit", columnList = "visit_fr,visit_to" ),
				@Index( name="idx_corona_04_deleted_up_dt", columnList = "deleted,up_dt" ),
		}
)
@JsonSerialize(using = CoronaSerializer.class)
public class Corona {
	private static final long serialVersionUID = 7651442912976880520L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column( name="corona_id", updatable = false, nullable = false)
	@Getter @Setter public Long id ;

	@Column( name="place", nullable = false)
	@Getter @Setter public String place ;
	@ManyToOne
	@JoinColumn( name="patient_id" )
	@Getter @Setter public Patient patient ;
	
	@JsonSerialize(using = PointSerializer.class)
	@Column( name="geom" )
	@Getter @Setter public Point geom;

	@Getter @Setter public transient int rno = 0 ;

	@Column( name="visit_fr", nullable = false)
	@Getter @Setter  public Timestamp visitFr ;

	@Column( name="visit_to", nullable = false)
	@Getter @Setter  public Timestamp visitTo ;

	@UpdateTimestamp
	@Column( name="up_dt", nullable = false)
	@Getter @Setter public Timestamp upDt ;

	@Column( name="deleted", nullable = false)
	@Getter @Setter public Integer deleted = 0 ;

	public Corona() {  
	}   
	
}