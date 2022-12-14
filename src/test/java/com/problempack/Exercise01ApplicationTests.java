package com.problempack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.problempack.controller.PackController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.lang.model.element.PackageElement;


@SpringBootTest
@AutoConfigureMockMvc
class Exercise01ApplicationTests {

	@Autowired
	PackController packController;
	@Autowired
	private MockMvc mockMvc;

	
	@Test
	void contextLoads() throws Exception{
		assertThat(packController).isNotNull();
	}

}
