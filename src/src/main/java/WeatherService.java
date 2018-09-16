import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherService {

    @GET("weather?")
    Observable<WeatherData> getWeatherData(@Query("q") String city, @Query("APPID") String key);
}
