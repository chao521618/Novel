package yueshenginfo.com.mynovel.module.home.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/7.
 * Email 1064224874@qq.com
 */
public class BooksCategoryDto {

    /**
     * male : [{"name":"玄幻","bookCount":336818},{"name":"奇幻","bookCount":38915},{"name":"武侠","bookCount":26347},{"name":"仙侠","bookCount":91978},{"name":"都市","bookCount":218839},{"name":"职场","bookCount":10984},{"name":"历史","bookCount":45952},{"name":"军事","bookCount":10746},{"name":"游戏","bookCount":52511},{"name":"竞技","bookCount":3934},{"name":"科幻","bookCount":66329},{"name":"灵异","bookCount":25280},{"name":"同人","bookCount":34344},{"name":"轻小说","bookCount":3864}]
     * female : [{"name":"古代言情","bookCount":252702},{"name":"现代言情","bookCount":273337},{"name":"青春校园","bookCount":82611},{"name":"纯爱","bookCount":61340},{"name":"玄幻奇幻","bookCount":63591},{"name":"武侠仙侠","bookCount":37984},{"name":"科幻","bookCount":3565},{"name":"游戏竞技","bookCount":3371},{"name":"悬疑灵异","bookCount":5418},{"name":"同人","bookCount":93085},{"name":"女尊","bookCount":9602},{"name":"莉莉","bookCount":13373}]
     * press : [{"name":"传记名著","bookCount":946},{"name":"出版小说","bookCount":1739},{"name":"人文社科","bookCount":3558},{"name":"生活时尚","bookCount":266},{"name":"经管理财","bookCount":2332},{"name":"青春言情","bookCount":2491},{"name":"外文原版","bookCount":428},{"name":"政治军事","bookCount":60},{"name":"成功励志","bookCount":917},{"name":"育儿健康","bookCount":1293}]
     * ok : true
     */

    private boolean ok;
    /**
     * name : 玄幻
     * bookCount : 336818
     */

    private List<MaleVO> male;
    /**
     * name : 古代言情
     * bookCount : 252702
     */

    private List<FemaleVO> female;
    /**
     * name : 传记名著
     * bookCount : 946
     */

    private List<PressVO> press;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<MaleVO> getMale() {
        return male;
    }

    public void setMale(List<MaleVO> male) {
        this.male = male;
    }

    public List<FemaleVO> getFemale() {
        return female;
    }

    public void setFemale(List<FemaleVO> female) {
        this.female = female;
    }

    public List<PressVO> getPress() {
        return press;
    }

    public void setPress(List<PressVO> press) {
        this.press = press;
    }

    public static class MaleVO {
        private String name;
        private int bookCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }
    }

    public static class FemaleVO {
        private String name;
        private int bookCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }
    }

    public static class PressVO {
        private String name;
        private int bookCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }
    }
}
