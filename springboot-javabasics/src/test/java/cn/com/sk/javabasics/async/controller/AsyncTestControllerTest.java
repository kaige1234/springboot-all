package cn.com.sk.javabasics.async.controller;

import cn.com.sk.javabasics.SpringbootJavabasicsApplication;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author sunkai
 * @title: AsyncTestControllerTest
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/2/2110:58
 */


@ContextConfiguration
@WebAppConfiguration
@SpringBootTest(classes = SpringbootJavabasicsApplication.class)
class AsyncTestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    public void setUp(){
        System.out.println("niadd");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getAsyncTest() throws Exception {
        setUp();
        MvcResult mvcResult = mockMvc.perform(get("/async/test/getAsyncTest")
                //请求类型
                .contentType(MediaType.APPLICATION_ATOM_XML)
                .param("name", "SUnkai")
        ).andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        JSONObject jsonObject = JSONObject.parseObject(contentAsString);
        JSONArray jsonArray = (JSONArray)jsonObject.get("data");


    }

    @Test
    void difinationAsyncTest() {
    }
}