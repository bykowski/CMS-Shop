package com.adrian.cmsshoppingcart;

import com.adrian.cmsshoppingcart.controllers.AdminPagesController;
import com.adrian.cmsshoppingcart.models.data.Page;
import com.adrian.cmsshoppingcart.models.data.Product;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminProductsController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AdminProductsController adminProductsController;


    @Test
    public void should_add_new_product() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\": \"1\"," +
                        "\"name\" : \"apple\"," +
                        "\"slug\" : \"apple-slug\"," +
                        "\"description\" : \"red apple\"" +
                        "\"image\" : \"image\"" +
                        "\"price\" : \"2\"" +
                        "\"categoryId\" : \"1\"" +
                        "\"createdAt\" : \"2020-02-02\"" +
                        "\"updatedAt\" : \"2020-02-02\"" +
                        "}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void getAdminProducts() {
        //given
        AdminProductsController adminProductsController = mock(AdminProductsController.class);
        //when
        when(adminProductsController.getAll()).thenReturn(prepareMockData());
        //then
        Assert.assertThat(adminProductsController.getAll(), Matchers.hasSize(4));
    }

    private List<Product> prepareMockData() {
        List<Product> poducts = new ArrayList<>();

        poducts.add(new Product());
        poducts.add(new Product());
        poducts.add(new Product());
        poducts.add(new Product());

        return poducts;
    }


}


//@SpringBootTest
//@AutoConfigureMockMvc
//class CarControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    CarController carController;
//
//    @Test
//    void hello() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/cars/hello"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("hello"));
//    }
//
//    @Test
//    void getCars() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
//    }
//
//    @Test
//    void should_get_car_by_id() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/cars/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//    }
//
//    @Test
//    void should_add_new_car() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/cars")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{ \"id\": \"4\"," +
//                        "\"mark\" : \"Fiat\"," +
//                        "\"model\" : \"126p\"," +
//                        "\"color\" : \"czerwony\"" +
//                        "}"))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    void getFord() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Is.is("Ford")));
//    }
//
//    @Test
//    void should_get_cars_with_specified_color() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/cars/colors/{color}", "czarny"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
//    }
//
//
//}
