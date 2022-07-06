package observables;

public class Weather extends Observable {

    private String weather;

    public Weather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public void change() {
        notifyObservers(this, "Changed");
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weather='" + weather + '\'' +
                '}';
    }
}
