import com.google.gson.annotations.Expose;

public class Rain {

    @Expose
    private Double _1h;

    public Double get1h() {
        return _1h;
    }

    public void set1h(Double _1h) {
        this._1h = _1h;
    }
}
