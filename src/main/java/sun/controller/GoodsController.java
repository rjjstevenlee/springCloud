package sun.controller;

import common.entity.RestfulResult;
import common.utils.CommUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.entity.ServiceInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController // 重要，如果用Controller会404
@RequestMapping(value = "/order")
public class GoodsController {

    @RequestMapping(value = "/hello")
    public void login(HttpServletRequest request, HttpServletResponse response,@RequestBody ServiceInfo serviceInfo) {
        RestfulResult restfulResult = new RestfulResult();
        try {
            restfulResult.setData("Service1:Welcome " + serviceInfo.getName() + "!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        CommUtils.printDataJason(response, restfulResult);
    }
    @RequestMapping(value = "/rest")
    public String rest(@RequestBody ServiceInfo serviceInfo) {

        return "Service1:Welcome " + serviceInfo.getName() + " !";
    }
    @RequestMapping(value = "/rest2")
    public String rest2(@RequestBody ServiceInfo serviceInfo) {

        return "Service1:Welcome " + serviceInfo.getName() + " !";
    }
}