package com.shelterapp.backend.user;

import com.shelterapp.backend.models.Volunteer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_vol_id")
    @NotNull
    @NotBlank
    private Volunteer volunteer_id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Boolean enabled = true;

    public User(Volunteer volunteer_id,
                String name,
                String username,
                String email,
                String password,
                Boolean enabled) {
        this.volunteer_id = volunteer_id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public User() {
    }

    public long getId() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getRoles() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        return roles;
    }

}