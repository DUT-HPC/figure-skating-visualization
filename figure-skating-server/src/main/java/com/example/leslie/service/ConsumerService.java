package com.example.leslie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.leslie.common.R;
import com.example.leslie.model.domain.Consumer;
import com.example.leslie.model.request.ConsumerRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

public interface ConsumerService extends IService<Consumer> {

    R addUser(ConsumerRequest registryRequest);

    R updateUserMsg(ConsumerRequest updateRequest);

    R updateUserAvator(MultipartFile avatorFile, int id);

    R updatePassword(ConsumerRequest updatePasswordRequest);

    boolean existUser(String username);

    boolean verityPasswd(String username, String password);

    R deleteUser(Integer id);

    R allUser();

    R userOfId(Integer id);

    R loginStatus(ConsumerRequest loginRequest, HttpSession session);

}
