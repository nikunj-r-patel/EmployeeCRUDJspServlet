package employeeJspServletCrud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/")
public class EmployeeServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeDao employeeDao;
    public void init() {
    	employeeDao=new EmployeeDao(); 
    } 
    public EmployeeServletController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action= request.getServletPath();
		try {
//			if(action.equals("/register")) {
//				newEmpForm(request,response);
//			}
			if(action.equals("/list")) {
				listOfEmps(request,response);
			}
			else if(action.equals("/insert")) {
				addNewEmp(request,response);
			}
			else if(action.equals("/edit")) {
				editEmpForm(request,response);
			}
			else if(action.equals("/update")) {
				updateEmpdata(request,response);
			}
			else if(action.equals("/delete")) {
				deleteEmpData(request,response);
			}else {
//				listOfEmps(request,response);
				newEmpForm(request,response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	private void newEmpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println("---------showing form to add employee-------");
		request.getRequestDispatcher("/WEB-INF/views/employeeRegister.jsp").forward(request, response);
	}
	private void addNewEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		System.out.println("---------got data inserted by user-------");
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
	private void editEmpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("--------id edit in controller  --"+id);
		Employee getAnEmployee=employeeDao.getOneEmployee(id);
		System.out.println("--------old employee at id   --"+id);
		System.out.println(getAnEmployee);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/views/employeeUpdate.jsp");
		request.setAttribute("employeeEdit", getAnEmployee);
		requestDispatcher.forward(request, response);
	}
	private void updateEmpdata(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int id= Integer.parseInt(request.getParameter("empId"));
		String newName = request.getParameter("newEmpName");
		String newSkills = request.getParameter("newEmpSkills");
		String newAge = request.getParameter("newEmpAge");
		String newSalary = request.getParameter("newEmpSalary");
		String newJoinDate = request.getParameter("newEmpJoinDate");
		Employee newEmpDetail=new Employee();
		newEmpDetail.setId(id);
		newEmpDetail.setName(newName);
		newEmpDetail.setSkills(newSkills);
		newEmpDetail.setAge(Integer.parseInt(newAge));
		newEmpDetail.setSalary(Long.parseLong(newSalary));
		newEmpDetail.setJoinDate(newJoinDate);
		System.out.println("--------new employee at id   --"+id);
		System.out.println(newEmpDetail);
		try {
			int status=employeeDao.update(newEmpDetail);
			System.out.println("----update status ----"+status);
			if(status>0) {
				out.println("<h1>Employee Updated Successfully!!</h1>");
				response.sendRedirect("ListOfEmps");
			}else {
				out.println("<h3>The Employee is not updated</h3>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deleteEmpData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int id= Integer.parseInt(request.getParameter("id"));
		try {
			int status=employeeDao.delete(id);
			if(status>0) {
				out.println("<h1>Employee Deleted Successfully!!</h1>");
				response.sendRedirect("ListOfEmps");
			}else {
				out.println("<h3>The Employee is not in List</h3>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void listOfEmps(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		List<Employee> allEmployees= employeeDao.getAllEmployees();
//		System.out.println(allEmployees);
//		request.setAttribute("listOfAllEmployee", allEmployees);
//		request.getRequestDispatcher("/WEB-INF/views/employeeDetails.jsp").forward(request, response);
		response.sendRedirect("ListOfEmps");
	}
}
