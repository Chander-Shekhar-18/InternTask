package com.example.interntask;

public class ExampleItem {
    private String imageUrl;
    private String countryName;
    private String capitalName;
    private String regionName;
    private String subRegionName;
    private String population;



    public ExampleItem(String imageUrl, String countryName, String capitalName, String regionName, String subRegionName, String population) {
        this.imageUrl = imageUrl;
        this.countryName = countryName;
        this.capitalName = capitalName;
        this.regionName = regionName;
        this.subRegionName = subRegionName;
        this.population = population;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getSubRegionName() {
        return subRegionName;
    }

    public void setSubRegionName(String subRegionName) {
        this.subRegionName = subRegionName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
