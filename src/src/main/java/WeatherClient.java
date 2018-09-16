import rx.Observable;
import rx.Subscriber;

public class WeatherClient {

    public void printWeatherData(String cityName) {
        Observable<WeatherData> weatherDataObservable = RetrofitClient.getWeatherData(cityName);

        weatherDataObservable
                .subscribe(new Subscriber<WeatherData>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("On Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("On Error");
                    }

                    @Override
                    public void onNext(WeatherData weatherData) {
                        System.out.println("Current Weather :" + weatherData.getWeather()
                                .get(0)
                                .getDescription());
                    }
                });
    }
}