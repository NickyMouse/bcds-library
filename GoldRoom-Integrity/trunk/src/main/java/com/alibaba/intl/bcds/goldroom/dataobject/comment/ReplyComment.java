/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dataobject.comment;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.alibaba.intl.bcds.goldroom.dataobject.Comment;

/**
 * @author Harrison
 *
 */

@Entity
@DiscriminatorValue(value="REPLY")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ReplyComment extends Comment {
	
    private Set<Comment> replyComment; // 评论本身的回复信息
	
	/**
	 * @return the replyComment
	 */
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="REPLY_ID", nullable=true, referencedColumnName="ID")
	public Set<Comment> getReplyComment() {
		return replyComment;
	}

	/**
	 * @param replyComment the replyComment to set
	 */
	public void setReplyComment(Set<Comment> replyComment) {
		this.replyComment = replyComment;
	}

}
