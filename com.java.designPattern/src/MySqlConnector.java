import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnector {

	private Connection connection = null;
	private Statement statement = null;

	/* need the select query */
	private ResultSet resultset = null;

	private String JBDC_Driver = "com.mysql.jdbc.Driver";

	/* set default connection */
	/* localhost connection default url jdbc:mysql://127.0.0.1 */

	private String url = "jdbc:mysql://localhost:" + getPort() + "/";
	private String port = "3306";
	private String database;
	private String user;
	private String password;
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

	/* getter */

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

	public String getInitconnection() {
		return initconnection;
	}

	/* setter */

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

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

	public void setStatement(String sql) {

		try {

			this.statement = connection.prepareStatement(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}

	public void setResultset(String sql) {
		try {

			this.resultset = (ResultSet) connection.prepareStatement(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void setJBDC_Driver(String jBDC_Driver) {
		JBDC_Driver = jBDC_Driver;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public void setInitconnection(String initconnection) {
		this.initconnection = initconnection;
	}

	public void setInitconnection(String url, String port, String database, String user, String password) {
		this.url = url;
		this.url = port;
		this.url = database;
		this.url = user;
		this.url = password;
	}

}
