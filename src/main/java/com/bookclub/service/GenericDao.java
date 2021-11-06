package com.bookclub.service;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/

import java.util.List;

public interface GenericDao<E, K> {
    List<E> list(K key); // Return a list of objects of type E.
    E find(K key); // Return an object of type E by type K value.
}
