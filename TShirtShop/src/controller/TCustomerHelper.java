/**@author wuebk - Tyler Wuebker
 * Class : CIS175 Spring 2021
 * Mar 9, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TCustomer;

/**
 * @author wuebk
 *
 */
public class TCustomerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("TShirtShop");
	
	public void insertNewListDetails(TCustomer s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<TCustomer> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<TCustomer> allDetails = em.createQuery("SELECT d from ListDetails d").getResultList();
		return allDetails;
	}
}
