package Bridge.devices;

import java.util.List;

public class SmartTV implements SmartDevice {
    private static final List<String> INSTALLED_APPS = List.of("YouTube", "Netflix", "Yle Areena");

    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    private String currentContent = "Channel 1";

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = Math.max(1, channel);
        currentContent = "Channel " + this.channel;
    }

    @Override
    public void openApp(String appName) {
        if (!on) {
            System.out.println("SmartTV: cannot open " + appName + ", the TV is off.");
            return;
        }
        for (String app : INSTALLED_APPS) {
            if (app.equalsIgnoreCase(appName)) {
                currentContent = "App: " + app;
                System.out.println("SmartTV: opening app " + app);
                return;
            }
        }
        System.out.println("SmartTV: app '" + appName + "' is not installed.");
    }

    @Override
    public void browseInternet(String url) {
        if (!on) {
            System.out.println("SmartTV: cannot browse, the TV is off.");
            return;
        }
        currentContent = "Browser: " + url;
        System.out.println("SmartTV: browsing to " + url);
    }

    @Override
    public String getCurrentContent() {
        return currentContent;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm Smart TV.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("| Showing: " + currentContent);
        System.out.println("------------------------------------\n");
    }
}
