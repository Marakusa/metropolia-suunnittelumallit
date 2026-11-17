package Bridge.remotes;

import Bridge.devices.Device;
import Bridge.devices.SmartDevice;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    public boolean voiceControl(String command) {
        String cmd = command.trim().toLowerCase();
        System.out.println("SmartRemote heard: \"" + command + "\"");

        if (cmd.equals("power") || cmd.equals("turn on") || cmd.equals("turn off")) {
            boolean wantOn = cmd.equals("turn on") || (cmd.equals("power") && !device.isEnabled());
            if (wantOn != device.isEnabled()) {
                power();
            }
            return true;
        }
        if (cmd.equals("volume up") || cmd.equals("louder")) {
            volumeUp();
            return true;
        }
        if (cmd.equals("volume down") || cmd.equals("quieter")) {
            volumeDown();
            return true;
        }
        if (cmd.equals("mute")) {
            mute();
            return true;
        }
        if (cmd.equals("next channel")) {
            channelUp();
            return true;
        }
        if (cmd.equals("previous channel")) {
            channelDown();
            return true;
        }
        if (cmd.startsWith("channel ")) {
            try {
                int channel = Integer.parseInt(cmd.substring("channel ".length()).trim());
                device.setChannel(channel);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("SmartRemote: invalid channel number.");
                return false;
            }
        }
        if (cmd.startsWith("open ")) {
            return withSmartDevice(sd -> sd.openApp(command.trim().substring("open ".length())));
        }
        if (cmd.startsWith("browse ")) {
            return withSmartDevice(sd -> sd.browseInternet(command.trim().substring("browse ".length())));
        }
        System.out.println("SmartRemote: sorry, I did not understand that.");
        return false;
    }

    public boolean browseInternet(String url) {
        return withSmartDevice(sd -> sd.browseInternet(url));
    }

    private boolean withSmartDevice(java.util.function.Consumer<SmartDevice> action) {
        if (device instanceof SmartDevice smartDevice) {
            action.accept(smartDevice);
            return true;
        }
        System.out.println("SmartRemote: this device does not support internet features.");
        return false;
    }
}
