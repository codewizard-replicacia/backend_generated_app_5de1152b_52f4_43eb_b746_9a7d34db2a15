package com.mycompany.group234.repository;


import com.mycompany.group234.model.Industry;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class IndustryRepository extends SimpleJpaRepository<Industry, String> {
    private final EntityManager em;
    public IndustryRepository(EntityManager em) {
        super(Industry.class, em);
        this.em = em;
    }
    @Override
    public List<Industry> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Industry\"", Industry.class).getResultList();
    }
}