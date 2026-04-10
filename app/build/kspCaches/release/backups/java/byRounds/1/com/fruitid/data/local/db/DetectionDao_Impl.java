package com.fruitid.data.local.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DetectionDao_Impl implements DetectionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DetectionEntity> __insertionAdapterOfDetectionEntity;

  private final EntityDeletionOrUpdateAdapter<DetectionEntity> __deletionAdapterOfDetectionEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOlderThan;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DetectionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDetectionEntity = new EntityInsertionAdapter<DetectionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `detections` (`id`,`timestamp`,`commonName`,`scientificName`,`confidence`,`bboxX1`,`bboxY1`,`bboxX2`,`bboxY2`,`categoryColor`,`thumbnailPath`,`nutritionJson`,`taxonomy`,`ripenessDescription`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DetectionEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTimestamp());
        statement.bindString(3, entity.getCommonName());
        statement.bindString(4, entity.getScientificName());
        statement.bindDouble(5, entity.getConfidence());
        statement.bindDouble(6, entity.getBboxX1());
        statement.bindDouble(7, entity.getBboxY1());
        statement.bindDouble(8, entity.getBboxX2());
        statement.bindDouble(9, entity.getBboxY2());
        statement.bindLong(10, entity.getCategoryColor());
        if (entity.getThumbnailPath() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getThumbnailPath());
        }
        if (entity.getNutritionJson() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getNutritionJson());
        }
        if (entity.getTaxonomy() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTaxonomy());
        }
        if (entity.getRipenessDescription() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getRipenessDescription());
        }
      }
    };
    this.__deletionAdapterOfDetectionEntity = new EntityDeletionOrUpdateAdapter<DetectionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `detections` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DetectionEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM detections WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOlderThan = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM detections WHERE timestamp < ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM detections";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final DetectionEntity entity, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfDetectionEntity.insertAndReturnId(entity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final DetectionEntity entity, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDetectionEntity.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteById(final long id, final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            final Integer _result = _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteOlderThan(final long timestamp,
      final Continuation<? super Integer> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOlderThan.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, timestamp);
        try {
          __db.beginTransaction();
          try {
            final Integer _result = _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteOlderThan.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public PagingSource<Integer, DetectionEntity> getAllPaged() {
    final String _sql = "SELECT * FROM detections ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LimitOffsetPagingSource<DetectionEntity>(_statement, __db, "detections") {
      @Override
      @NonNull
      protected List<DetectionEntity> convertRows(@NonNull final Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(cursor, "timestamp");
        final int _cursorIndexOfCommonName = CursorUtil.getColumnIndexOrThrow(cursor, "commonName");
        final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(cursor, "scientificName");
        final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(cursor, "confidence");
        final int _cursorIndexOfBboxX1 = CursorUtil.getColumnIndexOrThrow(cursor, "bboxX1");
        final int _cursorIndexOfBboxY1 = CursorUtil.getColumnIndexOrThrow(cursor, "bboxY1");
        final int _cursorIndexOfBboxX2 = CursorUtil.getColumnIndexOrThrow(cursor, "bboxX2");
        final int _cursorIndexOfBboxY2 = CursorUtil.getColumnIndexOrThrow(cursor, "bboxY2");
        final int _cursorIndexOfCategoryColor = CursorUtil.getColumnIndexOrThrow(cursor, "categoryColor");
        final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(cursor, "thumbnailPath");
        final int _cursorIndexOfNutritionJson = CursorUtil.getColumnIndexOrThrow(cursor, "nutritionJson");
        final int _cursorIndexOfTaxonomy = CursorUtil.getColumnIndexOrThrow(cursor, "taxonomy");
        final int _cursorIndexOfRipenessDescription = CursorUtil.getColumnIndexOrThrow(cursor, "ripenessDescription");
        final List<DetectionEntity> _result = new ArrayList<DetectionEntity>(cursor.getCount());
        while (cursor.moveToNext()) {
          final DetectionEntity _item;
          final long _tmpId;
          _tmpId = cursor.getLong(_cursorIndexOfId);
          final long _tmpTimestamp;
          _tmpTimestamp = cursor.getLong(_cursorIndexOfTimestamp);
          final String _tmpCommonName;
          _tmpCommonName = cursor.getString(_cursorIndexOfCommonName);
          final String _tmpScientificName;
          _tmpScientificName = cursor.getString(_cursorIndexOfScientificName);
          final float _tmpConfidence;
          _tmpConfidence = cursor.getFloat(_cursorIndexOfConfidence);
          final float _tmpBboxX1;
          _tmpBboxX1 = cursor.getFloat(_cursorIndexOfBboxX1);
          final float _tmpBboxY1;
          _tmpBboxY1 = cursor.getFloat(_cursorIndexOfBboxY1);
          final float _tmpBboxX2;
          _tmpBboxX2 = cursor.getFloat(_cursorIndexOfBboxX2);
          final float _tmpBboxY2;
          _tmpBboxY2 = cursor.getFloat(_cursorIndexOfBboxY2);
          final int _tmpCategoryColor;
          _tmpCategoryColor = cursor.getInt(_cursorIndexOfCategoryColor);
          final String _tmpThumbnailPath;
          if (cursor.isNull(_cursorIndexOfThumbnailPath)) {
            _tmpThumbnailPath = null;
          } else {
            _tmpThumbnailPath = cursor.getString(_cursorIndexOfThumbnailPath);
          }
          final String _tmpNutritionJson;
          if (cursor.isNull(_cursorIndexOfNutritionJson)) {
            _tmpNutritionJson = null;
          } else {
            _tmpNutritionJson = cursor.getString(_cursorIndexOfNutritionJson);
          }
          final String _tmpTaxonomy;
          if (cursor.isNull(_cursorIndexOfTaxonomy)) {
            _tmpTaxonomy = null;
          } else {
            _tmpTaxonomy = cursor.getString(_cursorIndexOfTaxonomy);
          }
          final String _tmpRipenessDescription;
          if (cursor.isNull(_cursorIndexOfRipenessDescription)) {
            _tmpRipenessDescription = null;
          } else {
            _tmpRipenessDescription = cursor.getString(_cursorIndexOfRipenessDescription);
          }
          _item = new DetectionEntity(_tmpId,_tmpTimestamp,_tmpCommonName,_tmpScientificName,_tmpConfidence,_tmpBboxX1,_tmpBboxY1,_tmpBboxX2,_tmpBboxY2,_tmpCategoryColor,_tmpThumbnailPath,_tmpNutritionJson,_tmpTaxonomy,_tmpRipenessDescription);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public Object getRecent(final int limit,
      final Continuation<? super List<DetectionEntity>> $completion) {
    final String _sql = "SELECT * FROM detections ORDER BY timestamp DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<DetectionEntity>>() {
      @Override
      @NonNull
      public List<DetectionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCommonName = CursorUtil.getColumnIndexOrThrow(_cursor, "commonName");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfBboxX1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX1");
          final int _cursorIndexOfBboxY1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY1");
          final int _cursorIndexOfBboxX2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX2");
          final int _cursorIndexOfBboxY2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY2");
          final int _cursorIndexOfCategoryColor = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryColor");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailPath");
          final int _cursorIndexOfNutritionJson = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionJson");
          final int _cursorIndexOfTaxonomy = CursorUtil.getColumnIndexOrThrow(_cursor, "taxonomy");
          final int _cursorIndexOfRipenessDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "ripenessDescription");
          final List<DetectionEntity> _result = new ArrayList<DetectionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DetectionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpCommonName;
            _tmpCommonName = _cursor.getString(_cursorIndexOfCommonName);
            final String _tmpScientificName;
            _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final float _tmpBboxX1;
            _tmpBboxX1 = _cursor.getFloat(_cursorIndexOfBboxX1);
            final float _tmpBboxY1;
            _tmpBboxY1 = _cursor.getFloat(_cursorIndexOfBboxY1);
            final float _tmpBboxX2;
            _tmpBboxX2 = _cursor.getFloat(_cursorIndexOfBboxX2);
            final float _tmpBboxY2;
            _tmpBboxY2 = _cursor.getFloat(_cursorIndexOfBboxY2);
            final int _tmpCategoryColor;
            _tmpCategoryColor = _cursor.getInt(_cursorIndexOfCategoryColor);
            final String _tmpThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfThumbnailPath)) {
              _tmpThumbnailPath = null;
            } else {
              _tmpThumbnailPath = _cursor.getString(_cursorIndexOfThumbnailPath);
            }
            final String _tmpNutritionJson;
            if (_cursor.isNull(_cursorIndexOfNutritionJson)) {
              _tmpNutritionJson = null;
            } else {
              _tmpNutritionJson = _cursor.getString(_cursorIndexOfNutritionJson);
            }
            final String _tmpTaxonomy;
            if (_cursor.isNull(_cursorIndexOfTaxonomy)) {
              _tmpTaxonomy = null;
            } else {
              _tmpTaxonomy = _cursor.getString(_cursorIndexOfTaxonomy);
            }
            final String _tmpRipenessDescription;
            if (_cursor.isNull(_cursorIndexOfRipenessDescription)) {
              _tmpRipenessDescription = null;
            } else {
              _tmpRipenessDescription = _cursor.getString(_cursorIndexOfRipenessDescription);
            }
            _item = new DetectionEntity(_tmpId,_tmpTimestamp,_tmpCommonName,_tmpScientificName,_tmpConfidence,_tmpBboxX1,_tmpBboxY1,_tmpBboxX2,_tmpBboxY2,_tmpCategoryColor,_tmpThumbnailPath,_tmpNutritionJson,_tmpTaxonomy,_tmpRipenessDescription);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getById(final long id, final Continuation<? super DetectionEntity> $completion) {
    final String _sql = "SELECT * FROM detections WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<DetectionEntity>() {
      @Override
      @Nullable
      public DetectionEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCommonName = CursorUtil.getColumnIndexOrThrow(_cursor, "commonName");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfBboxX1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX1");
          final int _cursorIndexOfBboxY1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY1");
          final int _cursorIndexOfBboxX2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX2");
          final int _cursorIndexOfBboxY2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY2");
          final int _cursorIndexOfCategoryColor = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryColor");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailPath");
          final int _cursorIndexOfNutritionJson = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionJson");
          final int _cursorIndexOfTaxonomy = CursorUtil.getColumnIndexOrThrow(_cursor, "taxonomy");
          final int _cursorIndexOfRipenessDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "ripenessDescription");
          final DetectionEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpCommonName;
            _tmpCommonName = _cursor.getString(_cursorIndexOfCommonName);
            final String _tmpScientificName;
            _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final float _tmpBboxX1;
            _tmpBboxX1 = _cursor.getFloat(_cursorIndexOfBboxX1);
            final float _tmpBboxY1;
            _tmpBboxY1 = _cursor.getFloat(_cursorIndexOfBboxY1);
            final float _tmpBboxX2;
            _tmpBboxX2 = _cursor.getFloat(_cursorIndexOfBboxX2);
            final float _tmpBboxY2;
            _tmpBboxY2 = _cursor.getFloat(_cursorIndexOfBboxY2);
            final int _tmpCategoryColor;
            _tmpCategoryColor = _cursor.getInt(_cursorIndexOfCategoryColor);
            final String _tmpThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfThumbnailPath)) {
              _tmpThumbnailPath = null;
            } else {
              _tmpThumbnailPath = _cursor.getString(_cursorIndexOfThumbnailPath);
            }
            final String _tmpNutritionJson;
            if (_cursor.isNull(_cursorIndexOfNutritionJson)) {
              _tmpNutritionJson = null;
            } else {
              _tmpNutritionJson = _cursor.getString(_cursorIndexOfNutritionJson);
            }
            final String _tmpTaxonomy;
            if (_cursor.isNull(_cursorIndexOfTaxonomy)) {
              _tmpTaxonomy = null;
            } else {
              _tmpTaxonomy = _cursor.getString(_cursorIndexOfTaxonomy);
            }
            final String _tmpRipenessDescription;
            if (_cursor.isNull(_cursorIndexOfRipenessDescription)) {
              _tmpRipenessDescription = null;
            } else {
              _tmpRipenessDescription = _cursor.getString(_cursorIndexOfRipenessDescription);
            }
            _result = new DetectionEntity(_tmpId,_tmpTimestamp,_tmpCommonName,_tmpScientificName,_tmpConfidence,_tmpBboxX1,_tmpBboxY1,_tmpBboxX2,_tmpBboxY2,_tmpCategoryColor,_tmpThumbnailPath,_tmpNutritionJson,_tmpTaxonomy,_tmpRipenessDescription);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM detections";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getOldThumbnailPaths(final long timestamp,
      final Continuation<? super List<String>> $completion) {
    final String _sql = "SELECT thumbnailPath FROM detections WHERE thumbnailPath IS NOT NULL AND timestamp < ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, timestamp);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<String>>() {
      @Override
      @NonNull
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            _item = _cursor.getString(0);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<DetectionEntity>> $completion) {
    final String _sql = "SELECT * FROM detections ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<DetectionEntity>>() {
      @Override
      @NonNull
      public List<DetectionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCommonName = CursorUtil.getColumnIndexOrThrow(_cursor, "commonName");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfBboxX1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX1");
          final int _cursorIndexOfBboxY1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY1");
          final int _cursorIndexOfBboxX2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX2");
          final int _cursorIndexOfBboxY2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY2");
          final int _cursorIndexOfCategoryColor = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryColor");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailPath");
          final int _cursorIndexOfNutritionJson = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionJson");
          final int _cursorIndexOfTaxonomy = CursorUtil.getColumnIndexOrThrow(_cursor, "taxonomy");
          final int _cursorIndexOfRipenessDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "ripenessDescription");
          final List<DetectionEntity> _result = new ArrayList<DetectionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DetectionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpCommonName;
            _tmpCommonName = _cursor.getString(_cursorIndexOfCommonName);
            final String _tmpScientificName;
            _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final float _tmpBboxX1;
            _tmpBboxX1 = _cursor.getFloat(_cursorIndexOfBboxX1);
            final float _tmpBboxY1;
            _tmpBboxY1 = _cursor.getFloat(_cursorIndexOfBboxY1);
            final float _tmpBboxX2;
            _tmpBboxX2 = _cursor.getFloat(_cursorIndexOfBboxX2);
            final float _tmpBboxY2;
            _tmpBboxY2 = _cursor.getFloat(_cursorIndexOfBboxY2);
            final int _tmpCategoryColor;
            _tmpCategoryColor = _cursor.getInt(_cursorIndexOfCategoryColor);
            final String _tmpThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfThumbnailPath)) {
              _tmpThumbnailPath = null;
            } else {
              _tmpThumbnailPath = _cursor.getString(_cursorIndexOfThumbnailPath);
            }
            final String _tmpNutritionJson;
            if (_cursor.isNull(_cursorIndexOfNutritionJson)) {
              _tmpNutritionJson = null;
            } else {
              _tmpNutritionJson = _cursor.getString(_cursorIndexOfNutritionJson);
            }
            final String _tmpTaxonomy;
            if (_cursor.isNull(_cursorIndexOfTaxonomy)) {
              _tmpTaxonomy = null;
            } else {
              _tmpTaxonomy = _cursor.getString(_cursorIndexOfTaxonomy);
            }
            final String _tmpRipenessDescription;
            if (_cursor.isNull(_cursorIndexOfRipenessDescription)) {
              _tmpRipenessDescription = null;
            } else {
              _tmpRipenessDescription = _cursor.getString(_cursorIndexOfRipenessDescription);
            }
            _item = new DetectionEntity(_tmpId,_tmpTimestamp,_tmpCommonName,_tmpScientificName,_tmpConfidence,_tmpBboxX1,_tmpBboxY1,_tmpBboxX2,_tmpBboxY2,_tmpCategoryColor,_tmpThumbnailPath,_tmpNutritionJson,_tmpTaxonomy,_tmpRipenessDescription);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<DetectionEntity>> getAllFlow() {
    final String _sql = "SELECT * FROM detections ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"detections"}, new Callable<List<DetectionEntity>>() {
      @Override
      @NonNull
      public List<DetectionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCommonName = CursorUtil.getColumnIndexOrThrow(_cursor, "commonName");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfBboxX1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX1");
          final int _cursorIndexOfBboxY1 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY1");
          final int _cursorIndexOfBboxX2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxX2");
          final int _cursorIndexOfBboxY2 = CursorUtil.getColumnIndexOrThrow(_cursor, "bboxY2");
          final int _cursorIndexOfCategoryColor = CursorUtil.getColumnIndexOrThrow(_cursor, "categoryColor");
          final int _cursorIndexOfThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnailPath");
          final int _cursorIndexOfNutritionJson = CursorUtil.getColumnIndexOrThrow(_cursor, "nutritionJson");
          final int _cursorIndexOfTaxonomy = CursorUtil.getColumnIndexOrThrow(_cursor, "taxonomy");
          final int _cursorIndexOfRipenessDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "ripenessDescription");
          final List<DetectionEntity> _result = new ArrayList<DetectionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DetectionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpCommonName;
            _tmpCommonName = _cursor.getString(_cursorIndexOfCommonName);
            final String _tmpScientificName;
            _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            final float _tmpConfidence;
            _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            final float _tmpBboxX1;
            _tmpBboxX1 = _cursor.getFloat(_cursorIndexOfBboxX1);
            final float _tmpBboxY1;
            _tmpBboxY1 = _cursor.getFloat(_cursorIndexOfBboxY1);
            final float _tmpBboxX2;
            _tmpBboxX2 = _cursor.getFloat(_cursorIndexOfBboxX2);
            final float _tmpBboxY2;
            _tmpBboxY2 = _cursor.getFloat(_cursorIndexOfBboxY2);
            final int _tmpCategoryColor;
            _tmpCategoryColor = _cursor.getInt(_cursorIndexOfCategoryColor);
            final String _tmpThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfThumbnailPath)) {
              _tmpThumbnailPath = null;
            } else {
              _tmpThumbnailPath = _cursor.getString(_cursorIndexOfThumbnailPath);
            }
            final String _tmpNutritionJson;
            if (_cursor.isNull(_cursorIndexOfNutritionJson)) {
              _tmpNutritionJson = null;
            } else {
              _tmpNutritionJson = _cursor.getString(_cursorIndexOfNutritionJson);
            }
            final String _tmpTaxonomy;
            if (_cursor.isNull(_cursorIndexOfTaxonomy)) {
              _tmpTaxonomy = null;
            } else {
              _tmpTaxonomy = _cursor.getString(_cursorIndexOfTaxonomy);
            }
            final String _tmpRipenessDescription;
            if (_cursor.isNull(_cursorIndexOfRipenessDescription)) {
              _tmpRipenessDescription = null;
            } else {
              _tmpRipenessDescription = _cursor.getString(_cursorIndexOfRipenessDescription);
            }
            _item = new DetectionEntity(_tmpId,_tmpTimestamp,_tmpCommonName,_tmpScientificName,_tmpConfidence,_tmpBboxX1,_tmpBboxY1,_tmpBboxX2,_tmpBboxY2,_tmpCategoryColor,_tmpThumbnailPath,_tmpNutritionJson,_tmpTaxonomy,_tmpRipenessDescription);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
