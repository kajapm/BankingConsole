package com.thirukkural;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSON {

    private JSONArray jsonArray = new JSONArray();
    private Object object;
    private JSONObject jsonObject;
    static JSON json;

    private JSON() {
        try {
            object = new JSONParser().parse(new FileReader("E:\\eclipse\\ThirukkuralViewer\\JSON\\Thirukkural.json"));
            jsonObject = (JSONObject) object;
            jsonArray = (JSONArray) jsonObject.get("kural");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static JSON getInstance() {
        if (json == null)
            json = new JSON();
        return json;
    }

    public JSONArray getJsonArray()
    {
        return jsonArray;
    }
}
