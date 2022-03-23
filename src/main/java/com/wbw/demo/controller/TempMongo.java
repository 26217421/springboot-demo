package com.wbw.demo.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wbw.demo.entity.Drivers;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 使用MongoTemplate操作数据库
 * @author wbw
 * @description: TODO
 * @date 2022-3-23 0:12
 */
@RestController
@RequestMapping("/tem")
public class TempMongo {
    @Resource
    private MongoTemplate mongoTemplate;

    @PostMapping("create")
    public Drivers createUser(Drivers driver){
        Drivers user1 = mongoTemplate.insert(driver);
        System.out.println(user1);
        return user1;
    }


    /**
     * 查询所有
     */
    @GetMapping("findAll")
    public List<Drivers> findUser() {
        List<Drivers> userList = mongoTemplate.findAll(Drivers.class);
        System.out.println("userList = " + userList);
        return userList;
    }

    /**
     * 根据id查询
     */
    @GetMapping("findById")
    public Drivers getById(String id){
        Drivers driver = mongoTemplate.findById(id, Drivers.class);
        return driver;
    }

    /**
     * 条件查询
     */
    @GetMapping("findUser")
    public List<Drivers> findUserList() {

        //筛选条件
        Query query = new Query(Criteria
                .where("username").is("张三")
                .and("age").is(23)
        );

        //执行查询
        List<Drivers> userList = mongoTemplate.find(query, Drivers.class);
        return userList;

    }

    /**
     * 模糊查询
     */
    @GetMapping("findLike")
    public List<Drivers> findUsersLikeName() {
        String username = "张";
        String regex = String.format("%s%s%s", "^.*", username, ".*$");
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        //名字符合正则表达式的条件 
        Query query = new Query(Criteria.where("username").regex(pattern));
        //mongodb 文档相对应的模型类
        List<Drivers> userList = mongoTemplate.find(query, Drivers.class);
        return userList;
    }

    //分页查询
    @GetMapping("findPage")
    public void findUsersPage() {
        String name = "est";
        int pageNo = 1;
        int pageSize = 10;

        //构造条件
        Query query = new Query();
        //正则表达式匹配
        String regex = String.format("%s%s%s", "^.*", name, ".*$");
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        //添加条件
        query.addCriteria(Criteria.where("name").regex(pattern));
        //开始统计记录数
        int totalCount = (int) mongoTemplate.count(query, Drivers.class);
        //分页查询 返回结果
        List<Drivers> userList = mongoTemplate.find(query.skip(0).limit(pageSize), Drivers.class);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("list", userList);
        pageMap.put("totalCount",totalCount);
        System.out.println(pageMap);
    }

    /**
     * 修改
     */
    @GetMapping("update")
    public void updateUser(Drivers driver) {
        //修改好相应的数据 根据id进行修改 id是查询出来的
        Query query = new Query(Criteria.where("_id").is(driver.getId()));
        Update update = new Update();
        update.set("name", driver.getName());
        update.set("age", driver.getAge());
        //执行更新
        UpdateResult result = mongoTemplate.upsert(query, update, Drivers.class);
        long count = result.getModifiedCount();
        System.out.println(count);
    }

    //删除操作
    @GetMapping("delete")
    public void delete() {

        //构造条件 根据id删除相应的文档
        Query query =
                new Query(Criteria.where("_id").is("5ffbfa2ac290f356edf9b5aa"));
        DeleteResult result = mongoTemplate.remove(query, Drivers.class);
        long count = result.getDeletedCount();
        System.out.println(count);
    }
}
