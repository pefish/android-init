package com.pefish.joy.greendaotest.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：10/03/2017 3:58 PM
 */
@Entity
public class ExtraData {
    @Id(autoincrement = true)
    private Long id;

    private String test;

    @Generated(hash = 237591765)
    public ExtraData(Long id, String test) {
        this.id = id;
        this.test = test;
    }

    @Generated(hash = 639686732)
    public ExtraData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest() {
        return this.test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
