package com.neu.final_project.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.PrimitiveIterator.OfDouble;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.neu.final_project.dao.EmployeeDAO;
import com.neu.final_project.dao.UserDAO;
import com.neu.final_project.pojo.Employee;
import com.neu.final_project.pojo.User;
import com.neu.final_project.validator.EmployeeRegisterValidator;


@Controller
public class EmployeeController {

	@Autowired
	@Qualifier("employeeDAO")
	EmployeeDAO emplyeeDAO;
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("employeeRegisterValidator")
	EmployeeRegisterValidator employeeRegisterValidator;

	// redirect to employee login page
	@RequestMapping(value = "/employee/login", method = RequestMethod.GET)
	public String showEmployeeLoginPage(HttpServletRequest request) {	
		if(request.getSession().getAttribute("employee")!=null){
			return "/employee/EmployeeHomeIndex";
		}
		return "employee/EmployeeLogin";
	}

	// process employee login
	@RequestMapping(value = "/employee/login", method = RequestMethod.POST)
	public String loginEmployee(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		Employee employee = emplyeeDAO.loginEmployee(username, password);
		if(employee==null){
			request.setAttribute("errorMessage", "Employee username/password pair not found");
			return "employee/EmployeeLogin";
		}else{
			request.getSession().setAttribute("employee", employee);
			return "employee/EmployeeHomeIndex";
		}
		
	}	

	// redirect to admin manage account page
	@RequestMapping(value = "/employee/admin-manage-accounts", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "employee/AdminManageAccount";
	}

	// process admin add pns request
	@RequestMapping(value = "/employee/admin-manage-accounts/add", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("employee") Employee employee, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();

		employeeRegisterValidator.validate(employee, result);

		employee.setUsername(HtmlUtils.htmlUnescape(employee.getUsername()));
		employee.setEmail(HtmlUtils.htmlEscape(employee.getEmail()));
		employee.setPassword(HtmlUtils.htmlEscape(employee.getPassword()));
		employee.setFirstName(HtmlUtils.htmlEscape(employee.getFirstName()));
		employee.setLastName(HtmlUtils.htmlEscape(employee.getLastName()));
		employee.setAccountType("pns");
		
		if (result.hasErrors())
			return new ModelAndView("/employee/AdminManageAccount");

		String status = emplyeeDAO.createPns(employee);

		if (status.equals("success")) {
			modelAndView.addObject(new Employee());
			modelAndView.addObject("message", "Employee succuessfully added");
			modelAndView.setViewName("employee/AdminManageAccount");
		} else {
			modelAndView.addObject("message", "Error occured, please try again");
			modelAndView.setViewName("employee/AdminManageAccount");
		}

		return modelAndView;
	}
	
	//redirect to view account detail page
	@RequestMapping(value="/employee/admin-manage-accounts/view", method = RequestMethod.GET)
	public ModelAndView viewAccountDetailPage(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = emplyeeDAO.getEmployee(Integer.parseInt(request.getParameter("accountId")));
		if (employee==null){
			User user = userDAO.getUser(Integer.parseInt(request.getParameter("accountId")));
			modelAndView.addObject("user",user);
			modelAndView.setViewName("employee/ViewUserAccountDetail");
		}else{
			modelAndView.addObject("employee",employee);
			modelAndView.setViewName("employee/ViewEmployeeAccountDetail");
		}
		
		return modelAndView;		
	}
	
	//process modify employee account request
	@RequestMapping(value = "/employee/admin-manage-accounts/manage-employee", method = RequestMethod.POST)
	public String manageEmployee(Employee employee, HttpServletRequest request){
		String action = request.getParameter("update");
		if (action.equals("Submit Changes")){
			emplyeeDAO.updateEmployee(employee);
		}else{
			emplyeeDAO.deleteEmployee(employee);
		}
		return "redirect:/employee/admin-manage-accounts";
	}
	
	//process modify user account request
	@RequestMapping(value = "/employee/admin-manage-accounts/manage-user", method = RequestMethod.POST)
	public String manageUser(User user){
		userDAO.deleteUser(user);
		return "redirect:/employee/admin-manage-accounts";
	}
}
