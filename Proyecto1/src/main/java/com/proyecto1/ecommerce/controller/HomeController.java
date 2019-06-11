package com.proyecto1.ecommerce.controller;

import java.util.LinkedList;
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
import com.proyecto1.ecommerce.domain.Carrito;
import com.proyecto1.ecommerce.domain.CategoriaProducto;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.ItemCarrito;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;
import com.proyecto1.ecommerce.form.CategoriaForm;
import com.proyecto1.ecommerce.form.ClienteForm;
import com.proyecto1.ecommerce.form.EmpleadoForm;

@Controller
public class HomeController {

	@Autowired
	private ProductoBusiness productoBusiness;
	private List<ItemCarrito> items;

	public HomeController(List<ItemCarrito> items) {
		this.items = new LinkedList<>();
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String Home(Model model) {
		model.addAttribute("productos", productoBusiness.findAll());
		return "index";
	}

	@RequestMapping(value = "/myAcount", method = RequestMethod.GET)
	public String Acount() {
		return "checkout";
	}

	@RequestMapping(value = "/carrito", method = RequestMethod.GET)
	public String Carrito(Model model) {
		model.addAttribute("items", items);
		return "checkout2";
	}

	@RequestMapping(value = "/checkout2", method = RequestMethod.GET)
	public String checkout2(Model model, @RequestParam("idProducto") int idProducto,
			@RequestParam("nombre") String nombre, @RequestParam("precio") float precio,
			@RequestParam("unidadesExistentes") int unidadesExistentes) {
		ItemCarrito itemCarrito = new ItemCarrito();
		Producto p = new Producto();
		float total=0;
		p.setIdProducto(idProducto);
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setUnidadesExistentes(unidadesExistentes);
		itemCarrito.setProducto(p);
		itemCarrito.setPrecioUnitario(precio);
		itemCarrito.setCantidad(1);
		if (items.size() > 0) {
			if (existe(idProducto)==false) {
				items.add(itemCarrito);
			} else { // incrementamos en 1 la cantidad
				items.get(indexProducto(idProducto)).setCantidad(items.get(indexProducto(idProducto)).getCantidad()+1);
			}
		}else {
			items.add(itemCarrito);
		}
		model.addAttribute("productos", productoBusiness.findAll());
		total = total(items, total);
		model.addAttribute("total", total);
		return "index";
	}

	private int indexProducto(int idProducto) {
		for (int i = 0; i < items.size(); i++) {
			if (idProducto==items.get(i).getProducto().getIdProducto()) {
				return i;
			}
		}
		return 0;
	}

	private boolean existe(int idProducto) {
		for (int i = 0; i < items.size(); i++) {
			if (idProducto==items.get(i).getProducto().getIdProducto())
				return true;
		}
		return false;
	}
	
	private float total(List<ItemCarrito> items, float total) {
		  for (int i = 0; i < items.size(); i++) {
		   total = total + (items.get(i).getCantidad() * items.get(i).getPrecioUnitario());
		  }
		  return total;
		 }

	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public String bill() {
		return "bill";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String Product(Model model, @RequestParam("nombre") String nombre, @RequestParam("precio") float precio,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("unidadesExistentes") int unidadesExistentes) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("precio", precio);
		model.addAttribute("descripcion", descripcion);
		model.addAttribute("unidadesExistentes", unidadesExistentes);
		return "product";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "header";
	}

	@RequestMapping(value = "/menuAdmin", method = RequestMethod.GET)
	public String menuAdmin() {
		return "menuAdmin";
	}



}
