package com.ringnull.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "users_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;
    // указываем через что связь с таблицей (свойство details объекта User, которое указывает на поле таблицы Users.details_id)
    @OneToOne(mappedBy = "details")
    private User user;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDetails() {}

    @Override
    public String toString(){
        return String.format("UserDetails [id = %d, email = '%s', city = '%s']", this.id, this.email, this.city);
    }
}