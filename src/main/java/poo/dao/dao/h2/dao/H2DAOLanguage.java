package poo.dao.dao.h2.dao;

import poo.dao.beans.Language;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public final class H2DAOLanguage extends H2DAO<Language> {
	
	@Override
	public Language find(long id) {
		String sql = "select * from LANGUAGES where LANG_ID = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
		statement.setLong(1, id);
		
		ResultSet set = statement.executeQuery();
		if (set.first()){
			Language language = new Language(set.getString("LANG_NAME"));
			language.setId(set.getLong("LANG_ID"));
			return language;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Language save(Language object) {
		String sql = "insert into LANGUAGES (LANG_NAME) values ( ? )";
		
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, object.getName());
			if (statement.execute()){
				ResultSet set = statement.getGeneratedKeys();
				if (set.first()) object.setId(set.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	@Override
	public Language update(Language object) {
		String sql = "update LANGUAGES set LANG_NAME = ? where LANG_ID = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, object.getName());
			statement.setLong(2,object.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	@Override
	public boolean delete(Language object) {
		String sql = "delete from LANGUAGES where LANG_ID = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)){
			
			statement.setLong(1, object.getId());
			return statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void saveAll(Collection<Language> collection) {
	
	}
}
