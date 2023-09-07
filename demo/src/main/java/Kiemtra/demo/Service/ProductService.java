package Kiemtra.demo.Service;


import Kiemtra.demo.Entities.Product;
import Kiemtra.demo.Modes.ProductStatus;
import Kiemtra.demo.Repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    final ProductRespository productRespository;
    @Autowired
    public ProductService(ProductRespository productRespository){
        this.productRespository = productRespository;
    }
    public Product insert(Product product){
        product.setCreatedDate(LocalDateTime.now());
        return productRespository.save(product);
    }
    public Product update(Product product){
        Optional<Product> optionalProduct = productRespository
                .findById(product.getId());
        if(optionalProduct.isPresent()){
            return productRespository.save(product);
        }
        return null;
    }
    public List<Product> findAll()
    {
        return productRespository.findAll().stream()
                .filter(product -> product.isCancel()==false)
                .collect(Collectors.toList());
    }
    public Product getProductById(Long id) {
        Optional<Product> optional = productRespository.findById(id);
        return optional.orElse(null);
    }
    public Product getProductByName(String name) {
        return productRespository.findByName(name);
    }
    public Product delete (Long id) {
        Optional<Product> optional = productRespository.findById(id);
        if (optional.isPresent()) {
            Product foundProduct = optional.get();
            if (foundProduct.isActive() == true || foundProduct.isInactive() == true) {
                foundProduct.setStatus(ProductStatus.PRODUCT_CANCEL);
            }
            return productRespository.save(foundProduct);
        }
        return null;
    }


}

