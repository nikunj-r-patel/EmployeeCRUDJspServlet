package employeeJspServletCrud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServletOnlyInsert")
public class EmployeeServletOnlyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDao();
	public EmployeeServletOnlyInsert() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/views/employeeRegister.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name = request.getParameter("empName");
		String skills = request.getParameter("empSkills");
		String age = request.getParameter("empAge");
		String salary = request.getParameter("empSalary");
		String joinDate = request.getParameter("empJoinDate");
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSkills(skills);
		employee.setAge(Integer.parseInt(age));
		employee.setSalary(Long.parseLong(salary));
		employee.setJoinDate(joinDate);
		System.out.println(employee);
		try {
			int status=employeeDao.save(employee);
			if(status>0) {
				out.println("<h1>Employee Registerd Successfully!!</h1>");
				request.getRequestDispatcher("/WEB-INF/views/employeeRegister.jsp").include(request, response);
			}else {
				out.println("<h3>The Employee is not saved to List</h3>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
