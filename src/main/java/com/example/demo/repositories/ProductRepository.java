package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Product;
import com.example.demo.repositories.projections.ProductProjection;

public interface ProductRepository extends JpaRepository<Product,Long>{
    // example of HQL(Hibernate Query Language)
//    @Query("SELECT p FROM Product p where p.title = :title")
//    List<Product> findProductWithTitle(@Param("title") String title);

    //example of use of projections
//    @Query("SELECT p.title, p.price, p.description FROM Product where p.price = :price")
//    List<ProductProjection> findProductWithPrice(@Param("price") double price);

    // example of JPA Query Methods
    Product findByIdIs(Long id);
    List<Product> findAll();
    List<Product> findAllByCategory_Title(String title);

    //example of a native query
//    @Query(value = "SELECT * FROM product p where p.category.title=:categoryName and p.price=:price",nativeQuery = true)
//    List<Product> findProductWithCategoryAndPrice(@Param("categoryName") String name, @Param("price") double price);
}
