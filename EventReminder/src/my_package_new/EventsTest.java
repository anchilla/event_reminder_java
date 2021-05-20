package my_package_new;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EventsTest {
	
	List<Events1> tableEvents;
	
	public List<Events1> getList() {
		return tableEvents;
	}
	
	public void hibernate(String day, String month, String year, String type) {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session=sessionFactory.getCurrentSession();
	
	try {
		System.out.println("Creating new session");
		Events1 tempEvent=new Events1(day, month, year,  type);
		session.beginTransaction();
		System.out.println("saving date");
		session.save(tempEvent);
		
		String hql = "from Events1";
		Query query = session.createQuery(hql);
		tableEvents = query.list(); 
		
		System.out.println("Size liste je: "+ tableEvents.size());
		
		session.getTransaction().commit();
		System.out.println("Done");
		System.out.println(getList());
		
	}
	finally {
		session.close();
	}
	}
}