package br.com.rpg.campaign.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rpg.campaign.model.User;

public class UserDao {
	
	EntityManager em;
	
	public UserDao(EntityManager em){
		this.em = em;
	}
	
	public List<User> getAllUsers(){
		
		em.getTransaction().begin();
		List<User> listUser = em.createQuery("select object(o) from User as o", User.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listUser;
		
	}
	
	public User getUserById(int id) {
		
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		em.close();
		return user;
	}
	
	public void editUserById(int id, String name, String email, String password) {
		
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		user.setUsername(name);
		user.setEmail(email);
		user.setPassword(password);
		em.merge(user);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void createUser(User user) {
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void removeUserById(int id) {
		
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.remove(user);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
