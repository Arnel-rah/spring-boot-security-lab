package hei.school.springbootsecuritylab.controller;

import hei.school.springbootsecuritylab.model.JProduct;
import hei.school.springbootsecuritylab.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<JProduct> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public JProduct getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JProduct create(@RequestBody JProduct dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public JProduct update(@PathVariable String id, @RequestBody JProduct dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}