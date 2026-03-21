package com.obsidian.app.models;

import com.obsidian.core.database.orm.model.Model;
import com.obsidian.core.database.orm.model.Table;
import com.obsidian.core.security.user.UserDetails;
/**
 * Represents a user in the application.
 * Maps to the "users" table via ActiveJDBC (ActiveRecord pattern).
 *
 * Implements AppUserDetails to integrate with Obsidian's authentication system.
 * Fields are read from the database row via getString() / getLong() — no column annotations needed.
 */
@Table("users")
public class User extends Model implements UserDetails
{
    /**
     * Returns the primary key of the user.
     */
    public Object getId() { return getLong("id"); }

    /**
     * Returns the username used for login.
     */
    public String getUsername() { return getString("username"); }

    /**
     * Returns the hashed password.
     */
    public String getPassword() { return getString("password"); }

    /**
     * Returns the user's role (e.g. "USER", "ADMIN").
     * Used by @HasRole to restrict access to routes.
     */
    public String getRole() { return getString("role"); }

}