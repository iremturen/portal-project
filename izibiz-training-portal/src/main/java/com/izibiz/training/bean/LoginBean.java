package com.izibiz.training.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.izibiz.training.bean.base.GenericBean;
import com.izibiz.training.entity.Users;
import com.izibiz.training.entity.dto.UsersDTO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends GenericBean<Users> {

	private static final long serialVersionUID = 1L;

	private Users users;
	private UsersDTO usersDTO;
	// private UsersService usersService;

	public void loadPage() {
		users = new Users();
		// usersService = new UsersServiceImp();
	}

	public void login() {

		/*
		 * // boolean check = getUsersService().checkUser(users); if (check == false) {
		 * System.out.println("Incorrect password or username");
		 * 
		 * } else { addInfoMessage("Login"); System.out.println("Login successful"); }
		 */
		/*
		 * getRestTemplate().postForLocation("http://localhost:8085/login", users);
		 * System.out.println("Login successful");
		 */
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public UsersDTO getUsersDTO() {
		return usersDTO;
	}

	public void setUsersDTO(UsersDTO usersDTO) {
		this.usersDTO = usersDTO;
	}

}
