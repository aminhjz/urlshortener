package com.aminhjz.interview.urlshortner.urlshortner;

import com.aminhjz.interview.urlshortner.urlshortner.controller.dto.ShortUrlRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
@EnableAutoConfiguration(exclude= {CassandraAutoConfiguration.class, CassandraDataAutoConfiguration.class})
class UrlShortnerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	/*@Test*/
	void contextLoads() {
	}

	/*@Test*/
	public void createUrl() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/1/urls")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(new ShortUrlRequestDto("https://takeaway.com/aminhjz"))))
				.andDo(print())
				.andExpect(status().isCreated());
	}


	/*@Test*/
	public void getUrl() throws Exception {
		String pathVariable = "/test";
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/1/urls"+ pathVariable)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
