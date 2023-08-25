
package com.mvr.example

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = SpringRedisApplication.class)
@AutoConfigureMockMvc
public class SpringRedisIT {
    
    @Autowired
    MockMvc mvc;

    @Test
    public void whenGetAllPeople_thenStatus200()
        throws Exception {
                        
            mvc.perform(get("/api/v1/people/all")
              .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());)
        }
}
