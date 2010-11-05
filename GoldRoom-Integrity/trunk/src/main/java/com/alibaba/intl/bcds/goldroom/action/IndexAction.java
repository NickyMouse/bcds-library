/**
 *
 */
package com.alibaba.intl.bcds.goldroom.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Comment;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.TagInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.TagInfoBooksDTO;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.CommentService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.TagService;

/**
 * @author Harrison
 *
 */
public class IndexAction extends BaseAction {

	/**
	 *service
	 */

	private BookItemService bookItemService;

	private CommentService commentService;
	private MemberService memberService;
	private TagService tagService;
	private BookInfoService bookInfoService;

	/**
	 * 页面获取的属性
	 */

	private List<BookItem> hotBooks;
	private List<Member> scoremembers;
	private List<TagInfo> tagInfos;
	private List<TagInfoBooksDTO> tagInfoBooks=new ArrayList<TagInfoBooksDTO>();

	public List<TagInfoBooksDTO> getTagInfoBooks() {
		return tagInfoBooks;
	}

	public void setTagInfoBooks(List<TagInfoBooksDTO> tagInfoBooks) {
		this.tagInfoBooks = tagInfoBooks;
	}

	public List<TagInfo> getTagInfos() {
		return tagInfos;
	}

	public void setTagInfos(List<TagInfo> tagInfos) {
		this.tagInfos = tagInfos;
	}

	public TagService getTagService() {
		return tagService;
	}

	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	public List<Member> getScoremembers() {
		return scoremembers;
	}

	public void setScoremembers(List<Member> scoremembers) {
		this.scoremembers = scoremembers;
	}

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

	public BookInfoService getBookInfoService() {
		return bookInfoService;
	}

	public void setBookInfoService(BookInfoService bookInfoService) {
		this.bookInfoService = bookInfoService;
	}

	private static final long serialVersionUID = -2235532196343484766L;

	public String execute() throws Exception {

		// 获取热评记录
		List<BookItem> hotBooks1 = creatHotBooks();

		// 最受欢迎的书评 TODO

		// 热门标签 TODO

		List<TagInfo> tagInfos = tagService.listTag(19);
		setTagInfos(tagInfos);

		// 新书榜 按照 标签来获取不同的新书 TODO
		/**
		 * 取标签后 按照标签去查找4本书
		 *
		 */

		int i = 0;

		for (TagInfo tagInfo : tagInfos) {

			i++;

			TagInfoBooksDTO tagbooks = new TagInfoBooksDTO();
			// 获取书籍
			BookSearchResult bookSearchResult = bookInfoService
					.searchBookByKeyword(tagInfo.getTagName(),
							SearchBookType.ALL, 1, 4);

			tagbooks.setTagInfo(tagInfo);
			tagbooks.setBookInfoList(bookSearchResult.getBookList());

			this.getTagInfoBooks().add(tagbooks);

			if (i >= 5) {

				break;

			}

		}

		// 推荐排行榜 TODO

		// 积分排行榜
        List<Member> memebers = memberService.listMemberByScore(10);

		setScoremembers(memebers);

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
//			hotBooks.getBookInfo().setComments(CommentList);

			if (hotBooks.getBookInfo().getDescription() != null) {

				String descriptions = hotBooks.getBookInfo().getDescription();
//				if (hotBooks.getBookInfo().getComments().size() > 1) {
//
//					if (descriptions.length() > 120) {
//						descriptions = descriptions.substring(0, 120) + "...";
//
//					}
//
//				} else {

					if (descriptions.length() > 160) {
						descriptions = descriptions.substring(0, 160) + "...";

					}
//				}
				hotBooks.getBookInfo().setDescription(descriptions);
			}

			// 查找书评信息

		}
		return hotBooks1;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
