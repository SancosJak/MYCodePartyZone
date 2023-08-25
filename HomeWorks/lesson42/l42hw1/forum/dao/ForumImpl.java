package forum.dao;

import forum.model.Post;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ForumImpl implements Forum {

    private static Post[] posts;
    private int size;

    public ForumImpl() {
        this.posts = new Post[10];
        this.size = 0;
    }

    @Override
    public boolean addPost(Post post) {
        String title = post.getTitle();
        String author = post.getAuthor();
        String content = post.getContent();

        if (title == null || author == null || content == null) {
            return false; // throw new IllegalArgumentException("Some parameters are null");
        }

        int postId = post.getPostId();

        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                return false;
            }
        }

        LocalDateTime date = LocalDateTime.now();
        int likes = generateRandomLikes();

        Post newPost = new Post(postId, title, author, content, date, likes);

        if (size == posts.length) {
            resizePostsArray();
        }

        int index = Arrays.binarySearch(posts, 0, size, newPost);
        if (index < 0) {
            index = -index - 1;
        }

        System.arraycopy(posts, index, posts, index + 1, size - index);

        posts[index] = newPost;
        size++;

        return true;
    }


    private int generateRandomLikes() {
        return (int) (Math.random() * 100);
    }

    private void resizePostsArray() {
        int newCapacity = posts.length * 2;
        Post[] newPosts = new Post[newCapacity];
        System.arraycopy(posts, 0, newPosts, 0, size);
        posts = newPosts;
    }

    @Override
    public boolean removePost(int postId) {
        int index = findPostIndex(postId);
        if (index != -1) {
            posts[index] = null;
            size--;

            // Уменьшение postId на 1 для оставшихся элементов
            for (int i = 0; i < posts.length; i++) {
                if (posts[i] != null && posts[i].getPostId() > postId) {
                    posts[i].setPostId(posts[i].getPostId() - 1);
                }
            }

            // Обновление массива без пустых элементов
            Post[] tempPosts = new Post[size];
            int newIndex = 0;
            for (Post post : posts) {
                if (post != null) {
                    tempPosts[newIndex++] = post;
                }
            }

            // Обновление основного массива
            posts = tempPosts;

            // Пересортировка обновленного массива
            Arrays.sort(posts, 0, size);

            return true;
        }
        return false;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        int index = findPostIndex(postId);
        if (index != -1) {
            Post post = posts[index];
            post.setContent(content);
            return true;
        }
        return false;
    }

    private int findPostIndex(int postId) {
        for (int i = 0; i < size; i++) {
            Post post = posts[i];
            if (post != null && post.getPostId() == postId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Post getPostById(int postId) {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null && posts[i].getPostId() == postId) {
                return posts[i];
            }
        }
        return null;
    }

    @Override
    public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post[] result = new Post[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            Post post = posts[i];
            if (post != null && post.getAuthor() != null && post.getAuthor().equals(author) &&
                    (dateFrom == null || !post.getDate().toLocalDate().isBefore(dateFrom)) &&
                    (dateTo == null || !post.getDate().toLocalDate().isAfter(dateTo))) {
                result[count++] = post;
            }
        }

        return Arrays.copyOf(result, count);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void loadForumFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Post post = parsePostFromString(line);
                if (post != null) {
                    addPost(post);
                }
            }
            System.out.println("Posts are loaded from a file " + fileName);
        } catch (IOException e) {
            System.out.println("Error loading posts: " + e.getMessage());
        }
    }
    @Override
    public void saveForumToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Post[] posts = getAllPosts();
            for (Post post : posts) {
                if (post != null) {
                    writer.write(post.toString());
                    writer.newLine();
                }
            }
            System.out.println("Posts are saved to a file " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving posts: " + e.getMessage());
        }
    }

    public Post[] getAllPosts() {
        Post[] allPosts = new Post[posts.length];
        int count = 0;
        for (Post post : posts) {
            if (post != null) {
                allPosts[count++] = post;
            }
        }
        return Arrays.copyOf(allPosts, count);
    }

    public static Post parsePostFromString(String postString) {
        String[] parts = postString.split(", ");
        if (parts.length == 6) {
            int postId = Integer.parseInt(parts[0].substring(parts[0].indexOf("=") + 1));
            String title = parts[1].substring(parts[1].indexOf("'") + 1, parts[1].lastIndexOf("'"));
            String author = parts[2].substring(parts[2].indexOf("'") + 1, parts[2].lastIndexOf("'"));
            String content = parts[3].substring(parts[3].indexOf("'") + 1, parts[3].lastIndexOf("'"));

            LocalDateTime date = null;
            if (!parts[4].equals("date=null")) {
                date = LocalDateTime.parse(parts[4].substring(parts[4].indexOf("=") + 1));
            }

            int likes = Integer.parseInt(parts[5].substring(parts[5].indexOf("=") + 1, parts[5].indexOf("}")));

            return new Post(postId, title, author, content, date, likes);
        }
        return null;
    }

}
