public class DAO {
private static int pageSize = 3;
public static List getData(int pageNumber) {
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.getCurrentSession();
List result = null;
try {
session.beginTransaction();
Query query = session.createQuery("from Employee");
query = query.setFirstResult(pageSize * (pageNumber - 1));
query.setMaxResults(pageSize);
result = query.list();
session.getTransaction().commit();
} catch (Exception e) {
e.printStackTrace();
}
return result;
}
}
