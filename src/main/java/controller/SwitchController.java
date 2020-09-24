package controller;

import bean.SysSwitch;
import dao.SysSwitchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
