package lab3_52000643;

import lab3_52000643.pojo.Manufacture;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ManufactureDAO {
    Session session = HibernateUtils.getFactory().openSession();

    public boolean add(Manufacture manufacture) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(manufacture);
            transaction.commit();
            return true;
        }catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public Manufacture get(int id) {
        try {
            return (Manufacture) session.createQuery("from Manufacture e where e.id="+id).list().get(0);
        }catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    public List<Manufacture> getAll(){
        try {
            return session.createQuery("from Manufacture").list();
        }catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    public boolean remove(int id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Manufacture manufacture = session.get(Manufacture.class, id);
            if (manufacture != null) {
                String hql = "DELETE FROM Manufacture " + "WHERE id = :manufactureId";
                Query query = session.createQuery(hql);
                query.setParameter("manufactureId", id);
                int result = query.executeUpdate();
                transaction.commit();
                if(result > 0) {
                    return true;
                }
                return false;
            }
            return false;
        }catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean remove(Manufacture p) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Manufacture manufacture = session.get(Manufacture.class, p.getId());
            if (manufacture != null) {
                String hql = "DELETE FROM Manufacture " + "WHERE id = :manufactureId";
                Query query = session.createQuery(hql);
                query.setParameter("manufactureId", p.getId());
                int result = query.executeUpdate();
                transaction.commit();
                if(result > 0) {
                    return true;
                }
                return false;
            }
            return false;
        }catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean update(Manufacture p) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE Manufacture set name = :name, location = :location, employee = :employee WHERE id = :id");
            query.setParameter("name", p.getName());
            query.setParameter("location", p.getLocation());
            query.setParameter("employee", p.getEmployee());
            query.setParameter("id", p.getId());
            int result = query.executeUpdate();
            transaction.commit();
            if(result > 0) {
                return true;
            }
            return false;
        }catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public boolean checkMoreThan100Employee() {
        for(Manufacture manufacture : this.getAll())
            if(manufacture.getEmployee() < 100)
                return false;
        return true;
    }

    public int countAllEmployee() {
        int result = 0;
        for(Manufacture manufacture : this.getAll())
            result += manufacture.getEmployee();
        return result;
    }

    public Manufacture inUS() throws Exception {
        try {
            return (Manufacture) session.createQuery("from Manufacture e where e.location='US' ORDER BY e.id DESC").list().get(0);
        }catch (Exception e) {
            // TODO: handle exception
            throw new Exception("InvalidOperationException");
        }
    }
}
