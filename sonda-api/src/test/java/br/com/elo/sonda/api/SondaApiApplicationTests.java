package br.com.elo.sonda.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.elo.sonda.api.SondaApiApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SondaApiApplication.class)
@WebAppConfiguration
public class SondaApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
