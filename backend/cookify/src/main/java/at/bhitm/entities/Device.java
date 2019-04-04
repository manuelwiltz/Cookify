package at.bhitm.entities;

import org.springframework.data.annotation.Id;

public class Device {

    @Id
    private String deviceID;

    private String timestamp;

    public Device() {
    }

    public Device(String deviceID, String timestamp) {
        this.deviceID = deviceID;
        this.timestamp = timestamp;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceID='" + deviceID + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
