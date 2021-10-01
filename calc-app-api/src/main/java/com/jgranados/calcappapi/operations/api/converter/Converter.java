package com.jgranados.calcappapi.operations.api.converter;

import com.google.gson.Gson;

/**
 *
 * @author jose
 */
public abstract class Converter<T> {

    private Gson gson;
    private Class<T> typeConverter;

    public Converter(Class<T> typeConverter) {
        this.gson = new Gson();
        this.typeConverter = typeConverter;
    }
    
    public T fromJson(String json) {
        return gson.fromJson(json, typeConverter);
    }
    
    public String toJson(T object) {
        return gson.toJson(object, typeConverter);
    }
}
