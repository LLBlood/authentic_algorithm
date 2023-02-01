package cn.liulin.algorithm.dhdesign.delegate;

/**
 * cn.liulin.algorithm.dhdesign.wp$
 * 体育课代表
 * @author ll
 * @date 2021-03-24 16:08:48
 **/
public class PhysicalEducation implements Person{
    @Override
    public void doSport(String sportName) {
        System.out.println("体育委员开始做" + sportName + "的活动");
    }
}
