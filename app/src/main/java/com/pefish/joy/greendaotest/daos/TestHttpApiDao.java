package com.pefish.joy.greendaotest.daos;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pefish.joy.greendaotest.entities.Suggestion;

import com.pefish.joy.greendaotest.entities.TestHttpApi;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEST_HTTP_API".
*/
public class TestHttpApiDao extends AbstractDao<TestHttpApi, Long> {

    public static final String TABLENAME = "TEST_HTTP_API";

    /**
     * Properties of entity TestHttpApi.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Citycode = new Property(1, String.class, "citycode", false, "CITYCODE");
        public final static Property Rdesc = new Property(2, String.class, "rdesc", false, "RDESC");
        public final static Property Cityname = new Property(3, String.class, "cityname", false, "CITYNAME");
        public final static Property SuggestionId = new Property(4, long.class, "suggestionId", false, "SUGGESTION_ID");
    }

    private DaoSession daoSession;


    public TestHttpApiDao(DaoConfig config) {
        super(config);
    }
    
    public TestHttpApiDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEST_HTTP_API\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CITYCODE\" TEXT," + // 1: citycode
                "\"RDESC\" TEXT," + // 2: rdesc
                "\"CITYNAME\" TEXT," + // 3: cityname
                "\"SUGGESTION_ID\" INTEGER NOT NULL );"); // 4: suggestionId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEST_HTTP_API\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TestHttpApi entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String citycode = entity.getCitycode();
        if (citycode != null) {
            stmt.bindString(2, citycode);
        }
 
        String rdesc = entity.getRdesc();
        if (rdesc != null) {
            stmt.bindString(3, rdesc);
        }
 
        String cityname = entity.getCityname();
        if (cityname != null) {
            stmt.bindString(4, cityname);
        }
        stmt.bindLong(5, entity.getSuggestionId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TestHttpApi entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String citycode = entity.getCitycode();
        if (citycode != null) {
            stmt.bindString(2, citycode);
        }
 
        String rdesc = entity.getRdesc();
        if (rdesc != null) {
            stmt.bindString(3, rdesc);
        }
 
        String cityname = entity.getCityname();
        if (cityname != null) {
            stmt.bindString(4, cityname);
        }
        stmt.bindLong(5, entity.getSuggestionId());
    }

    @Override
    protected final void attachEntity(TestHttpApi entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TestHttpApi readEntity(Cursor cursor, int offset) {
        TestHttpApi entity = new TestHttpApi( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // citycode
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // rdesc
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // cityname
            cursor.getLong(offset + 4) // suggestionId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TestHttpApi entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCitycode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRdesc(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCityname(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSuggestionId(cursor.getLong(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TestHttpApi entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TestHttpApi entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TestHttpApi entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getSuggestionDao().getAllColumns());
            builder.append(" FROM TEST_HTTP_API T");
            builder.append(" LEFT JOIN SUGGESTION T0 ON T.\"SUGGESTION_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected TestHttpApi loadCurrentDeep(Cursor cursor, boolean lock) {
        TestHttpApi entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Suggestion relationSuggestion = loadCurrentOther(daoSession.getSuggestionDao(), cursor, offset);
         if(relationSuggestion != null) {
            entity.setRelationSuggestion(relationSuggestion);
        }

        return entity;    
    }

    public TestHttpApi loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<TestHttpApi> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<TestHttpApi> list = new ArrayList<TestHttpApi>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<TestHttpApi> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<TestHttpApi> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
