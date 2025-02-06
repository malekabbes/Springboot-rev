package com.example.rest_service.models;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import java.util.List;

@Entity
@Table(name = "users")
public class User{
    // Ici j'ai mis les attributs necessaires ( spécifié dans la partie tasks: ID /username/npt de passe/pseudonyme)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 100)
    private String pseudonym;

    //relation 1-n car un utilisaur peux acheter plusieurs books
    //C'est dans le cas ou on aura implementer la logique d'achat de livre c'est pas demandé dans tasks mais c'est important dans la logique de contexte
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> purch_books;

    public User() {}
    // constructeur
    public User(String username, String password, String email, String pseudonym) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.pseudonym = pseudonym;
    }

    // Getters et Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPseudonym() { return pseudonym; }
    public void setPseudonym(String pseudonym) { this.pseudonym = pseudonym; }

    public List<Book> getBooks() { return purch_books; }
    public void setBooks(List<Book> books) { this.purch_books = books; }
}
