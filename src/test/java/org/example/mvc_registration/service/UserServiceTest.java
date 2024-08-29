package org.example.mvc_registration.service;

import org.example.mvc_registration.model.User;
import org.example.mvc_registration.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;
    //2 способ объявления мокито
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }


    @AfterEach
    void tearDown() {

    }


    @Test
    void getUserByName() {
        //создание объекта для теста
        User user = new User();
        user.setName("FTP");
        user.setPassword("password");

        // прописываем повидение для репозитория если у него будет вызван метод findByName с именем FTP
        when(userRepository.findByName(user.getName())).thenReturn(Optional.of(user));

        /** Главная строка для теста сервиса и его метода getUserByName */
        //получаем результат метода getUserByName из service
        Optional<User> ftp = userService.getUserByName("FTP");

        //проверяем результат с тем что ожидали получить
        assertEquals(user, ftp.get());
        assertEquals("FTP", ftp.get().getName());
    }

    @Test
    void save() {
        User user = new User();
        user.setName("Sidorov");
        user.setPassword("ghffhg");
        user.setEmail("jannet87@list.ru");

        when(userRepository.save(user)).thenReturn(user);

        User userResult = userService.save(user);

        assertEquals("Sidorov", userResult.getName());
        assertEquals("ghffhg", userResult.getPassword());
        assertEquals("jannet87@list.ru", userResult.getEmail());


    }
}