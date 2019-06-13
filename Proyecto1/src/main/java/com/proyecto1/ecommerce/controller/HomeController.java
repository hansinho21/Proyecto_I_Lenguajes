package com.proyecto1.ecommerce.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
import com.proyecto1.ecommerce.business.DireccionEnvioBusiness;
import com.proyecto1.ecommerce.business.EmpleadoBusiness;
import com.proyecto1.ecommerce.business.ItemCarritoBusiness;
import com.proyecto1.ecommerce.business.OrdenBusiness;
import com.proyecto1.ecommerce.business.ProductoBusiness;
import com.proyecto1.ecommerce.business.RolBusiness;
import com.proyecto1.ecommerce.data.ClienteData;
import com.proyecto1.ecommerce.domain.Carrito;
import com.proyecto1.ecommerce.domain.CategoriaProducto;
import com.proyecto1.ecommerce.domain.Cliente;
import com.proyecto1.ecommerce.domain.DireccionEnvio;
import com.proyecto1.ecommerce.domain.Empleado;
import com.proyecto1.ecommerce.domain.EstadoOrden;
import com.proyecto1.ecommerce.domain.ItemCarrito;
import com.proyecto1.ecommerce.domain.Orden;
import com.proyecto1.ecommerce.domain.Producto;
import com.proyecto1.ecommerce.domain.Rol;
import com.proyecto1.ecommerce.form.CategoriaForm;
import com.proyecto1.ecommerce.form.ClienteForm;
import com.proyecto1.ecommerce.form.DireccionEnvioForm;
import com.proyecto1.ecommerce.form.EmpleadoForm;
import com.proyecto1.ecommerce.form.ProductoForm;
import com.proyecto1.ecommerce.pdf.util.GeneratePDFReport;
import com.proyecto1.ecommerce.utils.Utilidades;
import com.proyecto1.ecommerce.utils.*;

import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class HomeController {

	@Autowired
	private ProductoBusiness productoBusiness;
	@Autowired
	private ClienteBusiness clienteBusiness;
	@Autowired 
	DireccionEnvioBusiness direccionEnvioBusiness;
	@Autowired
	ItemCarritoBusiness itemCarritoBusiness;
	@Autowired
	OrdenBusiness ordenBusiness;
	@Autowired
	CategoriaProductoBusiness categoriaProductoBusiness;
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
		   model.addAttribute("categorias", categoriaProductoBusiness.findAll());
		   return "index";
		  } else if (isAdmin) {
		   return "menuAdmin";
		  } else {
		   throw new IllegalStateException();
		  }
		 }

	@RequestMapping(value = "/myAcount", method = RequestMethod.GET)
	public String addProduct(Model model) {
		model.addAttribute("direccionEnvioForm", new DireccionEnvioForm());
		return "checkout";
	}
	
	@RequestMapping(value = "/myAcount", method = RequestMethod.POST)
	public String checkout(@Valid DireccionEnvioForm direccionEnvioForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("direccionEnvioForm", new DireccionEnvioForm());
			return "checkout";
		} else {
			DireccionEnvio direccionEnvio = new DireccionEnvio();
			BeanUtils.copyProperties(direccionEnvioForm, direccionEnvio);
			direccionEnvio.getCliente().setIdCliente(3);
			direccionEnvioBusiness.insert(direccionEnvio);
			for (int i = 0; i < items.size(); i++) {
				itemCarritoBusiness.insert(items.get(i));
			}
			/*for (int i = 0; i < items.size(); i++) {
				items.remove(i);
			}
		*/	
			model.addAttribute("items",items);
			return "bill";
		}
	}

	
	@RequestMapping(value = "/ventasReport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	  public ResponseEntity<InputStreamResource> PDFReport() throws IOException {   
	  HashMap<Producto, Integer> productos = new HashMap<Producto, Integer>();
	  productos = productoBusiness.reporteProductosVendidos();  
	   ByteArrayInputStream bis = GeneratePDFReport.ventasReport(productos);

	   HttpHeaders headers = new HttpHeaders();
	   headers.add("Content-Disposition", "inline; filename=ventasReport.pdf");

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
	
	
	/*@RequestMapping(value = "/addShippingAdress", method = RequestMethod.POST)
	public String checkout(@Valid DireccionEnvioForm direccionEnvioForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("direccionEnvioForm", new DireccionEnvioForm());
			return "checkout";
		} else {
			DireccionEnvio direccionEnvio = new DireccionEnvio();
			BeanUtils.copyProperties(direccionEnvioForm, direccionEnvio);
			direccionEnvio.getCliente().setIdCliente(3);
			direccionEnvioBusiness.insert(direccionEnvio);
			return "bill";
		}
	}
	
	*/
	@RequestMapping(value = "/carrito", method = RequestMethod.GET)
	public String Carrito(Model model) {
		model.addAttribute("items", items);
		return "checkout2";
	}
	
	
	@RequestMapping(value = "/factura", method = RequestMethod.GET)
	public String Factura(Model model) {
		String d= Utilidades.getCurrentTimeUsingDate();
		model.addAttribute("fecha",d);
		model.addAttribute("items", items);
		EstadoOrden estadoOrden= new EstadoOrden();
		estadoOrden.setIdEstadoOrden(6);
		estadoOrden.setEstadoOrden("Saliendo del vendedor");
		Orden orden= new Orden();
		orden.getCliente().setIdCliente(3);
		//orden.setCliente(new Cliente(3, "juan@gmail.com", "user", "Juan", "Araya"));
		orden.setEstadoOrden(estadoOrden);
		//orden.setFechaEnvio(Utilidades.getCurrentTimeUsingDate());
		//orden.setFechaOrden(Utilidades.getCurrentTimeUsingDate());
		orden.setValorEnvio(3000);
		float total=0;
		orden.setValorProductos(total(items, total));
		orden.setValorTotal(total(items, total));
		//ordenBusiness.insert(orden);
		ordenBusiness.confirmarOrden(orden);
		return "bill";
	}

	@RequestMapping(value = "/checkout2", method = RequestMethod.GET)
	public String checkout2(Model model, @RequestParam("idProducto") int idProducto,
			@RequestParam("nombre") String nombre, @RequestParam("precio") float precio,
			@RequestParam("unidadesExistentes") int unidadesExistentes) {
		ItemCarrito itemCarrito = new ItemCarrito();
		Producto p = new Producto();
		float total=0;
		Cliente cliente = new Cliente(3, "juan@gmail.com", "user", "Juan", "Araya");
		p.setIdProducto(idProducto);
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setUnidadesExistentes(unidadesExistentes);
		itemCarrito.setProducto(p);
		itemCarrito.setPrecioUnitario(precio);
		itemCarrito.setCantidad(1);
		itemCarrito.setCliente(cliente);
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
