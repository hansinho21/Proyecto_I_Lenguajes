package com.proyecto1.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto1.ecommerce.business.ClienteBusiness;
import com.proyecto1.ecommerce.business.RolBusiness;
import com.proyecto1.ecommerce.data.ClienteData;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Rol;
import com.proyecto1.ecommerce.form.ClienteForm;

@Controller
public class HomeController {
	
	@Autowired
	private RolBusiness rolBusiness;
	@Autowired
	private ClienteBusiness clienteBusiness;

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
	public String addClient(Model model) {
		model.addAttribute("roles", rolBusiness.findAll());
		model.addAttribute("clienteForm", new ClienteForm());
		return "addClient";
	}
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public String agregar(@Valid ClienteForm clienteForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("roles", rolBusiness.findAll());
			model.addAttribute("libroForm", clienteForm);
			return "addClient";
		} else {
			Cliente cliente = new Cliente();
			BeanUtils.copyProperties(clienteForm, cliente);
			cliente.getRol().setIdRol(clienteForm.getIdRol());
			clienteBusiness.insert(cliente);
			return "success";
		}
	}
	
	@RequestMapping(value="/success", method = RequestMethod.GET)
	public String success() {
		return "success";
	}
	@RequestMapping(value="/clientMaintenance", method = RequestMethod.GET)
	public String clientMaintenance(Model model) {
		model.addAttribute("clientes", clienteBusiness.findAll());
		return "clientMaintenance";
	}
	
	@RequestMapping(value="/clientMaintenance", method = RequestMethod.POST)
	public String findClientByEmail(Model model, @RequestParam("correo") String correoCliente) {
		model.addAttribute("clientes", clienteBusiness.findByEmail(correoCliente));
		return "clientMaintenance";
	}
	
	@RequestMapping(value="/editClient", method = RequestMethod.GET)
	public String cargarClient(Model model, @RequestParam("idCliente") int idCliente,@RequestParam("contrasenaCliente") String contrasena,
			@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
			@RequestParam("correo") String correo) {
		model.addAttribute("idCliente", idCliente);
		model.addAttribute("contrasenaCliente", contrasena);
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellidosCliente", apellidos);
		model.addAttribute("correoCliente", correo);
		model.addAttribute("roles", rolBusiness.findAll());
		model.addAttribute("clienteForm", new ClienteForm());
		return "editClient";
	}
	
	@RequestMapping(value="/editClient", method = RequestMethod.POST)
	public String editarCliente(@Valid ClienteForm clienteForm,Model model, @RequestParam("idCliente") int idCliente,@RequestParam("contrasenaCliente") String contrasena,
			@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
			@RequestParam("correo") String correo,@RequestParam("idRol") int idRol) {
		Cliente cliente= new Cliente();
		cliente.getRol().setIdRol(clienteForm.getIdRol());
		cliente.setIdCliente(idCliente);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setCorreo(correo);
		cliente.setContrasenaCliente(contrasena);
		clienteBusiness.update(cliente);
		return "success";
	}	
	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String eliminarCliente(Model model, @RequestParam("idCliente") int idCliente) {
		model.addAttribute("idCliente",idCliente);
		clienteBusiness.delete(idCliente);
		return "success";
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
