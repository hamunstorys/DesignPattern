
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlBehavior {

	/*
	 * 데이타베이스 기본 설정
	 */

	private Connection connection = null;
	private Statement statement = null;

	/* need the select query */
	private ResultSet resultset = null;

	private String JBDC_Driver = "com.mysql.jdbc.Driver";

	/* set default connection */

	private String url = "jdbc:mysql://localhost:" + getPort() + "/";
	private String port = "3306";
	private String database = "";
	private String user = "root";
	private String password = "1234";
	private String initconnection = getUrl() + getDatabase() + getUser() + getPassword();

	public void connectionDatabase() {

		try {

			this.connection = DriverManager.getConnection(getUrl() + getDatabase(), getUser(), getPassword());
			statement = this.connection.createStatement();

			System.out.println("DATABASE Connection Success");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE Connection Exception");

		}
	}

	public void connectionDatabase(String url, String user, String password) {

		try {

			setConnection(url, user, password);
			statement = this.connection.createStatement();
			System.out.println("DATABASE Connection Success");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE Connection Exception");

		}

	}

	public void connectionDatabase(String url, String database, String user, String password) {

		try {

			setConnection(url, database, user, password);
			statement = this.connection.createStatement();
			System.out.println("DATABASE Connection");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE Connection Exception");

		}

	}

	public void executeUpdate(String Query, String url, String user, String password) {

		try {

			connectionDatabase(url, user, password);
			statement.executeUpdate(Query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE execuetUpdate : " + Query);

	}

	public void executeUpdate(String Query, String url, String database, String user, String password) {

		try {

			connectionDatabase(url, database, user, password);
			statement.executeUpdate(Query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE execuetUpdate : " + Query);

	}

	public void executeQuery(String Query) {

		try {

			connectionDatabase();
			statement.executeQuery(Query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE executeUpdate : " + Query);

	}

	public void executeQuery(String Query, String url, String user, String password) {

		try {

			connectionDatabase(url, user, password);
			statement.executeQuery(Query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE executeUpdate : " + Query);

	}

	public void executeQuery(String Query, String url, String database, String user, String password) {

		try {

			connectionDatabase(url, database, user, password);
			statement.executeQuery(Query);
			System.out.println("DATABASE executeUpdate Excepion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("DATABASE executeUpdate Exception");
		}

		System.out.println("DATABASE executeUpdate : " + Query);

	}

	public void sqlExecuteSelect(String select, String table) {

		executeQuery("SELECT " + select + "FROM " + table);

	}

	/* setter */

	public void setConnection(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;

		try {

			connection = DriverManager.getConnection(getUrl() + getDatabase() + getUser() + getPassword());

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void setConnection(String url, String database, String user, String password) {
		this.url = url;
		this.database = database;
		this.user = database;
		this.password = password;

		try {

			connection = DriverManager.getConnection(getUrl() + getDatabase() + getUser() + getPassword());

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

	public void setJBDC_Driver(String jBDC_Driver) {
		JBDC_Driver = jBDC_Driver;
	}

	public void setUrl(String url) {
		this.url = "jdbc:mysql://" + url + ":" + 3306;

	}

	public void setUrl(String url, String port) {
		this.url = "jdbc:mysql://" + url + ":" + port;

	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/* setter */

	public Connection getConnection() {
		return connection;

	}

	public Statement getStatement() {
		return statement;
	}

	public ResultSet getResultset() {
		return resultset;
	}

	public String getJBDC_Driver() {
		return JBDC_Driver;
	}

	public String getUrl() {
		return url;
	}

	public String getPort() {
		return port;
	}

	public String getDatabase() {
		return database;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

}