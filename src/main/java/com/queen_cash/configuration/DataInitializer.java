package com.queen_cash.configuration;

import com.queen_cash.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired private EntityManager entityManager;
    @Autowired private WebApplicationContext appContext;
    Repositories repositories = null;

    public void run(ApplicationArguments args) {
        repositories = new Repositories(appContext);
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        for (EntityType entity : entities) {
            Class clazz = entity.getJavaType();
            try {
                if (repositories.hasRepositoryFor(clazz)) {
                    clazz.getMethod("initialize", CommonRepository.class).invoke(null, repositories.getRepositoryFor(clazz));
                }
            } catch (NoSuchMethodException e) {
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
