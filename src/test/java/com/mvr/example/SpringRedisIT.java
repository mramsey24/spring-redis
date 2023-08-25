
package com.mvr.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = SpringRedisApplication.class)
@AutoConfigureMockMvc
public class SpringRedisIT {
    
    @Autowired
    MockMvc mvc;

    @Test
    public void whenGET_All_People_thenStatus200()
        throws Exception {
                        
            mvc.perform(get("/api/v1/people/all")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
        }

    @Test void whenGET_Specific_Person_thenStatus200()
        throws Exception {
          throw new Exception ("Not Implemented")
        }
}
