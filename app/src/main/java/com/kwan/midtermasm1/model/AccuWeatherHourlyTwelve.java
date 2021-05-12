package com.kwan.midtermasm1.model;

public class AccuWeatherHourlyTwelve {
    private String DateTime;
    private int EpochDateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private boolean IsDaylight;
    private AccWeatherTemp Temperature;
    private int PrecipitationProbability;
    private String MobileLink;
    private String Link;

    public AccuWeatherHourlyTwelve(String dateTime, int epochDateTime, int weatherIcon, String iconPhrase, boolean hasPrecipitation, boolean isDaylight, AccWeatherTemp temperature, int precipitationProbability, String mobileLink, String link) {
        DateTime = dateTime;
        EpochDateTime = epochDateTime;
        WeatherIcon = weatherIcon;
        IconPhrase = iconPhrase;
        HasPrecipitation = hasPrecipitation;
        IsDaylight = isDaylight;
        Temperature = temperature;
        PrecipitationProbability = precipitationProbability;
        MobileLink = mobileLink;
        Link = link;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getEpochDateTime() {
        return EpochDateTime;
    }

    public void setEpochDateTime(int epochDateTime) {
        EpochDateTime = epochDateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public boolean isDaylight() {
        return IsDaylight;
    }

    public void setDaylight(boolean daylight) {
        IsDaylight = daylight;
    }

    public AccWeatherTemp getTemperature() {
        return Temperature;
    }

    public void setTemperature(AccWeatherTemp temperature) {
        Temperature = temperature;
    }

    public int getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        PrecipitationProbability = precipitationProbability;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
