package album.model;

public enum AlbumMenu {
    LIST(1), ADD(2), FIND(3), REMOVE(4), SAVE(5), EXIT(6);

    private int menuItem;

    AlbumMenu(int menuItem) {
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
        for (AlbumMenu option : AlbumMenu.values()) {
            menuString.append(option.getMenuItem()).append(" - ").append(option).append(" | ");
        }
        System.out.println(menuString.toString());
    }
}
