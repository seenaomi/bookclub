package com.bookclub.service.impl;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

    }

    @Override
    public boolean remove(WishlistItem entity) {
        return false;
    }

    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}
