package com.pefish.joy.greendaotest.utils.http;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：08/03/2017 6:02 PM
 */

public interface IHttpResponseListener<T> {
    void onSuccess(T t);
    void onError(int code, String error);
}
