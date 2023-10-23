package CinemaSysManagment.model;

import java.util.List;

public class DataModel {
    public List<Film> films;
    public List<Session> sessions;
    public List<Product> products;


    public DataModel(List<Film> films, List<Session> sessions, List<Product> products) {
        this.films = films;
        this.sessions = sessions;
        this.products = products;
    }
}