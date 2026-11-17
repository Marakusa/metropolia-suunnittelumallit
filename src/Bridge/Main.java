package Bridge;

import Bridge.devices.Device;
import Bridge.devices.Radio;
import Bridge.devices.SmartTV;
import Bridge.devices.Tv;
import Bridge.remotes.AdvancedRemote;
import Bridge.remotes.BasicRemote;
import Bridge.remotes.SmartRemote;

public class Main {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testDevice(new SmartTV());

        System.out.println("===== SmartRemote with SmartTV =====");
        SmartTV smartTV = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTV);
        smartRemote.voiceControl("Turn on");
        smartRemote.voiceControl("Louder");
        smartRemote.voiceControl("Channel 7");
        smartRemote.voiceControl("Open Netflix");
        smartRemote.voiceControl("Open Spotify");
        smartRemote.voiceControl("Browse https://refactoring.guru");
        smartRemote.voiceControl("Make me a sandwich");
        smartTV.printStatus();

        System.out.println("===== SmartRemote with Radio =====");
        Radio radio = new Radio();
        SmartRemote radioRemote = new SmartRemote(radio);
        radioRemote.voiceControl("Turn on");
        radioRemote.voiceControl("Mute");
        radioRemote.voiceControl("Browse https://yle.fi");
        radio.printStatus();
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
