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

    @BeforeEach
    void setUp() {
        album = new AlbumImpl(4);

        photo1 = new Photo(1, 1, "Iron Man", "https://example.com/iron_man.jpg", LocalDateTime.now());
        photo2 = new Photo(1, 2, "Spider-Man", "https://example.com/spider_man.jpg", LocalDateTime.now());

        album.addPhoto(photo1);
        album.addPhoto(photo2);

        album.addPhoto(new Photo(2, 3, "Black Widow", "https://example.com/black_widow.jpg", LocalDateTime.now()));
    }

    @Test
    void testAddPhoto() {
        //Add photo success check
        Photo newPhoto = new Photo(3, 4, "Hulk", "https://example.com/hulk.jpg", LocalDateTime.now());
        assertTrue(album.addPhoto(newPhoto));
        assertEquals(4, album.size());

        //test to add photo with the same photoId and albumId
        assertFalse(album.addPhoto(newPhoto));

        //Null photo check
        assertFalse(album.addPhoto(null));
        assertEquals(4, album.size());


        // test add photo exceed capacity
        Photo extraPhoto = new Photo(11, 1, "Extra Photo", "https://example.com/extraphoto.jpg", LocalDateTime.now());
        assertFalse(album.addPhoto(extraPhoto));
        assertEquals(4, album.size());

        //test add photo duplicate photo
        assertFalse(album.addPhoto(newPhoto));

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

//        Photo[] expectedPhotos = {photo1, photo2, null};
//        Photo[] actualPhotos = album.getAllPhotoFromAlbum(1);
//        assertArrayEquals(expectedPhotos, actualPhotos);

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

        LocalDate startDate = LocalDate.of(2023, 8, 16);
        LocalDate endDate = LocalDate.of(2023, 8, 18);

        Photo[] result = album.getPhotoBetweenDate(startDate, endDate);
        assertEquals(0, result.length);
    }

    @Test
    void testSize() {
        assertEquals(3, album.size());
    }
}
