package employeeJspServletCrud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDao {
	// created connection method to use every time for connections
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empjspservlet", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return connection;
	}
	// first method to get a new employee's data and to save in DataBase
	public int save(Employee employee) throws ClassNotFoundException {
		String insertInSql = " INSERT INTO employee(name,skills,age,salary,joinDate)values(?,?,?,?,?)";
		int status = 0;
		try {
			// Step 1- getting connection of DataBase
			Connection connection = EmployeeDao.getConnection();
			// Step 2- Creating Statement to insert in Database
			PreparedStatement insertQuery = connection.prepareStatement(insertInSql);
			// Step 3- getting data which user had entered
			insertQuery.setString(1, employee.getName());
			insertQuery.setString(2, employee.getSkills());
			insertQuery.setInt(3, employee.getAge());
			insertQuery.setLong(4, employee.getSalary());
			insertQuery.setString(5, employee.getJoinDate());
			// Step 4- checking data and also work as debug point
			System.out.println(insertQuery);
			// Step 5- executing query
			status = insertQuery.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("---------employee data inserted in DB-------");
		return status;
	}
	public int update(Employee employee) throws ClassNotFoundException {
		String updateInSql = "UPDATE employee SET name=?,skills=?,age=?,salary=?,joinDate=? where id=?";
		int status = 0;
		try (Connection connection = EmployeeDao.getConnection();
				PreparedStatement updateQuery = connection.prepareStatement(updateInSql);) {
			updateQuery.setString(1, employee.getName());
			updateQuery.setString(2, employee.getSkills());
			updateQuery.setInt(3, employee.getAge());
			updateQuery.setLong(4, employee.getSalary());
			updateQuery.setString(5, employee.getJoinDate());
			updateQuery.setInt(6, employee.getId());
			System.out.println(updateQuery);
			status = updateQuery.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	public int delete(int id) {
		String deleteFromSql = "DELETE FROM employee where id=?";
		int status = 0;
		try (Connection connection = EmployeeDao.getConnection();
				PreparedStatement deleteQuery = connection.prepareStatement(deleteFromSql);) {
			System.out.println(deleteQuery);
			deleteQuery.setInt(1, id);
			System.out.println("----dao delet -----" + id);
			status = deleteQuery.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	public Employee getOneEmployee(int id) {
		String getDataFromSql = "SELECT * FROM employee where id=? ";
		Employee oneEmployee = new Employee();
		try (Connection connection = EmployeeDao.getConnection();
				PreparedStatement seeOneQuery = connection.prepareStatement(getDataFromSql);) {
			System.out.println(seeOneQuery);
			System.out.println("---- Dao id ----" + id);
			seeOneQuery.setInt(1, id);
			ResultSet oneEmployeeData = seeOneQuery.executeQuery();
			if (oneEmployeeData.next()) {
				oneEmployee.setId(oneEmployeeData.getInt(1));
				oneEmployee.setName(oneEmployeeData.getString(2));
				oneEmployee.setSkills(oneEmployeeData.getString(3));
				oneEmployee.setAge(oneEmployeeData.getInt(4));
				oneEmployee.setSalary(oneEmployeeData.getLong(5));
				oneEmployee.setJoinDate(oneEmployeeData.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return oneEmployee;
	}
	public List<Employee> getAllEmployees() {
		String getAllFromSql = "SELECT * FROM employee";
		List<Employee> listOfAllEmployee = new ArrayList<Employee>();
		try (Connection connection = EmployeeDao.getConnection();
				PreparedStatement seeAllQuery = connection.prepareStatement(getAllFromSql);) {
			System.out.println(seeAllQuery);
			ResultSet allEmployeeDetails = seeAllQuery.executeQuery();
			System.out.println(allEmployeeDetails);
			System.out.println("-----4----geting all data from MySQL-------");
			while (allEmployeeDetails.next()) {
				listOfAllEmployee.add(new Employee(allEmployeeDetails.getInt(1), allEmployeeDetails.getString(2),
						allEmployeeDetails.getString(3), allEmployeeDetails.getInt(4), allEmployeeDetails.getLong(5),
						allEmployeeDetails.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listOfAllEmployee;
	}
}
