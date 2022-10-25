package edu.mriabov.restapitesttask.dao.daoservice;

import edu.mriabov.restapitesttask.config.Config;
import edu.mriabov.restapitesttask.dao.model.User;
import edu.mriabov.restapitesttask.dao.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    /**
     * Method under test: {@link UserService#save(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.time.DateTimeException: Unable to obtain Instant from TemporalAccessor: 2022 of type java.time.Year
        //       at java.time.Instant.from(Instant.java:380)
        //       at edu.mriabov.restapitesttask.dao.daoservice.UserService.save(UserService.java:20)
        //   java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: InstantSeconds
        //       at java.time.Year.getLong(Year.java:505)
        //       at java.time.Instant.from(Instant.java:375)
        //       at edu.mriabov.restapitesttask.dao.daoservice.UserService.save(UserService.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository, new Config());

        User user = new User();
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhoneNumber("4105551212");

        // Act
        userService.save(user);
    }

    /**
     * Method under test: {@link UserService#save(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "edu.mriabov.restapitesttask.config.Config.getAge()" because "this.config" is null
        //       at edu.mriabov.restapitesttask.dao.daoservice.UserService.save(UserService.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        UserService userService = new UserService(mock(UserRepository.class), null);

        User user = new User();
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhoneNumber("4105551212");

        // Act
        userService.save(user);
    }

    /**
     * Method under test: {@link UserService#save(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Date.toInstant()" because the return value of "edu.mriabov.restapitesttask.dao.model.User.getBirthDate()" is null
        //       at edu.mriabov.restapitesttask.dao.daoservice.UserService.save(UserService.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository, new Config());

        User user = new User();
        user.setAddress("42 Main St");
        user.setBirthDate(null);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhoneNumber("4105551212");

        // Act
        userService.save(user);
    }

    /**
     * Method under test: {@link UserService#delete(String)}
     */
    @Test
    void testDelete() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        doNothing().when(userRepository).deleteByEmail((String) any());

        // Act
        (new UserService(userRepository, new Config())).delete("jane.doe@example.org");

        // Assert
        verify(userRepository).deleteByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#getByBirthdays(Date, Date)}
     */
    @Test
    void testGetByBirthdays() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.getByBirthDateBetween((Date) any(), (Date) any())).thenReturn(userList);
        UserService userService = new UserService(userRepository, new Config());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date startFrom = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();

        // Act
        List<User> actualByBirthdays = userService.getByBirthdays(startFrom,
                Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));

        // Assert
        assertSame(userList, actualByBirthdays);
        assertTrue(actualByBirthdays.isEmpty());
        verify(userRepository).getByBirthDateBetween((Date) any(), (Date) any());
    }

    /**
     * Method under test: {@link UserService#editUser(User)}
     */
    @Test
    void testEditUser() {
        // Arrange
        User user = new User();
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhoneNumber("4105551212");
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.existsById((Long) any())).thenReturn(true);
        UserService userService = new UserService(userRepository, new Config());

        User user1 = new User();
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPhoneNumber("4105551212");

        // Act and Assert
        assertTrue(userService.editUser(user1));
        verify(userRepository).existsById((Long) any());
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link UserService#editUser(User)}
     */
    @Test
    void testEditUser2() {
        // Arrange
        User user = new User();
        user.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhoneNumber("4105551212");
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.existsById((Long) any())).thenReturn(false);
        UserService userService = new UserService(userRepository, new Config());

        User user1 = new User();
        user1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPhoneNumber("4105551212");

        // Act and Assert
        assertFalse(userService.editUser(user1));
        verify(userRepository).existsById((Long) any());
    }
}

