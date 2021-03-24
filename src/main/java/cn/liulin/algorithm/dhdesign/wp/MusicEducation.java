package cn.liulin.algorithm.dhdesign.wp;

/**
 * cn.liulin.algorithm.dhdesign.wp$
 * 音乐课代表
 * @author ll
 * @date 2021-03-24 16:10:34
 **/
public class MusicEducation implements Person{
    @Override
    public void doSport(String sportName) {
        System.out.println("音乐课代表开始做" + sportName + "的活动");
    }
}
