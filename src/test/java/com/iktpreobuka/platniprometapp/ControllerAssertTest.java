package com.iktpreobuka.platniprometapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iktpreobuka.platniprometapp.controllers.AccountController;
import com.iktpreobuka.platniprometapp.controllers.AddressController;
import com.iktpreobuka.platniprometapp.controllers.BankController;
import com.iktpreobuka.platniprometapp.controllers.ClientController;
import com.iktpreobuka.platniprometapp.controllers.TransactionController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerAssertTest {
	
	@Autowired
    private ClientController clientController;
	@Autowired
    private AddressController addressController;
	@Autowired
    private BankController bankController;
	@Autowired
    private AccountController accountController;
	@Autowired
    private TransactionController transactionController;

    @Test
    public void contexLoads1() throws Exception {
        assertThat(clientController).isNotNull();
    }
    @Test
    public void contexLoads2() throws Exception {
        assertThat(addressController).isNotNull();
    }
    @Test
    public void contexLoads3() throws Exception {
        assertThat(bankController).isNotNull();
    }
    @Test
    public void contexLoads4() throws Exception {
        assertThat(accountController).isNotNull();
    }
    @Test
    public void contexLoads5() throws Exception {
        assertThat(transactionController).isNotNull();
    }

}
