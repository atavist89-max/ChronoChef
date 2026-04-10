package com.fruitid.data.download;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n\u00a8\u0006\""}, d2 = {"Lcom/fruitid/data/download/DownloadProgress;", "", "bytesDownloaded", "", "totalBytes", "speedBytesPerSecond", "state", "Lcom/fruitid/data/download/DownloadState;", "(JJJLcom/fruitid/data/download/DownloadState;)V", "getBytesDownloaded", "()J", "isComplete", "", "()Z", "isFailed", "progressPercent", "", "getProgressPercent", "()F", "getSpeedBytesPerSecond", "getState", "()Lcom/fruitid/data/download/DownloadState;", "getTotalBytes", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"})
public final class DownloadProgress {
    private final long bytesDownloaded = 0L;
    private final long totalBytes = 0L;
    private final long speedBytesPerSecond = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.fruitid.data.download.DownloadState state = null;
    
    public DownloadProgress(long bytesDownloaded, long totalBytes, long speedBytesPerSecond, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.download.DownloadState state) {
        super();
    }
    
    public final long getBytesDownloaded() {
        return 0L;
    }
    
    public final long getTotalBytes() {
        return 0L;
    }
    
    public final long getSpeedBytesPerSecond() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.data.download.DownloadState getState() {
        return null;
    }
    
    public final float getProgressPercent() {
        return 0.0F;
    }
    
    public final boolean isComplete() {
        return false;
    }
    
    public final boolean isFailed() {
        return false;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.data.download.DownloadState component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fruitid.data.download.DownloadProgress copy(long bytesDownloaded, long totalBytes, long speedBytesPerSecond, @org.jetbrains.annotations.NotNull()
    com.fruitid.data.download.DownloadState state) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}