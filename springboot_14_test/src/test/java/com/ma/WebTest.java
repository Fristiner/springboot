package com.ma;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

// web测试类
// SpringBootTest.WebEnvironment.DEFINED_PORT 定义端口和你上面定义的一样
// SpringBootTest.WebEnvironment.RANDOM_PORT 随机启用端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // 1.开启虚拟mvc调用
public class WebTest {
    @Test
    void test() {

    }
//    注入方式1
//    @Autowired
//    private MockMvc mvc;

    //注入方式2
    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception {
        // 2.创建一个虚拟的请求 当前访问/books
        MockHttpServletRequestBuilder buider = MockMvcRequestBuilders.get("/books");
        // 3. 执行类对应的请求
        ResultActions action = mvc.perform(buider);

        // 设置预期值   与 真实值进行 比较
        // 定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本次调用时成功的 状态码200
        ResultMatcher ok = status.isOk();

        // 添加预期值到本次调用过程中进行匹配
        action.andExpect(ok);
    /*
    * java.lang.AssertionError: Status expected:<200> but was:<404>
    预期:200
    实际:404
    * */

    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder buider = MockMvcRequestBuilders.get("/books");

        ResultActions action = mvc.perform(buider);

        ContentResultMatchers content = MockMvcResultMatchers.content();

        ResultMatcher resultMatcher = content.string("springboot");

        action.andExpect(resultMatcher);
        //java.lang.AssertionError: Response content expected:<springboot> but was:<spring boot >
        //预期:springboot
        //实际:spring boot
    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder buider = MockMvcRequestBuilders.get("/books/json");

        ResultActions action = mvc.perform(buider);
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"springboot\",\n" +
                "    \"des\": \"springboot\",\n" +
                "    \"type\": \"springboot1\"\n" +
                "}");
        action.andExpect(json);
        //java.lang.AssertionError: type
        //Expected: springboot1
        //     got: springboot
    }


    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder buider = MockMvcRequestBuilders.get("/books");

        ResultActions action = mvc.perform(buider);
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher resultMatcher = header.string("Content-Type", "application/json");

        action.andExpect(resultMatcher);
        // java.lang.AssertionError: Response header 'Content-Type' expected:<application/json> but was:<text/plain;charset=UTF-8>
        //预期:application/json
        //实际:text/plain;charset=UTF-8
    }

    @Test
    void testById(@Autowired MockMvc mvc) throws Exception {
        // 一个完整的controller请求测试需要以下三个测试
        // 1.首先看你请求是否ok
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions action = mvc.perform(builder);
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        action.andExpect(ok);

        // 2/添加预期值到本次调用过程中进行匹配
        // 然后看你结果是否ok
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"springboot\",\n" +
                "    \"des\": \"springboot\",\n" +
                "    \"type\": \"springboot1\"\n" +
                "}");
        action.andExpect(json);

        // 3.最后看你这个请求头
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher resultMatcher = header.string("Content-Type", "application/json");

        action.andExpect(resultMatcher);

    }

}

