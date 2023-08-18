package album;

import album.dao.AlbumImpl;
import album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlbumAppl {
    public static void main(String[] args) {
        AlbumImpl album = new AlbumImpl(10);

        Photo photo1 = new Photo(1, 1, "Iron Man", "https://example.com/iron_man.jpg", LocalDateTime.now());
        Photo photo2 = new Photo(1, 2, "Spider-Man", "https://example.com/spider_man.jpg", LocalDateTime.now());
        Photo photo3 = new Photo(2, 3, "Black Widow", "https://example.com/black_widow.jpg", LocalDateTime.now());

        album.addPhoto(photo1);
        album.addPhoto(photo2);
        album.addPhoto(photo3);

        System.out.println("Album size: " + album.size());
        System.out.println(album.toString());
        //System.out.println(album);


        Photo retrievedPhoto = album.getPhotoFromAlbum(2, 3);
        if (retrievedPhoto != null) {
            System.out.println("Retrieved photo: " + retrievedPhoto.getTitle());
        } else {
            System.out.println("Photo not found.");
        }

        Photo[] photosInAlbum1 = album.getAllPhotoFromAlbum(1);
        System.out.println("Photos in Album 1:");
        for (Photo photo : photosInAlbum1) {
            if (photo != null) {
                System.out.println(photo.getTitle());
            }
        }

        Photo[] photosBetweenDates = album.getPhotoBetweenDate(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        System.out.println("Photos between dates:");
        for (Photo photo : photosBetweenDates) {
            if (photo != null) {
                System.out.println(photo.getTitle());
            }
        }

        album.removePhoto(1, 1);
        System.out.println("Album size after removal: " + album.size());
    }
}
