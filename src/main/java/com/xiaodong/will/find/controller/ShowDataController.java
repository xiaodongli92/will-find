package com.xiaodong.will.find.controller;

import com.xiaodong.will.find.model.PageParam;
import com.xiaodong.will.find.model.SearchParam;
import com.xiaodong.will.find.model.pojo.Record;
import com.xiaodong.will.find.service.inter.ShowDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据显示Controller
 */
@Controller
@RequestMapping("show")
public class ShowDataController extends ErrorHandleController {

    private static final Logger LOG = LoggerFactory.getLogger(ShowDataController.class);

    @Autowired
    protected ShowDataService showDataService;

    @RequestMapping("toDataPage.do")
    public String toDataPage() {
        return "data";
    }

    @RequestMapping("data.do")
    @ResponseBody
    public List<Record> data(SearchParam searchParam, PageParam pageParam) {
        long count = showDataService.count(searchParam);
        pageParam.setTotalCount(count);
        pageParam.init();
        return showDataService.findByParam(searchParam, pageParam);
    }
}
