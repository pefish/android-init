package com.pefish.joy.greendaotest.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：08/03/2017 4:00 PM
 */

@Entity
public class User {
    @Id
    private Long id; // 表示主键, 不需要设置此字段，会递增
    private String name;
    @Transient
    private int tempUsageCount; // 表示此字段不入库
    @Generated(hash = 873297011)
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
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