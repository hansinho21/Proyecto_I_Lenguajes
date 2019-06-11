package com.proyecto1.ecommerce.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

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
import com.proyecto1.ecommerce.pdf.util.GeneratePDFReport;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class HomeController {

	@Autowired
	private ProductoBusiness productoBusiness;
	@Autowired
	private ClienteBusiness clienteBusiness;
	private List<ItemCarrito> items;

	public HomeController(List<ItemCarrito> items) {
		this.items = new LinkedList<>();
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String Home(Model model)  {
		  Collection<? extends GrantedAuthority> authorities;
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  authorities = authentication.getAuthorities();
		  boolean isCustomer = false;
		  boolean isAdmin = false;
		  for (GrantedAuthority grantedAuthority : authorities) {
		   if (grantedAuthority.getAuthority().equals("ROLE_COSTUMER")) {
		    isCustomer = true;
		    break;
		   } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
		    isAdmin = true;
		    break;
		   }
		  }//for
		  if (isCustomer) {
		   model.addAttribute("productos", productoBusiness.findAll());
		   return "index";
		  } else if (isAdmin) {
		   return "menuAdmin";
		  } else {
		   throw new IllegalStateException();
		  }
		 }

	@RequestMapping(value = "/myAcount", method = RequestMethod.GET)
	public String Acount() {
		return "checkout";
	}

	
	@RequestMapping(value = "/pdfreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> PDFReport() throws IOException {

	  //List<City> cities = (List<City>) cityService.findAll();
	  
	  List<Cliente> c=clienteBusiness.findAll();
	  ByteArrayInputStream bis = GeneratePDFReport.PDFReport(c,"Clientes");

	  HttpHeaders headers = new HttpHeaders();
	  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	  return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
	    .body(new InputStreamResource(bis));
	 }
	
	@RequestMapping(value = "/deleteFromCarrito", method = RequestMethod.GET)
	public String deleteFromCarrito(Model model, @RequestParam("idProducto") int idProducto, @RequestParam("precio") float precio
			, @RequestParam("unidadesExistentes") int unidadesExistentes) {
		int index = indexProducto(idProducto);
		items.remove(index);
		System.out.println(items.toString());
		model.addAttribute("items",items);
		return "checkout2";
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
