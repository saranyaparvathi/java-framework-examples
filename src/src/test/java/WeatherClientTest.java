import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

public class WeatherClientTest {

    WeatherClient subject;

    @Before
    public void setup() {
        subject = new WeatherClient();
    }

    @Test
    public void givenCityIsChennai_onSuccess_printWeatherData() {

        subject.printWeatherData("Chennai");

        TestSubscriber<WeatherData> testSubscriber = new TestSubscriber<>();
        WeatherData weatherData = new WeatherData();
        Observable<WeatherData> weatherDataObservable = Observable.just(weatherData);
        weatherDataObservable.subscribe(testSubscriber);

        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(weatherData);
        testSubscriber.assertNoErrors();
    }

    @Test
    public void givenCityIsChennai_onError_doesNotPrintWeatherData() {
        subject.printWeatherData("Chennai");

        TestSubscriber<WeatherData> testSubscriber = new TestSubscriber<>();
        Observable<WeatherData> weatherDataObservable = Observable.error(new RuntimeException());
        weatherDataObservable.subscribe(testSubscriber);

        testSubscriber.assertValueCount(0);
        testSubscriber.assertError(RuntimeException.class);
    }
}
