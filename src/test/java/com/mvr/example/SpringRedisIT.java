
package com.mvr.example

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = SpringRedisApplication.class)
@AutoConfigureMockMvc
public class SpringRedisIT {
    
    @Autowired
    MockMvc mvc;
}
