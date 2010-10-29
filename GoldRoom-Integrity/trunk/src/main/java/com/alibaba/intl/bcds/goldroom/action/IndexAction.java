/**
 *
 */
package com.alibaba.intl.bcds.goldroom.action;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
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
		List<BookItem> hotBooks1 = bookItemService.getBookItemsByAddtime(4);

		for (BookItem hotBooks : hotBooks1) {
			
			hotBooks.getBookInfo().setComments(
					commentService.listBookCommentByBookInfoId(
							hotBooks.getId(), 1, 2));
			
			if (hotBooks.getBookInfo().getDescription() != null) {

				String descriptions = hotBooks.getBookInfo().getDescription();
				if(hotBooks.getBookInfo().getComments().size()>1){

					if (descriptions.length() > 120) {
						descriptions = descriptions.substring(0, 120) + "...";
						
					}
					
				}else{				
			
				if (descriptions.length() > 160) {
						descriptions = descriptions.substring(0, 160) + "...";
					
				}
				}
				hotBooks.getBookInfo().setDescription(descriptions);
			}
			// 查找书评信息

		}
		hotBooks = hotBooks1;

		return SUCCESS;
	}

}
