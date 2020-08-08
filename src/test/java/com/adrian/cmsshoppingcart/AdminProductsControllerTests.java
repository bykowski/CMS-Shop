package com.adrian.cmsshoppingcart;

import com.adrian.cmsshoppingcart.controllers.AdminPagesController;
import com.adrian.cmsshoppingcart.controllers.AdminProductsController;
import com.adrian.cmsshoppingcart.models.data.Page;
import com.adrian.cmsshoppingcart.models.data.Product;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AdminProductsControllerTests {

    private List<Product> prepareMockData() {
        List<Product> poducts = new ArrayList<>();

        poducts.add(new Product());
        poducts.add(new Product());
        poducts.add(new Product());
        poducts.add(new Product());

        return poducts;
    }

    @Test
    public void addProduct() {
        //given
        AdminProductsController adminProductsController = mock(AdminProductsController.class);
        given(adminProductsController.add(Mockito.any(Product.class), Mockito.any(Model.class))).willReturn(String.valueOf(new Product()));
        //when

        Model testModel = new Model() {
            @Override
            public Model addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        String product = adminProductsController.add(new Product(), testModel);
        //then
        Assert.assertEquals(product, new String("Product(id=0, name=null, slug=null, description=null, image=null, price=null, categoryId=null, createdAt=null, updatedAt=null)"));
    }


}

