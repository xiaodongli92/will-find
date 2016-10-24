package com.xiaodong.will.find.model;

/**
 * 用户
 */
public class User {

    private String uid;

    private String avatarName;

    private int freeCoin;

    private String IPAddress;

    private int isFirstLogin;

    private String nickname;

    private int coin;

    private String IP;

    private String avatarPrefix;

    private String cid;

    private int bonusNum;

    private String mobile;

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", avatarName='" + avatarName + '\'' +
                ", freeCoin=" + freeCoin +
                ", IPAddress='" + IPAddress + '\'' +
                ", isFirstLogin=" + isFirstLogin +
                ", nickname='" + nickname + '\'' +
                ", coin=" + coin +
                ", IP='" + IP + '\'' +
                ", avatarPrefix='" + avatarPrefix + '\'' +
                ", cid='" + cid + '\'' +
                ", bonusNum=" + bonusNum +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public int getFreeCoin() {
        return freeCoin;
    }

    public void setFreeCoin(int freeCoin) {
        this.freeCoin = freeCoin;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public int getIsFirstLogin() {
        return isFirstLogin;
    }

    public void setIsFirstLogin(int isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getAvatarPrefix() {
        return avatarPrefix;
    }

    public void setAvatarPrefix(String avatarPrefix) {
        this.avatarPrefix = avatarPrefix;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
