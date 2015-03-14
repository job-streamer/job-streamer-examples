package example.csv;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kawasima
 */
public class PostalLoader extends AbstractItemWriter {
    private EntityManager em;
    private String persistenceUnitName = "my-app";

    @Override
    public void open(Serializable checkpoint) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = factory.createEntityManager();
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            for (Object item : items) {
                if (!(item instanceof PostalAddress)) {
                    throw new IllegalStateException("item isn't PostalAddress.");
                }
                em.persist(item);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        em.close();
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }
}
