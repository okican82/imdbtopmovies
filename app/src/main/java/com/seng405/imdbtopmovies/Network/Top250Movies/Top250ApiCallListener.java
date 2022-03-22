package com.seng405.imdbtopmovies.Network.Top250Movies;

public interface Top250ApiCallListener {
    void onSuccess();
    void onFail();
    void onSerializeError();
}
