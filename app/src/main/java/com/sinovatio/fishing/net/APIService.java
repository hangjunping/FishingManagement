package com.sinovatio.fishing.net;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface APIService {

    @GET("app/getSec")
    Flowable<Object> getSec();
}
