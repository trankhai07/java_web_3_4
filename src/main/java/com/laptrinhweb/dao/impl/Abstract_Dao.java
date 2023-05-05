package com.laptrinhweb.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhweb.dao.Generic_Dao;
import com.laptrinhweb.mapper.Row_mapper;
import com.laptrinhweb.model.category;
import com.laptrinhweb.model.song_play;

public class Abstract_Dao<T> implements Generic_Dao<T> {
	ResourceBundle bundle = ResourceBundle.getBundle("db");
	public Connection getConnection() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/zing_play";
//			String user = "root";
//			String password = "khaine12345";
			Class.forName(bundle.getString("drivername"));
			String url = bundle.getString("url");
			String user = bundle.getString("user");
			String password = bundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public <T> List<T> query(String sql, Row_mapper<T> rowmapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				setParameters(statement,parameters);
				resultset = statement.executeQuery();
				
				while(resultset.next()) {
					results.add(rowmapper.mapRow(resultset));
				}
				return results;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if (statement != null)
						statement.close();
					if (resultset != null)
						resultset.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return null;
	}

//	private void setParameters(PreparedStatement statement, Object[] parameters) {
//		try {
//			for(int i = 0;i < parameters.length;i ++) {
//				Object para = parameters[i];
//				int index = i + 1;
//				if(para instanceof Long) {
//					statement.setLong(index,(Long)para);
//				}
//				else if(para instanceof String) {
//					statement.setString(index, (String) para);
//				}
//				else if(para instanceof Integer) {
//					statement.setInt(index,(Integer)para);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//
//	}
	private void setParameters(PreparedStatement st,Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					st.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					st.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					st.setInt(index, (Integer) parameter);
				} else if (parameter == null) {
					st.setNull(index, Types.NULL);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer insert (String sql, Object... parametes) {
		ResultSet res = null;
		 Integer id = null;
		 Connection connection = null;
		 PreparedStatement statement = null;
		try {
		    connection = getConnection();
		    connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(statement, parametes);
			statement.executeUpdate();
			res = statement.getGeneratedKeys();
			while(res.next()) {
				id = res.getInt(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		}finally{
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(res != null) {
					res.close();
				}
			} catch (Exception e2) {
				return null;
			}
		}

	}

	@Override
	public void insert_1(String sql, Object... parametes) {
		ResultSet res = null;
		Integer id = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parametes);
			statement.executeUpdate();

			connection.commit();

		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
				e.printStackTrace();
		}finally{
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(res != null) {
					res.close();
				}
			} catch (Exception e2) {
			    e2.printStackTrace();
			}
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		 Connection connection = null;
		 PreparedStatement statement = null;
		try {
			
		    connection = getConnection();
		    connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally{
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public Integer count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet re = null;
		Integer count = 0;
		try {

			connection = getConnection();

			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			re = statement.executeQuery();

			while(re.next()){
				count = re.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(re != null){
					re.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}


}
