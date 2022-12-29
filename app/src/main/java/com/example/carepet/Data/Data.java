package com.example.carepet.Data;

public class Data {
    String major;
    String name;
    String hospital;
    String call;

    public Data(String major, String name, String hospital, String call) {
        this.major = major;
        this.name = name;
        this.hospital = hospital;
        this.call = call;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public String getHospital() {
        return hospital;
    }

    public String getCall() {
        return call;
    }
}
