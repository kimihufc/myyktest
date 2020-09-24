package bean;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sys_switch")
public class SysSwitch implements Serializable {

    @Id
    private Long id;

    /**
     * 功能开光说明
     */
    private String flag;
    /**
     * 说明
     */
    private String switchDesc;
    /**
     * 是否开启
     */
    private Boolean enabled;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSwitchDesc() {
        return switchDesc;
    }

    public void setSwitchDesc(String switchDesc) {
        this.switchDesc = switchDesc;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
