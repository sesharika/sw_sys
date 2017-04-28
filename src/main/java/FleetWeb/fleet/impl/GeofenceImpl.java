package FleetWeb.fleet.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import FleetWeb.fleet.GeofenceInterface;
import FleetWeb.model.GeofenceVO;

public class GeofenceImpl implements GeofenceInterface{

	public GeofenceVO saveGeofence(GeofenceVO gf) {
		Session session = FleetWeb.fleet.util.HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			int fenceId = (Integer) session.save(gf);
			gf.setFenceId(fenceId);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return gf;
	}
	
	public GeofenceVO updateGeofence(GeofenceVO gf) {
		Session session = FleetWeb.fleet.util.HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(gf);
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return gf;
	}
	
	public List<GeofenceVO> getAllGeofences(){
		Session session = FleetWeb.fleet.util.HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<GeofenceVO> geofences = null;
		try{
			tx = session.beginTransaction();
			String sql = "SELECT * FROM geofence";
			geofences = session.createSQLQuery(sql).list();
			tx.commit();
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return geofences;
	}
	
	public static void main(String[] args){
		// GeofenceVO gf = new GeofenceVO(2, 111.23 , 111.23, 123.0);
		
		GeofenceInterface geofenceImpl = new GeofenceImpl();
		List<GeofenceVO> result = geofenceImpl.getAllGeofences();
		
		// GeofenceVO result = geofenceImpl.updateGeofence(gf);
		
		Iterator<GeofenceVO> iter = result.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getFenceId());
		}
		
	}
	
}
