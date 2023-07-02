package tech.jiangchen.entity;

import java.io.Serializable;

public class ContactMultiKeys implements Serializable {

    protected Long ownerUid;
    protected Long otherUid;

    public ContactMultiKeys(Long ownerUid, Long otherUid) {
        this.ownerUid = ownerUid;
        this.otherUid = otherUid;
    }

    public ContactMultiKeys() {
        
    }

    public Long getOwnerUid() {
        return ownerUid;
    }

    public void setOwnerUid(Long ownerUid) {
        this.ownerUid = ownerUid;
    }

    public Long getOtherUid() {
        return otherUid;
    }

    public void setOtherUid(Long otherUid) {
        this.otherUid = otherUid;
    }
}