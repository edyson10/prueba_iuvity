package com.example.demo.Controller;

import com.example.demo.DTO.Message;
import com.example.demo.Entity.Product;
import com.example.demo.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @GetMapping("/listarProductos")
    public ResponseEntity<List<Product>> listProduct(){
        List<Product> products = productServices.listProduct();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity saveProduct(@RequestBody Product product) {

        Product producto = new Product(product.getCategoria(), product.getNombre(),
                product.getCantidad(), product.getStock(), product.getPrecio_costo(), product.getPrecio_costo());

        productServices.saveProduct(producto);
        return new ResponseEntity(new Message("Se creo con éxito el producto"), HttpStatus.OK);
    }

    @PutMapping(path = "/updateProduct/{idProduct}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity updateProduct(@PathVariable("idProduct") int idProduct, @RequestBody Product product){

        if (!productServices.existsByIdProduct(idProduct))
            return new ResponseEntity(new Message("No existe la torre"), HttpStatus.NOT_FOUND);

        if (product.getCantidad() < 0 || (Integer) product.getCantidad() == null)
            return new ResponseEntity(new Message("La cantidad de aptos debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        Product prod = productServices.getProduct(idProduct).get();
        prod.setCantidad(prod.getCantidad() + product.getCantidad());
        productServices.saveProduct(prod);

        return new ResponseEntity(new Message("El producto ha sido actualizado."), HttpStatus.OK);
    }

    @PutMapping(path = "/makeSale/{idProduct}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity makeSale(@PathVariable("idProduct") int idProduct, @RequestBody Product product){
        Product prod = productServices.getProduct(idProduct).get();
         if (prod.getCantidad() == prod.getStock())
             return new ResponseEntity(new Message("No se puede realizar la venta, la cantidad iguala al stock."), HttpStatus.BAD_REQUEST);

        prod.setCantidad(prod.getCantidad() - product.getCantidad());
        productServices.saveProduct(prod);

        return new ResponseEntity(new Message("Se ha realizado la venta con éxito."), HttpStatus.OK);
    }

}
