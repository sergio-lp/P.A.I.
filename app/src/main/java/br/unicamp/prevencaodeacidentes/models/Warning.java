package br.unicamp.prevencaodeacidentes.models;

public class Warning {
    private String title;
    private String description;
    private float type;
    private double lat;
    private double lon;

    public Warning(String title, String description, float type, double lat, double lon) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
    }

    public Warning() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getType() {
        return type;
    }

    public void setType(float type) {
        this.type = type;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
