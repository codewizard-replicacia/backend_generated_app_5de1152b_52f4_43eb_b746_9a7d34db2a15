package com.mycompany.group234.repository;


import com.mycompany.group234.model.BackendApp;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class BackendAppRepository extends SimpleJpaRepository<BackendApp, String> {
    private final EntityManager em;
    public BackendAppRepository(EntityManager em) {
        super(BackendApp.class, em);
        this.em = em;
    }
    @Override
    public List<BackendApp> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"BackendApp\"", BackendApp.class).getResultList();
    }
}