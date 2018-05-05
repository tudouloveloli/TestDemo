package me.microcool.okhttpdemo.bean;

/**
 *
 * @author gaoshiwei
 * @date 2017/12/11
 */

public class AboutMe {

    /**
     * login : tudouloveloli
     * id : 17944369
     * avatar_url : https://avatars1.githubusercontent.com/u/17944369?v=4
     * gravatar_id :
     * url : https://api.github.com/users/tudouloveloli
     * html_url : https://github.com/tudouloveloli
     * followers_url : https://api.github.com/users/tudouloveloli/followers
     * following_url : https://api.github.com/users/tudouloveloli/following{/other_user}
     * gists_url : https://api.github.com/users/tudouloveloli/gists{/gist_id}
     * starred_url : https://api.github.com/users/tudouloveloli/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/tudouloveloli/subscriptions
     * organizations_url : https://api.github.com/users/tudouloveloli/orgs
     * repos_url : https://api.github.com/users/tudouloveloli/repos
     * events_url : https://api.github.com/users/tudouloveloli/events{/privacy}
     * received_events_url : https://api.github.com/users/tudouloveloli/received_events
     * type : User
     * site_admin : false
     * name : Tudou
     * company : null
     * blog : http://www.jianshu.com/u/deaef54ff006
     * location : Chengdu,China
     * email : null
     * hireable : null
     * bio : To be a better man !
     * public_repos : 117
     * public_gists : 0
     * followers : 4
     * following : 103
     * created_at : 2016-03-19T08:26:46Z
     * updated_at : 2017-12-05T02:22:58Z
     */

    private String login; //注册名
    private int id; // id
    private String avatar_url;
    private String repos_url;
    private String type;
    private String name;
    private String blog;
    private String location;
    private String bio;
    private int public_repos;
    private int followers;
    private int following;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
}
