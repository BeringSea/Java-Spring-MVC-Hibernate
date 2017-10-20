package com.luv2code.springdemo.controller;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by David on 2017-10-20.
 */
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testList() throws Exception{
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());
        customers.add(new Customer());
        when(customerService.getCustomers()).thenReturn((List) customers);

        mockMvc.perform(get("/customer/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("list-customers"))
                .andExpect(model().attribute("customers", hasSize(3)));
    }

    @Test
    public void testNewCustomer() throws Exception{
        verifyZeroInteractions(customerService);

        mockMvc.perform(get("/customer/showFormForAdd"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer-form"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testEdit() throws Exception{
        int id = 1;
        when(customerService.getCustomer(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/showFormForUpdate?customerId=1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer-form"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void deleteTest() throws Exception{
        int id = 10;
        when(customerService.getCustomer(id)).thenReturn(new Customer());
        customerService.deleteCustomer(id);
        verify(customerService,times(1)).deleteCustomer(id);
    }
}
