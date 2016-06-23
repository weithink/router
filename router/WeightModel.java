package com.leoao.fitness.router;

/**
 * model
 */
public class WeightModel {

    private String weightId;
    private String protocol;
    private String parma;
    private String url;
    private String originInfo;

    public String getWeightId() {
        return weightId;
    }

    public void setWeightId(String weightId) {
        this.weightId = weightId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getParma() {
        return parma;
    }

    public void setParma(String parma) {
        this.parma = parma;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginInfo() {
        return originInfo;
    }

    public void setOriginInfo(String originInfo) {
        this.originInfo = originInfo;
    }

    @Override
    public String toString() {
        return "WeightModel{" +
                "weightId='" + weightId + '\'' +
                ", protocol='" + protocol + '\'' +
                ", parma='" + parma + '\'' +
                ", url='" + url + '\'' +
                ", originInfo='" + originInfo + '\'' +
                '}';
    }
}
