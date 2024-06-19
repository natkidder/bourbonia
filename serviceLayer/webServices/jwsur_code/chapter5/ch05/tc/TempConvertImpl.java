package ch05.tc;
import javax.jws.WebService;

@WebService(endpointInterface = "ch05.tc.TempConvert")
public class TempConvertImpl implements TempConvert {
    public float c2f(float t) { return 32.0f + (t * 9.0f / 5.0f); }
    public float f2c(float t) { return (5.0f / 9.0f) * (t - 32.0f); }
}