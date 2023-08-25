package forum.tests;

import forum.dao.ForumImpl;
import forum.model.Post;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ForumImplTest {

    @Test
    void testAddPost() {
        ForumImpl forum = new ForumImpl();
        Post post = new Post(1, "Title", "Author", "Content", null, 0);

        assertTrue(forum.addPost(post));
        assertEquals(1, forum.size());

        assertFalse(forum.addPost(post));

        assertFalse(forum.addPost(new Post(2, null, "Author 2", "Content 2", null, 0)));
        assertEquals(1, forum.size());
    }

    @Test
    void testRemovePost() {
        ForumImpl forum = new ForumImpl();
        Post post = new Post(1, "Title", "Author", "Content", null, 0);
        assertTrue(forum.addPost(post));

        assertTrue(forum.removePost(1));
        assertEquals(0, forum.size());

        assertFalse(forum.removePost(1));
    }

    @Test
    void testUpdatePost() {
        ForumImpl forum = new ForumImpl();
        Post post = new Post(1, "Title", "Author", "Content", null, 0);
        assertTrue(forum.addPost(post));

        assertTrue(forum.updatePost(1, "Updated content"));
        assertEquals("Updated content", forum.getPostById(1).getContent());

        assertFalse(forum.updatePost(2, "Updated content"));
    }

    @Test
    void getPostById() {
        Post post1 = new Post(1, "Title 1", "Author 1", "Content 1", null, 0);
        Post post2 = new Post(2, "Title 2", "Author 2", "Content 2", null, 0);

        ForumImpl forum = new ForumImpl();
        forum.addPost(post1);
        forum.addPost(post2);

        assertEquals(post1, forum.getPostById(1));
        assertEquals(post2, forum.getPostById(2));

        ForumImpl forum1 = new ForumImpl();
        assertNull(forum1.getPostById(1));
    }

    @Test  //testGetPostsByAuthorWithDateRange
    void getPostsByAuthor() {
        LocalDate today = LocalDate.now();
        LocalDate twoDaysAgo = today.minusDays(2);
        LocalDate fourDaysAgo = today.minusDays(4);

        Post post1 = new Post(1, "Title 1", "Author", "Content 1", twoDaysAgo.atStartOfDay(), 0);
        Post post2 = new Post(2, "Title 2", "Author", "Content 2", fourDaysAgo.atStartOfDay(), 0);
        Post post3 = new Post(3, "Title 3", "Author", "Content 3", today.atStartOfDay(), 0);

        ForumImpl forum = new ForumImpl();
        forum.addPost(post1);
        forum.addPost(post2);
        forum.addPost(post3);

        Post[] postsByAuthor = forum.getPostsByAuthor("Author", fourDaysAgo, today);

        assertEquals(3, postsByAuthor.length);
        assertTrue(postsByAuthor[0].getTitle().equals("Title 1") || postsByAuthor[0].getTitle().equals("Title 3"));
        assertFalse(postsByAuthor[1].getTitle().equals("Title 1") || postsByAuthor[1].getTitle().equals("Title 3"));
        assertNotEquals(postsByAuthor[0].getTitle(), postsByAuthor[1].getTitle());
    }
    @Test
    void testGetPostsByAuthorWithoutDateRange() {
        Post post1 = new Post(1, "Title 1", "Author", "Content 1", null, 0);
        Post post2 = new Post(2, "Title 2", "Author", "Content 2", null, 0);

        ForumImpl forum = new ForumImpl();
        forum.addPost(post1);
        forum.addPost(post2);

        Post[] postsByAuthor = forum.getPostsByAuthor("Author", null, null);

        assertEquals(2, postsByAuthor.length);
        assertTrue(postsByAuthor[0].getTitle().equals("Title 1") || postsByAuthor[0].getTitle().equals("Title 2"));
        assertTrue(postsByAuthor[1].getTitle().equals("Title 1") || postsByAuthor[1].getTitle().equals("Title 2"));
        assertNotEquals(postsByAuthor[0].getTitle(), postsByAuthor[1].getTitle());
    }

    @Test
    void testGetPostsByNonexistentAuthor() {
        ForumImpl forum = new ForumImpl();
        Post[] postsByAuthor = forum.getPostsByAuthor("Nonexistent Author", null, null);

        assertEquals(0, postsByAuthor.length);
    }

    @Test
    void testSize() {
        ForumImpl forum = new ForumImpl();
        assertEquals(0, forum.size());

        Post post = new Post(1, "Title", "Author", "Content", null, 0);
        forum.addPost(post);
        assertEquals(1, forum.size());

        Post post2 = new Post(2, "Title 2", "Author 2", "Content 2", null, 0);
        forum.addPost(post2);
        assertEquals(2, forum.size());

        forum.removePost(1);
        assertEquals(1, forum.size());
    }

    @Test
    void testSaveAndLoadForumFromFile() {

        String testFileName = "testPosts.txt";
        ForumImpl forum = new ForumImpl();

        Post post1 = new Post(1, "Title 1", "Author 1", "Content 1", null, 0);
        Post post2 = new Post(2, "Title 2", "Author 2", "Content 2", null, 0);
        assertTrue(forum.addPost(post1));
        assertTrue(forum.addPost(post2));

        forum.saveForumToFile(testFileName);

        ForumImpl forum1 = new ForumImpl();
        forum1.loadForumFromFile(testFileName);

        assertEquals(2, forum1.size());
        assertEquals(post1, forum1.getPostById(1));
        assertEquals(post2, forum1.getPostById(2));
    }

}