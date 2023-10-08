package attendance.model;

public enum AttendanceAction {
    ADD_STUDENT (1),
    ADD_LESSON_DATE(2),
    MARK_ATTENDANCE(3),
    PRINT_ALL_ATTENDANCE(4),
    PRINT_STUDENT_ATTENDANCE(5),

    EXIT(6);
    private int menuItem;

    AttendanceAction(int menuItem) {
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
        for (AttendanceAction option : AttendanceAction.values()) {
            menuString.append(option.getMenuItem()).append(" - ").append(option).append(" | ");
        }
        System.out.println(menuString.toString());
    }
}
