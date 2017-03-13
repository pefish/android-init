package com.pefish.joy.greendaotest.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Suggestion {
    @Id
    private Long id;
    @Transient
    private InternelClass1 uv;
    @Transient
    private InternelClass1 cw;
    @Transient
    private InternelClass1 drs;
    @Transient
    private InternelClass1 trav;
    @Transient
    private InternelClass1 comf;

    @Generated(hash = 1122320667)
    public Suggestion(Long id) {
        this.id = id;
    }

    @Generated(hash = 998731485)
    public Suggestion() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private class InternelClass1 {
        private String txt;
        private String brf;

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }
    }
}
