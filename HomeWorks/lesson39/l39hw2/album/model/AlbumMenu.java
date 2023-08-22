package album.model;
/*
 Для приложения Album сделать Menu: List, Add, Find, Remove, Save, Exit
 должно сохранять созданные Photo в файл построчно.
 */
public enum AlbumMenu {
    ALL_PHOTO_FROM_ALBUM(1), ADD_PHOTO(2), FIND_PHOTO(3), REMOVE_PHOTO(4), SAVE(5), EXIT(6);

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
