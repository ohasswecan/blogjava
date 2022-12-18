package com.ctfstar.myblog.web.pojo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;


import java.util.Date;
import java.util.List;

@Entity(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatetime;

    @ManyToOne
    private Type type;


    @ManyToMany
    private List<Tag> tags=new ArrayList<>();

    @ManyToOne
    private Admin admin;



    @OneToMany
    private List<Comment> comments=new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Blog(){}

    public Blog(Long id, String content, String firstPicture, String flag, Integer views, boolean recommend, Date createtime, Date updatetime) {
        this.id = id;
        this.content = content;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.views = views;
        this.recommend = recommend;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", recommend=" + recommend +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
