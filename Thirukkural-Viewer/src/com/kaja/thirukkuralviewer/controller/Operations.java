package com.kaja.thirukkuralviewer.controller;

import com.kaja.thirukkuralviewer.model.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Operations {
    private JSON json = JSON.getInstance();
    private JSONArray jsonArray = json.getJsonArray();

    public void printVerses(int from, int to) {
        for (int i = from - 1; i < to; i++) {
            JSONObject jobj = (JSONObject) jsonArray.get(i);
            System.out.println(i + 1 + "." + jobj.get("Line1"));
            System.out.println(jobj.get("Line2"));
            System.out.println("");
        }
    }

    public void printVerseWithMeaning(String author) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            System.out.println(i + 1 + "." + jsonObject.get("Line1"));
            System.out.println(jsonObject.get("Line2"));
            System.out.println("Meaning: " + jsonObject.get(author));
            System.out.println("");
        }
    }

    public void searchByNumber(int verse) {
        JSONObject jsonObject = (JSONObject) jsonArray.get(verse - 1);
        System.out.println("");
        System.out.println(jsonObject.get("Number") + "." + jsonObject.get("Line1"));
        System.out.println(jsonObject.get("Line2"));
        System.out.println("Transliteration :" + jsonObject.get("transliteration1") + " " + jsonObject.get("transliteration2"));
        System.out.println("Meaning :" + jsonObject.get("mv"));
        System.out.println("Couplet :" + jsonObject.get("couplet"));
        System.out.println("Translation :" + jsonObject.get("Translation"));
    }

    public void searchByWord(String containingWord) {
        int searchCount = 0;
        System.out.println(containingWord);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String transliteration1 = ((String) jsonObject.get("transliteration1")).toLowerCase();
            String transliteration2 = ((String) jsonObject.get("transliteration2")).toLowerCase();
            if (transliteration1.contains(containingWord) || transliteration2.contains(containingWord)) {
                System.out.println(i + 1 + "." + jsonObject.get("Line1"));
                System.out.println(jsonObject.get("Line2"));
                System.out.println("");
                searchCount++;
            }
        }
        if (searchCount == 0) System.out.println("No thirukkiural found");
    }
}
