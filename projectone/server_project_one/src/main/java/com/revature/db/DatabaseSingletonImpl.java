package com.revature.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.ReinbursementRequest;

public class DatabaseSingletonImpl implements DatabaseSingleton {
	public static final int RESULTS_PER_PAGE = 25;
	final static Logger log = Logger.getLogger(DatabaseSingletonImpl.class);

	private Connection con;
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	private static final DatabaseSingletonImpl instance = new DatabaseSingletonImpl();

	/**
	 * 
	 */
	private DatabaseSingletonImpl() {
		initDB();
	}

	public static void main(String[] args) {
		DatabaseSingleton db = DatabaseSingletonImpl.getInstance();
		System.out.println(db);
		// Employee e = new Employee("Pedro", "Tapua", "jose11@gmail.com", false);
		// db.create(e, "password");
		// Manager m = new Manager("Pedro", "Tapua", "jose11@gmail.com", false);
		// db.create(m, "password");
		// ReinbursementRequest r = new ReinbursementRequest(1, "image.jpeg", null, e,
		// "running receipt", 40, (short) 0,
		// false);
		// db.create(r);
		// db.update(m, "Upr@upr.edu");
		// r.setOwner(new Employee("Pedro", "Tapua",
		// "antonio.tapia.maldonado@gmail.com", false));
		// db.update(r);
		// db.update(e, "Upr@upr.edu");
//		System.out.println("---");
//		for (ReinbursementRequest rr : db.getAllRRs(0)) {
//			if (rr == null)
//				break;
//			System.out.println(rr.toString());
//		}
//		System.out.println("---");
//		for (ReinbursementRequest rr : db.getAllUnresolvedRRs(0)) {
//			if (rr == null)
//				break;
//			System.out.println(rr.toString());
//		}
//		System.out.println("---");
//		for (Employee e : db.getAllEmployees(0)) {
//			if (e == null)
//				break;
//			System.out.println(e.toString());
//		}
//		System.out.println("---");
//		for (ReinbursementRequest rr : db.getAllRRs(0, "antonio.tapia.maldonado@gmail.com")) {
//			if (rr == null)
//				break;
//			System.out.println(rr.toString());
//		}
//		System.out.println("---");
//		ReinbursementRequest r = db.readRR(3L);
//		System.out.println(r);
		System.out.println("---");
		ReinbursementRequest[] dbrr = db.getAllRRs("a",0);
		for (ReinbursementRequest rr : dbrr) {
			if (rr == null)
				break;
			System.out.println(rr.toString());
		}
		System.out.println("---");
		dbrr = db.getAllRRs(0, "antonio.tapia.maldonado@gmail.com", "a");
		for (ReinbursementRequest rr : dbrr) {
			if (rr == null)
				break;
			System.out.println(rr.toString());
		}
		System.out.println("---");
		dbrr = db.getAllUnresolvedRRs("a",0);
		for (ReinbursementRequest rr : dbrr) {
			if (rr == null)
				break;
			System.out.println(rr.toString());
		}
		System.out.println("---");
		dbrr = db.getAllUnresolvedRRs(0, "antonio.tapia.maldonado@gmail.com", "z");
		for (ReinbursementRequest rr : dbrr) {
			if (rr == null)
				break;
			System.out.println(rr.toString());
		}

	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		con.close();
	}

	/**
	 * 
	 */
	private void initDB() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("src/main/resources/db.properties");
			props.load(in);
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
					props.getProperty("jdbc.password"));
		} catch (ClassNotFoundException e) {
			log.error(e);
		} catch (SQLException e) {
			log.error(e);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				log.error(e);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public static DatabaseSingleton getInstance() {
		return instance;
	}

	@Override
	public boolean create(Employee e, String password) {
		int index = 0;
		try {
			CallableStatement stmt = con.prepareCall("{CALL insertEmployee(?,?,?,?,?)}");
			stmt.setString(++index, e.getFname());
			stmt.setString(++index, password);
			stmt.setString(++index, e.getLname());
			stmt.setInt(++index, e.isDeleted() ? 1 : 0);
			stmt.setString(++index, e.getEmail());
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean create(Manager m, String password) {
		int index = 0;
		try {
			CallableStatement stmt = con.prepareCall("{CALL insertManager(?,?,?,?,?)}");
			stmt.setString(++index, m.getFname());
			stmt.setString(++index, password);
			stmt.setString(++index, m.getLname());
			stmt.setInt(++index, m.isDeleted() ? 1 : 0);
			stmt.setString(++index, m.getEmail());
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean create(ReinbursementRequest r) {
		int index = 0;
		try {
			CallableStatement stmt = con.prepareCall("{CALL insertReinbursementRequest(?, ?, ?, ?, ?,?,?,?)}");
			// (RRId, image, handledBy, owner, description,amount,isDeleted,status)
			stmt.setLong(++index, r.getId());
			stmt.setString(++index, r.getImageURL());
			stmt.setString(++index, r.getHandledBy() != null ? r.getHandledBy().getEmail() : "");
			stmt.setString(++index, r.getOwner() != null ? r.getOwner().getEmail() : "");
			stmt.setString(++index, r.getDescription());
			stmt.setDouble(++index, r.getAmount());
			stmt.setInt(++index, r.isDeleted() ? 1 : 0);
			stmt.setInt(++index, r.getStatus());
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean update(Employee e, String newEmail) {
		int index = 0;
		try {
			CallableStatement stmt = con.prepareCall("{CALL updateEmployee(?,?,?,?,?)}");
			stmt.setString(++index, e.getFname());
			stmt.setString(++index, e.getLname());
			stmt.setInt(++index, e.isDeleted() ? 1 : 0);
			stmt.setString(++index, e.getEmail());
			stmt.setString(++index, newEmail);

			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean update(Manager m, String newEmail) {
		int index = 0;
		try {
			CallableStatement stmt = con.prepareCall("{CALL updateManager(?,?,?,?,?)}");
			stmt.setString(++index, m.getFname());
			stmt.setString(++index, m.getLname());
			stmt.setInt(++index, m.isDeleted() ? 1 : 0);
			stmt.setString(++index, m.getEmail());
			stmt.setString(++index, newEmail);

			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean update(ReinbursementRequest r) {
		int index = 0;
		try {
			CallableStatement stmt = con.prepareCall("{CALL updateReinbursementRequest(?,?,?,?,?,?,?,?)}");
			stmt.setLong(++index, r.getId());
			stmt.setString(++index, r.getImageURL());
			stmt.setString(++index, r.getHandledBy() != null ? r.getHandledBy().getEmail() : "");
			stmt.setString(++index, r.getOwner().getEmail());
			stmt.setString(++index, r.getDescription());
			stmt.setDouble(++index, r.getAmount());
			stmt.setInt(++index, r.isDeleted() ? 1 : 0);
			stmt.setShort(++index, r.getStatus());
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Employee readEmployee(String email) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM employee WHERE email = ? AND isDeleted = 0");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (rs.next())
				return new Employee(rs.getString("fname"), rs.getString("lname"), rs.getString("email"),
						rs.getBoolean("isDeleted"));
		} catch (SQLException e1) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e1);
		} finally {
			if (stmt != null)
				try {
					stmt.close();
					rs.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return null;
	}

	@Override
	public Manager readManager(String email) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM manager WHERE email = ? AND isDeleted = 0");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			if (rs.next())
				return new Manager(rs.getString("fname"), rs.getString("lname"), rs.getString("email"),
						rs.getBoolean("isDeleted"));
		} catch (SQLException e1) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e1);
			return null;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
					rs.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return null;
	}

	@Override
	public ReinbursementRequest readRR(long id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM reinbursementrequest WHERE RRId = ? AND isDeleted = 0");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				log.info(rs.getString("handledBy"));
				return new ReinbursementRequest(id, rs.getString("image"),
						rs.getString("handledBy") != null ? readManager(rs.getString("handledBy")) : null,
						rs.getString("owner") != null ? readEmployee(rs.getString("owner")) : null,
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
		} catch (SQLException e1) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e1);
			return null;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
					rs.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return null;
	}

	@Override
	public boolean delete(Employee e) {
		e.setDeleted(true);
		return update(e, e.getEmail());
	}

	@Override
	public boolean delete(Manager m) {
		m.setDeleted(true);
		return update(m, m.getEmail());
	}

	@Override
	public boolean delete(ReinbursementRequest r) {
		r.setDeleted(true);
		return update(r);
	}

	@Override
	public Employee login(Employee e, String password) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			log.info(e.getEmail());
			log.info(password);
			stmt = con.prepareStatement("SELECT * FROM employee WHERE email = ? AND password = ? AND isDeleted = 0");
			stmt.setString(1, e.getEmail());
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next())
				return new Employee(rs.getString("fname"), rs.getString("lname"), rs.getString("email"),
						rs.getBoolean("isDeleted"));
		} catch (SQLException e1) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e1);
			return null;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
					rs.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return null;
	}

	@Override
	public Manager login(Manager e, String password) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			log.info(e.getEmail());
			log.info(password);
			stmt = con.prepareStatement("SELECT * FROM manager WHERE email = ? AND password = ? AND isDeleted = 0");
			stmt.setString(1, e.getEmail());
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next())
				return new Manager(rs.getString("fname"), rs.getString("lname"), rs.getString("email"),
						rs.getBoolean("isDeleted"));
		} catch (SQLException e1) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e1);
			return null;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
					rs.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return null;
	}

	@Override
	public ReinbursementRequest[] getAllRRs(int page) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con.prepareStatement("SELECT *  FROM  reinbursementrequest rr WHERE isDeleted=0 OFFSET "
					+ offset + " ROWS FETCH NEXT " + RESULTS_PER_PAGE + " ROWS ONLY");
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public ReinbursementRequest[] getAllUnresolvedRRs(int page) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con
					.prepareStatement("SELECT *  FROM  reinbursementrequest rr WHERE isDeleted=0 AND status=0 OFFSET "
							+ offset + " ROWS FETCH NEXT " + RESULTS_PER_PAGE + " ROWS ONLY");
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public Employee[] getAllEmployees(int page) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Employee[] temp = new Employee[RESULTS_PER_PAGE];
		int resultCount = 0;
		try {
			statement = con.prepareStatement("SELECT *  FROM  employee e WHERE isDeleted=0 OFFSET " + offset
					+ " ROWS FETCH NEXT " + RESULTS_PER_PAGE + " ROWS ONLY");
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new Employee(rs.getString("fname"), rs.getString("lname"), rs.getString("email"),
						rs.getBoolean("isDeleted"));
			}
			resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				Employee[] result = new Employee[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public ReinbursementRequest[] getAllRRs(int page, String email) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con
					.prepareStatement("SELECT *  FROM  reinbursementrequest rr WHERE isDeleted=0 AND owner = ? OFFSET "
							+ offset + " ROWS FETCH NEXT " + RESULTS_PER_PAGE + " ROWS ONLY");
			statement.setString(1, email);
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
				log.info(temp[i-1]);
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++) {					
					result[j] = temp[j];
					log.info(result[j]);
				}
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public ReinbursementRequest[] getAllUnresolvedRRs(int page, String email) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con.prepareStatement(
					"SELECT *  FROM  reinbursementrequest rr WHERE isDeleted=0 AND status=0 AND owner = ? OFFSET "
							+ offset + " ROWS FETCH NEXT " + RESULTS_PER_PAGE + " ROWS ONLY");
			statement.setString(1, email);
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public ReinbursementRequest[] getAllUnresolvedRRs(int page, String email, String search) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con.prepareStatement("SELECT * FROM reinbursementrequest WHERE (owner LIKE ? OR"
					+ " description LIKE ? OR handledBy LIKE ? ) AND owner = ? AND isDeleted=0 AND status=0 "
					+ "OFFSET " + offset + " ROWS FETCH NEXT " + RESULTS_PER_PAGE + " ROWS ONLY");
			statement.setString(1, "%" + search + "%");
			statement.setString(2, "%" + search + "%");
			statement.setString(3, "%" + search + "%");
			statement.setString(4, email);
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public ReinbursementRequest[] getAllRRs(int page, String email, String search) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con.prepareStatement("SELECT * FROM reinbursementrequest WHERE (owner LIKE ? OR"
					+ " description LIKE ? OR handledBy LIKE ? ) AND owner = ? AND isDeleted=0 "
					+ "OFFSET "+ offset + " ROWS FETCH NEXT "+RESULTS_PER_PAGE+" ROWS ONLY");
			statement.setString(1, "%" + search + "%");
			statement.setString(2, "%" + search + "%");
			statement.setString(3, "%" + search + "%");
			statement.setString(4, email);
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public ReinbursementRequest[] getAllRRs(String search, int page) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con.prepareStatement("SELECT * FROM reinbursementrequest WHERE (owner LIKE ? OR"
					+ " description LIKE ? OR handledBy LIKE ? ) AND isDeleted=0 "
					+ "OFFSET "+ offset + " ROWS FETCH NEXT "+RESULTS_PER_PAGE+" ROWS ONLY");
			statement.setString(1, "%" + search + "%");
			statement.setString(2, "%" + search + "%");
			statement.setString(3, "%" + search + "%");
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	@Override
	public ReinbursementRequest[] getAllUnresolvedRRs(String search, int page) {
		int offset = page * RESULTS_PER_PAGE;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ReinbursementRequest[] temp = new ReinbursementRequest[RESULTS_PER_PAGE];
		try {
			statement = con.prepareStatement("SELECT * FROM reinbursementrequest WHERE (owner LIKE ? OR"
					+ " description LIKE ? OR handledBy LIKE ? ) AND isDeleted=0 AND status=0 "
					+ "OFFSET " + offset + " ROWS FETCH NEXT " + RESULTS_PER_PAGE + " ROWS ONLY");
			statement.setString(1, "%" + search + "%");
			statement.setString(2, "%" + search + "%");
			statement.setString(3, "%" + search + "%");
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i > temp.length)
					break;
				temp[i++] = new ReinbursementRequest(rs.getInt("RRId"), rs.getString("image"),
						readManager(rs.getString("handledBy")), readEmployee(rs.getString("owner")),
						rs.getString("description"), rs.getDouble("amount"), rs.getShort("status"),
						rs.getBoolean("isDeleted"));
			}
			int resultCount = i;
			if (resultCount < RESULTS_PER_PAGE) {
				ReinbursementRequest[] result = new ReinbursementRequest[resultCount];
				for (int j = 0; j < resultCount; j++)
					result[j] = temp[j];
				return result;
			}
			return temp;
		} catch (SQLException e) {
			try {
				if(con.isClosed())
					initDB();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			log.error(e);
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					log.error(e1);
				}
		}
		return temp;
	}

	// SELECT * FROM reinbursementrequest WHERE owner LIKE '%a%' OR description LIKE
	// '%a%' OR handledBy LIKE '%a%' OFFSET 0 ROWS FETCH NEXT 2 ROWS ONLY;
}
