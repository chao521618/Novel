package yueshenginfo.com.mynovel.module.home.dto;

import java.util.List;

import yueshenginfo.com.mynovel.module.morenovel.dto.BooksDto;

/**
 * Created by huchao on 2016/12/12.
 * Email 1064224874@qq.com
 */
public class CategoryEvent {
    public List<BooksDto.BooksVO> mBooksDto;

    public CategoryEvent(List<BooksDto.BooksVO> mBooksDto) {
        this.mBooksDto = mBooksDto;
    }
}
