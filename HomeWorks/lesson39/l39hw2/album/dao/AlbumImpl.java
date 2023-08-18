package album.dao;

import album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class AlbumImpl implements Album {

    static Comparator <Photo> comparator = (p1,p2) -> {
        int res = p1.getDate().compareTo(p2.getDate()); //sort by data
        return res != 0 ? res : Integer.compare(p1.getPhotoId(), p2.getPhotoId()); //sort by id
    };
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
        if (photo == null || photos.length == size || getPhotoFromAlbum(photo.getPhotoId(),photo.getAlbumId()) !=null) {
            return false;
        }

        int index = Arrays.binarySearch(photos, 0, size, photo, comparator);
        index = index >= 0 ? index : - index -1;
        System.arraycopy(photos, index, photos, index + 1, size - index);
        photos[index] = photo;
        size++;
        return true;
    }


    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                System.arraycopy(photos, i + 1, photos, i, size - i - 1);
               photos[--size] = null;
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
//        method from CW, replace and test also passed
//        Photo photo = getPhotoFromAlbum(photoId, albumId); // нашли photo по двум id
//        if (photo == null) {
//            return false;
//        }
//        photo.setUrl(url);
//        return true;
    }


    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                return photos[i];
            }
        }
        return null;

        // method from CW, test also passed
//        Photo pattern = new Photo(albumId, photoId, null, null, null); // создаем объект, с которым сравниваем photo из массива
//        for (int i = 0; i < size; i++) {
//            if(pattern.equals(photos[i])) {
//                return photos[i];
//            }
//        }
//        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        Photo[] result = new Photo[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            Photo photo = photos[i];
            if (photo != null && photo.getAlbumId() == albumId) {
                result[count++] = photo;
            }
        }

        Photo[] actualResult = new Photo[count];
        System.arraycopy(result, 0, actualResult, 0, count);

        return actualResult;
    }
// method from CW, checked, tests passed
//    @Override
//    public Photo[] getAllPhotoFromAlbum(int albumId) {
//        return findByPredicate (p -> p.getAlbumId() == albumId );
//    }
//    private Photo[] findByPredicate(Predicate<Photo> predicate){
//        Photo[] res = new Photo[size];
//        int j = 0; // счетчик найденных по условию
//        for (int i = 0; i < size; i++) {
//            if(predicate.test(photos[i])) {
//                res[j++] = photos[i];
//            }
//        }
//        return Arrays.copyOf(res, j); // копируем только ту часть, где нет null
//    }


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
