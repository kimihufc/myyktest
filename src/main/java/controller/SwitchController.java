package controller;

import bean.SysSwitch;
import dao.SysSwitchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@Controller
@RequestMapping(value = "switch")
public class SwitchController {

    @Autowired
    private SysSwitchMapper sysSwitchMapper;

    @RequestMapping(value = "findall")
    @ResponseBody
    public List<SysSwitch> findall(){
        return sysSwitchMapper.selectAll();
    }


    @RequestMapping(value = "find")
    @ResponseBody
    public SysSwitch findall(@RequestParam Long id){
        SysSwitch param = new SysSwitch();
        param.setId(id);
        return sysSwitchMapper.selectOne(param);
    }

    /**
     * DeferredResult 只要有值就会等主程序执行完返回结果 如果一直没有设置值 等超时就会返回设置的超时值
     * @param time
     * @return
     */
    @RequestMapping(value = "test")
    @ResponseBody
    public DeferredResult<String> testDeferedResult(Long time){
        DeferredResult<String> result = new DeferredResult<>(3000L,"time over");
        result.onTimeout(()->{
//            result.setResult("timeout ...");
            System.out.println("time over");
        });
        result.setResultHandler(new DeferredResult.DeferredResultHandler() {
            @Override
            public void handleResult(Object o) {
                System.out.println("begin ....");

                System.out.println("over ...");
            }
        });
        if(time>2000){
            result.setResult("success");
        }
        return result;
    }
}
