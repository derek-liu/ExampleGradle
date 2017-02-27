package com.example.liudingyu.examplegradle.Mode;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by liudingyu on 12/20/16.
 */
public class ObservableTest {

    public String mValue;

    public void setValue(String value) {
        mValue = value;
    }

    public Observable<String> valueObservable() {
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(mValue);
            }
        });
    }
}
