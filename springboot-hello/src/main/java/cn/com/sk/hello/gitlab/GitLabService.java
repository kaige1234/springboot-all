package cn.com.sk.hello.gitlab;

import org.gitlab4j.api.GitLabApiException;
import org.springframework.stereotype.Service;

import java.text.ParseException;


public interface GitLabService {

    public void get() throws GitLabApiException, ParseException;


}
