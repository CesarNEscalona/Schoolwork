package edu.greenriver.sdev.testing.mockito;


import edu.greenriver.sdev.testing.controllers.UserController;
import org.apache.tomcat.jni.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class MockitoControllerTest {

    @InjectMocks
    private UserController userController;

//    @Mock
//    private UserRepository userRepository;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetUserById(){
//        User u = new User();
//        u.setId(1L);
//        when(userRepository.findOne(1l)).thenReturn(u);
//
//        User user = userController.get(1l);
//
//        verify(userRepository).findOne(1l);
//
//        assertEquals(1l, user,getId().longValue());
//    }
}
