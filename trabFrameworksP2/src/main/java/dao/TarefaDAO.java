package dao;

import models.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TarefaDAO implements DAO<Tarefa> {
    private EntityManagerFactory factory;
    private EntityManager manager;

    public TarefaDAO() {
        this.factory = Persistence.createEntityManagerFactory("tiagoFrameworks");
        this.manager = factory.createEntityManager();
    }

    @Override
    public void insert(Tarefa tarefa) {
        manager.getTransaction().begin();
        manager.persist(tarefa);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Tarefa tarefa = this.get(id);
        if (tarefa != null) {
            manager.getTransaction().begin();
            manager.remove(tarefa);
            manager.getTransaction().commit();
        }
    }

    @Override
    public void update(Tarefa tarefa) {
        if (this.get(tarefa.getId()) != null) {
            manager.getTransaction().begin();
            manager.merge(tarefa);
            manager.getTransaction().commit();
        }
    }

    @Override
    public List<Tarefa> list(int limit, int offset) {
        return manager.createQuery("FROM Tarefa", Tarefa.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public Tarefa get(int id) {
        return manager.find(Tarefa.class, id);
    }
}

