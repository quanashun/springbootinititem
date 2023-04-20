package top.ashun.recruit.pojo.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 18483
 */
//UserInfo是user和administrator的抽象，以便于userTokenDTO可以通用
@Data
@ToString
public class UserInfo implements Serializable {
    private String id;
    private String username;
    private String phone;
}
