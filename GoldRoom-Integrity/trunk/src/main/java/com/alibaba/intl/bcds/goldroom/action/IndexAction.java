/**
 *
 */
package com.alibaba.intl.bcds.goldroom.action;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Comment;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.CommentService;

/**
 * @author Harrison
 * 
 */
public class IndexAction extends BaseAction {

	/**
	 *
	 */

	private BookItemService bookItemService;
	private CommentService commentService;

	private List<BookItem> hotBooks;

	public List<BookItem> getHotBooks() {
		return hotBooks;
	}

	public void setHotBooks(List<BookItem> hotBooks) {
		this.hotBooks = hotBooks;
	}

	public BookItemService getBookItemService() {
		return bookItemService;
	}

	public void setBookItemService(BookItemService bookItemService) {
		this.bookItemService = bookItemService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	private static final long serialVersionUID = -2235532196343484766L;

	public String execute() throws Exception {

		// 获取热评记录
		List<BookItem> hotBooks1 = creatHotBooks();
		
		//新书榜 按照 标签来获取不同的新书 TODO
		
		//最受欢迎的书评 TODO
		
		//热门标签  TODO
		
		//推荐排行榜 TODO
		
		//积分排行榜 TODO

		hotBooks = hotBooks1;

		return SUCCESS;
	}

	private List<BookItem> creatHotBooks() {
		List<BookItem> hotBooks1 = bookItemService.getBookItemsByAddtime(4);

		for (BookItem hotBooks : hotBooks1) {

			List<Comment> CommentList = commentService
					.listBookCommentByBookInfoId(hotBooks.getId(), 1, 2);
			// 截取评论的长度
			for (Comment comment : CommentList) {

				if (comment.getContent() != null
						&& comment.getContent().length() > 20) {

					comment.setContent(comment.getContent().substring(0, 20)
							+ "...");

				}
			}
			hotBooks.getBookInfo().setComments(CommentList);

			if (hotBooks.getBookInfo().getDescription() != null) {

				String descriptions = hotBooks.getBookInfo().getDescription();
				if (hotBooks.getBookInfo().getComments().size() > 1) {

					if (descriptions.length() > 120) {
						descriptions = descriptions.substring(0, 120) + "...";

					}

				} else {

					if (descriptions.length() > 160) {
						descriptions = descriptions.substring(0, 160) + "...";

					}
				}
				hotBooks.getBookInfo().setDescription(descriptions);
			}
			// 查找书评信息

		}
		return hotBooks1;
	}
}
