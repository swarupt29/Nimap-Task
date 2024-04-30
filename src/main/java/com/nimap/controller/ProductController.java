package com.nimap.controller;

import com.nimap.dto.ProductDTO;
import com.nimap.model.Product;
import com.nimap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<ProductDTO> getAllProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Page<Product> productPage = productService.getAllProducts(PageRequest.of(page, size));
		List<ProductDTO> productDTOs = productPage.getContent().stream().map(this::convertToProductDTO)
				.collect(Collectors.toList());
		return productDTOs;
	}

	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		return convertToProductDTO(product);
	}

	@PostMapping
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		Product product = convertToProduct(productDTO);
		Product createdProduct = productService.createProduct(product);
		return convertToProductDTO(createdProduct);
	}

	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		Product product = convertToProduct(productDTO);
		Product updatedProduct = productService.updateProduct(id, product);
		return convertToProductDTO(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

	private ProductDTO convertToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());

		productDTO.setCategoryName(product.getCategory().getName());

		return productDTO;
	}

	private Product convertToProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());

		return product;
	}
}
