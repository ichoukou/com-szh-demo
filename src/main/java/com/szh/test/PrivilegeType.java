package com.szh.test;

/**
 * Created by zhihaosong on 16-11-7.
 */
public enum PrivilegeType {
    JOB_UP_LIMIT_X1(1, "job_up_limit_x1", "管理有效职位上限+1", 1),
    JOB_REFRESH_X1(2, "job_refresh_x1", "职位刷新1次", 1),
    RESUME_DOWNLOAD_X1(3, "resume_download_x1", "简历下载1份", 1),
    REWARD_500_INVITATION(4, "reward_500_invitation", "悬赏邀约（500人）1次", 1),
    REWARD_1000_INVITATION(5, "reward_1000_invitation", "悬赏邀约（1000人）1次", 1),
    REWARD_1500_INVITATION(6, "reward_1500_invitation", "悬赏邀约（1500人）1次", 1),
    JOB_UP_LIMIT_X5(7, "job_up_limit_x5", "管理有效职位上限+5", 5),
    RESUME_DOWNLOAD_X5(8, "resume_download_x5", "简历下载5份", 5);

    private int id;
    private String privilegeType;
    private String privilegeName;
    private int num;

    PrivilegeType(int id, String privilegeType, String privilegeName, int num) {
        this.id = id;
        this.privilegeType = privilegeType;
        this.privilegeName = privilegeName;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilegeType() {
        return privilegeType;
    }

    public void setPrivilegeType(String privilegeType) {
        this.privilegeType = privilegeType;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
