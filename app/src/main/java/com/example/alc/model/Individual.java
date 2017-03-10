package com.example.alc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Individual {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("public_repos")
    @Expose
    public String public_repos;
    @SerializedName("followers")
    @Expose
    public String followers;
    @SerializedName("following")
    @Expose
    public String following;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicRepos() {
        return public_repos;
    }

    public void setPublicRepos(String public_repos) {
        this.public_repos = public_repos;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

}
