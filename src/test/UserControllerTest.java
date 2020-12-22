import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static junit.framework.TestCase.fail;

public class UserControllerTest extends BaseControllerTest {

    //此URL对应你的请求地址
    private String url = "/user/";

    //POST 设置参数
    @Test
    public void addUserType() {
        try {
//            UserReq req = new UserReq();
//            req.setUserCode("TestLiTong");
//            req.setUserName("TestLiTong");
//            req.setCreateRemark("TestLiTong");
//            req.setCreateUname("LT");
            String requestJson = "";//JSONObject.toJSONString(req);
            //在这边的URL对应相应的接口
            mvc.perform(MockMvcRequestBuilders.post(url+"add")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(requestJson)
            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
            //出异常就报错
            fail();
        }
    }

    //GET 设置参数
    @Test
    public void get() throws Exception {
        try{
            //在这边的URL对应相应的接口
            mvc.perform(MockMvcRequestBuilders.get(url+"get")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .param("id","20")
                    .param("userCode","TestLiTong")
            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
            //出异常就报错
            fail();
        }
    }
}