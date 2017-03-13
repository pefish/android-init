package com.pefish.joy.greendaotest.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.pefish.joy.greendaotest.daos.DaoSession;
import com.pefish.joy.greendaotest.daos.SuggestionDao;
import org.greenrobot.greendao.annotation.NotNull;
import com.pefish.joy.greendaotest.daos.TestHttpApiDao;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：08/03/2017 6:24 PM
 */

@Entity
public class TestHttpApi {
    @Id(autoincrement = true)
    private Long id;

    private String citycode;
    private String rdesc;
    private String cityname;
    @Transient
    private Suggestion suggestion;

    private long suggestionId;
    @ToOne(joinProperty = "suggestionId")
    private Suggestion relationSuggestion;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1252064715)
    private transient TestHttpApiDao myDao;
    @Generated(hash = 905448409)
    public TestHttpApi(Long id, String citycode, String rdesc, String cityname,
            long suggestionId) {
        this.id = id;
        this.citycode = citycode;
        this.rdesc = rdesc;
        this.cityname = cityname;
        this.suggestionId = suggestionId;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    @Generated(hash = 1417368215)
    public TestHttpApi() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCitycode() {
        return this.citycode;
    }
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    public String getRdesc() {
        return this.rdesc;
    }
    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }
    public String getCityname() {
        return this.cityname;
    }
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
    public long getSuggestionId() {
        return this.suggestionId;
    }
    public void setSuggestionId(long suggestionId) {
        this.suggestionId = suggestionId;
    }
    @Generated(hash = 673252358)
    private transient Long relationSuggestion__resolvedKey;
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1217323888)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTestHttpApiDao() : null;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1627452302)
    public Suggestion getRelationSuggestion() {
        long __key = this.suggestionId;
        if (relationSuggestion__resolvedKey == null
                || !relationSuggestion__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SuggestionDao targetDao = daoSession.getSuggestionDao();
            Suggestion relationSuggestionNew = targetDao.load(__key);
            synchronized (this) {
                relationSuggestion = relationSuggestionNew;
                relationSuggestion__resolvedKey = __key;
            }
        }
        return relationSuggestion;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1142606855)
    public void setRelationSuggestion(@NotNull Suggestion relationSuggestion) {
        if (relationSuggestion == null) {
            throw new DaoException(
                    "To-one property 'suggestionId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.relationSuggestion = relationSuggestion;
            suggestionId = relationSuggestion.getId();
            relationSuggestion__resolvedKey = suggestionId;
        }
    }

}

