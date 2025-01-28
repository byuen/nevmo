package com.capitalized.controller;

import com.capitalized.AbstractTest;
import com.capitalized.model.User;
import com.capitalized.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends AbstractTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @Before("")
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void getUser_whenUserExists_thenReturn200() throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID());
        when(userService.getUser(any())).thenReturn(Optional.of(user));

        MvcResult result = mockMvc.perform(get(String.format("/user/%s", user.getId().toString()))).andExpect(status().isOk()).andReturn();
        User userResult = mapFromJson(result.getResponse().getContentAsString(), User.class);

        assertEquals("id", user.getId().toString(), userResult.getId().toString());

    }
}
