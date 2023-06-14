package com.mycompany.group234.repository;


import com.mycompany.group234.model.Database;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class DatabaseRepository extends SimpleJpaRepository<Database, String> {
    private final EntityManager em;
    public DatabaseRepository(EntityManager em) {
        super(Database.class, em);
        this.em = em;
    }
    @Override
    public List<Database> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Database\"", Database.class).getResultList();
    }
}