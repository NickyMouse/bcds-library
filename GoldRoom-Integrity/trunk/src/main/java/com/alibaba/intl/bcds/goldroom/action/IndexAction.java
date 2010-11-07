/**
 *
 */
package com.alibaba.intl.bcds.goldroom.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.TagInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.TagInfoBooksDTO;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.service.TagService;

/**
 * @author Harrison
 */
public class IndexAction extends BaseAction {

    /**
     * service
     */
    private MemberService         memberService;
    private TagService            tagService;
    private BookInfoService       bookInfoService;

    /**
     * 页面获取的属性
     */
    private static final long     serialVersionUID = -2235532196343484766L;
    private List<Member>          memberScores;
    private List<BookInfo>        hotBookList;
    private List<TagInfoBooksDTO> tagInfoBooks;
    private List<TagInfo>         tags;

    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    public String execute() throws Exception {

        this.hotBookList = createHotBooks();
        this.tagInfoBooks = createTagInfo();

        // 积分排行榜
        this.memberScores = createMemberScoreList();

        return SUCCESS;
    }

    /**
     * 最新书籍
     *
     * @return
     */
    private List<BookInfo> createHotBooks() {
        List<BookInfo> newBooks = bookInfoService.listAllBook(SearchBookType.ALL, 1, 4).getBookList();
        return newBooks;
    }

    /**
     * 积分排行榜
     *
     * @return
     */
    private List<Member> createMemberScoreList() {
        return memberService.listMemberByScore(10);
    }

    /**
     * tag信息
     *
     * @return
     */
    private List<TagInfoBooksDTO> createTagInfo() {
        tags = tagService.listTag(19);

        if (tags != null) {
            List<TagInfoBooksDTO> tagInfoBookList = new ArrayList<TagInfoBooksDTO>(4);
            for (int i = 0; i < 5 && i < tags.size(); i++) {
                TagInfo tag = tags.get(i);

                TagInfoBooksDTO tagbooks = new TagInfoBooksDTO();
                BookSearchResult bookSearchResult = bookInfoService.searchBookByKeyword(tag.getTagName(),
                                                                                        SearchBookType.ALL, 1, 4);
                tagbooks.setTagInfo(tag);
                tagbooks.setBookInfoList(bookSearchResult.getBookList());
                tagInfoBookList.add(tagbooks);
            }
            return tagInfoBookList;
        }
        return null;

    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public void setMemberScores(List<Member> memberScores) {
        this.memberScores = memberScores;
    }

    public List<Member> getMemberScores() {
        return memberScores;
    }

    public List<TagInfo> getTags() {
        return tags;
    }

    public List<TagInfoBooksDTO> getTagInfoBooks() {
        return tagInfoBooks;
    }

    public List<BookInfo> getHotBookList() {
        return hotBookList;
    }
}
