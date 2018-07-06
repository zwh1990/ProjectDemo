package com.example.admin.openwpsdemo.utils;

import com.example.admin.openwpsdemo.biz.GsonBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/3/6.
 */

public class JSONUitl {

    public static final String TAG = JSONUitl.class.getSimpleName();

    private static final JSONUitl ourInstance = new JSONUitl();
    private Gson mGson = null;
    private JsonParser parser = null;

    public static JSONUitl getInstance() {
        return ourInstance;
    }

    private JSONUitl() {
        mGson = new Gson();
        mGson = new GsonBuilder().registerTypeAdapter(GsonBean.class, new TypeAdapter<GsonBean>() {
            @Override
            public void write(JsonWriter out, GsonBean value) throws IOException {

            }

            @Override
            public GsonBean read(JsonReader in) throws IOException {

                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                return null;
            }
        }).create();
        parser = new JsonParser();
    }

    public JsonParser getParser() {
        return parser;
    }

    public void setParser(JsonParser parser) {
        this.parser = parser;
    }

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public String GsonString(Object object) {
        String gsonString = null;
        if (mGson != null) {
            gsonString = mGson.toJson(object);
        }
        return gsonString;
    }


    /**
     * 将Map转化为Json
     *
     * @param map
     * @return String
     */
    public <T> String RequestMapToJson(Map<String, T> map) {
        String jsonStr = mGson.toJson(map);
        return jsonStr;
    }

    /**
     * 将List转化为Json
     *
     * @param list
     * @rturn String
     */
    public <T> String ListToJson(List<T> list) {
        String jsonStr = mGson.toJson(list);
        return jsonStr;
    }

    /**
     * 转成Javabean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (mGson != null) {
            t = mGson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    public <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (mGson != null) {
            map = mGson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
//        return map;
        return map != null ? map : new HashMap<String, T>();
    }

    /**
     * 转成map的
     *
     * @param map
     * @return
     */
    public String MapToJsons(Map<String, Object> map) {
        String jsonStr = mGson.toJson(map);
        return jsonStr;
    }

    /**
     * 转成list
     * 解决泛型问题
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public <T> List<T> jsonToList(String json, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        JsonArray array = parser.parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(mGson.fromJson(elem, cls));
        }
        return list;
    }


    /**
     * 转成list
     * 解决泛型问题
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T jsonToBean(String json, Class<T> cls) {
        JsonObject array = parser.parse(json).getAsJsonObject();
        return mGson.fromJson(array, cls);
    }


    /**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (mGson != null) {
            list = mGson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * Object 转json，
     *
     * @param object
     * @return
     */
    public static String obj2Json(Object object) {
        Gson lGson = new GsonBuilder().serializeNulls().create();
        return lGson.toJson(object);
    }


}
