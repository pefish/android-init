package com.pefish.joy.greendaotest.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.pefish.joy.greendaotest.daos.DaoSession;
import com.pefish.joy.greendaotest.daos.ExtraDataDao;
import com.pefish.joy.greendaotest.daos.UserDao;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：08/03/2017 4:00 PM
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id; // 表示主键, 不需要设置此字段，会递增
    @NotNull
    @Index(unique = true)
    private String name;
    @Transient
    private int tempUsageCount; // 表示此字段不入库

    private long extraDataId;
    @ToOne(joinProperty = "extraDataId")
    private ExtraData extraData;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;
    @Generated(hash = 165013248)
    public User(Long id, @NotNull String name, long extraDataId) {
        this.id = id;
        this.name = name;
        this.extraDataId = extraDataId;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getExtraDataId() {
        return this.extraDataId;
    }
    public void setExtraDataId(long extraDataId) {
        this.extraDataId = extraDataId;
    }
    @Generated(hash = 1127863733)
    private transient Long extraData__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 2112223081)
    public ExtraData getExtraData() {
        long __key = this.extraDataId;
        if (extraData__resolvedKey == null
                || !extraData__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ExtraDataDao targetDao = daoSession.getExtraDataDao();
            ExtraData extraDataNew = targetDao.load(__key);
            synchronized (this) {
                extraData = extraDataNew;
                extraData__resolvedKey = __key;
            }
        }
        return extraData;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 745552934)
    public void setExtraData(@NotNull ExtraData extraData) {
        if (extraData == null) {
            throw new DaoException(
                    "To-one property 'extraDataId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.extraData = extraData;
            extraDataId = extraData.getId();
            extraData__resolvedKey = extraDataId;
        }
    }
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
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}

//(一) @Entity 定义实体
//@nameInDb 在数据库中的名字，如不写则为实体中类名
//@indexes 索引
//@createInDb 是否创建表，默认为true,false时不创建
//@schema 指定架构名称为实体
//@active 无论是更新生成都刷新
//    (二) @Id
//    (三) @NotNull 不为null
//    (四) @Unique 唯一约束
//    (五) @ToMany 一对多
//    (六) @OrderBy 排序
//    (七) @ToOne 一对一
//    (八) @Transient 不存储在数据库中
//    (九) @generated 由greendao产生的构造函数或方法

