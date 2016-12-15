package yueshenginfo.com.mynovel.module.home.dto;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public class BooksBean {
private String img;
    private String name;

    public BooksBean(String img, String name) {
        this.img = img;
        this.name = name;
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
}
