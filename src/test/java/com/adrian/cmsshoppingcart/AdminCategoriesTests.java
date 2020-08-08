package com.adrian.cmsshoppingcart;

import com.adrian.cmsshoppingcart.controllers.AdminCategoriesController;
import com.adrian.cmsshoppingcart.controllers.AdminPagesController;
import com.adrian.cmsshoppingcart.models.data.Page;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AdminCategoriesTests {

    private MockMvc mockMvc;

    private AdminCategoriesController adminCategoriesController;

    @Before
    public void setup() {
        AdminCategoriesController adminCategoriesController = mock(AdminCategoriesController.class);
        mockMvc = MockMvcBuilders.standaloneSetup(adminCategoriesController).build();

    }

    @Test
    public void testAdminPages() throws Exception {
        mockMvc.perform(get("/admin/categories"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/categories"));
    }

    @Test
    public void addPage() {
        //given
        AdminPagesController adminPagesController = mock(AdminPagesController.class);
        given(adminPagesController.add(Mockito.any(Page.class))).willReturn(String.valueOf(new Page()));
        //when
        String page = adminPagesController.add(new Page());
        //then
        Assert.assertEquals(page, new String("Page(id=0, title=null, slug=null, content=null, sorting=0)"));
    }


    private List<Page> prepareMockData() {
        List<Page> pages = new ArrayList<>();

        pages.add(new Page());
        pages.add(new Page());

        return pages;
    }
}
