package com.bookclub.service.impl;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlistItems;

    public MemWishlistDao() {
        this.wishlistItems = new ArrayList<WishlistItem>();
        this.wishlistItems.add(new WishlistItem("9780802125361", "Please Kill Me: The Uncensored Oral History of Punk"));
        this.wishlistItems.add(new WishlistItem("9780609807743", "We Got the Neutron Bomb : The Untold Story of L.A. Punk"));
        this.wishlistItems.add(new WishlistItem("9781452170398", "We Are the Change: Words of Inspiration from Civil Rights Leaders"));
        this.wishlistItems.add(new WishlistItem("9781452169927", "Art of Feminism: Images that Shaped the Fight for Equality, 1857-2017"));
        this.wishlistItems.add(new WishlistItem("9781732098671", "The New Woman's Survival Catalog: A Woman-made Book"));
    }

    @Override
    public List<WishlistItem> list() {
        return this.wishlistItems;
    }

    @Override
    public WishlistItem find(String key) {
        for (WishlistItem item : wishlistItems) {
            if(item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
    }
}
