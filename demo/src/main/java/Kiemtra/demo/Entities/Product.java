package Kiemtra.demo.Entities;

import Kiemtra.demo.Modes.ProductStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String type;
    private String desc;
    private double price;
    private int status; // quy định trạng thái của sản phẩm
    private String image;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;


    public boolean isActive() {
        return this.status == ProductStatus.PRODUCT_ACTIVE;

    }

    public boolean isCancel() {
        return this.status == ProductStatus.PRODUCT_CANCEL;
    }

    public boolean isInactive() {
        return this.status == ProductStatus.PRODUCT_INACTIVE;
    }
}


