package br.com.rpg.campaign.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.rpg.campaign.dao.UserDao;
import br.com.rpg.campaign.util.JpaUtil;

/**
 * 
 * The Abstract Class User represents a user. The user contains a user name, an
 * email and a password.
 * 
 * A user might be of two types: Player or Dungeon Master. The Player is a User
 * that have a character and cannot interact with campaign. The Dungeon Master
 * is a user that have a campaign and is able to change every campaign detail.
 * 
 * The class User is also responsible to verify if the user is authenticated,
 * change user's email and change user's password.
 * 
 * @author jonas
 * @since 02/10/2019
 * @version 1.4
 *
 */

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String email;
	private String password;
	private Date creationDate;

	public User() {	};

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.creationDate = new Date();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public static List<User> getLista() {
		
		EntityManager em = new JpaUtil().getEntityManager();
		UserDao dao = new UserDao(em);
		return dao.getAllUsers();
		
	}

	public User searchUserById(Integer id) {

		EntityManager em = new JpaUtil().getEntityManager();
		UserDao dao = new UserDao(em);
		User user = dao.getUserById(id);

		if (user.getId() == id) {
			return user;
		}
		return null;
		
	}

	public User exist(String login, String password) {

		for (User user : getLista()) {
			if (user.isAuthenticated(login, password)) {
				return user;
			}
		}
		return null;

	}

	public boolean isAuthenticated(String login, String password) {
		if (!this.email.equals(login)) {
			return false;
		}

		if (!this.password.equals(password)) {
			return false;
		}

		return true;
	}

}
