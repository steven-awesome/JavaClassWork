package com.cejv416.data;

public class FishData {

    private long id;
    private String commonName;
    private String latin;
    private String ph;
    private String kh;
    private String temp;
    private String fishSize;
    private String speciesOrigin;
    private String tankSize;
    private String stocking;
    private String diet;

    public FishData(long id, String commonName, String latin, String ph,
            String kh, String temp, String fishSize, String speciesOrigin,
            String tankSize, String stocking, String diet) {
        super();
        this.id = id;
        this.commonName = commonName;
        this.latin = latin;
        this.ph = ph;
        this.kh = kh;
        this.temp = temp;
        this.fishSize = fishSize;
        this.speciesOrigin = speciesOrigin;
        this.tankSize = tankSize;
        this.stocking = stocking;
        this.diet = diet;
    }

    public FishData() {
        super();
        this.id = -1;
        this.commonName = "";
        this.latin = "";
        this.ph = "";
        this.kh = "";
        this.temp = "";
        this.fishSize = "";
        this.speciesOrigin = "";
        this.tankSize = "";
        this.stocking = "";
        this.diet = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFishSize() {
        return fishSize;
    }

    public void setFishSize(String fishSize) {
        this.fishSize = fishSize;
    }

    public String getSpeciesOrigin() {
        return speciesOrigin;
    }

    public void setSpeciesOrigin(String speciesOrigin) {
        this.speciesOrigin = speciesOrigin;
    }

    public String getTankSize() {
        return tankSize;
    }

    public void setTankSize(String tankSize) {
        this.tankSize = tankSize;
    }

    public String getStocking() {
        return stocking;
    }

    public void setStocking(String stocking) {
        this.stocking = stocking;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    @Override
    public String toString() {
        String s =
        "            ID = " + id + "\n" +
        "   Common Name = " + commonName + "\n" +
        "         Latin = " + latin + "\n" +
        "            ph = " + ph + "\n" +
        "            kh = " + kh + "\n" +
        "          Temp = " + temp + "\n" +
        "          Size = " + fishSize + "\n" +
        "Species Origin = " + speciesOrigin + "\n" +
        "     Tank Size = " + tankSize + "\n" +
        "      Stocking = " + stocking + "\n" +
        "          Diet = " + diet + "\n";

        return s;
    }
}
