package yueshenginfo.com.mynovel.module.home.dto;

/**
 * Created by huchao on 2016/12/1.
 * Email 1064224874@qq.com
 */
public class BookShelfBean {
    private String img;
    private String name;
    private String bookState;
    private String readState;

    public BookShelfBean(String img, String name, String bookState, String readState) {
        this.img = img;
        this.name = name;
        this.bookState = bookState;
        this.readState = readState;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookState() {
        return bookState;
    }

    public void setBookState(String bookState) {
        this.bookState = bookState;
    }

    public String getReadState() {
        return readState;
    }

    public void setReadState(String readState) {
        this.readState = readState;
    }
}
