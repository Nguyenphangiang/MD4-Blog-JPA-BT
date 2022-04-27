package com.controller.repository;

import com.controller.model.Blog;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> showAll() {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b",Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b where b.id = :id",Blog.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null){
            em.merge(blog);
        } else {
            em.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            em.remove(blog);
        }
    }
}
