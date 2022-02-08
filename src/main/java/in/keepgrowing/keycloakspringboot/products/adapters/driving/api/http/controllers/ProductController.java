package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.controllers;

import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.ProductRequest;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services.ProductHttpApiFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ProductControllerPaths.PRODUCTS_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductHttpApiFacade apiFacade;

    public ProductController(ProductHttpApiFacade apiFacade) {
        this.apiFacade = apiFacade;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return new ResponseEntity<>(apiFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse>save(@RequestBody ProductRequest newProduct) {
        return new ResponseEntity<>(apiFacade.save(newProduct), HttpStatus.OK);
    }
}
