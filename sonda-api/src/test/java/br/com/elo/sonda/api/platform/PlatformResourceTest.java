package br.com.elo.sonda.api.platform;

import static br.com.elo.sonda.api.builders.CoordinateBuilder.coordinate;
import static br.com.elo.sonda.api.builders.PlatformExploreRequestBuider.platformRequest;
import static br.com.elo.sonda.api.builders.ProbeBuilder.spaceProbe;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.elo.sonda.api.SondaApiApplication;
import br.com.elo.sonda.api.TestUtils;
import br.com.elo.sonda.api.builders.PlatformBuilder;
import br.com.elo.sonda.api.error.ApiErrorMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SondaApiApplication.class)
@WebAppConfiguration
public class PlatformResourceTest {

	@Autowired
	WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testRequestWithoutPlatform() throws Exception {

		PlatformExploreRequest request = platformRequest() //
				.addSpaceProbe(spaceProbe() //
						.withCoordinate(coordinate() //
								.withLatitude(1) //
								.withLongitude(1)) //
						.withDirection("N") //
						.withCommands("L", "M", "L", "M", "L", "M")) //
				.build(); //

		mockMvc.perform(post("/platform")//
				.content(TestUtils.writeToBytes(request))//
				.contentType("application/json;charset=UTF-8"))//
				.andExpect(status().isBadRequest()) //
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.errors[*]", hasSize(1))) //
				.andExpect(jsonPath("$.errors[0].code", is(ApiErrorMessage.PLATFORM_REQUIRED))); //

	}

	@Test
	public void testRequestWithoutPlatformCoordinate() throws Exception {

		PlatformExploreRequest request = platformRequest() //
				.withPlatform(PlatformBuilder.platform()) //
				.addSpaceProbe(spaceProbe() //
						.withCoordinate(coordinate() //
								.withLatitude(1) //
								.withLongitude(1)) //
						.withDirection("N") //
						.withCommands("L", "M", "L", "M", "L", "M")) //
				.build(); //

		mockMvc.perform(post("/platform")//
				.content(TestUtils.writeToBytes(request))//
				.contentType("application/json;charset=UTF-8"))//
				.andExpect(status().isBadRequest()) //
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.errors[*]", hasSize(1))) //
				.andExpect(jsonPath("$.errors[0].code", is(ApiErrorMessage.PLATFORM_MAX_COORDINATE_REQUIRED))); //

	}

	@Test
	public void testRequestWithInvalidCoordinate() throws Exception {

		PlatformExploreRequest request = platformRequest() //
				.withPlatform(PlatformBuilder.platform() //
						.withCoordinate(coordinate() //
								.withLatitude(-1) //
								.withLongitude(-1))) //
				.addSpaceProbe(spaceProbe() //
						.withCoordinate(coordinate() //
								.withLatitude(1) //
								.withLongitude(1)) //
						.withDirection("N") //
						.withCommands("L", "M", "L", "M", "L", "M")) //
				.build(); //

		mockMvc.perform(post("/platform")//
				.content(TestUtils.writeToBytes(request))//
				.contentType("application/json;charset=UTF-8"))//
				.andExpect(status().isBadRequest()) //
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.errors[*]", hasSize(2))); //
//				.andExpect(jsonPath("$.errors[*].code",
//						is(Arrays.asList(ApiErrorMessage.INVALID_LATITUDE, ApiErrorMessage.INVALID_LONGITUDE)))); //
	}

	@Test
	public void testValidRequest() throws Exception {

		PlatformExploreRequest request = platformRequest() //
				.withPlatform(PlatformBuilder.platform() //
						.withCoordinate(coordinate() //
								.withLatitude(5) //
								.withLongitude(5))) //
				.addSpaceProbe(spaceProbe() //
						.withCoordinate(coordinate() //
								.withLatitude(2) //
								.withLongitude(1)) //
						.withDirection("N") //
						.withCommands("L", "M", "L", "M", "L", "M","L","M","M")) //
				.build(); //

		mockMvc.perform(post("/platform")//
				.content(TestUtils.writeToBytes(request))//
				.contentType("application/json;charset=UTF-8"))//
				.andExpect(status().isOk()) //
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.probes[*]", hasSize(1))) //
				.andExpect(jsonPath("$.probes[0].position.coordinate.longitude",is(1))) //
				.andExpect(jsonPath("$.probes[0].position.coordinate.latitude",is(3))) //
				.andExpect(jsonPath("$.probes[0].position.direction",is("N"))); //
	}
	
}
