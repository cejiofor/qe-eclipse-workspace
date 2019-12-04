package com.perscholas.classifieds.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.classifieds.models.User;

public interface UserRepository {
	Integer createUser(User user);
	User getUserById(Integer id) throws SQLException;
	List<User> getAllUsers() throws ClassNotFoundException, IOException, SQLException;
	Boolean updateUser(User user);
	Boolean deleteUser(Integer userId);
}
