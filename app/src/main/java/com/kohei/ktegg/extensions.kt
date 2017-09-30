package com.kohei.ktegg

import android.support.annotation.IdRes
import android.view.View

/**
 * Created by kohei on 2017/09/30.
 */
//ぶっちゃけよくわかんないけど便利になるやつ
fun <T : View> View.bindView(@IdRes id : Int): Lazy<T> = lazy {
    findViewById(id) as T
}
