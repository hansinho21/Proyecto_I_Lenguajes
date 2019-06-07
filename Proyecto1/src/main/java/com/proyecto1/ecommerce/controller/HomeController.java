package com.proyecto1.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto1.ecommerce.business.CategoriaProductoBusiness;
import com.proyecto1.ecommerce.business.ClienteBusiness;
import com.proyecto1.ecommerce.business.EmpleadoBusiness;
import com.proyecto1.ecommerce.business.ProductoBusiness;
import com.proyecto1.ecommerce.business.RolBusiness;
import com.proyecto1.ecommerce.data.ClienteData;
import com.proyecto1.ecommerce.domain.CategoriaProducto;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;
import com.proyecto1.ecommerce.form.CategoriaForm;
import com.proyecto1.ecommerce.form.ClienteForm;
import com.proyecto1.ecommerce.form.EmpleadoForm;

@Controller
public class HomeController {
	
	@Autowired
	private RolBusiness rolBusiness;
	@Autowired
	private ClienteBusiness clienteBusiness;
	@Autowired 
	private EmpleadoBusiness empleadoBusiness;
	@Autowired
	private CategoriaProductoBusiness categoriaBusiness;
	@Autowired
	private ProductoBusiness productoBusiness;

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String Home(Model model) {
		model.addAttribute("productos", productoBusiness.findAll());
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
	
	@RequestMapping(value="/addCategory", method = RequestMethod.GET)
	public String addCategory(Model model) {
		model.addAttribute("categoriaForm", new CategoriaForm());
		return "addCategory";
	}
	
	@RequestMapping(value="/addCategory", method = RequestMethod.POST)
	public String AgregarCategories(@Valid CategoriaForm categoriaForm, BindingResult br, Model model) {
			if (br.hasErrors()) {
				model.addAttribute("categoriaForm", categoriaForm);
				return "addCategory";
			} else {
				CategoriaProducto categoria = new CategoriaProducto();
				BeanUtils.copyProperties(categoriaForm, categoria);
				categoriaBusiness.insert(categoria.getNombreCategoria());
				return "success";
			}
		}
	
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String Product(Model model, @RequestParam("nombre") String nombre, @RequestParam("precio") float precio, @RequestParam("descripcion")
	 String descripcion, @RequestParam("unidadesExistentes") int unidadesExistentes) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("precio", precio);
		model.addAttribute("descripcion", descripcion);
		model.addAttribute("unidadesExistentes", unidadesExistentes);
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
			model.addAttribute("clienteForm", clienteForm);
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
	public String loadAddEmployee(Model model) {
		model.addAttribute("roles", rolBusiness.findAll());
		model.addAttribute("empleadoForm", new EmpleadoForm());
		return "addEmployee";
	}
	
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@Valid EmpleadoForm empleadoForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("roles", rolBusiness.findAll());
			model.addAttribute("empleadoForm", empleadoForm);
			return "addEmployee";
		} else {
			Empleado empleado = new Empleado();
			BeanUtils.copyProperties(empleadoForm, empleado);
			empleado.getRol().setIdRol(empleadoForm.getIdRol());
			empleadoBusiness.insert(empleado);
			return "success";
		}
	}
	
	@RequestMapping(value="/employeeMaintenance", method = RequestMethod.GET)
	public String employeeMaintenance(Model model) {
		model.addAttribute("empleados", empleadoBusiness.findAll());
		return "employeeMaintenance";
	}
	@RequestMapping(value="/editEmployee", method = RequestMethod.GET)
	public String cargarEmployee(Model model, @RequestParam("idEmpleado") int idEmpleado,@RequestParam("contrasenaEmpleado") String contrasena,
			@RequestParam("nombreEmpleado") String nombre, @RequestParam("apellidosEmpleado") String apellidosEmpleado,
			@RequestParam("correoEmpleado") String correo,@RequestParam("telefonoOficina") String telefono,@RequestParam("departamento") String departamento) {
		model.addAttribute("idEmpleado", idEmpleado);
		model.addAttribute("telefonoOficina", telefono);
		model.addAttribute("departamento", departamento);
		model.addAttribute("contrasenaEmpleado", contrasena);
		model.addAttribute("nombreEmpleado", nombre);
		model.addAttribute("apellidosEmpleado", apellidosEmpleado);
		model.addAttribute("correoEmpleado", correo);
		model.addAttribute("roles", rolBusiness.findAll());
		model.addAttribute("empleadoForm", new EmpleadoForm());
		return "editEmployee";
	}
	
	@RequestMapping(value="/editEmployee", method = RequestMethod.POST)
	public String editarEmployee(Model model, @RequestParam("idEmpleado") int idEmpleado,@RequestParam("contrasenaEmpleado") String contrasena,
			@RequestParam("nombreEmpleado") String nombre, @RequestParam("apellidosEmpleado") String apellidosEmpleado,
			@RequestParam("correoEmpleado") String correo,@RequestParam("telefonoOficina") String telefono,
			@RequestParam("departamento") String departamento,@RequestParam("idRol") int idRol) {
		Empleado empleado = new Empleado();
		empleado.setNombreEmpleado(nombre);
		empleado.setApellidosEmpleado(apellidosEmpleado);
		empleado.setCorreoEmpleado(correo);
		empleado.setContrasenaEmpleado(contrasena);
		empleado.setDepartamento(departamento);
		empleado.setTelefonoOficina(telefono);
		empleado.setIdEmpleado(idEmpleado);
		empleado.getRol().setIdRol(idRol);
		empleadoBusiness.update(empleado);
		return "success";
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String eliminarEmpleado(Model model, @RequestParam("idEmpleado") int idEmpleado) {
		model.addAttribute("idEmpleado",idEmpleado);
		empleadoBusiness.delete(idEmpleado);
		return "success";
	}
	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public String eliminarCategoria(Model model, @RequestParam("idCategoriaProducto") int idCategoriaProducto) {
		model.addAttribute("idCategoriaProducto",idCategoriaProducto);
		categoriaBusiness.delete(idCategoriaProducto);
		return "success";
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
	
	@RequestMapping(value="/categoryMaintenance", method = RequestMethod.GET)
	public String categoryMaintenance(Model model) {
		model.addAttribute("categorias", categoriaBusiness.findAll());
		return "categoryMaintenance";
	}
	
	@RequestMapping(value="/categoryMaintenance", method = RequestMethod.POST)
	public String categoryMaintenance() {
		return "categoryMaintenance";
	}
	
	
	@RequestMapping(value="/editCategory", method = RequestMethod.GET)
	public String cargarCategory(Model model, @RequestParam("idCategoriaProducto") int idCategoria,@RequestParam("nombreCategoria") String nombreCategoria) {
		model.addAttribute("idCategoriaProducto", idCategoria);
		model.addAttribute("nombreCategoria", nombreCategoria);
		return "editCategory";
	}
	
	@RequestMapping(value="/editCategory", method = RequestMethod.POST)
	public String editCategory(Model model, @RequestParam("idCategoriaProducto") int idCategoria,@RequestParam("nombreCategoria") String nombreCategoria) {
		CategoriaProducto categoriaProducto = new CategoriaProducto();
		categoriaProducto.setNombreCategoria(nombreCategoria);
		categoriaProducto.setIdCategoriaProducto(idCategoria);
		categoriaBusiness.update(categoriaProducto);
		return "succes";
	}
		
	@RequestMapping(value="/menuAdmin", method = RequestMethod.GET)
	public String menuAdmin() {
		return "menuAdmin";
	}
	@RequestMapping(value="/addRol", method = RequestMethod.GET)
	public String addRol() {
		return "addRol";
	}
	@RequestMapping(value="/RolMaintenance", method = RequestMethod.GET)
	public String RolMaintenance() {
		return "RolMaintenance";
	}
	@RequestMapping(value="/addBrand", method = RequestMethod.GET)
	public String addBrand() {
		return "addBrand";
	}
	@RequestMapping(value="/brandMaintenance", method = RequestMethod.GET)
	public String brandMaintenance() {
		return "brandMaintenance";
	}
	
}
