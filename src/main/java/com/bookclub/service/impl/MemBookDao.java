package com.bookclub.service.impl;

/*
Lomax, R. (2021). CIS 530 Server-Side Development. Bellevue University.
Modified by N.See 2021
*/

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        this.books = new ArrayList<Book>();
        this.books.add(new Book("9780802125361", "Please Kill Me: The Uncensored Oral History of Punk", "A contemporary classic, Please Kill Me is the definitive oral history of the most nihilistic of all pop movements. Iggy Pop, Richard Hell, the Ramones, and scores of other punk figures lend their voices to this decisive account of that explosive era. This 20th anniversary edition features new photos and an afterword by the authors.", 448, new ArrayList<>(List.of("Legs McNeil", "Gillian McCain"))));
        this.books.add(new Book("9780609807743", "We Got the Neutron Bomb : The Untold Story of L.A. Punk", "Assembled from exhaustive interviews, We Got the Neutron Bomb tells the authentically gritty stories of bands like the Runaways, the Germs, X, the Screamers, Black Flag, and the Circle Jerks—their rise, their fall, and their undeniable influence on the rock ’n’ roll of today.", 320, new ArrayList<>(List.of("Marc Spitz", "Brendan Mullen"))));
        this.books.add(new Book("9781452170398", "We Are the Change: Words of Inspiration from Civil Rights Leaders", "Sixteen award-winning children's book artists illustrate the civil rights quotations that inspire them in this stirring and beautiful book. Featuring an introduction by Harry Belafonte, words from Eleanor Roosevelt, Maya Angelou, and Dr. Martin Luther King, Jr. among others, this inspirational collection sets a powerful example for generations of young leaders to come. It includes illustrations by Selina Alko, Alina Chau, Lisa Congdon, Emily Hughes, Molly Idle, Juana Medina, Innosanto Nagara, Christopher Silas Neal, John Parra, Brian Pinkney, Greg Pizzoli, Sean Qualls, Dan Santat, Shadra Strickland, Melissa Sweet, and Raúl the Third.", 48, new ArrayList<>(List.of("Harry Belafonte"))));
        this.books.add(new Book("9781452169927", "Art of Feminism: Images that Shaped the Fight for Equality, 1857-2017", "Features more than 350 works of art, illustration, photography, performance, and graphic design along with essays examining the legacy of the radical canon", 272, new ArrayList<>(List.of("Helena Reckitt"))));
        this.books.add(new Book("9781732098671", "The New Woman's Survival Catalog: A Woman-made Book", "Originally published in 1973, The New Woman’s Survival Catalog is a seminal survey of the second-wave feminist effort across the US. Edited by Kirsten Grimstad and Susan Rennie in just five months, The New Woman’s Survival Catalog makes a nod to Stewart Brand’s influential Whole Earth Catalog, mapping a vast network of feminist alternative cultural activity in the 1970s.", 210, new ArrayList<>(List.of("Kirsten Grimstad", "Susan Rennie"))));
    }

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}
