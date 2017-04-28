package FleetWeb.fleet;

import java.util.List;

import FleetWeb.model.GeofenceVO;

public interface GeofenceInterface {
	
	public GeofenceVO saveGeofence(GeofenceVO gf);
	public GeofenceVO updateGeofence(GeofenceVO gf);
	public List<GeofenceVO> getAllGeofences();
}
