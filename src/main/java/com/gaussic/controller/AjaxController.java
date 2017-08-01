package com.gaussic.controller;

import com.item.mapper.ItemMapper;
import com.item.model.ItemModel;
import com.item.service.ItemOperateService;
import com.util.JSONUtil;
import com.ying.dairy.DariyService;
import com.ying.dairy.model.DariyModel;
import com.ying.spring.context.SpringContext;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yingmeng on 2017/5/21 0021.
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(HttpServletRequest request, HttpServletResponse response) {
        String jsonResult = getJSONString(request);
        renderData(response, jsonResult);
    }

    @RequestMapping(value = "/{bean}/{method}", method = RequestMethod.POST)
    public void requestData(@PathVariable String bean, @PathVariable String method, HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, Object> params = request.getParameterMap();
        String clientIp = request.getRemoteAddr();
        Object object = SpringContext.getApplicationContext().getBean(bean);
        Map<String, Object> returnValue = new HashMap<>();
        if (bean.equals("dairy"))
        {
            DariyService dariyService = (DariyService) object;
            if (method.equals("saveDariy"))
            {
                 boolean result = dariyService.saveDariy(((String[])params.get("title"))[0], ((String[]) params.get("content"))[0],
                         Integer.valueOf(((String[]) params.get("level"))[0]));
                 returnValue.put("result", String.valueOf(result));
            }

            if (method.equals("queryAll"))
            {
                List<DariyModel> result = dariyService.queryAll();
                returnValue.put("result", result);
            }
        }
        else if (bean.equals("item"))
        {
            ItemOperateService item = (ItemOperateService) object;
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
                List<ItemModel> result = item.queryDoingItem();
                returnValue.put("result", result);
            }
            else if (method.equals("queryDomeOrDoingItem"))
            {
                List<ItemModel> result = item.queryDomeOrDoingItem();
                returnValue.put("result", result);
            }
        }

        renderData(response, JSONUtil.toJson(returnValue));
    }

    private String getJSONString(HttpServletRequest request) {
        String jsonResult = "qwer";
        String title = request.getParameter("title");
        return jsonResult;
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
}
