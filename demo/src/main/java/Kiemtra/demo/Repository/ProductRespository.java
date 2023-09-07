package Kiemtra.demo.Repository;

import Kiemtra.demo.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product,Long> {
    Product findByName(String name);
}
