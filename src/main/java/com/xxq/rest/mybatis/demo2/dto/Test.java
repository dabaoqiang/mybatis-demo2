package com.xxq.rest.mybatis.demo2.dto;

import java.util.Date;

/**
 * @author xiaoqiang
 * @Title: Test
 * @ProjectName mybatis-demo2
 * @Description: TODO
 * @date 2018-12-22 19:43
 */
public class Test {

    private Long id;
    private Long interact_Id;
    private Long activity_id;
    private Date create_time;
    private Date modify_time;

    /**
     * setter/getter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInteract_Id() {
        return interact_Id;
    }

    public void setInteract_Id(Long interact_Id) {
        this.interact_Id = interact_Id;
    }

    public Long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Long activity_id) {
        this.activity_id = activity_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", interact_Id=" + interact_Id +
                ", activity_id=" + activity_id +
                ", create_time=" + create_time +
                ", modify_time=" + modify_time +
                '}';
    }

}
