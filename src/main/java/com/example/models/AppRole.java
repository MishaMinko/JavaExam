package com.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@Table(name="role")
public class AppRole implements GrantedAuthority {

    @Id
    @Column(name="id")
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @Column(name="name", length = 128, nullable = false)
    String name;

    @ManyToMany(mappedBy = "roles")
    Set<AppUser> users;

    public AppRole() {}

    public AppRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return getName();
    }
}