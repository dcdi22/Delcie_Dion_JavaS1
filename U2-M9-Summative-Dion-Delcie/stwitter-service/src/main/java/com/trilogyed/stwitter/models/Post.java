package com.trilogyed.stwitter.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Post {

    private int postId;
    private String postContent;
    private LocalDate postDate;
    private String posterName;
    private List<String> comments;

    public Post() {
    }

    public Post(int postId, String postContent, LocalDate postDate, String posterName, List<String> comments) {
        this.postId = postId;
        this.postContent = postContent;
        this.postDate = postDate;
        this.posterName = posterName;
        this.comments = comments;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    // did not set anything to notnull

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId &&
                Objects.equals(postContent, post.postContent) &&
                Objects.equals(postDate, post.postDate) &&
                Objects.equals(posterName, post.posterName) &&
                Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postContent, postDate, posterName, comments);
    }


    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postContent='" + postContent + '\'' +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", comments=" + comments +
                '}';
    }
}
