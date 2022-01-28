package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.TestProductResponseProvider;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services.ProductHttpApiFacade;
import in.keepgrowing.keycloakspringboot.products.config.MvcConfig;
import in.keepgrowing.keycloakspringboot.shared.config.annotations.RestControllerIntegrationTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestControllerIntegrationTestConfig(value = ProductController.class)
class ProductControllerTest {

    private static final String BASE_PATH = "/" + MvcConfig.API_PREFIX + "/" + ProductControllerPaths.PRODUCTS_PATH;

    private TestProductResponseProvider productResponseProvider;

    @Autowired
    private ProductController controller;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductHttpApiFacade apiFacade;

    @BeforeEach
    void setUp() {
        productResponseProvider = new TestProductResponseProvider();
    }

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    void shouldReturnAllProducts() throws Exception {
        ProductResponse productResponse = productResponseProvider.full();
        String expected = objectMapper.writeValueAsString(List.of(productResponse));

        when(apiFacade.findAll())
                .thenReturn(List.of(productResponse));

        mvc.perform(get(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}