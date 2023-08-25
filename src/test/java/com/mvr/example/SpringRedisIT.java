
package com.mvr.example

/*
 * Integration Test for Spring Redist application
 */
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

    @Disabled ("Not Ready yet")
    @Test void whenGET_Specific_Person_thenStatus200()
        throws Exception {
          mvc.perform(get("/api/v1/people/1")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOK());
        }
}
