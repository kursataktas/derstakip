package com.humtk.util;

import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;

/**
 * Created by burcu on 12.08.2017.
 */
public class JsonResponse extends LinkedHashMap {
    public static final int FAILURE = 0;
    public static final int OK = 1;
    public static final int WARNING = 2;

    public JsonResponse(){}

    public static JsonResponse success() {
        return new JsonResponse(OK, null, null);
    }

    public static JsonResponse success(Object obj) {
        return new JsonResponse(OK, null, obj);
    }

    public static JsonResponse success(String message, Object obj) {
        return new JsonResponse(OK, message, obj);
    }

    public static JsonResponse success(String message, String objName, Object obj) {
        return new JsonResponse(OK, message, objName, obj);
    }

    public static JsonResponse failure() {
        return new JsonResponse(FAILURE, null, null);
    }

    public static JsonResponse failure(String message) {
        return new JsonResponse(FAILURE, message, null);
    }

    public static JsonResponse failure(Object obj) {
        return new JsonResponse(FAILURE, null, obj);
    }

    public static JsonResponse failure(String message, Object obj) {
        return new JsonResponse(FAILURE, message, obj);
    }

    public static JsonResponse warning(String message, Object obj) {
        return new JsonResponse(WARNING, message, obj);
    }

    public JsonResponse(int success, String message, Object obj) {
        super.put("success", success);
        if (message != null) {
            super.put("message", message);
        }
        addData(obj);
    }

    public JsonResponse(int success, String message, String objName, Object obj) {
        super.put("success", success);
        if (message != null) {
            super.put("message", message);
        }
        addData(objName, obj);
    }

    public void setSuccess(int success) {
        super.put("success", success);
    }

    public void setMessage(String message) {
        super.put("message", message);
    }

    /**
     * Adds object in data map using object's classname as entry name
     *
     * @param obj - object to add
     */
    public void addData(Object obj) {
        if (obj != null) {
            addData(StringUtils.uncapitalize(obj.getClass().getSimpleName()), obj);
        }
    }

    /**
     * Adds object in data map with provided entry name
     *
     * @param objName - entry name
     * @param obj     - object to add
     */
    public void addData(String objName, Object obj) {
        super.put(StringUtils.uncapitalize(objName), obj);
    }
}
