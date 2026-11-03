package com.example.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: NetworkSyncManager.kt */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u000f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/example/utils/NetworkSyncManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "_isOnline", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isOnline", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "networkCallback", "com/example/utils/NetworkSyncManager$networkCallback$1", "Lcom/example/utils/NetworkSyncManager$networkCallback$1;", "checkInitialConnectivity", "toggleSimulatedNetworkMode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/classes6.dex */
public final class NetworkSyncManager {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _isOnline;
    private final ConnectivityManager connectivityManager;
    private final StateFlow<Boolean> isOnline;
    private final NetworkSyncManager$networkCallback$1 networkCallback;

    /* JADX WARN: Type inference failed for: r0v9, types: [com.example.utils.NetworkSyncManager$networkCallback$1] */
    public NetworkSyncManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        this._isOnline = StateFlowKt.MutableStateFlow(Boolean.valueOf(checkInitialConnectivity()));
        this.isOnline = FlowKt.asStateFlow(this._isOnline);
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.example.utils.NetworkSyncManager$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MutableStateFlow mutableStateFlow;
                Intrinsics.checkNotNullParameter(network, "network");
                mutableStateFlow = NetworkSyncManager.this._isOnline;
                mutableStateFlow.setValue(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MutableStateFlow mutableStateFlow;
                Intrinsics.checkNotNullParameter(network, "network");
                mutableStateFlow = NetworkSyncManager.this._isOnline;
                mutableStateFlow.setValue(false);
            }
        };
        NetworkRequest request = new NetworkRequest.Builder().addCapability(12).build();
        try {
            this.connectivityManager.registerNetworkCallback(request, this.networkCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final StateFlow<Boolean> isOnline() {
        return this.isOnline;
    }

    private final boolean checkInitialConnectivity() {
        NetworkCapabilities capabilities;
        try {
            Network activeNetwork = this.connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (capabilities = this.connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return capabilities.hasCapability(12);
        } catch (Exception e) {
            return true;
        }
    }

    public final boolean toggleSimulatedNetworkMode() {
        boolean z = BuildConfig.DEBUG;
        MutableStateFlow<Boolean> mutableStateFlow = this._isOnline;
        if (z) {
            boolean newState = !((Boolean) mutableStateFlow.getValue()).booleanValue();
            this._isOnline.setValue(Boolean.valueOf(newState));
            return newState;
        }
        return ((Boolean) mutableStateFlow.getValue()).booleanValue();
    }
}
