package com.fruitid.data.download;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u0082\u0001\u0005\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/fruitid/data/download/DownloadError;", "", "message", "", "(Ljava/lang/String;)V", "Cancelled", "Corrupted", "Generic", "NetworkError", "StorageFull", "Lcom/fruitid/data/download/DownloadError$Cancelled;", "Lcom/fruitid/data/download/DownloadError$Corrupted;", "Lcom/fruitid/data/download/DownloadError$Generic;", "Lcom/fruitid/data/download/DownloadError$NetworkError;", "Lcom/fruitid/data/download/DownloadError$StorageFull;", "app_release"})
public abstract class DownloadError extends java.lang.Throwable {
    
    private DownloadError(java.lang.String message) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/fruitid/data/download/DownloadError$Cancelled;", "Lcom/fruitid/data/download/DownloadError;", "()V", "app_release"})
    public static final class Cancelled extends com.fruitid.data.download.DownloadError {
        @org.jetbrains.annotations.NotNull()
        public static final com.fruitid.data.download.DownloadError.Cancelled INSTANCE = null;
        
        private Cancelled() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/fruitid/data/download/DownloadError$Corrupted;", "Lcom/fruitid/data/download/DownloadError;", "()V", "app_release"})
    public static final class Corrupted extends com.fruitid.data.download.DownloadError {
        @org.jetbrains.annotations.NotNull()
        public static final com.fruitid.data.download.DownloadError.Corrupted INSTANCE = null;
        
        private Corrupted() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/fruitid/data/download/DownloadError$Generic;", "Lcom/fruitid/data/download/DownloadError;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"})
    public static final class Generic extends com.fruitid.data.download.DownloadError {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String error = null;
        
        public Generic(@org.jetbrains.annotations.NotNull()
        java.lang.String error) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getError() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.fruitid.data.download.DownloadError.Generic copy(@org.jetbrains.annotations.NotNull()
        java.lang.String error) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/fruitid/data/download/DownloadError$NetworkError;", "Lcom/fruitid/data/download/DownloadError;", "()V", "app_release"})
    public static final class NetworkError extends com.fruitid.data.download.DownloadError {
        @org.jetbrains.annotations.NotNull()
        public static final com.fruitid.data.download.DownloadError.NetworkError INSTANCE = null;
        
        private NetworkError() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/fruitid/data/download/DownloadError$StorageFull;", "Lcom/fruitid/data/download/DownloadError;", "()V", "app_release"})
    public static final class StorageFull extends com.fruitid.data.download.DownloadError {
        @org.jetbrains.annotations.NotNull()
        public static final com.fruitid.data.download.DownloadError.StorageFull INSTANCE = null;
        
        private StorageFull() {
        }
    }
}