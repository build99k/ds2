package com.example.ds2.feign.client;

import com.example.ds2.feign.config.Config;
import com.example.ds2.dto.Contributor;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign", url = "https://api.github.com/repos", configuration = Config.class)
public interface GitHubFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/{owner}/{repo}/contributors")
  List<Contributor> getContributor(@PathVariable("owner") String owner, @PathVariable("repo") String repo);
}
