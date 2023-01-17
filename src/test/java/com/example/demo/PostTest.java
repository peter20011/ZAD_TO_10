package com.example.demo;


import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.Employ;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostTest {
    private static final String PATH="/NewEmploy";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;

    private JsonObject PostRequestGood(String name, String surname, String data){
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("surname",surname);
        jsonObject.addProperty("data",data);
        return jsonObject;
    }


    @Test
    public void shouldReturnStatusOk_whenSuccessfuly() throws Exception{
        mvc.perform(post(PATH).contentType(MediaType.APPLICATION_JSON).content(PostRequestGood("JAS","KOWALSKI",
                "10 10 2005").toString())).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnStatusBad_whenLackOfData() throws Exception{
        mvc.perform(post(PATH).contentType(MediaType.APPLICATION_JSON).content(""
                )).andExpect(status().isBadRequest());
    }

}
