package com.proyecto1.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String Home() {
		return "index";
	}
	
	@RequestMapping(value="/myAcount", method = RequestMethod.GET)
	public String Acount() {
		return "checkout";
	}
	
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public String Acount2() {
		return "checkout2";
	}
	
	@RequestMapping(value="/category", method = RequestMethod.GET)
	public String Categories() {
		return "store";
	}
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String Product() {
		return "product";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProduct() {
		return "addProduct";
	}
	
	@RequestMapping(value="/productMaintenance", method = RequestMethod.GET)
	public String productMaintenance() {
		return "productMaintenance";
	}
	@RequestMapping(value="/editProduct", method = RequestMethod.GET)
	public String editProduct() {
		return "editProduct";
	}
	
	@RequestMapping(value="/addClient", method = RequestMethod.GET)
	public String addClient() {
		return "addClient";
	}
	@RequestMapping(value="/clientMaintenance", method = RequestMethod.GET)
	public String clientMaintenance() {
		return "clientMaintenance";
	}
	@RequestMapping(value="/editClient", method = RequestMethod.GET)
	public String editClient() {
		return "editClient";
	}
	@RequestMapping(value="/addEmployee", method = RequestMethod.GET)
	public String addEmployee() {
		return "addEmployee";
	}
	@RequestMapping(value="/employeeMaintenance", method = RequestMethod.GET)
	public String employeeMaintenance() {
		return "employeeMaintenance";
	}
	@RequestMapping(value="/editEmployee", method = RequestMethod.GET)
	public String editEmployee() {
		return "editEmployee";
	}
	@RequestMapping(value="/addShippingAddress", method = RequestMethod.GET)
	public String addShippingAddress() {
		return "addShippingAddress";
	}
	@RequestMapping(value="/shippingAddressMaintenance", method = RequestMethod.GET)
	public String shippingAddressMaintenance() {
		return "shippingAddressMaintenance";
	}
	@RequestMapping(value="/editShippingAddress", method = RequestMethod.GET)
	public String editShippingAddress() {
		return "editShippingAddress";
	}
	@RequestMapping(value="/addCategory", method = RequestMethod.GET)
	public String addCategory() {
		return "addCategory";
	}
	@RequestMapping(value="/categoryMaintenance", method = RequestMethod.GET)
	public String categoryMaintenance() {
		return "categoryMaintenance";
	}
	@RequestMapping(value="/editCategory", method = RequestMethod.GET)
	public String editCategory() {
		return "editCategory";
	}
	@RequestMapping(value="/menuAdmin", method = RequestMethod.GET)
	public String menuAdmin() {
		return "menuAdmin";
	}
	
}
