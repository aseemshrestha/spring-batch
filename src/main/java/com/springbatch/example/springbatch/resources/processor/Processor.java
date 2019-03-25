package com.springbatch.example.springbatch.resources.processor;

import com.springbatch.example.springbatch.resources.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAME = new HashMap<>();

    public Processor() {
        DEPT_NAME.put("001", "Technology");
        DEPT_NAME.put("002", "Finance");
        DEPT_NAME.put("003", "Accounting");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        String dept = DEPT_NAME.get(deptCode);
        user.setDept(dept);
        return user;
    }
}
