package com.luve;

import com.luve.daos.UserDao;
import com.luve.models.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDao userDAO = new UserDao();

        userDAO.insertUser(new User(0, "John Doe", "johndoe@gmail.com"));

        userDAO.getAllUsers().forEach(user -> 
            System.out.println(user.getId() + " - " + user.getName() + " - " + user.getEmail()));

	}

}
