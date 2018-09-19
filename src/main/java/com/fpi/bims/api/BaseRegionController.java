package com.fpi.bims.api;

import com.fpi.bims.model.BaseRegion;
import com.fpi.bims.model.JResult;
import com.fpi.bims.service.BaseRegionService;
import com.fpi.bims.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhaokun
 * @date 2018/09/15
 */
@Controller
@RequestMapping(value = "/bims/api/v1.0/baseregion")
public class BaseRegionController {
    private static final Logger logger = LoggerFactory.getLogger(BaseRegionController.class);

    @Autowired
    private BaseRegionService baseRegionService;

    @ApiOperation(value = "查询区域", notes = "查询区域")
    @ApiImplicitParam(paramType = "query", name = "name", value = "用户名称", required = false, dataType = "String")
    @RequestMapping(value = "/findRegion", method = RequestMethod.GET)
    @ResponseBody
    public JResult findRegion(@RequestParam(value="name", required = false, defaultValue = "") String name) {

        logger.info("exec findUserByName");
        Pageable pageable = new PageRequest(1, 10);
        List<BaseRegion> list = baseRegionService.findRegion(name);
        JResult jResult = new JResult(list);
        return jResult;
    }
}
