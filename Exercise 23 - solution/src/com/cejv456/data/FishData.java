package com.cejv456.data;



/**
 * Data bean for fish that overrides toString, hashCode and equals
 *
 
 */
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

    /**
     * Non-default constructor
     *
     * 
     */
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

    /**
     * Default Constructor
     */
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

    public void setFishSize(String size) {
        this.fishSize = size;
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
        String s = "            ID = " + id + "\n" + 
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((commonName == null) ? 0 : commonName.hashCode());
        result = prime * result + ((diet == null) ? 0 : diet.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((kh == null) ? 0 : kh.hashCode());
        result = prime * result + ((latin == null) ? 0 : latin.hashCode());
        result = prime * result + ((ph == null) ? 0 : ph.hashCode());
        result = prime * result
                + ((fishSize == null) ? 0 : fishSize.hashCode());
        result = prime * result
                + ((speciesOrigin == null) ? 0 : speciesOrigin.hashCode());
        result = prime * result
                + ((stocking == null) ? 0 : stocking.hashCode());
        result = prime * result
                + ((tankSize == null) ? 0 : tankSize.hashCode());
        result = prime * result + ((temp == null) ? 0 : temp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FishData other = (FishData) obj;
        if (commonName == null) {
            if (other.commonName != null) {
                return false;
            }
        } else if (!commonName.equals(other.commonName)) {
            return false;
        }
        if (diet == null) {
            if (other.diet != null) {
                return false;
            }
        } else if (!diet.equals(other.diet)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (kh == null) {
            if (other.kh != null) {
                return false;
            }
        } else if (!kh.equals(other.kh)) {
            return false;
        }
        if (latin == null) {
            if (other.latin != null) {
                return false;
            }
        } else if (!latin.equals(other.latin)) {
            return false;
        }
        if (ph == null) {
            if (other.ph != null) {
                return false;
            }
        } else if (!ph.equals(other.ph)) {
            return false;
        }
        if (fishSize == null) {
            if (other.fishSize != null) {
                return false;
            }
        } else if (!fishSize.equals(other.fishSize)) {
            return false;
        }
        if (speciesOrigin == null) {
            if (other.speciesOrigin != null) {
                return false;
            }
        } else if (!speciesOrigin.equals(other.speciesOrigin)) {
            return false;
        }
        if (stocking == null) {
            if (other.stocking != null) {
                return false;
            }
        } else if (!stocking.equals(other.stocking)) {
            return false;
        }
        if (tankSize == null) {
            if (other.tankSize != null) {
                return false;
            }
        } else if (!tankSize.equals(other.tankSize)) {
            return false;
        }
        if (temp == null) {
            if (other.temp != null) {
                return false;
            }
        } else if (!temp.equals(other.temp)) {
            return false;
        }
        return true;
    }

}
