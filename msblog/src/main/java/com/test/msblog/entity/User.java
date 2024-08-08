package com.test.msblog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 15, message = "작성자명은 4자 이상 15자 이하만 가능합니다.")
    @Pattern(regexp = "^[a-z0-9]*$", message = "작성자명은 알파벳 소문자와 숫자로만 구성되어야 합니다.")
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;


    private String role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();
}