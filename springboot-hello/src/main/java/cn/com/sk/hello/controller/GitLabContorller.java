package cn.com.sk.hello.controller;

import cn.com.sk.hello.gitlab.GitLabService;
import org.gitlab4j.api.GitLabApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("gitlab")
public class GitLabContorller {

    @Autowired
    private GitLabService gitLabService;

    @RequestMapping("get")
    public void get() throws GitLabApiException, ParseException {
        gitLabService.get();
    }
}
