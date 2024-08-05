package com.davidblog.comments.repository.impl;

import com.davidblog.comments.entity.Comment;
import com.davidblog.comments.repository.CommentRepositoryCustom;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {
    @Autowired
    private EntityManager em;

    @Override
    public List<Comment> getCommentByPost(Long postId) {
        return em.createQuery("""
                            select c from Comment c where c.postId = :postId
                        """, Comment.class)
                .setParameter("postId", postId)
                .getResultList();
    }
}
