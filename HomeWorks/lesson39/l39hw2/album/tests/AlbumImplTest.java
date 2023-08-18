package album.tests;

import album.dao.Album;
import album.dao.AlbumImpl;
import album.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class AlbumImplTest {
    private Album album;
    private Photo photo1;
    private Photo photo2;
    private Photo photo3;

    @BeforeEach
    void setUp() {
        album = new AlbumImpl(10);

        photo1 = new Photo(1, 1, "Iron Man", "https://example.com/iron_man.jpg", LocalDateTime.now());
        photo2 = new Photo(1, 2, "Spider-Man", "https://example.com/spider_man.jpg", LocalDateTime.now());
        photo3 = new Photo(2, 3, "Black Widow", "https://example.com/black_widow.jpg", LocalDateTime.now());

        album.addPhoto(photo1);
        album.addPhoto(photo2);
        album.addPhoto(photo3);
    }

    @Test
    void testAddPhoto() {
        Photo newPhoto = new Photo(3, 4, "Hulk", "https://example.com/hulk.jpg", LocalDateTime.now());
        assertTrue(album.addPhoto(newPhoto));
        assertEquals(4, album.size());
    }

    @Test
    void testRemovePhoto() {
        assertEquals(3, album.size());
        assertTrue(album.removePhoto(photo2.getPhotoId(), photo2.getAlbumId()));
        assertEquals(2, album.size());
    }

    @Test
    void testUpdatePhoto() {
        assertTrue(album.updatePhoto(photo1.getPhotoId(), photo1.getAlbumId(), "https://example.com/new_iron_man.jpg"));
        Photo updatedPhoto = album.getPhotoFromAlbum(photo1.getPhotoId(), photo1.getAlbumId());
        assertEquals("https://example.com/new_iron_man.jpg", updatedPhoto.getUrl());
    }

    @Test
    void testGetPhotoFromAlbum() {
        assertEquals(photo2, album.getPhotoFromAlbum(photo2.getPhotoId(), photo2.getAlbumId()));
    }

    @Test
    void testGetAllPhotoFromAlbum() {
        Album emptyAlbum = new AlbumImpl(10);
        Photo[] photosFromEmptyAlbum = emptyAlbum.getAllPhotoFromAlbum(1);
        assertEquals(0, photosFromEmptyAlbum.length);

        Photo[] photosFromAlbum1 = album.getAllPhotoFromAlbum(1);
        assertEquals(2, photosFromAlbum1.length);

        Photo[] photosFromAlbum2 = album.getAllPhotoFromAlbum(2);
        assertEquals(1, photosFromAlbum2.length);

        Photo[] photosFromAlbum3 = album.getAllPhotoFromAlbum(3);
        assertEquals(0, photosFromAlbum3.length);
    }

    @Test
    void testGetPhotoBetweenDate() {
        Photo[] photosBetweenDate = album.getPhotoBetweenDate(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertEquals(3, photosBetweenDate.length);
    }

    @Test
    void testSize() {
        assertEquals(3, album.size());
    }
}