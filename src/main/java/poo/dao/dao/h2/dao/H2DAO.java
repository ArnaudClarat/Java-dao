package poo.dao.dao.h2.dao;

import poo.dao.beans.Society;
import poo.dao.dao.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class H2DAO<T> implements DAO<T> {
	public Connection connection;
	
	{
		try {
			connection = H2Singleton.getInstance();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/* INUTILE A NE PAS DE REPRODUIRE
		abstract void getSociety();
		Utile pour définir des fonctions obligatoires dans les classes filles
	*/
}
