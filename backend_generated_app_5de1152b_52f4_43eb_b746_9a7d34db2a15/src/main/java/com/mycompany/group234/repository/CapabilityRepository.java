package com.mycompany.group234.repository;


import com.mycompany.group234.model.Capability;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class CapabilityRepository extends SimpleJpaRepository<Capability, String> {
    private final EntityManager em;
    public CapabilityRepository(EntityManager em) {
        super(Capability.class, em);
        this.em = em;
    }
    @Override
    public List<Capability> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Capability\"", Capability.class).getResultList();
    }
}