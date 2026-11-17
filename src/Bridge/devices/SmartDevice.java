package Bridge.devices;

public interface SmartDevice extends Device {
    void openApp(String appName);

    void browseInternet(String url);

    String getCurrentContent();
}
