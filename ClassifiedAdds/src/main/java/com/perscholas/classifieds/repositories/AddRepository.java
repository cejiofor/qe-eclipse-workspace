package com.perscholas.classifieds.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.classifieds.models.Add;

public interface AddRepository {
	Integer createAdd(Add add);
	Add getAddById(Integer id) throws SQLException;
	List<Add> getAllAdds() throws ClassNotFoundException, IOException, SQLException;
	Boolean updateAdd(Add add);
	Boolean deleteAdd(Integer addId);
}
