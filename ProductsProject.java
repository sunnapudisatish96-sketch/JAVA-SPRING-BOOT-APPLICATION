package Tutorials.com.java.spring_boot_sixth_Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSixthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSixthApplication.class, args);
	}

}

package Tutorials.com.java.spring_boot_sixth_Application;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id  
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "popularity", nullable = false)
    private int popularity;

 
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
package Tutorials.com.java.spring_boot_sixth_Application;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

}
package Tutorials.com.java.spring_boot_sixth_Application;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
INSERT INTO product (product_id, product_name, description, price, popularity) VALUES
(100, 'Satish', 'pen', 5.0, 1),
(102, 'Rajesh', 'Book', 10.0, 3),
(108, 'Pradeep', 'beg', 23.0, 8),
(109, 'Ramu', 'phone', 15000.0, 7);
CREATE TABLE product (
    product_id BIGINT NOT NULL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    popularity INT NOT NULL
);
spring.application.name=spring-boot-sixth-Application
server.port=8088

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.ClassdriverName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show.sql=true