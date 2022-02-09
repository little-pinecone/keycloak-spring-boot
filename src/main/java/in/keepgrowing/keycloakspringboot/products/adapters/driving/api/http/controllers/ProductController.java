package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.controllers;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.ProductRequest;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services.ProductHttpApiFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ProductControllerPaths.PRODUCTS_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products")
public class ProductController {

    private final ProductHttpApiFacade apiFacade;

    public ProductController(ProductHttpApiFacade apiFacade) {
        this.apiFacade = apiFacade;
    }

    @GetMapping
    @Operation(summary = "Return all products")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return new ResponseEntity<>(apiFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Save a new product")
    public ResponseEntity<ProductResponse>save(@RequestBody ProductRequest newProduct) {
        return new ResponseEntity<>(apiFacade.save(newProduct), HttpStatus.OK);
    }
}
