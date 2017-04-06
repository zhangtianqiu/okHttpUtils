package com.http.okhttp.callback;

import com.google.gson.internal.$Gson$Types;
import com.squareup.okhttp.Request;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class ResultCallback<T>
{
    public Type mType;

    public ResultCallback()
    {
        mType = getType(getClass());
    }

    static Type getType(Class<?> subclass)
    {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    public void onBefore(Request request)
    {
    }

    public void onAfter()
    {
    }

    public void onProgress(float progress)
    {

    }

    public abstract void onError(Request request, Exception e);

    public abstract void onResponse(T response);

//
    public static final ResultCallback<String>  mCallback = new ResultCallback<String>()
    {
        @Override
        public void onError(Request request, Exception e)
        {

        }

        @Override
        public void onResponse(String response)
        {

        }
    };
}