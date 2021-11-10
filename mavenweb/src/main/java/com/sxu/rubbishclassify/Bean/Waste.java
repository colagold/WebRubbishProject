package com.sxu.rubbishclassify.Bean;

public class Waste {
    private int wasteId;
    private int userId;
    private String wasteName;
    private String wasteInfo;
    private String wasteTime;

    public String getWasteTime() {
        return wasteTime;
    }

    public void setWasteTime(String wasteTime) {
        this.wasteTime = wasteTime;
    }

    public int getWasteId() {
        return wasteId;
    }

    public void setWasteId(int wasteId) {
        this.wasteId = wasteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getWasteName() {
        return wasteName;
    }

    public void setWasteName(String wasteName) {
        this.wasteName = wasteName;
    }

    public String getWasteInfo() {
        return wasteInfo;
    }

    public void setWasteInfo(String wasteInfo) {
        this.wasteInfo = wasteInfo;
    }

}
