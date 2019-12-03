package com.fhlxc.backend;
import java.io.File;

import com.fhlxc.entity.Plan;
import com.fhlxc.entity.Task;
/**
* @author Liu Haotian
* @date 2019/00/26 20:00:58
* @ClassName MainFunction.java
* @Description 描述了主要功能：导入课表，安排时间，匹配课友等。
*/

public class MainFunction {
    public boolean importCourse(File file) {
        return true;
    }
    public boolean viewNotification(String n_id) {
        return true;
    }
    public boolean arrangePlan(Plan p) {
        return true;
    }
    public boolean setRemind() {
        return true;
    }
    public boolean matchPartner(String aim) {
        return true;
    }
    public boolean arrangeTask(String st_id, Task t) {
        return true;
    }
}
