package com.alke.wallet.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;

public class LoginServiceTest {

    @Test
    public void testLoginSuccess() {
        // Arrange
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        LoginService loginService = new LoginService();
        loginService.setAuthenticationManager(authenticationManager);

        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("testuser", "testpassword")))
               .thenReturn(null);

        // Act
        boolean result = loginService.login("testuser", "testpassword");

        // Assert
        assertTrue(result);
    }

    @Test
    public void testLoginFailure() {
        // Arrange
        AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        LoginService loginService = new LoginService();
        loginService.setAuthenticationManager(authenticationManager);

        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("testuser", "wrongpassword")))
               .thenThrow(new BadCredentialsException("Invalid credentials"));

        // Act
        boolean result = loginService.login("testuser", "wrongpassword");

        // Assert
        assertFalse(result);
    }
}