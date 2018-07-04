package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

public class Dao {

	protected Session session;

	public void save(Object object) throws ConstraintViolationException {

		session = HibernateControl.getSession();

		session.beginTransaction();

		session.save(object);

		session.getTransaction().commit();

		session.flush();

		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<Comentario> findAll() {

		session = HibernateControl.getSession();

		session.beginTransaction();

		List<Comentario> object = (List<Comentario>) session.createQuery("from Comentario").list();

		session.getTransaction().commit();

		session.flush();

		session.close();

		return object;
	}

	public void update(Object object) {

		session = HibernateControl.getSession();

		session.beginTransaction();

		session.update(object);

		session.getTransaction().commit();

		session.flush();

		session.close();

	}

	public void delete(Object object) {

		session = HibernateControl.getSession();

		session.beginTransaction();

		session.delete(object);

		session.getTransaction().commit();

		session.flush();

		session.close();

	}

	public Session getSession() {
		return session;
	}
}