package yueshenginfo.com.mynovel.module.home.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/16.
 * Email 1064224874@qq.com
 */
public class KeyWordsDto {

    /**
     * keywords : ["秦简","全职法师","强势缠绵：总裁大人，你轻点！","青铜剑客","七星肥熊","秦时明月之大反派系统","秦简.","千回转z","千翠百恋","全宇宙都是我好友"]
     * ok : true
     */

    private boolean ok;
    private List<String> keywords;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
