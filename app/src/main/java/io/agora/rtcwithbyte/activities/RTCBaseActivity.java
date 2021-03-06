package io.agora.rtcwithbyte.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.agora.rtcwithbyte.MyApplication;
import io.agora.rtcwithbyte.EngineConfig;
import io.agora.rtcwithbyte.MyRtcEngineEventHandler;
import io.agora.rtcwithbyte.WorkerThread;
import io.agora.rtc.RtcEngine;

/**
 * Base activity enabling sub activities to communicate using
 * remote video calls.
 */
public abstract class RTCBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getApplication()).initWorkerThread();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        deInitUIAndEvent();
    }

    protected abstract void initUIAndEvent();

    protected abstract void deInitUIAndEvent();

    protected RtcEngine getRtcEngine() {
        return ((MyApplication) getApplication()).getWorkerThread().getRtcEngine();
    }

    protected final WorkerThread getWorker() {
        return ((MyApplication) getApplication()).getWorkerThread();
    }

    protected final EngineConfig getConfig() {
        return ((MyApplication) getApplication()).getWorkerThread().getEngineConfig();
    }

    protected final MyRtcEngineEventHandler getEventHandler() {
        return ((MyApplication) getApplication()).getWorkerThread().eventHandler();
    }
}
