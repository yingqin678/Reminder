package com.controller;

import com.item.model.ItemModel;
import com.item.service.ItemOperateService;
import com.service.login.LoginService;
import com.util.JSONUtil;
import com.util.SpringContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yingmeng on 2017/5/21 0021.
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @RequestMapping(value = "/{bean}/{method}", method = RequestMethod.POST)
    public void requestData(@PathVariable String bean, @PathVariable String method, HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, Object> params = request.getParameterMap();
        String clientIp = request.getRemoteAddr();
        Object object = SpringContext.getApplicationContext().getBean(bean);
        Map<String, Object> returnValue = new HashMap<>();
        if (bean.equals("item"))
        {
            ItemOperateService item = (ItemOperateService) object;
            itemOpre(item, returnValue, method, params, clientIp);
        }
        else if (bean.equals("user"))
        {
            LoginService loginService = (LoginService)object;
            userOper(loginService, returnValue, method, params, clientIp);
        }

        renderData(response, JSONUtil.toJson(returnValue));
    }

    /**
     * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
     *
     * @param response
     * @param data
     */
    private void renderData(HttpServletResponse response, String data) {
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print(data);
        } catch (IOException ex) {
        } finally {
            if (null != printWriter) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }

    private  void itemOpre(ItemOperateService item, Map<String, Object> returnValue, String method, Map<String, Object> params, String clientIp){
        if (method.equals("AddItem"))
        {
            ItemModel model = new ItemModel(Integer.parseInt(((String[])params.get("id"))[0]), ((String[])params.get("content"))[0],
                    Long.parseLong(((String[])params.get("deadTime"))[0]), Integer.parseInt(((String[])params.get("result"))[0]),
                    Integer.parseInt(((String[])params.get("levelValue"))[0]), Integer.parseInt(((String[])params.get("type"))[0]), clientIp);
            boolean result = item.AddItem(model);
            returnValue.put("result", String.valueOf(result));
        }
        else if (method.equals("queryDoingItem"))
        {
            List<ItemModel> result = item.queryDoingItem(clientIp);
            returnValue.put("result", result);
        }
        else if (method.equals("queryDomeOrDoingItem"))
        {
            List<ItemModel> result = item.queryDomeOrDoingItem(clientIp);
            returnValue.put("result", result);
        }
    }

    private void userOper(LoginService loginService, Map<String, Object> returnValue, String method, Map<String, Object> params, String clientIp) {
        if (method.equals("setIpAndName")) {
            loginService.setIpAndName(clientIp, ((String[])params.get("name"))[0]);
        } else if (method.equals("getName")) {
            String name = loginService.getName(clientIp);

            returnValue.put("result", name);
        }
    }
}
