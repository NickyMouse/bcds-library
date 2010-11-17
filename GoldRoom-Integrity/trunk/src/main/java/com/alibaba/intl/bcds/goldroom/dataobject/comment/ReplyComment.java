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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="reply")
public class ReplyComment extends Comment {
	
	private Comment reply; //评论的回复

	/**
	 * @return the reply
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="target_id")
	public Comment getReply() {
		return reply;
	}

	/**
	 * @param reply the reply to set
	 */
	public void setReply(Comment reply) {
		this.reply = reply;
	}

}
