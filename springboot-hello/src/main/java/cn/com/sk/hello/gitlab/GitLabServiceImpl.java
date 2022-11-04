package cn.com.sk.hello.gitlab;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.ProjectApi;
import org.gitlab4j.api.models.Commit;
import org.gitlab4j.api.models.Diff;
import org.gitlab4j.api.models.Project;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GitLabServiceImpl implements GitLabService{
    @Override
    public void get() throws GitLabApiException, ParseException {
        //GitLabApi gitLabApi = GitLabApi.oauth2Login("http://192.168.1.11","root","slIxmQJVEPBMvK8+oLN4NR479Fuh+RFrboH9NtCkdtY=");
        GitLabApi gitLabApi = GitLabApi.oauth2Login("http://192.168.1.11","wangyangming","wym111111");
        System.out.println(gitLabApi.getProjectApi());
        ProjectApi projectApi = gitLabApi.getProjectApi();
        List<Project> projects = projectApi.getProjects();
        for(int i=0;i<projects.size();i++){
            Project project = projects.get(i);
            List<Commit> main = gitLabApi.getCommitsApi().getCommits(project.getId(), "main", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-09-24 22:01:00"), new Date());
            for (int j=0;j<main.size();j++){
                Commit commit = main.get(j);
                List<Diff> diff = gitLabApi.getCommitsApi().getDiff(project.getId(), commit.getId());
                for(int a=0;a<diff.size();a++){
                    Diff diff1 = diff.get(a);
                    System.out.println(diff1);
                }
            }

            System.out.println(main);
        }
        //Project project = gitLabApi.getProjectApi().getProject("My Project");
        //gitLabApi.getCommitsApi().getCommits(project.getId(),"main",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(""),new Date());


    }
}
