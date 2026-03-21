package com.obsidian.app.security;

import com.obsidian.app.repository.UserRepository;
import com.obsidian.core.di.annotations.Inject;
import com.obsidian.core.security.user.UserDetails;
import com.obsidian.core.security.user.UserDetailsService;
import com.obsidian.core.security.user.UserDetailsServiceImpl;

/**
 * Tells Obsidian how to load a user from the database during authentication.
 * This service is called automatically by the framework — you don't invoke it manually.
 *
 * @UserDetailsServiceImpl registers this class as the active UserDetailsService.
 * Only one implementation should exist in the application.
 */
@UserDetailsServiceImpl
public class AppUserDetailsService implements UserDetailsService
{
    @Inject
    private UserRepository userRepository;

    /**
     * Called during login to find the user by their username.
     *
     * @param username the username submitted in the login form
     * @return the matching UserDetails, or null if not found
     */
    @Override
    public UserDetails loadByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Called on subsequent requests to reload the user from the session.
     *
     * @param id the user's primary key stored in the session
     * @return the matching UserDetails, or null if not found
     */
    @Override
    public UserDetails loadById(Object id) {
        return userRepository.findById(id);
    }
}