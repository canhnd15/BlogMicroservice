package com.davidblog.posts.repository.impl;

import com.davidblog.posts.entity.Post;
import com.davidblog.posts.repository.PostRepositoryCustom;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public List<Post> getPendingPostWithPagination(int pageSize, int pageNumber) {
        return em.createQuery("""
                            SELECT p FROM Post p WHERE p.status = 'PENDING'
                        """, Post.class)
                .setMaxResults(pageSize)
                .setFirstResult(pageSize * pageNumber)
                .getResultList();
    }
}
