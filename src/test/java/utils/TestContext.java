package utils;

public class TestContext {
    private String capturedValue;

    public TestContext( String capturedValue) {
        this.capturedValue = capturedValue;
    }

    public String getCapturedValue() {
        return capturedValue;
    }

    public void setCapturedValue(String capturedValue) {
        this.capturedValue = capturedValue;
    }
}
