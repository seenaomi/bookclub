package com.bookclub.service.impl;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);

    }

    @Override
    public void update(WishlistItem entity) {
        WishlistItem wishlistItem = mongoTemplate.findById(entity.getId(), WishlistItem.class);

        if(wishlistItem != null) {
            wishlistItem.setIsbn(entity.getIsbn());
            wishlistItem.setId(entity.getTitle());
            wishlistItem.setUsername(entity.getUsername());

            mongoTemplate.save(wishlistItem);
        }
    }

    @Override
    public boolean remove(String key) {
        Query query = new Query();

        query.addCriteria(Criteria.where("id").is(key));

        mongoTemplate.remove(query, WishlistItem.class);

        return true;
    }

    @Override
    public List<WishlistItem> list(String username) {
        Query query = new Query();

        query.addCriteria(Criteria.where("username").is(username));

        return mongoTemplate.find(query, WishlistItem.class);
    }

    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}
