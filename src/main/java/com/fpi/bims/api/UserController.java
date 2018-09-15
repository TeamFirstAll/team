package com.fpi.bims.api;

import com.fpi.bims.model.BaseRegion;
import com.fpi.bims.model.JResult;
import com.fpi.bims.model.User;
import com.fpi.bims.service.UserService;
import com.fpi.simple.responses.SuccessResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kangkang_sun
 * @date 2018/01/15
 */
@Controller
@RequestMapping(value = "/bims/api/v1.0/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "增加用户信息", notes = "增加用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse insert(@RequestBody User user) {
        try {
            logger.info("exec insert");
            userService.saveUser(user);
        } catch (Exception e) {
            return SuccessResponse.FAILURE;
        }
        return SuccessResponse.SUCCESS;
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public SuccessResponse update(@PathVariable(value = "id") Long id, @RequestBody User user) {
        try {
            logger.info("exec update");
            User oldUser = userService.findUserById(id);
            oldUser.setName(user.getName());
            oldUser.setPassword(user.getPassword());

            userService.updateUser(oldUser);
        } catch (Exception e) {
            return SuccessResponse.FAILURE;
        }
        return SuccessResponse.SUCCESS;
    }

    @ApiOperation(value = "根据用户ID删除用户信息", notes = "删除用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public SuccessResponse delete(@PathVariable(value = "id") Long id) {
        try {
            logger.info("exec delete");
            userService.deleteUserById(id);
        } catch (Exception e) {
            return SuccessResponse.FAILURE;
        }
        return SuccessResponse.SUCCESS;
    }

    @ApiOperation(value = "根据用户ID查询用户信息", notes = "查询单用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User select(@PathVariable(value = "id") Long id) {
        logger.info("exec select");
        return userService.findUserById(id);
    }


    @ApiOperation(value = "根据名称查询用户分页信息", notes = "查询多用户信息")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(paramType = "query", name = "name", value = "用户名称", required = false, dataType = "String"),
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页数", required = false, dataType = "int"),
        @ApiImplicitParam(paramType = "query", name = "size", value = "每页条数", required = false, dataType = "int")
    })
    @RequestMapping(value = "/find-page", method = RequestMethod.GET)
    @ResponseBody
    public Page<User> findPage(@RequestParam(value = "name", required = false, defaultValue = "") String name, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "5") int size) {

        logger.info("exec findPage");
        Pageable pageable = new PageRequest(page, size);
        //TODO 分页对象需要转换 PageResponse
        return userService.findPageByName(name, pageable);
    }

    @ApiOperation(value = "根据名称精确查询用户信息", notes = "查询单用户信息，此接口不支持模糊搜索")
    @ApiImplicitParam(paramType = "query", name = "name", value = "用户名称", required = false, dataType = "String")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public User findUserByName(@RequestParam(value="name", required = false, defaultValue = "") String name) {
        logger.info("exec findUserByName");
        return userService.findUserByName(name);
    }

    @ApiOperation(value = "查询区域", notes = "查询区域")
    @ApiImplicitParam(paramType = "query", name = "name", value = "用户名称", required = false, dataType = "String")
    @RequestMapping(value = "/findRegion", method = RequestMethod.GET)
    @ResponseBody
    public JResult findRegion(@RequestParam(value="name", required = false, defaultValue = "") String name) {
        logger.info("exec findUserByName");
        Pageable pageable = new PageRequest(1, 10);
        List<BaseRegion> list = userService.findRegion(name,pageable);
        JResult jResult = new JResult(list);
        return jResult;
    }

}