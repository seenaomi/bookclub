package com.bookclub.service;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/

import java.util.List;

public interface GenericCrudDao<E, K> {
    void add(E entity);
    void update(E entity);
    boolean remove(E entity);
    List<E> list();
    E find(K key);

}
