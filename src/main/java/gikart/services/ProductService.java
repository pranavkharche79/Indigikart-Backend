package gikart.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import gikart.entities.Product;

public interface ProductService {
	void addProduct(Product p);
	List<Product> findProducts(int sellerId);
	void updateProduct(Product p);
	void deleteProduct(int prodid);
	List<Product> allProducts();
	List<Product> categoryProducts(int pcat);
	Product findProductById(int prodid);
	Page<Product> allProductsPaginated(int page,int pagesize);
}
