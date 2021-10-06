package com.ringnull.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //    @JoinColumn(name = "details_id")
    // обрати внимание, что в БД это добавлено как внешний ключ (можно без foreign key? пока не знаю)
    @OneToOne
    @JoinColumn(name = "details_id")
    private UserDetails details;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetails getDetails() {
        return this.details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    public User() {}

    @Override
    public String toString(){
        return String.format("User [id = %d, name = '%s']", this.id, this.name);
    }
}