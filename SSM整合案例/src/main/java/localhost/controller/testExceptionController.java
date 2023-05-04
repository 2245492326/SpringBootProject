package localhost.controller;

import localhost.Service.testExceptionService;
import localhost.controller.tool.Code;
import localhost.controller.tool.Result;
import localhost.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Exception")
public class testExceptionController {
    @Autowired
    testExceptionService exceptionService;

    @GetMapping("/{id}")
    public Result idByBook(@PathVariable Integer id) {
        boolean flag = exceptionService.exception(id);
        System.out.println("触发");
        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag);
    }
}
