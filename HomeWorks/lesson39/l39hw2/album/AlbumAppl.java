package album;

import album.dao.AlbumImpl;
import album.model.AlbumMenu;
import album.model.Photo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AlbumAppl {
    private static int getUserChoice() {
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
    private static void savePhotosToFile() {
        System.out.print("Enter a file name to save the photos: ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Photo photo : album.getAllPhotos()) {
                if (photo != null) {
                    writer.write(photo.toString());
                    writer.newLine();
                }
            }
            System.out.println("Photos are saved to a file " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving photos: " + e.getMessage());
        }
    }

    private static AlbumImpl album = new AlbumImpl(100);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            AlbumMenu.printMenu();
            int choice = getUserChoice();

            AlbumMenu selectedOption = AlbumMenu.values()[choice-1];

            switch (selectedOption) {
                case LIST:
                    System.out.println("Enter the album number for the photo::");
                    int getAllPhotoAlbumId = scanner.nextInt();
                    Photo[] photosFromAlbum = album.getAllPhotoFromAlbum(getAllPhotoAlbumId);
                    if (photosFromAlbum.length == 0) {
                        System.out.println("There are no photos in album.");
                    } else {
                        for (Photo photo : photosFromAlbum) {
                            if (photo != null) {
                                System.out.println(photo.toString());
                            }
                        }
                    }
                    break;
                case ADD:
                    System.out.println("Enter the album number for the new photo:");
                    int albumId = scanner.nextInt();
                    System.out.println("Enter the photo's number:");
                    int photoId = scanner.nextInt();
                    System.out.println("Enter the photo's title:");
                    String titlePhoto = scanner.next();
                    System.out.println("Enter the photo's url:");
                    String urlPhoto = scanner.next();
                    Photo newPhoto = new Photo(albumId, photoId, titlePhoto, urlPhoto, LocalDateTime.now());
                    if (album.addPhoto(newPhoto)) {
                        System.out.println("Photo added successfully!");
                    } else {
                        System.out.println("Failed to add photo. Album is full.");
                    }
                    break;
                case FIND:
                    System.out.println("Enter the album number for the photo:");
                    int findAlbumId = scanner.nextInt();
                    System.out.println("Enter the photo's number:");
                    int findPhotoId = scanner.nextInt();
                    Photo foundPhoto = album.getPhotoFromAlbum(findPhotoId, findAlbumId);
                    if (foundPhoto != null) {
                        System.out.println("Found photo: " + foundPhoto.toString());
                    } else {
                        System.out.println("Photo with such number and album not found.");
                    }
                    break;
                case REMOVE:
                    System.out.println("Enter the album number for the photo:");
                    int removeAlbumId = scanner.nextInt();
                    System.out.println("Enter the photo's number:");
                    int removePhotoId = scanner.nextInt();

                    if (album.removePhoto(removePhotoId, removeAlbumId)) {
                        System.out.println("Photo successfully removed.");
                    } else {
                        System.out.println("Photo with such number and album not found.");
                    }
                    break;
                case SAVE:
                    savePhotosToFile();
                    break;
                case EXIT:
                    exit = true;
                    System.out.println("Exit from the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

}
