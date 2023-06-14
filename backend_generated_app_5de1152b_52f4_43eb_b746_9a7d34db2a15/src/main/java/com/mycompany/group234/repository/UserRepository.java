package com.mycompany.group234.repository;


import com.mycompany.group234.model.User;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class UserRepository extends SimpleJpaRepository<User, String> {
    private final EntityManager em;
    public UserRepository(EntityManager em) {
        super(User.class, em);
        this.em = em;
    }
    @Override
    public List<User> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"User\"", User.class).getResultList();
    }
}