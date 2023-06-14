package com.mycompany.group234.repository;


import com.mycompany.group234.model.ModelFile;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ModelFileRepository extends SimpleJpaRepository<ModelFile, String> {
    private final EntityManager em;
    public ModelFileRepository(EntityManager em) {
        super(ModelFile.class, em);
        this.em = em;
    }
    @Override
    public List<ModelFile> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"ModelFile\"", ModelFile.class).getResultList();
    }
}