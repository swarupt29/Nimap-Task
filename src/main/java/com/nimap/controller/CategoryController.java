package com.nimap.controller;

import com.nimap.dto.CategoryDTO;
import com.nimap.dto.ProductDTO;
import com.nimap.model.Category;
import com.nimap.model.Product;
import com.nimap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	 @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(Pageable pageable) {
        Page<Category> categoryPage = categoryService.getAllCategories(pageable);
        List<CategoryDTO> categoryDTOs = categoryPage.getContent().stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }

	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		Category category = categoryService.getCategoryById(id);
		return convertToCategoryDTO(category);
	}

	@PostMapping
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
		Category category = convertToCategory(categoryDTO);
		Category createdCategory = categoryService.createCategory(category);
		return convertToCategoryDTO(createdCategory);
	}

	@PutMapping("/{id}")
	public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
		Category category = convertToCategory(categoryDTO);
		Category updatedCategory = categoryService.updateCategory(id, category);
		return convertToCategoryDTO(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}

	  private CategoryDTO convertToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    private Category convertToCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
	}
}
