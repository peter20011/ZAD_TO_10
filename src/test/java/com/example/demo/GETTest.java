package com.example.demo;


import com.google.gson.JsonObject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;


import java.util.List;

import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GETTest {
    private final static String PATH="/ListEmploy";
    private static final String PATH2="/NewEmploy";

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mvc;



    private JsonObject RequestGood(String name, String surname, String data){
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("surname",surname);
        jsonObject.addProperty("data",data);
        return jsonObject;
    }



    @Test
    public void shouldReturnOk_whenSuccessfullyReturnedListOfEmployee() throws Exception{
        mvc.perform(post(PATH2).contentType(MediaType.APPLICATION_JSON)
                .content(RequestGood("Janek","Czarnecki","25 09 2001").toString()))
                .andExpect(status().isOk());

        mvc.perform(post(PATH2).contentType(MediaType.APPLICATION_JSON)
                        .content(RequestGood("Stanislaw","Burza","12 12 2012").toString()))
                .andExpect(status().isOk());


        List<Employ> table= Table.getInstance().get_employ();
        String response="";

        for(Employ employ:table){
            response+=employ.getName();
        }

        mvc.perform(get(PATH))
                .andExpect(status().isOk()).andExpect(content().string(response));
    }


    @Test
    public void shouldReturnOk_whenSuccessfully() throws Exception{
        mvc.perform(post(PATH2).contentType(MediaType.APPLICATION_JSON)
                        .content(RequestGood("Janek","Czarnecki","25 09 2001").toString()))
                .andExpect(status().isOk());

        mvc.perform(post(PATH2).contentType(MediaType.APPLICATION_JSON)
                        .content(RequestGood("Stanislaw","Burza","12 12 2012").toString()))
                .andExpect(status().isOk());



        mvc.perform(get(PATH))
                .andExpect(status().isOk());
    }




}