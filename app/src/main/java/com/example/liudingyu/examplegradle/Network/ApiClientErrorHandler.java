package com.example.liudingyu.examplegradle.Network;

import android.util.Log;

import com.example.liudingyu.examplegradle.Mode.StatusErrorMode;
import com.google.gson.stream.MalformedJsonException;

import okhttp3.Request;
import okhttp3.Response;

public class ApiClientErrorHandler {
    /**
     * 处理内部状态错误
     * @param request
     * @param mode
     * @return
     */
    protected StatusErrorMode handleStatusError(Request request, StatusErrorMode mode) {
        Log.d("d.d", "mode status:" + mode.message);
        return mode;
    }

    /**
     * 处理HTTP状态码错误
     * @param response
     * @return
     */
    protected Response handleHTTPError(Response response) {
        Log.d("d.d", "HTTP Status Code: " + response.code());
        return response;
    }

    /**
     * 处理运行时错误
     * 目前比如Gson解析错误
     * @param e
     */
    protected  void handleRuntimeException (Exception e) {
        if (e instanceof MalformedJsonException) {
            Log.e("d.d", "Gson Parse Exception");
        }
    }
}
