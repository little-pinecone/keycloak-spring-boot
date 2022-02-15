package in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.ProductRequest;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.requests.TestProductRequestProvider;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.ProductResponse;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.model.responses.TestProductResponseProvider;
import in.keepgrowing.keycloakspringboot.products.adapters.driving.api.http.services.ProductHttpApiFacade;
import in.keepgrowing.keycloakspringboot.products.config.MvcConfig;
import in.keepgrowing.keycloakspringboot.testing.annotations.RestControllerIntegrationTestConfig;
import in.keepgrowing.keycloakspringboot.testing.annotations.WithMockChiefOperationOfficer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestControllerIntegrationTestConfig(value = ProductController.class)
class ProductControllerTest {

    private static final String BASE_PATH = "/" + MvcConfig.API_PREFIX + "/" + ProductControllerPaths.PRODUCTS_PATH;
    private static final String TEST_UUID = "a25fd1a8-b2e2-3b40-97a5-cead9ec87986";

    private TestProductResponseProvider productResponseProvider;
    private TestProductRequestProvider productRequestProvider;

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
        productRequestProvider = new TestProductRequestProvider();
    }

    @Test
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    @WithMockUser
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

    @Test
    @WithMockUser
    void shouldSaveNewProduct() throws Exception {
        ProductRequest newProduct = productRequestProvider.full();
        ProductResponse savedProduct = productResponseProvider.full();
        String expected = objectMapper.writeValueAsString(savedProduct);

        when(apiFacade.save(newProduct))
                .thenReturn(savedProduct);

        mvc.perform(post(BASE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    @WithMockChiefOperationOfficer
    void shouldDeleteProduct() throws Exception {
        mvc.perform(delete(BASE_PATH + "/" + TEST_UUID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser
    void shouldDenyAccessToDeletingProduct() throws Exception {
        mvc.perform(delete(BASE_PATH + "/" + TEST_UUID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf()))
                .andExpect(status().isForbidden());
    }
}