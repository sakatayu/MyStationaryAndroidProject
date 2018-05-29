package com.fefe.mystationaryproject.ui

import rx.Observable
import rx.subjects.PublishSubject
import rx.subjects.SerializedSubject

object EventBus {
    private val subject = SerializedSubject(PublishSubject.create<Any>())

    /**
     * イベントを発行する
     *
     * @param <E>       event クラス指定
     * @param event     発行するイベント
     */
    fun <E> post(event: E) = subject.onNext(event)

    /**
     * 指定したタイプのイベントを通知する Observable を返す
     *
     * @param <E>       event のクラス指定
     * @param clazz     受け取るイベントのクラス
     */
    fun <E> event(clazz: Class<E>): Observable<E> = subject.ofType(clazz)
}