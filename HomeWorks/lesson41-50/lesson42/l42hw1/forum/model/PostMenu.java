package forum.model;

public enum PostMenu {
    LIST_ALL_POSTS(1),
    ADD_POST(2),
    REMOVE_POST(3),
    UPDATE_POST(4),
    GET_POST_BY_ID(5),
    GET_POSTS_BY_AUTHOR(6),
    SAVE_DATA(7),
    READ_DATA(8),

    EXIT(9);

    private int menuItem;

    PostMenu(int menuItem) {
        this.menuItem = menuItem;
    }

    public int getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(int menuItem) {
        this.menuItem = menuItem;
    }
    public static void printMenu() {
        StringBuilder menuString = new StringBuilder();
        for (PostMenu option : PostMenu.values()) {
            menuString.append(option.getMenuItem()).append(" - ").append(option).append(" | ");
        }
        System.out.println(menuString.toString());
    }
}
