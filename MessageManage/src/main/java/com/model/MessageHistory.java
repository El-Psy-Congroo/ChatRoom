package com.model;

import java.util.Date;

public class MessageHistory {
    private Integer id;

    private Integer senderId;

    private String sAddress;

    private String sCanal;

    private Date sTime;

    private String message;

    private String mType;

    private String mStatus;

    private Integer addresseeId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }

    public String getsCanal() {
        return sCanal;
    }

    public void setsCanal(String sCanal) {
        this.sCanal = sCanal == null ? null : sCanal.trim();
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus == null ? null : mStatus.trim();
    }

    public Integer getAddresseeId() {
        return addresseeId;
    }

    public void setAddresseeId(Integer addresseeId) {
        this.addresseeId = addresseeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}