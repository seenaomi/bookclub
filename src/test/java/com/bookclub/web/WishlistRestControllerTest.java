package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WishlistRestControllerTest {
    @Autowired
    private WishlistRestController wishlistRestController;

    @MockBean
    private WishlistDao wishlistDao;

    @Test
    public void contextLoads() {
        assertThat(wishlistRestController).isNotNull();
    }

    @Test
    public void shouldShowWishlistMatchesMockWishlist() {
        String username = "user";
        List<WishlistItem> mockWishList = Arrays.asList(
                new WishlistItem("9876", "978-3-16-148410-0", "Mocking Authentication", username)
        );
        when(wishlistDao.list(username)).thenReturn(mockWishList);

        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn(username);

        List<WishlistItem> userWishlist =  wishlistRestController.showWishlist(auth);

        assertThat(userWishlist).isEqualTo(mockWishList);
    }

    @Test
    public void shouldShowWishlistDoesNotMatchMockWishlist() {
        String username = "user";
        String username2 = "user2";
        List<WishlistItem> mockWishList = Arrays.asList(
                new WishlistItem("9876", "978-3-16-148410-0", "Mocking Authentication", username)
        );
        when(wishlistDao.list(username)).thenReturn(mockWishList);

        Authentication auth = mock(Authentication.class);
        when(auth.getName()).thenReturn(username2);

        List<WishlistItem> userWishlist =  wishlistRestController.showWishlist(auth);

        assertThat(userWishlist).isNotEqualTo(mockWishList);
    }

    @Test
    public void shouldReflectThatFindByIdMatchesMockWishlistItem() {
        String id = "9876";
        WishlistItem mockWishListItem = new WishlistItem(id, "978-3-16-148410-0", "Mocking Authentication", "user");
        when(wishlistDao.find(id)).thenReturn(mockWishListItem);

        WishlistItem userWishlistItem =  wishlistRestController.findById(id);

        assertThat(userWishlistItem).isEqualTo(mockWishListItem);
    }
}
