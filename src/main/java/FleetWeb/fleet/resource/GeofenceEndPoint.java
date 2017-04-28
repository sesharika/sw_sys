package FleetWeb.fleet.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import FleetWeb.fleet.GeofenceInterface;
import FleetWeb.fleet.impl.GeofenceImpl;
import FleetWeb.model.GeofenceVO;


@Path("/fleetapp")
public class GeofenceEndPoint {
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getGeofences() {
		GeofenceInterface geofenceImpl = new GeofenceImpl();
		List<GeofenceVO> gf = geofenceImpl.getAllGeofences();
		
		List<GeofenceVO> result = new ArrayList<GeofenceVO>(); 
		// Printing the values
		for (GeofenceVO geofence : gf) {
			GeofenceVO eachGf = new GeofenceVO(geofence.getFenceId(),geofence.getgLat(),geofence.getgLng(),geofence.getRadius());
			result.add(eachGf);
		}
		GenericEntity<List<GeofenceVO>> entity = new GenericEntity<List<GeofenceVO>>(
				result) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@POST
	@Path("/saveGeofence")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveGF(GeofenceVO geofence){
		GeofenceInterface geofenceImpl = new GeofenceImpl();
		GeofenceVO gf = new GeofenceVO(geofence.getFenceId(),geofence.getgLat(),geofence.getgLng(),geofence.getRadius());
		gf = geofenceImpl.saveGeofence(gf);
		GenericEntity<GeofenceVO> entity = new GenericEntity<GeofenceVO>(gf) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	@PUT
	@Path("/updateGeofence")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserBug(GeofenceVO geofence){
		GeofenceInterface geofenceImpl = new GeofenceImpl();
		GeofenceVO gf = new GeofenceVO(geofence.getFenceId(),geofence.getgLat(),geofence.getgLng(),geofence.getRadius());
		gf = geofenceImpl.updateGeofence(gf);	
		GenericEntity<GeofenceVO> entity = new GenericEntity<GeofenceVO>(gf) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
	

}
