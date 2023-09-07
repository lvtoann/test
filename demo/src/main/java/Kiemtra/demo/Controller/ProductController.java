package Kiemtra.demo.Controller;


import Kiemtra.demo.Entities.Product;
import Kiemtra.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")


public class ProductController {
    final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()
    {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product){
        return ResponseEntity.ok(productService.update(product));

    }
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Product product){
        return ResponseEntity.ok(productService.insert(product));

    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ResponseEntity.ok(productService.delete(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = productService.getProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}