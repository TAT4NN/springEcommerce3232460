package com.sena.springEcommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.springEcommerce.model.Producto;
import com.sena.springEcommerce.model.Usuario;
import com.sena.springEcommerce.service.IProductoService;
import com.sena.springEcommerce.service.IUsuarioService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/apiproductos")
public class APIProductoController {

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IUsuarioService usuarioService;

	// EndPoint GET para obtener todos los productos
	@GetMapping("/list")
	public List<Producto> gettAllProducts() {
		return productoService.findAll();
	}

	// End point get para obtener un producto por ID
	@GetMapping("/product/{id}")
	public ResponseEntity<Producto> getProductById(@PathVariable Integer id) {
		Optional<Producto> producto = productoService.get(id);
		return producto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Endpoind POST para crear un nuevo producto
	@PostMapping("/create")
	public ResponseEntity<Producto> createProduct(@RequestBody Producto producto) {
		Usuario u = usuarioService.findById(1).get();
		producto.setUsuario(u);
		if (producto.getImagen() == null) {
			producto.setImagen("default.jpg");
		}
		Producto savedProduct = productoService.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}

	// Endpoind PUT para actualizar un producto
	@PutMapping("/update/{id}")
	public ResponseEntity<Producto> updateProduct(@PathVariable Integer id, @RequestBody Producto productDetails) {
		Optional<Producto> producto = productoService.get(id);
		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Producto existProducto = producto.get();
		existProducto.setNombre(productDetails.getNombre());
		existProducto.setDescripcion(productDetails.getDescripcion());
		existProducto.setPrecio(productDetails.getPrecio());
		existProducto.setCantidad(productDetails.getCantidad());
		// Mantener la imagen existente a menos que se envie una nueva
		if (productDetails.getImagen() != null) {
			existProducto.setImagen(productDetails.getImagen());
		}
		productoService.update(existProducto);
		return ResponseEntity.ok(existProducto);
	}

	// Endpoint DELETE para eliminar un producto
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		Optional<Producto> producto = productoService.get(id);
		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Producto p = producto.get();
		if (!p.getImagen().equals("default.jpg")) {
			//
		}
		productoService.delete(id);
		return ResponseEntity.ok().build();
	}

}
