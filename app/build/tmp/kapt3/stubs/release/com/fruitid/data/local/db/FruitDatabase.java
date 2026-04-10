package com.fruitid.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/fruitid/data/local/db/FruitDatabase;", "Landroidx/room/RoomDatabase;", "()V", "detectionDao", "Lcom/fruitid/data/local/db/DetectionDao;", "app_release"})
@androidx.room.Database(entities = {com.fruitid.data.local.db.DetectionEntity.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.fruitid.data.local.db.Converters.class})
public abstract class FruitDatabase extends androidx.room.RoomDatabase {
    
    public FruitDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.fruitid.data.local.db.DetectionDao detectionDao();
}