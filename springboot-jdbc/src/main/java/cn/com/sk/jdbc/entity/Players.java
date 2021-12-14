package cn.com.sk.jdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("Players")
public class Players extends Model {

    private static final long serialVersionUID = 1L;

    @TableId("player_id")
    private Long playerId;

    @TableField("player_name")
    private String playerName;

}
