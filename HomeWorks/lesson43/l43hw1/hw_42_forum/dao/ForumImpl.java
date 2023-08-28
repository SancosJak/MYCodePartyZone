package hw_42_forum.dao;

import hw_42_forum.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForumImpl implements Forum{

    private static Comparator<Post> comparator = (p1, p2) -> {
        if (p1 == null || p1.getAuthor() == null || p1.getDate() == null) {

            return -1;
        }
        if (p2 == null || p2.getAuthor() == null || p2.getDate() == null) {

            return 1;
        }

    int res = p1.getAuthor().compareTo(p2.getAuthor());
     res = res != 0 ? res : p1.getDate().compareTo(p2.getDate());
    return res != 0 ? res : Integer.compare(p1.getPostId(), p2.getPostId());
    };

    private Post[] posts;
    private int size;

    public ForumImpl(){
        posts = new Post[0];
    }

    @Override
    public boolean addPost(Post post) {
        //TODO throw RuntimeException if post == null
        if(post == null){
            throw new RuntimeException();
        }
        if (getPostById(post.getPostId()) != null) {
            return false;
        }
        posts = Arrays.copyOf(posts, posts.length + 1);
        int index = Arrays.binarySearch(posts, 0, size, post, comparator);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(posts, index, posts, index + 1, size - index);
        posts[index] = post;
        size++;
        return true;
    }

    @Override
    public boolean removePost(int postId) {
        int index = searchById(postId);
        if (index < 0) {
            return false;
        }
        System.arraycopy(posts, index + 1, posts, index, size - index - 1);
        posts = Arrays.copyOf(posts, posts.length - 1);
        size--;
        return true;
    }

    @Override
    public boolean updatePost(int postId, String newContent) {
        int index = searchById(postId);
        if (index < 0) {
            return false;
        }
        posts[index].setContent(newContent);
        return true;
    }

    @Override
    public Post getPostById(int postId) {
        int index = searchById(postId);
        if (index < 0) {
            return null;
        }
        return posts[index];
    }

    @Override
    public Post[] getPostsByAuthor(String author) {
        Post startPattern = new Post(Integer.MIN_VALUE, null, author, null);
        startPattern.setDate(LocalDateTime.MIN);
        int from = -Arrays.binarySearch(posts, startPattern, comparator) - 1;

        Post endPattern = new Post(Integer.MAX_VALUE, null, author, null);
        endPattern.setDate(LocalDateTime.MAX);
        int to = -Arrays.binarySearch(posts, endPattern, comparator) - 1;

        return Arrays.copyOfRange(posts, from, to);
    }
//    @Override
//    public Post[] getPostsByAuthor(String author) {
//        int count = 0;
//        for (Post post : posts) {
//            if (post.getAuthor().equals(author)) {
//                count++;
//            }
//        }
//
//        Post[] result = new Post[count];
//        int index = 0;
//
//        for (Post post : posts) {
//            if (post.getAuthor().equals(author)) {
//                result[index++] = post;
//            }
//        }
//
//        return result;
//    }

    @Override
    public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        //FIXME increase performance. Hint: use binary search. Upgrade comparator
        Post pattern = new Post(Integer.MIN_VALUE, author, null, null);
        pattern.setDate(dateFrom.atStartOfDay());
        int from = -Arrays.binarySearch(posts, pattern, comparator) - 1;
        pattern = new Post(Integer.MAX_VALUE, author, null, null);
        pattern.setDate(LocalDateTime.of(dateTo, LocalTime.MAX));
        int to = -Arrays.binarySearch(posts, pattern, comparator) - 1;
        return Arrays.copyOfRange(posts, from, to);
    }

    @Override
    public int size() {
        return size;
    }

    private int searchById(int postId) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                return i;
            }
        }
        return -1;
    }

    private Post[] findByPredicate(Predicate<Post> predicate) {
        Post[] res = new Post[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(posts[i])) {
                res[j++] = posts[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}