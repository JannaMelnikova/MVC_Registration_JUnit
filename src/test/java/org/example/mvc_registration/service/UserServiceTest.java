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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    void getUserById() {
        User user = new User();
        user.setId(1);
        user.setName("Sidorov");
        user.setPassword("ghffhg");
        user.setEmail("jannet87@list.ru");
        // прописываем повидение для репозитория если у него будет вызван метод findByName с id=1
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        /** Главная строка для теста сервиса и его метода getUserById */
        //получаем результат метода getUserById из service
        Optional<User> userId = userService.getUserById(user.getId());
        //проверяем результат с тем что ожидали получить
        assertEquals(user, userId.get());
        assertEquals(1, userId.get().getId());

    }

    @Test
    void getUserByEmail() {
        User user = new User();
        user.setName("Sidorov");
        user.setPassword("ghffhg");
        user.setEmail("jannet87@list.ru");
        // прописываем повидение для репозитория если у него будет вызван метод findByName с email=jannet87@list.ru
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        /** Главная строка для теста сервиса и его метода getUserByEmail */
        //получаем результат метода getUserByEmail из service
        Optional<User> userEmail = userService.getUserByEmail(user.getEmail());
        assertEquals(user, userEmail.get());
        assertEquals("jannet87@list.ru", userEmail.get().getEmail());
    }

    @Test
    void findAll() {
        User user = new User();
        user.setName("Sidorov");
        user.setPassword("ghffhg");
        user.setEmail("jannet87@list.ru");
        List<User> userList = Collections.singletonList(user);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> userResultList = userService.findAll();
        assertEquals(1, userResultList.size());
        User userResult = userResultList.get(0);

        assertEquals("Sidorov", userResultList.get(0).getName());
        assertEquals("ghffhg", userResultList.get(0).getPassword());
        assertEquals("jannet87@list.ru", userResultList.get(0).getEmail());
    }

}