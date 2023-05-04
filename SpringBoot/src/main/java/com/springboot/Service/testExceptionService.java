package com.springboot.Service;


import com.springboot.controller.tool.Code;
import com.springboot.exception.BusinessException;
import com.springboot.exception.SystemException;
import org.springframework.stereotype.Service;

/**
 * 模拟异常
 *
 * @author Administrator
 */
@Service
public class testExceptionService {

    public boolean exception(Integer id) {
        if (id == 1) {
            //直接通过创建异常处理器模拟异常
            throw new BusinessException(Code.BUSINESS_ERR, "业务异常");
        }
        if (id == 2) {
            throw new SystemException(Code.SYSTEM_ERR, "系统异常");
        }
        if (id == 3) {
            try {
                //实际运行的代码
                int i = 1 / 0;
            } catch (Exception ex) {
                throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时, 请重试", ex);
            }
        }
        return true;
    }
}
