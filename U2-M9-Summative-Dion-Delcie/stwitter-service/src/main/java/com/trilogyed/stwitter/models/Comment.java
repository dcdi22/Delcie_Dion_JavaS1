package com.trilogyed.stwitter.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Comment {

    private int commentId;
    private int postId;
    private String commenterName;
    private LocalDate commentDate;
    private String commentContent;

    public Comment() {
    }

    public Comment(int commentId, int postId, String commenterName, LocalDate commentDate, String commentContent) {
        this.commentId = commentId;
        this.postId = postId;
        this.commenterName = commenterName;
        this.commentDate = commentDate;
        this.commentContent = commentContent;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    // did not set anything to notnull

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId &&
                postId == comment.postId &&
                Objects.equals(commenterName, comment.commenterName) &&
                Objects.equals(commentDate, comment.commentDate) &&
                Objects.equals(commentContent, comment.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, commenterName, commentDate, commentContent);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commenterName='" + commenterName + '\'' +
                ", commentDate=" + commentDate +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
