package practice.seasons;

public class SeasonAppl {
    public static void main(String[] args) {
        Season season = Season.WINTER;
        System.out.println(season);
        System.out.println(Season.AUTUMN);
        System.out.println(season.name());

        System.out.println();

        System.out.println("-----values-----");
        Season[] seasons = Season.values();
        for (int i = 0; i < seasons.length; i++) {
            System.out.println(seasons[i]);
        }

        System.out.println();

        System.out.println("-----ordinal-----");
        System.out.println(season.name());
        System.out.println(season.ordinal());
        System.out.println(season.SPRING.ordinal());
        System.out.println(season.AUTUMN.ordinal());

    }
}
