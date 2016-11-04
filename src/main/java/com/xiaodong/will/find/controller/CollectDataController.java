package com.xiaodong.will.find.controller;

import com.xiaodong.will.find.model.json.Period;
import com.xiaodong.will.find.service.inter.CollectDataService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * 采集数据Controller
 */
@Controller
@RequestMapping("collect")
public class CollectDataController extends ErrorHandleController {

    private static final Logger LOG = LoggerFactory.getLogger(CollectDataController.class);

    @Autowired
    private CollectDataService collectDataService;

    @ResponseBody
    @RequestMapping("data.do")
    public List<Period> data(@Param("period") String period) {
        if (StringUtils.isBlank(period)) {
            LOG.info("period is blank !");
            return Collections.emptyList();
        }
        return collectDataService.getAllRecode(period);
    }
}
