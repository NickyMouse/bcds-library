/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.dataobject.comment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alibaba.intl.bcds.goldroom.dataobject.Comment;

/**
 * @author Harrison
 *
 */

@Entity
@DiscriminatorValue(value="REPLY")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ReplyComment extends Comment {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REPLY_ID", nullable=true, referencedColumnName="ID")
	private Comment sourceComment; // 被回复的评论
	
//	private BookInfoComment bookInfoComment; // 图书评论的回复
//	
//    private List<ReplyComment> replyComment; // 评论本身的回复信息
//	


	/**
	 * @return the sourceComment
	 */
	public Comment getSourceComment() {
		return sourceComment;
	}

	/**
	 * @param sourceComment the sourceComment to set
	 */
	public void setSourceComment(Comment sourceComment) {
		this.sourceComment = sourceComment;
	}

}
