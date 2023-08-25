package forum;

import forum.dao.Forum;
import forum.dao.ForumImpl;
import forum.model.Post;
import forum.model.PostMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ForumApp {

    public static PostMenu getMenuByItem(int item) {
        for (PostMenu menu : PostMenu.values()) {
            if (menu.getMenuItem() == item) {
                return menu;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Forum forum = new ForumImpl();
        Scanner scanner = new Scanner(System.in);

        boolean continueExecution = true;

        while (continueExecution) {
            PostMenu.printMenu();
            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                PostMenu selectedMenu = getMenuByItem(choice);

                if (selectedMenu != null) {
                    switch (selectedMenu) {
                        case LIST_ALL_POSTS:
                            if (forum.size() > 0) {
                                System.out.println("Posts:");
                                for (Post post : ((ForumImpl) forum).getAllPosts()) {
                                    if (post != null) {
                                        System.out.println(post);
                                    }
                                }
                            } else {
                                System.out.println("No posts available.");
                            }
                            break;
                        case ADD_POST:
                            System.out.print("Enter post title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter post author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter post content: ");
                            String content = scanner.nextLine();

                            Post newPost = new Post(forum.size() + 1, title, author, content, null, 0);

                            if (forum.addPost(newPost)) {
                                System.out.println("Post added successfully!");
                            } else {
                                System.out.println("Failed to add post.");
                            }
                            break;


                        case REMOVE_POST:
                            System.out.print("Enter post ID to remove: ");
                            int postIdToRemove = scanner.nextInt();
                            if (forum.removePost(postIdToRemove)) {
                                System.out.println("Post removed successfully!");
                            } else {
                                System.out.println("Post not found.");
                            }
                            break;

                        case UPDATE_POST:
                            System.out.print("Enter post ID to update: ");
                            int postIdToUpdate = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter new content: ");
                            String newContent = scanner.nextLine();
                            if (forum.updatePost(postIdToUpdate, newContent)) {
                                System.out.println("Post updated successfully!");
                            } else {
                                System.out.println("Post not found.");
                            }
                            break;

                        case GET_POST_BY_ID:
                            System.out.print("Enter post ID to retrieve: ");
                            int postIdToRetrieve = scanner.nextInt();
                            scanner.nextLine();
                            Post retrievedPost = forum.getPostById(postIdToRetrieve);
                            if (retrievedPost != null) {
                                System.out.println("Retrieved post: " + retrievedPost);
                            } else {
                                System.out.println("Post not found.");
                            }
                            break;

                        case GET_POSTS_BY_AUTHOR:
                            System.out.print("Enter author: ");
                            String authorToSearch = scanner.nextLine();
                            Post[] postsByAuthor = forum.getPostsByAuthor( authorToSearch,null, null);
                            if (postsByAuthor.length > 0) {
                                System.out.println("Posts by author " + authorToSearch + ":");
                                for (Post post : postsByAuthor) {
                                    System.out.println(post);
                                }
                            } else {
                                System.out.println("No posts found for author " + authorToSearch);
                            }
                            break;

                        case SAVE_DATA:
                            System.out.print("Enter a file name to save the posts: ");
                            String saveFileName = scanner.nextLine();
                            forum.saveForumToFile(saveFileName);
                            break;

                        case READ_DATA:
                            System.out.print("Enter a file name to load posts from: ");
                            String readFileName = scanner.nextLine();
                            forum.loadForumFromFile(readFileName);
                            break;

                        case EXIT:
                            continueExecution = false;
                            break;

                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;
                    }

                    System.out.print("Do you want to continue (y/n)? ");
                    String continueChoice = scanner.next();
                    if (continueChoice.equalsIgnoreCase("n")) {
                        continueExecution = false;
                    }
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine();
            }
        }

        System.out.println("Thank you for using Forum Application!");
        scanner.close();
    }
}