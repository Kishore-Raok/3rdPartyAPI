package controller;

import Dto.ErrorDto;
import model.Product;
import service.ProductService;
import exceptions.ProductNotFoundException;
import service.FakeStoreProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct (@RequestBody Product product){
        Product postRequestResponse = productService.createProduct(product);
        return postRequestResponse;
    }

    @GetMapping("/products/{id}")
        public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException{
            Product currentProduct = productService.getSingleProduct(productId);
            ResponseEntity<Product> res = new ResponseEntity<>(
                    currentProduct, HttpStatus.OK
            );
            return res;
        }
    @GetMapping("/products")
    public void getAllProducts(){
        productService.getAllProducts();
    }

    @ExceptionHandler(ProductNotFoundException.class)
        public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e){
            ErrorDto errorDto = new ErrorDto();
            errorDto.setMessage(e.getMessage());
            return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
        }

}
