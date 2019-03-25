package com.springbatch.example.springbatch.resources.processor;

import com.springbatch.example.springbatch.resources.model.User;
import com.springbatch.example.springbatch.resources.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {
        userRepository.saveAll(users);
    }
}
