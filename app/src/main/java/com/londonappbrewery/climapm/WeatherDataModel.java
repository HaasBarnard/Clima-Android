package com.londonappbrewery.climapm;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {

    // TODO: Declare the member variables here
    String m_temperature;
    int m_condition;
    String m_city;
    String m_iconName;


    // TODO: Create a WeatherDataModel from a JSON:
    public static WeatherDataModel fromJSON(JSONObject jsonObject)
    {
        try
        {
            WeatherDataModel weatherDataModel = new WeatherDataModel();

            weatherDataModel.m_city = jsonObject.getString("name");
            weatherDataModel.m_condition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherDataModel.m_iconName = updateWeatherIcon(weatherDataModel.m_condition);

             double tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;

             int roundedValue = (int) Math.rint(tempResult);



            weatherDataModel.m_temperature = Integer.toString(roundedValue);

            return weatherDataModel;

        }
        catch (JSONException e)
        {
            Log.e("Clima", "fromJSON: ", e);
            return null;
        }



    }


    // TODO: Uncomment to this to get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
           return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    // TODO: Create getter methods for temperature, city, and icon name:


    public String getTemperature()
    {
        return m_temperature + "°";
    }

    public void setTemperature(String temperature)
    {
        m_temperature = temperature;
    }

    public String getCity()
    {
        return m_city;
    }

    public void setCity(String city)
    {
        m_city = city;
    }

    public String getIconName()
    {
        return m_iconName;
    }

    public void setIconName(String iconName)
    {
        m_iconName = iconName;
    }
}
