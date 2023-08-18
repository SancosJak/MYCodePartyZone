package album.dao;

import album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class AlbumImpl implements Album {
    private Photo[] photos;
    private int capacity;
    private int size;

    public AlbumImpl(int capacity) {
        this.capacity = capacity;
        this.photos = new Photo[capacity];
        this.size = 0;
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (size < capacity) {
            photos[size] = photo;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                System.arraycopy(photos, i + 1, photos, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                photos[i].setUrl(url);
                return true;
            }
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        Photo[] result = new Photo[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (photos[i].getAlbumId() == albumId) {
                result[count++] = photos[i];
            }
        }
        return result;
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        Photo[] result = new Photo[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            LocalDateTime photoDate = photos[i].getDate();
            LocalDate photoLocalDate = photoDate.toLocalDate();

            if (photoLocalDate.isAfter(dateFrom) && photoLocalDate.isBefore(dateTo.plusDays(1))) {
                result[count++] = photos[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album contents:\n");
        for (int i = 0; i < size; i++) {
            sb.append(photos[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
