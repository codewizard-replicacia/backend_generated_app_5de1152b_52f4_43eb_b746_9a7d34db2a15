package com.mycompany.group234.repository;


import com.mycompany.group234.model.BETechnology;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class BETechnologyRepository extends SimpleJpaRepository<BETechnology, String> {
    private final EntityManager em;
    public BETechnologyRepository(EntityManager em) {
        super(BETechnology.class, em);
        this.em = em;
    }
    @Override
    public List<BETechnology> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"BETechnology\"", BETechnology.class).getResultList();
    }
}