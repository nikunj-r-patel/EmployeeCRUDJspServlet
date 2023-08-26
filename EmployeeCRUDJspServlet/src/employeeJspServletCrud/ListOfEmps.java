package employeeJspServletCrud;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ListOfEmps")
public class ListOfEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao;
	public void init() {
		employeeDao = new EmployeeDao();
	}
	public ListOfEmps() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employee> allEmployees = employeeDao.getAllEmployees();
		System.out.println(allEmployees);
		request.setAttribute("listOfAllEmployee", allEmployees);
		request.getRequestDispatcher("/WEB-INF/views/employeeDetails.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
