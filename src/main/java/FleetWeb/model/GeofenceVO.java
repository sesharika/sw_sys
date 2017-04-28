package FleetWeb.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geofence")
public class GeofenceVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int fenceId;
    private double gLat;
    private double gLng;
    private double radius;
    
	public GeofenceVO(int fenceId, double gLat, double gLng, double radius) {
		super();
		this.fenceId = fenceId;
		this.gLat = gLat;
		this.gLng = gLng;
		this.radius = radius;
	}
	
	@Id
    @Column(name = "fence_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getFenceId() {
		return fenceId;
	}

	public void setFenceId(int fenceId) {
		this.fenceId = fenceId;
	}
	
	@Column(name = "g_lat")
	public double getgLat() {
		return gLat;
	}

	public void setgLat(double gLat) {
		this.gLat = gLat;
	}
	
	@Column(name = "g_lng")
	public double getgLng() {
		return gLng;
	}

	public void setgLng(double gLng) {
		this.gLng = gLng;
	}
	
	@Column(name = "radius")
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}
