package com.mg.android.kotlin_mvvm.core.di;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

//public class EventDeserializer implements JsonDeserializer<HeatMapScore> {
//    @Override
//    public HeatMapScore deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        final JsonObject heatMapJson = json.getAsJsonObject();
//        final JsonObject contentJson;
//        if (heatMapJson.get("content").isJsonObject()) {
//            contentJson = heatMapJson.getAsJsonObject("content");
//        } else {
//            heatMapJson.remove("content");
//            contentJson = new JsonObject();
//        }
//        if (contentJson.has("platforms") && !contentJson.get("platforms").isJsonArray()) {
//            String platform = contentJson.get("platforms").getAsString();
//            JsonArray jsonArray = new JsonArray();
//            jsonArray.add(platform);
//            contentJson.remove("platforms");
//            contentJson.add("platforms", jsonArray);
//        }
//        if (contentJson.has("types") && !contentJson.get("types").isJsonArray()) {
//            int types = contentJson.get("types").getAsInt();
//            JsonArray jsonArray = new JsonArray();
//            jsonArray.add(types);
//            contentJson.remove("types");
//            contentJson.add("types", jsonArray);
//        }
//        return new Gson().fromJson(heatMapJson, HeatMapScore.class);
//    }
//}