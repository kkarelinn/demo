package com.demo;

import com.demo.controller.Controller;
import com.demo.model.User;
import com.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Controller controller;

    @Autowired
    private UserService userService;


    @Test
    public void helloTest() throws Exception{
        this.mockMvc
                .perform(get("/api"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to karelin API test !!")));
    }

       @Test
    public void getUsersByAge40() {
        List<User> users = userService.getUsersByAgeGreaterThan(40);
        Assert.assertNotNull(users);
        users.forEach(u->Assert.assertTrue(u.getAge()>40));
    }

    @Test
    public void saveUser() {
        User user = new User("new USER King", 55);
        userService.saveUser(user);
        int id = user.getId();
        User userFromBase = userService.getUserById(id);
        Assert.assertEquals(user.getName(), userFromBase.getName());
        Assert.assertEquals(user.getAge(), userFromBase.getAge());
        Assert.assertArrayEquals(user.getArticles().toArray(), userFromBase.getArticles().toArray());
    }

}
