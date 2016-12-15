package yueshenginfo.com.mynovel.module.home.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/15.
 * Email 1064224874@qq.com
 */
public class AllLookBooksDto {


    /**
     * hotWords : ["神医嫡女","侯门毒妃","金牌神医：腹黑宠妃","续南明","榻上欢：皇叔，轻点！","综艺娱乐之王","废柴要逆天：魔帝狂妃","焚尸匠","悍妻当家：娘子，轻点打","踏天争仙","爆宠狂妻：神医五小姐","时光旅行者","相府嫡女：五毒大小姐","十国帝王","盛世绝宠：毒妃七小姐","天才后卫","妙偶天成","偷天魔道","黑萌影帝妙探妻","抗日之浩然正气","一品嫡妃","超神无敌系统","异能重生：天才少女占卜师","超能农民工","总裁，关灯吧！"]
     * ok : true
     */

    private boolean ok;
    private List<String> hotWords;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }
}
